/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfMps_statDao;
import simplemrp.entity.Mps_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Mps_statDao extends AbstractDao<Mps_stat> implements InfMps_statDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Mps_statDao() {
        super(Mps_stat.class);
    }

}
