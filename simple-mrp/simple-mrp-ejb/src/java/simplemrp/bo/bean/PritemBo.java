/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfPritemBo;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.dao.InfPritemDao;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;

/**
 *
 * @author Golf
 */
@Stateless
public class PritemBo implements InfPritemBo {
    @EJB
    private InfPritemDao pritemDao;


    @Override
    public List<Pritem> getPritemByPr(String p_strPr_id) throws Exception {
        List<Pritem> lsReturn = new ArrayList<Pritem>();
        List<Pritem> lsPritem = pritemDao.findByPr(p_strPr_id);

        for(int i = 0; i < lsPritem.size(); i++) {
            Pritem pritem = lsPritem.get(i);
            pritem.getItem().toString();

            lsReturn.add(pritem);
        }

        return lsReturn;
    }

    @Override
    public Pritem getPritem(PritemPK p_pkPritem) throws Exception {
        Pritem pritem = pritemDao.find(p_pkPritem);
        pritem.getItem().toString();

        return pritem;
    }

    @Override
    public Integer createPritem(Pritem p_pritem) throws Exception {
        Integer intNextPrSeq = pritemDao.getNextPr_seq(p_pritem.getPritemPK().getPrId());
        p_pritem.getPritemPK().setPrSeq(intNextPrSeq);

        p_pritem.setUdate(DateUtil.getDate());

        p_pritem.setCdate(p_pritem.getUdate());
        p_pritem.setCuser(p_pritem.getUuser());

        pritemDao.create(p_pritem);

        return intNextPrSeq;
    }

    @Override
    public void editPritem(Pritem p_pritem) throws Exception {
        PritemPK pritemPK = p_pritem.getPritemPK();

        Pritem pritem = pritemDao.find(pritemPK);
        pritem.setDueDate(p_pritem.getDueDate());
        pritem.setItem(p_pritem.getItem());
        pritem.setNote(p_pritem.getNote());
        pritem.setQty(p_pritem.getQty());

        pritem.setUdate(DateUtil.getDate());
        pritem.setUuser(pritem.getUuser());

        pritemDao.edit(pritem);
    }

    @Override
    public void removePritem(Pritem p_pritem) throws Exception {
        pritemDao.remove(p_pritem);
    }
}
