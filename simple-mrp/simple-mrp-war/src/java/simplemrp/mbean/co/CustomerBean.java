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
import simplemrp.util.CoConstant;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public class CustomerBean extends CustomerAttr {
    
    /** Creates a new instance of CustomerBean */
    public CustomerBean() throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbCust_id(false);
    }

    public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            message("Please Enter Customer Name");
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
        setMode(MODE_EDIT);
        setDisbCust_id(false);

        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        Customer customer = coFacade.getCustomer(p_strCust_id);

        if(customer != null) {
            setAddr1(customer.getAddr1());
            setAddr2(customer.getAddr2());
            setCountry_id(customer.getCountry().getCountryId());
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
            
            setZipcode(customer.getZipcode());

            setCdate(customer.getCdate());
            setCuser(customer.getCuser());

            setUdate(customer.getUdate());
            setUuser(customer.getUuser());

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
            setZipcode(subdistFirst.getZipcode());
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
            setZipcode(subdistFirst.getZipcode());
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
            setZipcode(subdistFirst.getZipcode());
        }
    }

    public void doCheckSubdist(ActionEvent e) throws Exception {
        checkSubdist(getSubdist_id());
    }

    private void checkSubdist(Integer p_intSubdist_id) throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Subdist subdist = maFacade.getSubdist(p_intSubdist_id);

        if (subdist != null) {
            setZipcode(subdist.getZipcode());
        }
    }

    private void loadPrefixname() throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Prefixname> lsAllPrefixname = coFacade.getListPrefixname();

        List lsPrefixname = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllPrefixname.size(); i++) {
            Prefixname prefixname = lsAllPrefixname.get(i);
            SelectItem selectItem = new SelectItem(prefixname.getPrefixId(), prefixname.getPrefixname());

            lsPrefixname.add(selectItem);
        }

        setLsPrefixname(lsPrefixname);
    }

    private void loadTax() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Tax> lsAllTax = maFacade.getListTax();

        List lsTax = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllTax.size(); i++) {
            Tax tax = lsAllTax.get(i);
            SelectItem selectItem = new SelectItem(tax.getTaxId(), tax.getDescription());

            lsTax.add(selectItem);
        }

        setLsTax(lsTax);
    }

    private Country loadCountry() throws Exception {
        Country countryFirst = null;

        List lsCountry = new ArrayList<SelectItem>();

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

        setLsCountry(lsCountry);

        return countryFirst;
    }

    private Province loadProvince(Country p_country) throws Exception {
        Integer intCountry_id = null;
        if (p_country != null) {
            intCountry_id = p_country.getCountryId();
        }
        Province provinceFirst = null;

        List lsProvince = new ArrayList<SelectItem>();

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

        setLsProvince(lsProvince);

        return provinceFirst;
    }

    private District loadDistrict(Province p_province) throws Exception {
        Integer intProvince_id = null;
        if (p_province != null) {
            intProvince_id = p_province.getProvinceId();
        }
        District districtFirst = null;

        List lsDistrict = new ArrayList<SelectItem>();

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

        setLsDistrict(lsDistrict);

        return districtFirst;
    }

    private Subdist loadSubdist(District p_district) throws Exception {
        Integer intDistrict_id = null;
        if (p_district != null) {
            intDistrict_id = p_district.getDistrictId();
        }
        Subdist subdistFirst = null;

        List lsSubdist = new ArrayList<SelectItem>();

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

        setLsSubdist(lsSubdist);

        return subdistFirst;
    }

    public void doNew(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);
        setDisbCust_id(true);

        loadPrefixname();
        loadTax();
        loadCountry();

        setCountry_id(CoConstant.COUNTRY_ID_THAILAND);
        Country thailand = new Country();
        thailand.setCountryId(getCountry_id());

        loadProvince(thailand);

        setProvince_id(CoConstant.PROVINCE_ID_BANGKOK);

        Province bangkok = new Province();
        bangkok.setProvinceId(getProvince_id());

        District districtFirst = loadDistrict(bangkok);

        Subdist subdistFirst = loadSubdist(districtFirst);

        if (subdistFirst != null) {
            setZipcode(subdistFirst.getZipcode());
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
        setDisbCust_id(false);
        
        setMode(MODE_EDIT);
        setLsPrefixname(null);
        setLsCountry(null);
        setLsProvince(null);
        setLsDistrict(null);
        setLsSubdist(null);
        setLsTax(null);
    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Customer customer = new Customer();
            customer.setCustId(getCust_id());
            customer.setName(getName());
            customer.setAddr1(getAddr1());
            customer.setAddr2(getAddr2());
            customer.setRoad(getRoad());
            customer.setSoi(getSoi());
            customer.setZipcode(getZipcode());
            customer.setPhone(getPhone());
            customer.setFax(getFax());
            customer.setEmail(getEmail());

            Prefixname prefixname = new Prefixname(getPrefix_id());
            customer.setPrefixname(prefixname);

            if ((getTax_id() != null) && (getTax_id().length() > 0)) {
                Tax tax = new Tax(getTax_id());
                customer.setTax(tax);
            }

            Subdist subdist = new Subdist(getSubdist_id());
            customer.setSubdist(subdist);

            Province province = new Province(getProvince_id());
            customer.setProvince(province);

            District district = new District(getDistrict_id());
            customer.setDistrict(district);

            Country country = new Country(getCountry_id());
            customer.setCountry(country);

            customer.setUuser(getUuser());

            CoFacadeRemote coFacade = EJBLookup.getCoFacade();

            if (getMode().equals(MODE_EDIT)) {
                coFacade.editCustomer(customer);
                checkCust_id(customer.getCustId());
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                message("Save Complete");

            } else if (getMode().equals(MODE_NEW)) {
                String strNewCust_id = coFacade.createCustomer(customer);
                checkCust_id(strNewCust_id);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                message("Create Complete");

            } else {
                message("Unknown Operation Mode");
            }
        } catch (Exception ex) {
            message(ex.getMessage());
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

            message("Delete Complete");
        } else {
            message("Please Enter Customer ID");
        }
    }
}
