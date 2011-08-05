/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Province;

/**
 *
 * @author Golf
 */
@Local
public interface InfProvinceBo {
    public List<Province> getProvinceInCountry(Integer p_intCountry) throws Exception;
}
