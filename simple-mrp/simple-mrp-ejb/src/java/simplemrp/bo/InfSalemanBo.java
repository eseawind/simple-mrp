/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Slsman;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfSalemanBo {

    public Slsman getSaleman(String strSale_id);

    public List<Slsman> searchSaleman(String p_strKeyword);

}
