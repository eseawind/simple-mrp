/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfMpsDao;
import simplemrp.entity.Mps;

/**
 *
 * @author Golf
 */
@Stateless
public class MpsDao extends AbstractDao<Mps> implements InfMpsDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MpsDao() {
        super(Mps.class);
    }

}
