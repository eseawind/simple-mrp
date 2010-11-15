/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfPr_statDao;
import simplemrp.entity.Pr_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Pr_statDao extends AbstractDao<Pr_stat> implements InfPr_statDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Pr_statDao() {
        super(Pr_stat.class);
    }

}
