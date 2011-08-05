/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfJob_statDao;
import simplemrp.entity.Job_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Job_statDao extends AbstractDao<Job_stat> implements InfJob_statDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Job_statDao() {
        super(Job_stat.class);
    }

}
