/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCustomerBo;
import simplemrp.bo.InfPrefixnamBo;
import simplemrp.bo.InfSalemanBo;
import simplemrp.entity.Customer;
import simplemrp.entity.Prefixname;
import simplemrp.entity.Slsman;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */

@Stateless (mappedName=BindingName.CoFacadeRemote)
public class CoFacade implements CoFacadeRemote {
    @EJB
    private InfPrefixnamBo prefixnameBo;
    @EJB
    private InfCustomerBo customerBo;
    @EJB
    private InfSalemanBo salemanBo;

    @Override
    public List<Customer> searchCustomer(String p_strKeyword) throws Exception {
        return customerBo.searchCustomer(p_strKeyword);
    }

    @Override
    public Customer getCustomer(String p_strCust_id) throws Exception {
        return customerBo.findCustomer(p_strCust_id);
    }

    @Override
    public void editCustomer(Customer p_customer) throws Exception {
        customerBo.editCustomer(p_customer);
    }

    @Override
    public void deleteCustomer(Customer p_customer) throws Exception {
        customerBo.removeCustomer(p_customer);
    }

    @Override
    public List<Prefixname> getListPrefixname() throws Exception {
        return prefixnameBo.getListPrefixname();
    }

    @Override
    public List<Slsman> searchSaleman(String p_strKeyword) {
        return salemanBo.searchSaleman(p_strKeyword);
    }

    @Override
    public Slsman getSaleman(String strSale_id) {
        return salemanBo.getSaleman(strSale_id);
    }

    @Override
    public String createCustomer(Customer p_customer) throws Exception {
        return customerBo.createCustomer(p_customer);
    }
}
