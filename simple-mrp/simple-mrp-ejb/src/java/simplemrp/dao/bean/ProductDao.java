/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfProductDao;
import simplemrp.entity.Product;

/**
 *
 * @author Golf
 */
@Stateless
public class ProductDao extends AbstractDao<Product> implements InfProductDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductDao() {
        super(Product.class);
    }

}
