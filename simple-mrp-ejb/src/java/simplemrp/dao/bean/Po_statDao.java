/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfPo_statDao;
import simplemrp.entity.Po_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Po_statDao extends AbstractDao<Po_stat> implements InfPo_statDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Po_statDao() {
        super(Po_stat.class);
    }

}
