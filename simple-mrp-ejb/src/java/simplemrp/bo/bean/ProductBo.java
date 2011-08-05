/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfProductBo;
import simplemrp.dao.InfProductDao;
import simplemrp.entity.Product;

/**
 *
 * @author Golf
 */
@Stateless
public class ProductBo implements InfProductBo {
    
    @EJB
    private InfProductDao productDao;


    @Override
    public List<Product> getListProduct() {
        return productDao.findAll();
    }

     @Override
    public Product getProduct(String strProduct) {
        return productDao.find(strProduct);
    }

    @Override
    public List<Product> searchProduct(String p_strKeyword) {
        List lsProduct = productDao.findByName(p_strKeyword);
        return lsProduct;
    }

    @Override
    public Product findProduct(String p_strProduct) throws Exception {
        Product product = productDao.find(p_strProduct);

        return product;
    }

    @Override
    public void editProduct(Product p_product) throws Exception {
        try {
            productDao.edit(p_product);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeProduct(Product p_product) throws Exception {
        productDao.remove(p_product);
    }

    @Override
    public String createProduct(Product p_product) throws Exception {
      //  String strNextUom = uomDao.getNextUom();
       // p_uom.setUom(strNextUom);

       productDao.create(p_product);

        return p_product.getProduct();
    }
 
}
