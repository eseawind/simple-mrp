/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfTermDao;
import simplemrp.entity.Term;

/**
 *
 * @author Golf
 */
@Stateless
public class TermDao extends AbstractDao<Term> implements InfTermDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TermDao() {
        super(Term.class);
    }

}
