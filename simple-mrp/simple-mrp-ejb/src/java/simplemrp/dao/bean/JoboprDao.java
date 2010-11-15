/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfJoboprDao;
import simplemrp.entity.Jobopr;

/**
 *
 * @author Golf
 */
@Stateless
public class JoboprDao extends AbstractDao<Jobopr> implements InfJoboprDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public JoboprDao() {
        super(Jobopr.class);
    }

}
