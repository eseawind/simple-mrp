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
import org.sit.common.utils.DateUtil;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Country;
import simplemrp.entity.Customer;
import simplemrp.entity.District;
import simplemrp.entity.Prefixname;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.mbean.AbstractManageBean;
import simplemrp.util.CoConstant;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public class CustomerBean extends AbstractManageBean {

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
    private String tax_id;
    private Integer subdist_id;
    private Integer province_id;
    private Integer district_id;
    private Integer country_id;
    private String keyword;
    private List<Customer> lsCustomer;
    private List<SelectItem> lsCountry;
    private List<SelectItem> lsProvince;
    private List<SelectItem> lsDistrict;
    private List<SelectItem> lsSubdist;
    private List<SelectItem> lsPrefixname;
    private List<SelectItem> lsTax;

    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;

    /** Creates a new instance of CustomerBean */
    public CustomerBean() throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
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

    public List<SelectItem> getLsPrefixname() {
        if (lsPrefixname == null) {
            lsPrefixname = new ArrayList<SelectItem>();
        }
        return lsPrefixname;
    }

    public void setLsPrefixname(List<SelectItem> lsPrefixname) {
        this.lsPrefixname = lsPrefixname;
    }

    public List<SelectItem> getLsTax() {
        if (lsTax == null) {
            lsTax = new ArrayList<SelectItem>();
        }
        return lsTax;
    }

    public void setLsTax(List<SelectItem> lsTax) {
        this.lsTax = lsTax;
    }

    public List<SelectItem> getLsCountry() {
        if (lsCountry == null) {
            lsCountry = new ArrayList<SelectItem>();
        }
        return lsCountry;
    }

    public void setLsCountry(List<SelectItem> lsCountry) {
        this.lsCountry = lsCountry;
    }

    public List<SelectItem> getLsProvince() {
        if (lsProvince == null) {
            lsProvince = new ArrayList<SelectItem>();
        }
        return lsProvince;
    }

    public void setLsProvince(List<SelectItem> lsProvince) {
        this.lsProvince = lsProvince;
    }

    public List<SelectItem> getLsDistrict() {
        if (lsDistrict == null) {
            lsDistrict = new ArrayList<SelectItem>();
        }
        return lsDistrict;
    }

    public void setLsDistrict(List<SelectItem> lsDistrict) {
        this.lsDistrict = lsDistrict;
    }

    public List<SelectItem> getLsSubDist() {
        if (lsSubdist == null) {
            lsSubdist = new ArrayList<SelectItem>();
        }
        return lsSubdist;
    }

    public void setLsSubdist(List<SelectItem> lsSubDist) {
        this.lsSubdist = lsSubDist;
    }


    public boolean isDisbDel() {
        return disbDel;
    }

    public void setDisbDel(boolean disbDel) {
        this.disbDel = disbDel;
    }

    public boolean isDisbNew() {
        return disbNew;
    }

    public void setDisbNew(boolean disbNew) {
        this.disbNew = disbNew;
    }

    public boolean isDisbSave() {
        return disbSave;
    }

    public void setDisbSave(boolean disbSave) {
        this.disbSave = disbSave;
    }

    public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter Customer Name");
        } else {
            checkKeyword(strKeyword);
        }
    }

    private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            List<Customer> ls = coFacade.searchCustomer(p_strKeyword);

            setLsCustomer(ls);
        }
    }

    public void doSelect(ActionEvent e) throws Exception {
        String strCust_id = FacesUtils.getRequestParameter("p_cust_id");
        checkCust_id(strCust_id);
    }

    public void doCheckCust_id(ActionEvent e) throws Exception {
        checkCust_id(StringUtil.zeroLeading(getCust_id(), 7));
    }

    private void checkCust_id(String p_strCust_id) throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        Customer customer = coFacade.getCustomer(p_strCust_id);

        setMode(MODE_EDIT);

        if(customer != null) {
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
            setUdate(customer.getUdate());
            setUuser(customer.getUuser());
            setZipcode(customer.getZipcode());

            Date dt = DateUtil.getDate();

            setCdate(dt);

            setDisbNew(false);
            setDisbSave(false);
            setDisbDel(false);

            loadPrefixname();
            loadCountry();
            loadProvince(customer.getCountry());
            loadDistrict(customer.getProvince());
            loadSubdist(customer.getDistrict());
            loadTax();
        } else {
            clearEditScreen();
            message("Find Not Found");
        }
    }

    public void doCheckCountry(ActionEvent e) throws Exception {
        checkCountry(getCountry_id());
    }

    private void checkCountry(Integer p_intCountry_id) throws Exception {
        Country country = new Country();
        country.setCountryId(p_intCountry_id);

        Province provinceFirst = loadProvince(country);

        District districtFirst = loadDistrict(provinceFirst);
        Subdist subdistFirst = loadSubdist(districtFirst);

        if (subdistFirst != null) {
            zipcode = subdistFirst.getZipcode();
        }
    }

    public void doCheckProvince(ActionEvent e) throws Exception {
        checkProvince(getProvince_id());
    }

    private void checkProvince(Integer p_intProvince_id) throws Exception {
        Province province = new Province();
        province.setProvinceId(p_intProvince_id);

        District districtFirst = loadDistrict(province);
        Subdist subdistFirst = loadSubdist(districtFirst);

        if (subdistFirst != null) {
            zipcode = subdistFirst.getZipcode();
        }
    }

    public void doCheckDistrict(ActionEvent e) throws Exception {
        checkDistrict(getDistrict_id());
    }

    private void checkDistrict(Integer p_intDistrict_id) throws Exception {
        District district = new District();
        district.setDistrictId(p_intDistrict_id);

        Subdist subdistFirst = loadSubdist(district);

        if (subdistFirst != null) {
            zipcode = subdistFirst.getZipcode();
        }
    }

    public void doCheckSubdist(ActionEvent e) throws Exception {
        checkSubdist(getSubdist_id());
    }

    private void checkSubdist(Integer p_intSubdist_id) throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Subdist subdist = maFacade.getSubdist(p_intSubdist_id);

        if (subdist != null) {
            zipcode = subdist.getZipcode();
        }
    }

    private void loadPrefixname() throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Prefixname> lsAllPrefixname = coFacade.getListPrefixname();

        lsPrefixname = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllPrefixname.size(); i++) {
            Prefixname prefixname = lsAllPrefixname.get(i);
            SelectItem selectItem = new SelectItem(prefixname.getPrefixId(), prefixname.getPrefixname());

            lsPrefixname.add(selectItem);
        }
    }

    private void loadTax() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Tax> lsAllTax = maFacade.getListTax();

        lsTax = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllTax.size(); i++) {
            Tax tax = lsAllTax.get(i);
            SelectItem selectItem = new SelectItem(tax.getTaxId(), tax.getDescription());

            lsTax.add(selectItem);
        }
    }

    private Country loadCountry() throws Exception {
        Country countryFirst = null;

        lsCountry = new ArrayList<SelectItem>();

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Country> lsAllCountry = maFacade.getListCountry();

        for (int i = 0; i < lsAllCountry.size(); i++) {
            Country country = lsAllCountry.get(i);

            if (countryFirst == null) {
                countryFirst = country;
            }

            SelectItem selectItem = new SelectItem(country.getCountryId(), country.getCountryName());

            lsCountry.add(selectItem);
        }

        return countryFirst;
    }

    private Province loadProvince(Country p_country) throws Exception {
        Integer intCountry_id = null;
        if (p_country != null) {
            intCountry_id = p_country.getCountryId();
        }
        Province provinceFirst = null;

        lsProvince = new ArrayList<SelectItem>();

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Province> lsProvinceInCountry = maFacade.getListProvince(intCountry_id);

        for (int i = 0; i < lsProvinceInCountry.size(); i++) {
            Province province = lsProvinceInCountry.get(i);

            if (provinceFirst == null) {
                provinceFirst = province;
            }

            SelectItem selectItem = new SelectItem(province.getProvinceId(), province.getProvinceName());

            lsProvince.add(selectItem);
        }

        return provinceFirst;
    }

    private District loadDistrict(Province p_province) throws Exception {
        Integer intProvince_id = null;
        if (p_province != null) {
            intProvince_id = p_province.getProvinceId();
        }
        District districtFirst = null;

        lsDistrict = new ArrayList<SelectItem>();

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<District> lsDistrictInProvince = maFacade.getListDistrict(intProvince_id);

        for (int i = 0; i < lsDistrictInProvince.size(); i++) {
            District district = lsDistrictInProvince.get(i);

            if (districtFirst == null) {
                districtFirst = district;
            }

            SelectItem selectItem = new SelectItem(district.getDistrictId(), district.getDistrictName());

            lsDistrict.add(selectItem);
        }

        return districtFirst;
    }

    private Subdist loadSubdist(District p_district) throws Exception {
        Integer intDistrict_id = null;
        if (p_district != null) {
            intDistrict_id = p_district.getDistrictId();
        }
        Subdist subdistFirst = null;

        lsSubdist = new ArrayList<SelectItem>();

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Subdist> lsAllSubdist = maFacade.getListSubdist(intDistrict_id);

        for (int i = 0; i < lsAllSubdist.size(); i++) {
            Subdist subdist = lsAllSubdist.get(i);

            if (subdistFirst == null) {
                subdistFirst = subdist;
            }

            SelectItem selectItem = new SelectItem(subdist.getSubdistId(), subdist.getSubdistName());

            lsSubdist.add(selectItem);
        }

        return subdistFirst;
    }

    public void doNew(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);

        loadPrefixname();
        loadTax();
        loadCountry();

        country_id = CoConstant.COUNTRY_ID_THAILAND;
        Country thailand = new Country();
        thailand.setCountryId(country_id);

        loadProvince(thailand);

        province_id = CoConstant.PROVINCE_ID_BANGKOK;

        Province bangkok = new Province();
        bangkok.setProvinceId(province_id);

        District districtFirst = loadDistrict(bangkok);

        Subdist subdistFirst = loadSubdist(districtFirst);

        if (subdistFirst != null) {
            zipcode = subdistFirst.getZipcode();
        }
    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
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
        setTax_id(null);
        setSubdist_id(null);
        setProvince_id(null);
        setDistrict_id(null);
        setCountry_id(null);

        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        
        setMode(MODE_EDIT);
        lsPrefixname = null;
        lsCountry = null;
        lsProvince = null;
        lsDistrict = null;
        lsSubdist = null;
        lsTax = null;
    }

    public void doSave(ActionEvent e) throws Exception {
        try {
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

            Prefixname prefixname = new Prefixname(prefix_id);
            customer.setPrefixname(prefixname);

            if ((tax_id != null) && (tax_id.length() > 0)) {
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

            if (getMode().equals(MODE_EDIT)) {
                customer.setUuser(uuser);

                coFacade.editCustomer(customer);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkCust_id(customer.getCustId());
                FacesUtils.addInfoMessage("Save Complete");

            } else if (getMode().equals(MODE_NEW)) {
                customer.setCuser(cuser);

                String strNewCust_id = coFacade.createCustomer(customer);
                checkCust_id(strNewCust_id);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                FacesUtils.addInfoMessage("Create Complete");

            } else {
                FacesUtils.addInfoMessage("Unknown Operation Mode");
            }
        } catch (Exception ex) {
            FacesUtils.addInfoMessage(ex.getMessage());
        }
    }

    public void doDelete(ActionEvent e) throws Exception {
        if (getCust_id().length() == 7) {
            Customer customer = new Customer();
            customer.setCustId(getCust_id());
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            coFacade.deleteCustomer(customer);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            FacesUtils.addInfoMessage("Delete Complete");
        } else {
            FacesUtils.addInfoMessage("Please Enter Customer ID");
        }
    }
}
