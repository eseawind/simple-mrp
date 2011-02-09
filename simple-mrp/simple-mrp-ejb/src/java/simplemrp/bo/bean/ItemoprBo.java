/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.bo.InfItemmatlBo;
import simplemrp.bo.InfItemoprBo;
import simplemrp.dao.InfItemoprDao;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemoprBo implements InfItemoprBo {

    @EJB
    private InfItemoprDao itemoprDao;
    @EJB
    private InfItemmatlBo itemmatlBo;

    @Override
    public List<Itemopr> getItemoprByItem(String p_strItem) throws Exception {
        List<Itemopr> lsItemopr = itemoprDao.findByItem(p_strItem);

        for(int i = 0; i < lsItemopr.size(); i++) {
            Itemopr itemopr = lsItemopr.get(i);
            itemopr.getItem1().toString();
            itemopr.getWorkcenter().toString();
        }

        return lsItemopr;
    }

    @Override
    public Itemopr getItemopr(ItemoprPK p_pkItemopr) throws Exception {
        Itemopr itemopr = itemoprDao.find(p_pkItemopr);

        if(itemopr != null) {
            itemopr.getItem1().toString();
            itemopr.getWorkcenter().toString();
        }

        return itemopr;
    }

    @Override
    public Integer createItemopr(Itemopr p_itemopr) throws Exception {
        Integer intNextOpr = itemoprDao.getNextOpr(p_itemopr.getItemoprPK().getItem());
        p_itemopr.getItemoprPK().setOpr(intNextOpr);

        p_itemopr.setUdate(DateUtil.getDate());

        p_itemopr.setCdate(p_itemopr.getUdate());
        p_itemopr.setCuser(p_itemopr.getUuser());

        itemoprDao.create(p_itemopr);

        return intNextOpr;
    }

    @Override
    public void editItemopr(Itemopr p_itemopr) throws Exception {
        ItemoprPK itemoprPK = p_itemopr.getItemoprPK();

        Itemopr itemopr = itemoprDao.find(itemoprPK);
        itemopr.setWorkcenter(p_itemopr.getWorkcenter());

        itemopr.setUdate(DateUtil.getDate());
        itemopr.setUuser(p_itemopr.getUuser());

        itemoprDao.edit(itemopr);
    }

    @Override
    public void removeItemopr(Itemopr p_itemopr) throws Exception {
        List<Itemmatl> lsItemmatl = itemmatlBo.getItemmatlByItemopr(p_itemopr.getItemoprPK().getItem(), p_itemopr.getItemoprPK().getOpr());
        for(int i=0; i<lsItemmatl.size(); i++) {
            Itemmatl itemmatl = lsItemmatl.get(i);
            itemmatlBo.removeItemmatl(itemmatl);
        }
        itemoprDao.remove(p_itemopr);
    }

    @Override
    public List<Itemopr> getBomDeatil(String p_strItem) throws Exception {
        List<Itemopr> lsItemopr = itemoprDao.findByItem(p_strItem);

        for(int i = 0; i < lsItemopr.size(); i++) {
            Itemopr itemopr = lsItemopr.get(i);
            itemopr.getItem1().toString();
            itemopr.getWorkcenter().toString();

            itemopr.getItem1().toString();
            itemopr.getWorkcenter().toString();

            List<Itemmatl> lsItemmatl = itemopr.getItemmatlList();
            for(int j = 0; j < lsItemmatl.size(); j++) {
                Itemmatl itemmatl = lsItemmatl.get(j);
                itemmatl.getMatl().toString();

                if(itemmatl.getMatl().getUom() != null){
                    itemmatl.getMatl().getUom().toString();
                }
            }


//            List<Itemmatl> lsItemmatl = itemmatlBo.getItemmatlByItemopr(itemopr.getItemoprPK().getItem(), itemopr.getItemoprPK().getOpr());
//
//            for(int j = 0; j < lsItemmatl.size(); j++) {
//                Itemmatl itemmatl = lsItemmatl.get(j);
//                itemmatl.getMatl().toString();
//            }

        }

        return lsItemopr;
    }
}
