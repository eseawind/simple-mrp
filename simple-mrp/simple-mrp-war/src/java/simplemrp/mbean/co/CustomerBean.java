/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.co;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Country;
import simplemrp.entity.Customer;
import simplemrp.entity.District;
import simplemrp.entity.Prefixname;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.entity.Term;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public class CustomerBean {

    private String MODE_NEW = "NEW";
    private String MODE_EDIT = "EDIT";
    private String mode;
    private String cust_id;
    private Integer prefix_id;
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

    private List<SelectItem> lsPrefixname;

    public List<SelectItem> getLsPrefixname() {
        if(lsPrefixname == null) {
            lsPrefixname = new ArrayList();
        }
        return lsPrefixname;
    }

    public void setLsPrefixname(List<SelectItem> lsPrefixname) {
        this.lsPrefixname = lsPrefixname;
    }

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

    public Integer getPrefix_id() {
        return prefix_id;
    }

    public void setPrefix_id(Integer prefixname) {
        this.prefix_id = prefixname;
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
        List<Customer> ls = coFacade.searchCustomer(getKeyword());

        setLsCustomer(ls);
    }

    public void doSelect(ActionEvent e) throws Exception {
        String strCust_id = FacesUtils.getRequestParameter("p_cust_id");

        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        Customer customer = coFacade.getCustomer(strCust_id);

        setMode(MODE_EDIT);

        setAddr1(customer.getAddr1());
        setAddr2(customer.getAddr2());
        setCdate(customer.getCdate());
        setCountry_id(customer.getCountry().getCountryId());
        setCuser(customer.getCuser());
        setCust_id(customer.getCustId());
        setDistrict_id(customer.getDistrict().getDistrictId());
        setEmail(customer.getEmail());
        setFax(customer.getFax());
        setName(customer.getName());
        setPhone(customer.getPhone());
        setPrefix_id(customer.getPrefixname().getPrefixId());
        setProvince_id(customer.getProvince().getProvinceId());
        setRoad(customer.getRoad());
        setSoi(customer.getSoi());
        setSubdist_id(customer.getSubdist().getSubdistId());
        setTax_id(customer.getTax().getTaxId());
        setTerm_id(customer.getTerm().getTermId());
        setUdate(customer.getUdate());
        setUuser(customer.getUuser());
        setZipcode(customer.getZipcode());

        loadPrefixname();
    }

    private void loadPrefixname() throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Prefixname> lsAllPrefixname = coFacade.getListPrefixname();
        
        lsPrefixname = new ArrayList();
        for (int i = 0; i < lsAllPrefixname.size(); i++) {
            Prefixname prefixname = lsAllPrefixname.get(i);
            SelectItem selectItem = new SelectItem(prefixname.getPrefixId(), prefixname.getPrefixname());

            lsPrefixname.add(selectItem);
        }
    }

    public void doNew(ActionEvent e) throws Exception {
        setMode(MODE_NEW);
        clearEditScreen();
        loadPrefixname();
    }

    public void doClear(ActionEvent e) throws Exception {
        setMode(MODE_EDIT);
        clearEditScreen();
    }

    public void clearEditScreen() {
        setCust_id(null);
        setPrefix_id(null);
        setName(null);
        setAddr1(null);
        setAddr2(null);
        setRoad(null);
        setSoi(null);
        setZipcode(null);
        setPhone(null);
        setFax(null);
        setEmail(null);
        setCdate(null);
        setCuser(null);
        setUdate(null);
        setUuser(null);
        setTerm_id(null);
        setTax_id(null);
        setSubdist_id(null);
        setProvince_id(null);
        setDistrict_id(null);
        setCountry_id(null);
    }

    public String doSave(ActionEvent e) throws Exception {
        Customer customer = new Customer();
        customer.setCustId(cust_id);
        customer.setName(name);
        customer.setAddr1(addr1);
        customer.setAddr2(addr2);
        customer.setRoad(road);
        customer.setSoi(soi);
        customer.setZipcode(zipcode);
        customer.setPhone(phone);
        customer.setFax(fax);
        customer.setEmail(email);
        customer.setCdate(cdate);
        customer.setCuser(cuser);
        customer.setUdate(udate);
        customer.setUuser(uuser);

        Prefixname prefixname = new Prefixname(prefix_id);
        customer.setPrefixname(prefixname);

        if ((term_id != null) && (term_id.length() > 0)) {
            Term term = new Term(term_id);
            customer.setTerm(term);
        }

        if((tax_id != null) && (tax_id.length() > 0)) {
            Tax tax = new Tax(tax_id);
            customer.setTax(tax);
        }
        

        Subdist subdist = new Subdist(subdist_id);
        customer.setSubdist(subdist);

        Province province = new Province(province_id);
        customer.setProvince(province);

        District district = new District(district_id);
        customer.setDistrict(district);

        Country country = new Country(country_id);
        customer.setCountry(country);

        CoFacadeRemote coFacade = EJBLookup.getCoFacade();

        coFacade.editCustomer(customer);

        FacesUtils.addInfoMessage("Save Complete");
        return "Save Comlpete";

    }

    public void doDelete() throws Exception {
        Customer customer = new Customer();
        customer.setCustId(getCust_id());
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        coFacade.deleteCustomer(customer);
    }
}
