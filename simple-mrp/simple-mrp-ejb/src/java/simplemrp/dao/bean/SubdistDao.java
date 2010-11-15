/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfSubdistDao;
import simplemrp.entity.Subdist;

/**
 *
 * @author Golf
 */
@Stateless
public class SubdistDao extends AbstractDao<Subdist> implements InfSubdistDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SubdistDao() {
        super(Subdist.class);
    }

}
