/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.bo.InfItemoprBo;
import simplemrp.dao.InfItemoprDao;
import simplemrp.entity.Item;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Workcenter;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemoprBo implements InfItemoprBo {

    @EJB
    private InfItemoprDao itemoprDao;

    @Override
    public List<Itemopr> getItemoprByItem(String p_strItem) throws Exception {
        List<Itemopr> lsItemopr = itemoprDao.findByItem(p_strItem);

        for(int i = 0; i < lsItemopr.size(); i++) {
            Itemopr itemopr = lsItemopr.get(i);
            itemopr.getItem1().toString();
        }

        return lsItemopr;
    }

    @Override
    public Itemopr getItemopr(ItemoprPK p_pkItemopr) throws Exception {
        Itemopr itemopr = itemoprDao.find(p_pkItemopr);
        itemopr.getItem1().toString();

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
        itemopr.setWorkcenter(itemopr.getWorkcenter());

        itemopr.setUdate(DateUtil.getDate());
        itemopr.setUuser(itemopr.getUuser());

        itemoprDao.edit(itemopr);
    }

    @Override
    public void removeItemopr(Itemopr p_itemopr) throws Exception {
        itemoprDao.remove(p_itemopr);
    }
}
