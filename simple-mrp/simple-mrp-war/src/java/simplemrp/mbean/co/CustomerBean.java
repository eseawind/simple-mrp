/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.co;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import simplemrp.entity.Customer;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.util.EJBLookup;


/**
 *
 * @author Golf
 */
public class CustomerBean {
    private String mode;
    private String cust_id;
    private String prefixname;
    private String name;
    private String addr1;
    private String addr2;
    private String road;
    private String soi;
    private String zipcode;
    private String phone;
    private String fax;
    private String email;
    private Date cdate;
    private String cuser;
    private Date udate;
    private String uuser;

    private String term_id;
    private String tax_id;
    private Integer subdist_id;
    private Integer province_id;
    private Integer district_id;
    private Integer country_id;

    private String keyword;
    private List<Customer> lsCustomer;

    /** Creates a new instance of CustomerBean */
    public CustomerBean() throws Exception {
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String custId) {
        this.cust_id = custId;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrefixname() {
        return prefixname;
    }

    public void setPrefixname(String prefixname) {
        this.prefixname = prefixname;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    public Integer getSubdist_id() {
        return subdist_id;
    }

    public void setSubdist_id(Integer subdist_id) {
        this.subdist_id = subdist_id;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Customer> getLsCustomer() {

        return lsCustomer;
    }

    public void setLsCustomer(List<Customer> lsCustomer) {
        this.lsCustomer = lsCustomer;
    }

    public void doSearch(ActionEvent e) throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Customer>ls = coFacade.searchCustomer(getKeyword());

        setLsCustomer(ls);
    }
    
    public void doShow(ActionEvent e) throws Exception {
//        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
    }

    public void doNew(ActionEvent e) throws Exception {
//        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
    }

    public void doSave(ActionEvent e) throws Exception {
        Customer c = new Customer();
        c.setAddr1(getAddr1());
        c.setAddr2(getAddr2());
//        c.setCdate(get);
//        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
    }
}
