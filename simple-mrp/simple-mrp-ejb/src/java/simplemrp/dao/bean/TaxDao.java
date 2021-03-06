/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfTaxDao;
import simplemrp.entity.Tax;

/**
 *
 * @author Golf
 */
@Stateless
public class TaxDao extends AbstractDao<Tax> implements InfTaxDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TaxDao() {
        super(Tax.class);
    }

}
