/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfCo_statBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfCo_statDao;
import simplemrp.entity.Co_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Co_statBo implements InfCo_statBo {
    @EJB
    private InfCo_statDao co_statDao;

    @Override
    public List<Co_stat> getListCo_stat() {
        return co_statDao.findAll();
    }
}
