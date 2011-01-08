/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.po;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import simplemrp.entity.Po;
import simplemrp.entity.Po_stat;
import simplemrp.entity.Poitem;
import simplemrp.entity.Term;


/**
 *
 * @author wisaruthkea
 */
public class PurchaseOrderBean {

  
    //FORM
    private String po;
    private String poDate;
    private String vendor;
    private String termId;
    private String invDate;
    private String invNum;
    private String tax;
    private String poStat;
    private String description;
    private String cUser;
    private String uUser;
    private String cDate;
    private String uDate;
    //List
    private List<Poitem> lsPoitem;

    //Search
    private String searchPoId;
    private String searchPoDate;
    private List<Po> lsPo;

    //Option value
    private List<Term> lsTerm;
    private List<Po_stat> lsPoStat;

      /** Creates a new instance of PurchaseOrderBean */
    public PurchaseOrderBean() {
        //init option value
        lsTerm = new ArrayList<Term>();
        lsPoStat = new ArrayList<Po_stat>();
    }

    //ACTION
     //operation
    public void doNew(ActionEvent e){

        System.out.println("New PO");
    }
    public void doSave(ActionEvent e){

        System.out.println("Save PO");
    }
    public void doDelete(ActionEvent e){

        System.out.println("Delete PO");
    }
    public void doSearch(ActionEvent e){

        System.out.println("Select PO");
    }
    public void doClear(ActionEvent e){
        System.out.println("Clear Po");
    }

    //table operation
    public void doSelect(ActionEvent e){
        System.out.println("Select PO");
    }

    //GET SET
    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getInvDate() {
        return invDate;
    }

    public void setInvDate(String invDate) {
        this.invDate = invDate;
    }

    public String getInvNum() {
        return invNum;
    }

    public void setInvNum(String invNum) {
        this.invNum = invNum;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getPoStat() {
        return poStat;
    }

    public void setPoStat(String poStat) {
        this.poStat = poStat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public String getuUser() {
        return uUser;
    }

    public void setuUser(String uUser) {
        this.uUser = uUser;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getuDate() {
        return uDate;
    }

    public void setuDate(String uDate) {
        this.uDate = uDate;
    }

    public List<Poitem> getLsPoitem() {
        return lsPoitem;
    }

    public void setLsPoitem(List<Poitem> lsPoitem) {
        this.lsPoitem = lsPoitem;
    }

    public String getSearchPoId() {
        return searchPoId;
    }

    public void setSearchPoId(String searchPoId) {
        this.searchPoId = searchPoId;
    }

    public String getSearchPoDate() {
        return searchPoDate;
    }

    public void setSearchPoDate(String searchPoDate) {
        this.searchPoDate = searchPoDate;
    }

    public List<Po> getLsPo() {
        return lsPo;
    }

    public void setLsPo(List<Po> lsPo) {
        this.lsPo = lsPo;
    }

    public List<Term> getLsTerm() {
        return lsTerm;
    }

    public void setLsTerm(List<Term> lsTerm) {
        this.lsTerm = lsTerm;
    }

    public List<Po_stat> getLsPoStat() {
        return lsPoStat;
    }

    public void setLsPoStat(List<Po_stat> lsPoStat) {
        this.lsPoStat = lsPoStat;
    }

}
