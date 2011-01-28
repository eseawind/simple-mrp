/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import simplemrp.bo.InfPoitemBo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.dao.InfPoitemDao;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;

/**
 *
 * @author Golf
 */
@Stateless
public class PoitemBo implements InfPoitemBo {
    @EJB
    private InfPoitemDao poitemDao;


    @Override
    public List<Poitem> getPoitemByPo(String p_strPo_id) throws Exception {
        List<Poitem> lsReturn = new ArrayList<Poitem>();
        List<Poitem> lsPoitem = poitemDao.findByPo(p_strPo_id);

        for(int i = 0; i < lsPoitem.size(); i++) {
            Poitem poitem = lsPoitem.get(i);
            poitem.getItem().toString();
            lsReturn.add(poitem);
        }

        return lsReturn;
    }

    @Override
    public Poitem getPoitem(PoitemPK p_pkPoitem) throws Exception {
        Poitem poitem = poitemDao.find(p_pkPoitem);
        poitem.getPostat().toString();
        poitem.getItem().toString();

        return poitem;
    }

    @Override
    public Integer createPoitem(Poitem p_poitem) throws Exception {
        Integer intNextPoSeq = poitemDao.getNextPo_seq();
        p_poitem.getPoitemPK().setPoSeq(intNextPoSeq);

        p_poitem.setUdate(DateUtil.getDate());

        p_poitem.setCdate(p_poitem.getUdate());
        p_poitem.setCuser(p_poitem.getUuser());

        poitemDao.create(p_poitem);

        return intNextPoSeq;
    }

    @Override
    public void editPoitem(Poitem p_poitem) throws Exception {
        PoitemPK poitemPK = p_poitem.getPoitemPK();

        Poitem poitem = poitemDao.find(poitemPK);
        poitem.setDueDate(p_poitem.getDueDate());
        poitem.setItem(p_poitem.getItem());
        poitem.setNote(p_poitem.getNote());
        poitem.setQty(p_poitem.getQty());
        poitem.setPostat(p_poitem.getPostat());
        poitem.setItem(p_poitem.getItem());
        poitem.setVendItem(p_poitem.getVendItem());

        poitem.setUdate(DateUtil.getDate());
        poitem.setUuser(poitem.getUuser());

        poitemDao.edit(poitem);
    }

    @Override
    public void removePoitem(Poitem p_poitem) throws Exception {
        poitemDao.remove(p_poitem);
    }
}
