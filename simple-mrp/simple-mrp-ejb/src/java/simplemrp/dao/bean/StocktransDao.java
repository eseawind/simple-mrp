/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Stocktrans;

/**
 *
 * @author Golf
 */
@Stateless
public class StocktransDao extends AbstractDao<Stocktrans> implements InfStocktransDao {

    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public StocktransDao() {
        super(Stocktrans.class);
    }

    @Override
    public Integer getNextPK() {
        String sql = "select max(o.transId) from Stocktrans as o";
        Query q = em.createQuery(sql);
        Integer newKey = (Integer) q.getSingleResult();
        if (newKey == null) {
            newKey = 1;
        } else {
            newKey += 1;
        }
        return newKey;
    }
}
