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
        if (customer.getCountry() != null) {
            customer.getCountry().toString();
        }
        if (customer.getDistrict() != null) {
            customer.getDistrict().toString();
        }
        if (customer.getProvince() != null) {
            customer.getProvince().toString();
        }
        if (customer.getSubdist() != null) {
            customer.getSubdist().toString();
        }
        if (customer.getTax() != null) {
            customer.getTax().toString();
        }
        if (customer.getTerm() != null) {
            customer.getTerm().toString();
        }
        if (customer.getPrefixname() != null) {
            customer.getPrefixname().toString();
        }
        
        return customer;
    }

    @Override
    public void editCustomer(Customer p_customer) throws Exception {
        try {
        customerDao.edit(p_customer);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeCustomer(Customer p_customer) throws Exception {
        customerDao.remove(p_customer);
    }
}
