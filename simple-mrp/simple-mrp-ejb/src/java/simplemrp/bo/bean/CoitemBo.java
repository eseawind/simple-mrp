/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfCoitemBo;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.dao.InfCoitemDao;
import simplemrp.dao.bean.CoitemDao;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;

/**
 *
 * @author Golf
 */
@Stateless
public class CoitemBo implements InfCoitemBo {
    @EJB
    private InfCoitemDao coitemDao;


    @Override
    public List<Coitem> getCoitemByCo(String p_strCo_id) throws Exception {
        List<Coitem> lsReturn = new ArrayList<Coitem>();
        List<Coitem> lsCoitem = coitemDao.findByCo(p_strCo_id);

        for(int i = 0; i < lsCoitem.size(); i++) {
            Coitem coitem = lsCoitem.get(i);
            coitem.getItem().toString();
            lsReturn.add(coitem);
        }
        
        return lsReturn;
    }

    @Override
    public Coitem getCoitem(CoitemPK p_pkCoitem) throws Exception {
        Coitem coitem = coitemDao.find(p_pkCoitem);
        coitem.getCostat().toString();
        coitem.getItem().toString();

        return coitem;
    }

    @Override
    public Integer createCoitem(Coitem p_coitem) throws Exception {
        Integer intNextCoSeq = coitemDao.getNextCo_seq(p_coitem.getCoitemPK().getCoId());
        p_coitem.getCoitemPK().setCoSeq(intNextCoSeq);

        p_coitem.setUdate(DateUtil.getDate());

        p_coitem.setCdate(p_coitem.getUdate());
        p_coitem.setCuser(p_coitem.getUuser());
        
        coitemDao.create(p_coitem);

        return intNextCoSeq;
    }

    @Override
    public void editCoitem(Coitem p_coitem) throws Exception {
        CoitemPK coitemPK = p_coitem.getCoitemPK();

        Coitem coitem = coitemDao.find(coitemPK);
        coitem.setCostat(p_coitem.getCostat());
        coitem.setItem(p_coitem.getItem());
        coitem.setPrice(p_coitem.getPrice());
        coitem.setQty(p_coitem.getQty());

        coitem.setUdate(DateUtil.getDate());
        coitem.setUuser(coitem.getUuser());

        coitemDao.edit(coitem);
    }

    @Override
    public void removeCoitem(Coitem p_coitem) throws Exception {
        coitemDao.remove(p_coitem);
    }
}
