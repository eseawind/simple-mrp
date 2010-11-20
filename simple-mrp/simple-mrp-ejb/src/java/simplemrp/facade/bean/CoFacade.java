/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCustomerBo;
import simplemrp.entity.Customer;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */

@Stateless (mappedName=BindingName.CoFacadeRemote)
public class CoFacade implements CoFacadeRemote {
    @EJB
    private InfCustomerBo customerBo;

    @Override
    public List<Customer> searchCustomer(String p_strKeyword) throws Exception {
        return customerBo.searchCustomer(p_strKeyword);
    }
}
