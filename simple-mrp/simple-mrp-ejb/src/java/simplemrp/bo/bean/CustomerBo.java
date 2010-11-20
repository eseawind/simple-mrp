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
}
