/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfCoBo;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.dao.InfCoDao;
import simplemrp.entity.Co;

/**
 *
 * @author Golf
 */
@Stateless
public class CoBo implements InfCoBo {
    @EJB
    private InfCoDao coDao;

    @Override
    public List<Co> searchCoByCustomer(String p_strCustomerId) throws Exception {
        return coDao.findByCustomerId(p_strCustomerId);
    }

    @Override
    public Co findCo(String p_strCo_id) throws Exception {
        Co co = coDao.find(p_strCo_id);
        if (co != null) {
            co.getCustomer().toString();
            co.getCostat().toString();
            co.getSlsman().toString();
            co.getTax().toString();
            co.getTerm().toString();
        }

        return co;
    }

    @Override
    public void editCo(Co p_co) throws Exception {
        try {
            Co co = findCo(p_co.getCoId());

            p_co.setCdate(co.getCdate());
            p_co.setCuser(co.getCuser());
            p_co.setUdate(DateUtil.getDate());

            coDao.edit(p_co);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeCo(Co p_co) throws Exception {
        coDao.remove(p_co);
    }

    @Override
    public String createCo(Co p_co) throws Exception {
        String strNextCo_id = coDao.getNextCo_id();

        p_co.setCoId(strNextCo_id);

        p_co.setUdate(DateUtil.getDate());

        p_co.setCdate(p_co.getUdate());
        p_co.setCuser(p_co.getUuser());

        coDao.create(p_co);

        return p_co.getCoId();
    }
}
