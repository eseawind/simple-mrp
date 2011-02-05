/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfPrBo;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.bo.InfPoBo;
import simplemrp.bo.InfPoitemBo;
import simplemrp.constant.PoConstant;
import simplemrp.dao.InfPrDao;
import simplemrp.dao.InfPritemDao;
import simplemrp.dao.InfUsrDao;
import simplemrp.entity.Po;
import simplemrp.entity.Po_stat;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Pr;
import simplemrp.entity.Pritem;
import simplemrp.entity.Usr;

/**
 *
 * @author Golf
 */
@Stateless
public class PrBo implements InfPrBo {

    @EJB
    private InfPrDao prDao;
    @EJB
    private InfPritemDao pritemDao;
    @EJB
    private InfUsrDao usrDao;
    @EJB
    private InfPoBo poBo;
    @EJB
    private InfPoitemBo poitemBo;

    @Override
    public List<Pr> searchPr(String p_strRequester, Date p_dtReqDate) throws Exception {
        List<Pr> lsPr = prDao.findByRequesterReqDate(p_strRequester, p_dtReqDate);

        for(int i = 0; i < lsPr.size(); i++) {
            Pr pr = lsPr.get(i);
            pr.getPrstat().toString();
        }

        return lsPr;
    }

    @Override
    public Pr findPr(String p_strPr_id) throws Exception {
        Pr pr = prDao.find(p_strPr_id);
        if(pr != null) {
            pr.getPrstat().toString();
        }

        return pr;
    }

    @Override
    public void removePr(Pr p_pr) throws Exception {
        prDao.remove(p_pr);
    }

    @Override
    public String createPr(Pr p_pr) throws Exception {
        String strNextPr_id = prDao.getNextPr_id();

        p_pr.setPrId(strNextPr_id);

        p_pr.setUdate(DateUtil.getDate());

        p_pr.setCdate(p_pr.getUdate());
        p_pr.setCuser(p_pr.getUuser());

        prDao.create(p_pr);

        return p_pr.getPrId();
    }

    @Override
    public void editPr(Pr p_pr) throws Exception {
        try {
            Pr pr = findPr(p_pr.getPrId());

            pr.setNote(p_pr.getNote());
            pr.setReqDate(p_pr.getReqDate());
            pr.setRequester(p_pr.getRequester());

            pr.setUuser(p_pr.getUuser());
            pr.setUdate(DateUtil.getDate());

            boolean isApprovePo = false;

            if(pr.getPrstat().getStat().equals(PoConstant.PR_STAT_REQUEST)) {
                if(p_pr.getPrstat().getStat().equals(PoConstant.PR_STAT_APPROVED)) {
                    Usr usr = usrDao.find(p_pr.getUuser());

                    if(usr.getApp_pr().equals('Y')) {
                        pr.setPrstat(p_pr.getPrstat());
                        pr.setApprover(p_pr.getUuser());

                        isApprovePo = true;
                    } else {
                        throw new Exception("Could not approve P/R");
                    }
                }
            } else if(pr.getPrstat().getStat().equals(PoConstant.PR_STAT_APPROVED)) {
                if(p_pr.getPrstat().getStat().equals(PoConstant.PR_STAT_REQUEST)) {
                    throw new Exception("Could not change P/R status");
                }
            } else {
                pr.setPrstat(p_pr.getPrstat());
            }

            prDao.edit(pr);

            if(isApprovePo) {
                approvePr(pr.getPrId());
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    private void approvePr(String p_strPr_id) throws Exception {
        try {
            Pr pr = prDao.find(p_strPr_id);
            
            Po po = new Po();
            po.setPoDate(DateUtil.getDate());

            Po_stat po_stat = new Po_stat();
            po_stat.setStat(PoConstant.PO_STAT_ORDER);
            po.setPostat(po_stat);

            po.setUuser(pr.getApprover());

            String strPo_id = poBo.createPo(po);

            if(strPo_id != null) {
                List<Pritem> lsPritem = pritemDao.findByPr(p_strPr_id);

                for(int i = 0; i < lsPritem.size(); i++) {
                    Pritem pritem = lsPritem.get(i);

                    Poitem poitem = new Poitem();

                    PoitemPK poitemPK = new PoitemPK();
                    poitemPK.setPoId(strPo_id);
                    poitem.setPoitemPK(poitemPK);
                    poitem.setItem(pritem.getItem());

                    Po_stat poitem_stat = new Po_stat();
                    poitem_stat.setStat(PoConstant.PO_STAT_ORDER);
                    poitem.setPostat(poitem_stat);
                        
                    poitem.setPritem(pritem);
                    poitem.setQty(pritem.getQty());

                    poitem.setDueDate(pritem.getDueDate());

                    poitem.setUuser(pr.getApprover());

                    Integer intPo_seq = poitemBo.createPoitem(poitem);

                    if(intPo_seq == null) {
                        throw new Exception("Could not create P/O for P/R Seq " + pritem.getPritemPK().getPrSeq());
                    }
                }
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }
    
}
