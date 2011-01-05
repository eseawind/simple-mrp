/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.District;

/**
 *
 * @author Golf
 */
@Local
public interface InfDistrictBo {

    public List<District> getDistrictInProvince(Integer p_intProvince) throws Exception;
}
