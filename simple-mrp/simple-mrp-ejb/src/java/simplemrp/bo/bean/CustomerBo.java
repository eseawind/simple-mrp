/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfCustomerBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfCustomerDao;
import simplemrp.entity.Customer;

/**
 *
 * @author Golf
 */
@Stateless
public class CustomerBo implements InfCustomerBo {
    @EJB
    private InfCustomerDao customerDao;

    @Override
    public List<Customer> searchCustomer(String p_strName) throws Exception {
        return customerDao.findByName(p_strName);
    }

    @Override
    public Customer findCustomer(String p_strCust_id) throws Exception {
        Customer customer = customerDao.find(p_strCust_id);
        customer.getCountry().toString();
        customer.getDistrict().toString();
        customer.getProvince().toString();
        customer.getSubdist().toString();
        customer.getTax().toString();
        customer.getTerm().toString();
        
        return customer;
    }

    @Override
    public void editCustomer(Customer p_customer) throws Exception {
        customerDao.edit(p_customer);
    }
}
