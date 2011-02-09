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
import simplemrp.dao.InfItemmatlDao;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemmatlBo implements InfItemmatlBo {
    @EJB
    private InfItemmatlDao itemmatlDao;

    @Override
    public List<Itemmatl> getItemmatlByItemopr(String p_strItem, Integer p_intOpr) throws Exception {
        List<Itemmatl> lsItemmatl = itemmatlDao.findByItemopr(p_strItem, p_intOpr);

        for(int i = 0; i < lsItemmatl.size(); i++) {
            Itemmatl itemmatl = lsItemmatl.get(i);
            itemmatl.getMatl().toString();
            itemmatl.getItemopr().toString();
        }

        return lsItemmatl;
    }

    @Override
    public Itemmatl getItemmatl(ItemmatlPK p_pkItemmatl) throws Exception {
        Itemmatl itemmatl = itemmatlDao.find(p_pkItemmatl);
        itemmatl.getMatl().toString();
        itemmatl.getItemopr().toString();

        return itemmatl;
    }

    @Override
    public Integer createItemmatl(Itemmatl p_itemmatl) throws Exception {
        if((p_itemmatl.getQty() == null) || (p_itemmatl.getQty().intValue() == 0)) {
            throw new Exception("Invalid quantity");
        }
        Integer intNextSeq = itemmatlDao.getNextSeq(p_itemmatl.getItemmatlPK().getItem(), p_itemmatl.getItemmatlPK().getOpr());
        p_itemmatl.getItemmatlPK().setSeq(intNextSeq);

        p_itemmatl.setUdate(DateUtil.getDate());

        p_itemmatl.setCdate(p_itemmatl.getUdate());
        p_itemmatl.setCuser(p_itemmatl.getUuser());

        itemmatlDao.create(p_itemmatl);

        return intNextSeq;
    }

    @Override
    public void editItemmatl(Itemmatl p_itemmatl) throws Exception {
        if((p_itemmatl.getQty() == null) || (p_itemmatl.getQty().intValue() == 0)) {
            throw new Exception("Invalid quantity");
        }
        
        ItemmatlPK itemmatlPK = p_itemmatl.getItemmatlPK();

        Itemmatl itemmatl = itemmatlDao.find(itemmatlPK);
        itemmatl.setMatl(p_itemmatl.getMatl());
        itemmatl.setQty(p_itemmatl.getQty());

        itemmatl.setUdate(DateUtil.getDate());
        itemmatl.setUuser(itemmatl.getUuser());

        itemmatlDao.edit(itemmatl);
    }

    @Override
    public void removeItemmatl(Itemmatl p_itemmatl) throws Exception {
        itemmatlDao.remove(p_itemmatl);
    }
}
