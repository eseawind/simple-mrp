/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Co;

/**
 *
 * @author Golf
 */
@Local
public interface InfCoBo {

    public List<Co> searchCoByCustomer(String p_strCustomerId) throws Exception;

    public Co findCo(String p_strCo_id) throws Exception;

    public void editCo(Co p_co) throws Exception;

    public void removeCo(Co p_co) throws Exception;

    public String createCo(Co p_co) throws Exception;
    
}
