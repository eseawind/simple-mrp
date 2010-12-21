/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Customer;
import simplemrp.entity.Slsman;

/**
 *
 * @author Golf
 */
@Remote
public interface CoFacadeRemote {
    public List<Customer> searchCustomer(String p_strKeyword) throws Exception;

    public Customer getCustomer(String p_strCust_id) throws Exception;

    public void editCustomer(Customer p_customer) throws Exception;

    public void deleteCustomer(Customer p_customer) throws Exception;

    public List getListPrefixname() throws Exception;

    //Saleman manage
    public List<Slsman> searchSaleman(String p_strKeyword);
    public Slsman getSaleman(String strSale_id);
    
}
