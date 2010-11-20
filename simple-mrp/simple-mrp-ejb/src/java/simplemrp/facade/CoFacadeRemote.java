/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Customer;

/**
 *
 * @author Golf
 */
@Remote
public interface CoFacadeRemote {
    public List<Customer> searchCustomer(String p_strKeyword) throws Exception;
}
