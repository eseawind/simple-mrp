/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCoBo;
import simplemrp.bo.InfCo_statBo;
import simplemrp.bo.InfCoitemBo;
import simplemrp.bo.InfCustomerBo;
import simplemrp.bo.InfItempriceBo;
import simplemrp.bo.InfPrefixnamBo;
import simplemrp.bo.InfSlsmanBo;
import simplemrp.bo.bean.CoBo;
import simplemrp.bo.bean.Co_statBo;
import simplemrp.bo.bean.CoitemBo;
import simplemrp.bo.bean.ItempriceBo;
import simplemrp.entity.Co;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Customer;
import simplemrp.entity.Itemprice;
import simplemrp.entity.ItempricePK;
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
    private InfSlsmanBo slsmanBo;
    @EJB
    private InfCoBo coBo;
    @EJB
    private InfCoitemBo coitemBo;
    @EJB
    private InfCo_statBo co_statBo;
    @EJB
    private InfItempriceBo itempriceBo;

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
    public String createCustomer(Customer p_customer) throws Exception {
        return customerBo.createCustomer(p_customer);
    }

    @Override
    public List<Prefixname> getListPrefixname() throws Exception {
        return prefixnameBo.getListPrefixname();
    }

    @Override
    public List<Slsman> searchSlsman(String p_strSlsman) {
        return slsmanBo.searchSlsman(p_strSlsman);
    }

    @Override
    public Slsman getSlsman(String p_strSlsman_id) throws Exception {
        return slsmanBo.getSlsman(p_strSlsman_id);
    }

    @Override
    public List<Co> searchCo(String p_strCustomerId) throws Exception {
        return coBo.searchCoByCustomer(p_strCustomerId);
    }

    @Override
    public String createSlsman(Slsman p_slsman) throws Exception {
        return slsmanBo.createSlsman(p_slsman);
    }

    @Override
    public void editSlsman(Slsman p_slsman) throws Exception {
        slsmanBo.editSlsman(p_slsman);
    }

    @Override
    public void deleteSlsman(Slsman p_slsman) throws Exception {
        slsmanBo.removeSlsman(p_slsman);
    }

    @Override
    public Co getCo(String strCo_id) throws Exception {
        return coBo.findCo(strCo_id);
    }

    @Override
    public String createCo(Co p_co) throws Exception {
        return coBo.createCo(p_co);
    }

    @Override
    public void editCo(Co p_co) throws Exception {
        coBo.editCo(p_co);
    }

    @Override
    public void deleteCo(Co p_co) throws Exception {
        coBo.removeCo(p_co);
    }

    @Override
    public List<Coitem> getCoitemByCo(String p_strCo_id) throws Exception {
        return coitemBo.getCoitemByCo(p_strCo_id);
    }

    @Override
    public Coitem getCoitem(CoitemPK p_pkCoitem) throws Exception {
        return coitemBo.getCoitem(p_pkCoitem);
    }

    @Override
    public Integer createCoitem(Coitem p_coitem) throws Exception {
        return coitemBo.createCoitem(p_coitem);
    }

    @Override
    public void editCoitem(Coitem p_coitem) throws Exception {
        coitemBo.editCoitem(p_coitem);
    }

    @Override
    public void deleteCoitem(Coitem p_coitem) throws Exception {
        coitemBo.removeCoitem(p_coitem);
    }

    @Override
    public List<Co_stat> getListCo_stat() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Itemprice> getItempriceByItem(String p_strItem) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Itemprice getItemprice(ItempricePK p_pkItemprice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void createItemprice(Itemprice p_itemprice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editItemprice(Itemprice p_itemprice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteItemprice(Itemprice p_itemprice) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
