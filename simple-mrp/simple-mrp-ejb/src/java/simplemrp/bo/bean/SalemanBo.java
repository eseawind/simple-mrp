/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfSalemanBo;
import simplemrp.dao.InfSlsmanDao;
import simplemrp.entity.Slsman;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class SalemanBo implements InfSalemanBo {

    @EJB
    private InfSlsmanDao salemanDao;

    @Override
    public Slsman getSaleman(String strSale_id) {
        return salemanDao.find(strSale_id);
    }

    @Override
    public List<Slsman> searchSaleman(String p_strKeyword) {
        return salemanDao.findByName(p_strKeyword);
    }

}
