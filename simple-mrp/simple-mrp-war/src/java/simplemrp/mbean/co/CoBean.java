/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.co;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import simplemrp.entity.Co;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Coitem;
import simplemrp.entity.Customer;
import simplemrp.entity.Term;

/**
 *
 * @author wisaruthkea
 */
public class CoBean extends CoAttr {
    private List<Coitem> lsCoItem;

    //search
    
    private String p_co_id;
    private List<Co> lsCo;

    //select resource
    

    
    public CoBean(){
    }
    
    //operation
    public void doNewCo(ActionEvent e){
        
        System.out.println("New CO");
    }
    public void doSaveCo(ActionEvent e){
        
        System.out.println("Save CO");
    }
    public void doDeleteCo(ActionEvent e){
        
        System.out.println("Delete CO");
    }

    public void doSearchCo(ActionEvent e) throws Exception {
        String strSearchCustomerName = getSearchCustName().trim();

        if ((strSearchCustomerName.length() == 0)) {
            message("Please Enter Search Condition");
        } else {
            searchCO(strSearchCustomerName);
        }
    }

    private void searchCO(String p_strSearchCustomer) throws Exception {
//        if (p_strSearchCustomer.length() > 0) {
//            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
//            List<Item> ls = maFacade.searchItem(p_strSearchItem, p_strSearchDesc);
//
//            setLsItem(ls);
//        }
    }

    public void doClearCo(ActionEvent e){
        System.out.println("Clear co");
    }

    //table operation
    public void doSelectCo(ActionEvent e){
        System.out.println("Select CO");
    }

    public List<Coitem> getLsCoItem() {
        return this.lsCoItem;
    }

    public void setLsCoItem(List<Coitem> lsCoItem) {
        this.lsCoItem = lsCoItem;
    }

    public List<Co> getLsCo() {
        return lsCo;
    }

    public void setLsCo(List<Co> lsCo) {
        this.lsCo = lsCo;
    }

    public String getP_co_id() {
        return p_co_id;
    }

    public void setP_co_id(String p_co_id) {
        this.p_co_id = p_co_id;
    }
}
