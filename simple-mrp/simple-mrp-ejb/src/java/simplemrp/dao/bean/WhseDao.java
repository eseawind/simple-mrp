/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfWhseDao;
import simplemrp.entity.Whse;

/**
 *
 * @author Golf
 */
@Stateless
public class WhseDao extends AbstractDao<Whse> implements InfWhseDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WhseDao() {
        super(Whse.class);
    }

}
