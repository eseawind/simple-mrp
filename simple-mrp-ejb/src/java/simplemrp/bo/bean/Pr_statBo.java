/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfPr_statBo;
import simplemrp.dao.InfPr_statDao;
import simplemrp.entity.Pr_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Pr_statBo implements InfPr_statBo {
    @EJB
    private InfPr_statDao pr_statDao;

   @Override
    public List<Pr_stat> getListPr_stat() {
        return pr_statDao.findAll();
    }
 
}
