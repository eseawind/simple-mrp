/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 @Override
    public List<Product> findByName(String name){
        String sql = "select distinct p from  Product as p where p.product like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name+"%");
        return q.getResultList();
    }

    @Override
    public String getNextProduct() {
        String strPrefix = "S";

        String sql = "select max(p.Product) from Product as p";
        Query q = em.createQuery(sql);
        String strLastProduct = (String)q.getSingleResult();
        if((strLastProduct == null) || (strLastProduct.length() == 0)) {
            strLastProduct = "S000000";
        }
        strLastProduct = strLastProduct.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastProduct).intValue() + 1;

        String strNextProduct = "000000" + intNext;
        strNextProduct = strPrefix + strNextProduct.substring(strNextProduct.length() - 6, strNextProduct.length());

        return strNextProduct;
    }
}
