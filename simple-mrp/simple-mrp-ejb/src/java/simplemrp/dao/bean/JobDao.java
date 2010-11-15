/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfJobDao;
import simplemrp.entity.Job;

/**
 *
 * @author Golf
 */
@Stateless
public class JobDao extends AbstractDao<Job> implements InfJobDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public JobDao() {
        super(Job.class);
    }

}
