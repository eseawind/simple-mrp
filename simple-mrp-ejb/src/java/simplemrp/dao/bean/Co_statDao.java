/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfCo_statDao;
import simplemrp.entity.Co_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Co_statDao extends AbstractDao<Co_stat> implements InfCo_statDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Co_statDao() {
        super(Co_stat.class);
    }

}
