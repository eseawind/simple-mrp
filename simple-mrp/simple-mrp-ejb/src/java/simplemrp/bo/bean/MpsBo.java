/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import org.sit.common.utils.OperationResult;
import simplemrp.bo.InfJobBo;
import simplemrp.bo.InfMpsBo;
import simplemrp.bo.InfPrBo;
import simplemrp.bo.InfPritemBo;
import simplemrp.constant.MasterConstant;
import simplemrp.constant.PoConstant;
import simplemrp.constant.PpConstant;
import simplemrp.dao.InfCoitemDao;
import simplemrp.dao.InfForecastDao;
import simplemrp.dao.InfItemDao;
import simplemrp.dao.InfItemlocDao;
import simplemrp.dao.InfMpsDao;
import simplemrp.dao.InfUsrDao;
import simplemrp.entity.Coitem;
import simplemrp.entity.Forecast;
import simplemrp.entity.Item;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;
import simplemrp.entity.Pr;
import simplemrp.entity.Pr_stat;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;
import simplemrp.entity.Usr;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class MpsBo implements InfMpsBo {

    @EJB
    private InfMpsDao mpsDao;
    @EJB
    private InfCoitemDao coitemDao;
    @EJB
    private InfForecastDao forecastDao;
    @EJB
    private InfItemlocDao itemlocDao;
    @EJB
    private InfItemDao itemDao;
    @EJB
    private InfUsrDao usrDao;
    @EJB
    private InfPrBo prBo;
    @EJB
    private InfPritemBo pritemBo;
    @EJB
    private InfJobBo jobBo;

    @Override
    public Mps find(String mpsId) {
        Mps result = mpsDao.find(mpsId);
        doLazyLoad(result);
        return result;
    }

    @Override
    public List<Mps> findAll() {
        List<Mps> result = mpsDao.findAll();
        //lazy load value
        for(Mps m : result) {
            doLazyLoad(m);
        }
        return result;
    }

    @Override
    public String create(Mps mps) {
        String id = mpsDao.getNextId();
        mps.setMpsId(id);
        mpsDao.create(mps);
        return id;
    }

    @Override
    public List<Mps> findByCreateDate(Date p_dtCreate) {
        List<Mps> result = mpsDao.findByCdate(p_dtCreate);
        //lazy load value
        for(Mps m : result) {
            doLazyLoad(m);
        }
        return result;
    }

    private void doLazyLoad(Mps m) {
        if(m.getItem() != null) {
            m.getItem().toString();
        }
        if(m.getMpsstat() != null) {
            m.getMpsstat().toString();
        }
        if(m.getMpstype() != null) {
            m.getMpstype().toString();
        }
    }

    @Override
    public void remove(String mpsId) throws Exception {
        try {
            Mps mps = new Mps(mpsId);

            List<Coitem> lsCoitem = coitemDao.findByMps(mpsId);
            
            for(int i= 0; i < lsCoitem.size(); i++) {
                Coitem coitem = lsCoitem.get(i);
                coitem.setMps_id(null);

                coitemDao.edit(coitem);
            }

            List<Forecast> lsForecast = forecastDao.findByMps(mpsId);

            for(int i = 0; i < lsForecast.size(); i++) {
                Forecast forecast = lsForecast.get(i);
                forecast.setMps_id(null);

                forecastDao.edit(forecast);
            }

            mpsDao.remove(mps);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void save(Mps p_mps) throws Exception {
        try {
            Mps mps = find(p_mps.getMpsId());
            mps.setDuedate(p_mps.getDuedate());
            mps.setItem(p_mps.getItem());
            mps.setMpstype(p_mps.getMpstype());
            mps.setQty(p_mps.getQty());

            mps.setUuser(p_mps.getUuser());
            mps.setUdate(DateUtil.getDate());

            boolean isReleaseMPS = false;

            if(mps.getMpsstat().getStat().equals(PpConstant.MPS_STAT_PLAN)) {
                if(p_mps.getMpsstat().getStat().equals(PpConstant.MPS_STAT_RELEASE)) {
                    Usr usr = usrDao.find(p_mps.getUuser());

                    if(usr.getRls_mps().equals('Y')) {
                        mps.setMpsstat(p_mps.getMpsstat());
                        mps.setReleaser(p_mps.getUuser());

                        isReleaseMPS = true;
                    } else {
                        throw new Exception("Could not release plan");
                    }
                }
            } else if(mps.getMpsstat().getStat().equals(PpConstant.MPS_STAT_RELEASE)) {
                if(p_mps.getMpsstat().getStat().equals(PpConstant.MPS_STAT_PLAN)) {
                    throw new Exception("Could not change plan status");
                }
            } else {
                mps.setMpsstat(p_mps.getMpsstat());
            }
            
            mpsDao.edit(mps);

            if(isReleaseMPS) {
                releasePlan(mps);
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public OperationResult generateMPS(String p_strUsr_id) throws Exception {
        OperationResult result = new OperationResult();

        try {
            Map<String, Mps> mapMps = new TreeMap<String, Mps>();
            Map<String, Double> mapOnhand = new TreeMap<String, Double>();

            {
                List<Coitem> lsCoitem = coitemDao.findForMpsGen();

                for(int i = 0; i < lsCoitem.size(); i++) {
                    Coitem coitem = lsCoitem.get(i);

                    Date dtDue = coitem.getCo().getDuedate();

                    Integer intLeadTime = coitem.getItem().getLeadtime();

                    if((intLeadTime != null) && (intLeadTime.intValue() > 0)) {
                        dtDue = DateUtil.addDays(dtDue, intLeadTime.intValue() * -1);
                    }

                    if(dtDue.compareTo(DateUtil.getDate()) > 0) {
                        Double dblQty = (coitem.getQty() == null) ? new Double(0) : coitem.getQty();
                        Double dblQtyship = (coitem.getQtyship() == null) ? new Double(0) : coitem.getQtyship();
                        Double dblDemand = new Double(dblQty.doubleValue() - dblQtyship.doubleValue());

                        String strItem = coitem.getItem().getItem();

                        if(!mapOnhand.containsKey(strItem)) {
//                            System.out.println(strItem + " onhand " + itemlocDao.countOnhand(strItem));
                            mapOnhand.put(strItem, itemlocDao.countOnhand(strItem));
                        }

                        Double dblOnhand = mapOnhand.get(strItem);
                        if(dblOnhand > dblDemand) {
                            dblOnhand = dblOnhand - dblDemand;
                            dblDemand = new Double(0);
                        } else {
                            dblDemand = new Double(dblOnhand.doubleValue());
                            dblOnhand = new Double(0);
                        }

                        mapOnhand.put(strItem, dblOnhand);

                        if(dblDemand.doubleValue() > 0) {
                            String strMpsKey = strItem + ":" + dtDue.toString();

                            if(mapMps.containsKey(strMpsKey)) {
                                Mps mps = mapMps.get(strMpsKey);
                                mps.setQty(new Integer(mps.getQty().intValue() + dblDemand.intValue()));
                                mapMps.put(strMpsKey, mps);

                                coitem.setMps_id(mps.getMpsId());
                                coitemDao.edit(coitem);

                                mpsDao.edit(mps);
                            } else {
                                Mps mps = new Mps();
                                mps.setMpsId(mpsDao.getNextId());

                                Item item = new Item();
                                item.setItem(strItem);
                                mps.setItem(item);
                                mps.setQty(new Integer(dblDemand.intValue()));
                                mps.setDuedate(dtDue);

                                Character chrItemSource = coitem.getItem().getItemsource().getSource();

                                if(chrItemSource.equals(MasterConstant.ITEMSOURCE_PURCHASE)) {
                                    Mps_type mps_type = new Mps_type(PpConstant.MPS_TYPE_PURCHASE);
                                    mps.setMpstype(mps_type);

                                } else if(chrItemSource.equals(MasterConstant.ITEMSOURCE_MANUFACTURE)) {
                                    Mps_type mps_type = new Mps_type(PpConstant.MPS_TYPE_MANUFACTURE);
                                    mps.setMpstype(mps_type);
                                }

                                Mps_stat mps_stat = new Mps_stat(PpConstant.MPS_STAT_PLAN);
                                mps.setMpsstat(mps_stat);

                                mps.setCdate(DateUtil.getDate());
                                mps.setCuser(p_strUsr_id);

                                mps.setUdate(DateUtil.getDate());
                                mps.setUuser(p_strUsr_id);

                                mpsDao.create(mps);

                                mapMps.put(strMpsKey, mps);

                                coitem.setMps_id(mps.getMpsId());
                                coitemDao.edit(coitem);
                            }
                        }
                    }
                }
            }

            {
                List<Forecast> lsForecast = forecastDao.findForMpsGen();

                for(int i = 0; i < lsForecast.size(); i++) {
                    Forecast forecast = lsForecast.get(i);

                    Date dtDue = forecast.getFcstdate();

                    Integer intLeadTime = forecast.getItem1().getLeadtime();

                    if((intLeadTime != null) && (intLeadTime.intValue() > 0)) {
                        dtDue = DateUtil.addDays(dtDue, intLeadTime.intValue() * -1);
                    }

                    if(dtDue.compareTo(DateUtil.getDate()) > 0) {
                        Double dblQty = (forecast.getQty() == null) ? new Double(0) : forecast.getQty();

                        String strItem = forecast.getItem1().getItem();

                        if(!mapOnhand.containsKey(strItem)) {
//                            System.out.println(strItem + " onhand " + itemlocDao.countOnhand(strItem));
                            mapOnhand.put(strItem, itemlocDao.countOnhand(strItem));
                        }

                        Double dblOnhand = mapOnhand.get(strItem);
                        if(dblOnhand > dblQty) {
                            dblOnhand = dblOnhand - dblQty;
                            dblQty = new Double(0);
                        } else {
                            dblQty = new Double(dblQty.doubleValue() - dblOnhand.doubleValue());
                            dblOnhand = new Double(0);
                        }

                        mapOnhand.put(strItem, dblOnhand);

                        if(dblQty.doubleValue() > 0) {
                            String strMpsKey = strItem + ":" + dtDue.toString();

                            if(mapMps.containsKey(strMpsKey)) {
                                Mps mps = mapMps.get(strMpsKey);
                                mps.setQty(new Integer(mps.getQty().intValue() + dblQty.intValue()));
                                mapMps.put(strMpsKey, mps);

                                forecast.setMps_id(mps.getMpsId());
                                forecastDao.edit(forecast);

                                mpsDao.edit(mps);
                            } else {
                                Mps mps = new Mps();
                                mps.setMpsId(mpsDao.getNextId());

                                Item item = new Item();
                                item.setItem(strItem);

                                mps.setItem(item);
                                mps.setQty(new Integer(dblQty.intValue()));
                                mps.setDuedate(dtDue);

                                Character chrItemSource = forecast.getItem1().getItemsource().getSource();

                                if(chrItemSource.equals(MasterConstant.ITEMSOURCE_PURCHASE)) {
                                    Mps_type mps_type = new Mps_type(PpConstant.MPS_TYPE_PURCHASE);
                                    mps.setMpstype(mps_type);

                                } else if(chrItemSource.equals(MasterConstant.ITEMSOURCE_MANUFACTURE)) {
                                    Mps_type mps_type = new Mps_type(PpConstant.MPS_TYPE_MANUFACTURE);
                                    mps.setMpstype(mps_type);
                                }

                                Mps_stat mps_stat = new Mps_stat(PpConstant.MPS_STAT_PLAN);
                                mps.setMpsstat(mps_stat);

                                mps.setCdate(DateUtil.getDate());
                                mps.setCuser(p_strUsr_id);

                                mps.setUdate(DateUtil.getDate());
                                mps.setUuser(p_strUsr_id);

                                mpsDao.create(mps);

                                mapMps.put(strMpsKey, mps);

                                forecast.setMps_id(mps.getMpsId());
                                forecastDao.edit(forecast);
                            }
                        }
                    }
                }
            }

            result.setMessage("Generate " + mapMps.size() + " plans");
            result.setObj(mapMps);
            result.setComplete(Boolean.TRUE);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return result;
    }

    private void releasePlan(Mps p_mps) throws Exception {
        try {
            if(p_mps.getMpstype().getMpsType().equals(PpConstant.MPS_TYPE_MANUFACTURE)) {
                genJob(p_mps);
            } else if(p_mps.getMpstype().getMpsType().equals(PpConstant.MPS_TYPE_PURCHASE)) {
                genPR(p_mps);
            } else {
                throw new Exception("Unknown MPS type");
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    private void genPR(Mps p_mps) throws Exception {
        try {
            Pr pr = new Pr();

            pr.setPrstat(new Pr_stat(PoConstant.PR_STAT_REQUEST));

            pr.setReqDate(DateUtil.getDate());
            pr.setRequester(p_mps.getReleaser());
            pr.setUuser(p_mps.getReleaser());

            String strPr_id = prBo.createPr(pr);

            Pritem pritem = new Pritem();
            pritem.setItem(p_mps.getItem());
            pritem.setQty(new Double(p_mps.getQty().intValue()));
            pritem.setDueDate(p_mps.getDuedate());

            pritem.setUuser(p_mps.getReleaser());

            PritemPK pritemPK = new PritemPK();
            pritemPK.setPrId(strPr_id);
            pritem.setPritemPK(pritemPK);

            Integer intPr_seq = pritemBo.createPritem(pritem);

            p_mps.setRefId(strPr_id);
            p_mps.setRefSeq(intPr_seq);

            mpsDao.edit(p_mps);

        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    private void genJob(Mps p_mps) throws Exception {
        try {
            Job job = new Job();

            job.setItem(p_mps.getItem());
            job.setJobdate(p_mps.getDuedate());
            job.setQty(p_mps.getQty());
            job.setJobstat(new Job_stat(PpConstant.JOB_STAT_FIRM));

            job.setCuser(p_mps.getReleaser());
            job.setCdate(DateUtil.getDate());

            job.setUdate(DateUtil.getDate());
            job.setUuser(p_mps.getReleaser());

            String strJob_id = jobBo.createJob(job);
            
            p_mps.setRefId(strJob_id);

            mpsDao.edit(p_mps);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public String getLastId() {
        return mpsDao.getLastId();
    }
}
