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
import simplemrp.bo.InfMpsBo;
import simplemrp.constant.MasterConstant;
import simplemrp.constant.PpConstant;
import simplemrp.dao.InfCoitemDao;
import simplemrp.dao.InfForecastDao;
import simplemrp.dao.InfItemDao;
import simplemrp.dao.InfItemlocDao;
import simplemrp.dao.InfMpsDao;
import simplemrp.entity.Coitem;
import simplemrp.entity.Forecast;
import simplemrp.entity.Item;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;
import simplemrp.entity.PritemPK;

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
        for(Mps m:result){
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
    public List<Mps> findByDueDate(Date dueDate) {
        List<Mps> result = mpsDao.findByDueDate(dueDate);
        //lazy load value
        for(Mps m:result){
            doLazyLoad(m);
        }
        return result;
    }
    private void doLazyLoad(Mps m){
        if(m.getItem()!=null){
                m.getItem().toString();
            }
            if(m.getMpsstat()!=null){
                m.getMpsstat().toString();
            }
            if(m.getMpstype()!=null){
                m.getMpstype().toString();
            }
    }

    @Override
    public void remove(String mpsId) {
        Mps mps = new Mps(mpsId);
        mpsDao.remove(mps);
    }

    @Override
    public void save(Mps mps) {
        mpsDao.edit(mps);
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

                    Double dblQty = (coitem.getQty() == null) ? new Double(0) : coitem.getQty();
                    Double dblQtyship = (coitem.getQtyship() == null) ? new Double(0) : coitem.getQtyship();
                    Double dblDemand = new Double(dblQty.doubleValue() - dblQtyship.doubleValue());

                    String strItem = coitem.getItem().getItem();

                    if(!mapOnhand.containsKey(strItem)) {
                        mapOnhand.put(strItem, itemlocDao.countOnhand(strItem));
                    }

                    Double dblOnhand = mapOnhand.get(strItem);
                    if(dblOnhand > dblDemand) {
                        dblOnhand = dblOnhand - dblDemand;
                    } else {
                        dblDemand = new Double(dblOnhand.doubleValue());
                        dblOnhand = new Double(0);
                    }

                    String strMpsKey = strItem + ":" + dtDue.toString();

                    if(mapMps.containsKey(strMpsKey)) {
                        Mps mps = mapMps.get(strMpsKey);
                        mps.setQty(new Integer(mps.getQty().intValue() + dblDemand.intValue()));
                        mapMps.put(strMpsKey, mps);
                    } else {
                        Mps mps = new Mps();
                        Item item = new Item();
                        mps.setItem(item);
                        mps.setQty(new Integer(dblDemand.intValue()));
                        mps.setDuedate(dtDue);

                        mapMps.put(strMpsKey, mps);
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

                    Double dblQty = (forecast.getQty() == null) ? new Double(0) : forecast.getQty();

                    String strItem = forecast.getItem1().getItem();

                    if(!mapOnhand.containsKey(strItem)) {
                        mapOnhand.put(strItem, itemlocDao.countOnhand(strItem));
                    }

                    Double dblOnhand = mapOnhand.get(strItem);
                    if(dblOnhand > dblQty) {
                        dblOnhand = dblOnhand - dblQty;
                    } else {
                        dblQty = new Double(dblOnhand.doubleValue());
                        dblOnhand = new Double(0);
                    }

                    String strMpsKey = strItem + ":" + dtDue.toString();

                    if(mapMps.containsKey(strMpsKey)) {
                        Mps mps = mapMps.get(strMpsKey);
                        mps.setQty(new Integer(mps.getQty().intValue() + dblQty.intValue()));
                        mapMps.put(strMpsKey, mps);
                    } else {
                        Mps mps = new Mps();
                        Item item = new Item();
                        mps.setItem(item);
                        mps.setQty(new Integer(dblQty.intValue()));
                        mps.setDuedate(dtDue);

                        mapMps.put(strMpsKey, mps);
                    }
                }
            }

            Set keySet = mapMps.keySet();
            Iterator<String> itr = keySet.iterator();
            while(itr.hasNext()) {
                String strKey = itr.next();
                Mps mps = mapMps.get(strKey);
                mps.setMpsId(mpsDao.getNextId());

                Item item = itemDao.find(mps.getItem().getItem());

                if(item.getItemsource().getSource().equals(MasterConstant.ITEMSOURCE_PURCHASE)) {
                    PritemPK pritemPK = genPR(mps);
                    mps.setRefId(pritemPK.getPrId());
                    mps.setRefSeq(pritemPK.getPrSeq());

                    Mps_stat mps_stat = new Mps_stat(PpConstant.MPS_STAT_PLAN);
                    mps.setMpsstat(mps_stat);

                    Mps_type mps_type = new Mps_type(PpConstant.MPS_TYPE_PURCHASE);
                    mps.setMpstype(mps_type);
                    
                    mps.setCdate(DateUtil.getDate());
                    mps.setCuser(p_strUsr_id);

                    mps.setUdate(DateUtil.getDate());
                    mps.setUuser(p_strUsr_id);

                } else if(item.getItemsource().getSource().equals(MasterConstant.ITEMSOURCE_MANUFACTURE)) {
                    String strJobId = genJob(mps);
                    mps.setRefId(strJobId);
                    mps.setRefSeq(null);

                    Mps_stat mps_stat = new Mps_stat(PpConstant.MPS_STAT_PLAN);
                    mps.setMpsstat(mps_stat);

                    Mps_type mps_type = new Mps_type(PpConstant.MPS_TYPE_MANUFACTURE);
                    mps.setMpstype(mps_type);

                    mps.setCdate(DateUtil.getDate());
                    mps.setCuser(p_strUsr_id);

                    mps.setUdate(DateUtil.getDate());
                    mps.setUuser(p_strUsr_id);
                } else {
                    throw new Exception("Unknown itemsource");
                }
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return result;
    }

    private PritemPK genPR(Mps p_mps) throws Exception {
        PritemPK pritemPK = null;

        try {


        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return pritemPK;
    }

    private String genJob(Mps p_mps) throws Exception {
        String strJobId = null;

        try {

        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return strJobId;
    }
}
