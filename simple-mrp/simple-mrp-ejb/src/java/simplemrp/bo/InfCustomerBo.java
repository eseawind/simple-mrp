/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Customer;

/**
 *
 * @author Golf
 */
@Local
public interface InfCustomerBo {
    public List<Customer> searchCustomer(String p_strName) throws Exception;

    public Customer findCustomer(String p_strCust_id) throws Exception;

    public void editCustomer(Customer p_customer) throws Exception;
}
