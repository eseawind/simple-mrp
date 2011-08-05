/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Co;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Customer;
import simplemrp.entity.Itemprice;
import simplemrp.entity.ItempricePK;
import simplemrp.entity.Prefixname;
import simplemrp.entity.Slsman;

/**
 *
 * @author Golf
 */
@Remote
public interface CoFacadeRemote {
    //Customer manage
    public List<Customer> searchCustomer(String p_strKeyword) throws Exception;
    public Customer getCustomer(String p_strCust_id) throws Exception;
    public String createCustomer(Customer p_customer) throws Exception;
    public void editCustomer(Customer p_customer) throws Exception;
    public void deleteCustomer(Customer p_customer) throws Exception;

    //Prefix manage
    public List<Prefixname> getListPrefixname() throws Exception;

    //Saleman manage
    public List<Slsman> searchSlsman(String p_strKeyword) throws Exception;
    public Slsman getSlsman(String p_strSlsman_id) throws Exception;
    public String createSlsman(Slsman p_slsman) throws Exception;
    public void editSlsman(Slsman p_slsman) throws Exception;
    public void deleteSlsman(Slsman p_slsman) throws Exception;

    //Co management
    public List<Co> searchCo(String p_strCustomerId) throws Exception;
    public Co getCo(String strCo_id) throws Exception;
    public String createCo(Co p_co) throws Exception;
    public void editCo(Co p_co) throws Exception;
    public void deleteCo(Co p_co) throws Exception;

    //Coitem Management
    public List<Coitem> getCoitemByCo(String p_strCo_id) throws Exception;
    public Coitem getCoitem(CoitemPK p_pkCoitem) throws Exception;
    public Integer createCoitem(Coitem p_coitem) throws Exception;
    public void editCoitem(Coitem p_coitem) throws Exception;
    public void deleteCoitem(Coitem p_coitem) throws Exception;

    //Costat Manangement
    public List<Co_stat> getListCo_stat() throws Exception;

    //Itemprice Management
    public List<Itemprice> getItempriceByItem(String p_strItem) throws Exception;
    public Itemprice getItemprice(ItempricePK p_pkItemprice) throws Exception;
    public void createItemprice(Itemprice p_itemprice) throws Exception;
    public void editItemprice(Itemprice p_itemprice) throws Exception;
    public void deleteItemprice(Itemprice p_itemprice) throws Exception;

    //Method for testing purpose
    public List<Coitem> getForMpsGen() throws Exception;
    public void daoEditCoitem(Coitem p_coitem) throws Exception;

}
