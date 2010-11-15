/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
