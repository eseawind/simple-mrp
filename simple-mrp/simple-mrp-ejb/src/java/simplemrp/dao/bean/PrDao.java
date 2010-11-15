/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfPrDao;
import simplemrp.entity.Pr;

/**
 *
 * @author Golf
 */
@Stateless
public class PrDao extends AbstractDao<Pr> implements InfPrDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PrDao() {
        super(Pr.class);
    }

}
