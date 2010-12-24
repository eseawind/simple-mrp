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
public class CustomerOrderBean implements Serializable {
    private String coId;
    private String custId;
    private String custName;
    private String custPo;
    private String duedate;
    private String term;
    private String costat;
    private String slsman;
    private String tax;
    private String uuser;
    private String cuser;
    private String cdate;
    private String udate;
    private List<Coitem> lsCoItem;

    //search
    private String searchCoId;
    private String searchCustName;
    private String p_co_id;
    private List<Co> lsCo;

    //select resource
    private List<Term> lsTerm;
    private List<Co_stat> lsCoStat;

    
    public CustomerOrderBean(){
        lsTerm = new ArrayList<Term>();
        lsCoStat = new ArrayList<Co_stat>();
        System.out.println("construct......");
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
    public void doSearchCo(ActionEvent e){
        
        System.out.println("Select CO");
    }
    public void doClearCo(ActionEvent e){
        System.out.println("Clear co");
    }

    //table operation
    public void doSelectCo(ActionEvent e){
        System.out.println("Select CO");
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }


    public String getCustPo() {
        return custPo;
    }

    public void setCustPo(String custPo) {
        this.custPo = custPo;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCostat() {
        return costat;
    }

    public void setCostat(String costat) {
        this.costat = costat;
    }

    public String getSlsman() {
        return slsman;
    }

    public void setSlsman(String slsman) {
        this.slsman = slsman;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
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

    public String getSearchCoId() {
        return searchCoId;
    }

    public void setSearchCoId(String searchCoId) {
        this.searchCoId = searchCoId;
    }

    public String getSearchCustName() {
        return searchCustName;
    }

    public void setSearchCustName(String searchCustName) {
        this.searchCustName = searchCustName;
    }

    public String getP_co_id() {
        return p_co_id;
    }

    public void setP_co_id(String p_co_id) {
        this.p_co_id = p_co_id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public List<Co_stat> getLsCoStat() {
        return lsCoStat;
    }

    public void setLsCoStat(List<Co_stat> lsCoStat) {
        this.lsCoStat = lsCoStat;
    }

    public List<Term> getLsTerm() {
        return lsTerm;
    }

    public void setLsTerm(List<Term> lsTerm) {
        this.lsTerm = lsTerm;
    }

}
