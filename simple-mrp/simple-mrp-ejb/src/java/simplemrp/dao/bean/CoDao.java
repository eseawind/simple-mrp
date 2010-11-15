/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfCoDao;
import simplemrp.entity.Co;

/**
 *
 * @author Golf
 */
@Stateless
public class CoDao extends AbstractDao<Co> implements InfCoDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CoDao() {
        super(Co.class);
    }

}
