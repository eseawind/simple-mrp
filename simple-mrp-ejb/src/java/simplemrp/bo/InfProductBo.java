/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Product;

/**
 *
 * @author Golf
 */
@Local
public interface InfProductBo {

    public List<Product> getListProduct();
     public Product getProduct(String strProduct);

    public List<Product> searchProduct(String p_strKeyword);

    public void removeProduct(Product p_product) throws Exception;

    public String createProduct(Product p_product) throws Exception;

    public void editProduct(Product p_product) throws Exception;

    public Product findProduct(String p_strProduct) throws Exception;
    
}
