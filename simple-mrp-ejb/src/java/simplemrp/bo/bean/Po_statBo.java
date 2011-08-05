/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfPo_statBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfPo_statDao;
import simplemrp.entity.Po_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Po_statBo implements InfPo_statBo {
    @EJB
    private InfPo_statDao po_statDao;

    @Override
    public List<Po_stat> getListPo_stat() {
        return po_statDao.findAll();
    }
 
}
