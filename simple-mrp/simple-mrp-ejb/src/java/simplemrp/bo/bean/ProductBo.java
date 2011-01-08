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
 
}
