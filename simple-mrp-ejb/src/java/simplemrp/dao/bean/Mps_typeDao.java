/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfMps_typeDao;
import simplemrp.entity.Mps_type;

/**
 *
 * @author Golf
 */
@Stateless
public class Mps_typeDao extends AbstractDao<Mps_type> implements InfMps_typeDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Mps_typeDao() {
        super(Mps_type.class);
    }

}
