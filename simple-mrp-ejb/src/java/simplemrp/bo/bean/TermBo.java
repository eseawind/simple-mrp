/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfTermBo;
import simplemrp.dao.InfTermDao;
import simplemrp.entity.Term;

/**
 *
 * @author Golf
 */
@Stateless
public class TermBo implements InfTermBo {
    @EJB
    private InfTermDao termDao;

    @Override
    public List<Term> getListTerm() {
        return termDao.findAll();
    }
 
}
