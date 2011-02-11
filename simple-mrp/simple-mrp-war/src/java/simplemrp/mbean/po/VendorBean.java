/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import simplemrp.mbean.po.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.DateUtil;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Country;
import simplemrp.entity.Vendor;
import simplemrp.entity.District;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.entity.Term;
import simplemrp.entity.Bank;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.constant.CoConstant;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf*/
 
public class VendorBean extends VendorAttr {
    
    /** Creates a new instance of CustomerBean*/
    public VendorBean() throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbVendor_id(false);
    }

    public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            message("Please Enter Vendor Name");
        } else {
            checkKeyword(strKeyword);
        }
    }

    private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            List<Vendor> ls = poFacade.searchVendor(p_strKeyword);

            setLsVendor(ls);
        }
    }

    public void doSelect(ActionEvent e) throws Exception {
        String strVendor_id = FacesUtils.getRequestParameter("p_vendor_id");
        checkVendor_id(strVendor_id);
    }

    public void doCheckVendor_id(ActionEvent e) throws Exception {
        checkVendor_id(StringUtil.prefixZero(getVendor_id(), 7));
    }

    private void checkVendor_id(String p_strVendor_id) throws Exception {
        setMode(MODE_EDIT);
        setDisbVendor_id(false);

        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        Vendor vendor = poFacade.getVendor(p_strVendor_id);

        if(vendor != null) {
            setAddr1(vendor.getAddr1());
            setAddr2(vendor.getAddr2());
            setBank_acc(vendor.getBankAcct());
            setBank_id(vendor.getBank().getBankId());
            setCountry_id(vendor.getCountry().getCountryId());
            setDescription(vendor.getDescription());
            setEmail(vendor.getEmail());
            setFax(vendor.getFax());
            setNote(vendor.getNote());
            setPhone(vendor.getPhone());
            setProvince(vendor.getProvince().getProvinceId());
            setRoad(vendor.getRoad());
            setSoi(vendor.getSoi());
            setSubdist_id(vendor.getSubdist().getSubdistId());
            setTax_id(vendor.getTax().getTaxId());
            setTax_no(vendor.getTaxNo());
            setVendor_id(vendor.getVendId());
            setZipcode(vendor.getZipcode());

            setDisbNew(false);
            setDisbSave(false);
            setDisbDel(false);


            loadTax();
            loadTerm();
            loadBank();
            loadCountry();
            loadProvince(vendor.getCountry());
            loadDistrict(vendor.getProvince());
            loadSubdist(vendor.getDistrict());

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
        checkProvince(getProvince());
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
        checkDistrict(getDistrict());
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

    private void loadTerm() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Term> lsAllTerm = maFacade.getListTerm();

        List lsTerm = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllTerm.size(); i++) {
            Term term = lsAllTerm.get(i);
            SelectItem selectItem = new SelectItem(term.getTermId(), term.getDescription());

            lsTerm.add(selectItem);
        }

        setLsTerm(lsTerm);
    }

    private void loadBank() throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Bank> lsAllTerm = poFacade.getListBank();

        List lsBank = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllTerm.size(); i++) {
            Bank bank = lsAllTerm.get(i);
            SelectItem selectItem = new SelectItem(bank.getBankId(), bank.getDescription());

            lsBank.add(selectItem);
        }

        setLsBank(lsBank);
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
        setDisbVendor_id(true);

        loadTerm();
        loadTax();
        loadCountry();

        setCountry_id(CoConstant.COUNTRY_ID_THAILAND);
        Country thailand = new Country();
        thailand.setCountryId(getCountry_id());

        loadProvince(thailand);

        setProvince(CoConstant.PROVINCE_ID_BANGKOK);

        Province bangkok = new Province();
        bangkok.setProvinceId(getProvince());

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
        setAddr1(null);
        setAddr2(null);
        setBank_acc(null);
        setDescription(null);
        setEmail(null);
        setFax(null);
        setNote(null);
        setPhone(null);
        setRoad(null);
        setSoi(null);
        setTax_no(null);
        setVendor_id(null);
        setZipcode(null);
        setProvince(null);
        setCountry_id(null);
        setDistrict(null);
        setSubdist_id(null);

        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbVendor_id(false);
        
        setMode(MODE_EDIT);
        setLsCountry(null);
        setLsProvince(null);
        setLsDistrict(null);
        setLsSubdist(null);
        setLsTax(null);
        setLsTerm(null);
        setLsBank(null);
    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Vendor vendor = new Vendor();
            vendor.setVendId(getVendor_id());
            vendor.setAddr1(getAddr1());
            vendor.setAddr2(getAddr2());
            vendor.setBankAcct(getBank_acc());
            vendor.setDescription(getDescription());
            vendor.setEmail(getEmail());
            vendor.setFax(getFax());
            vendor.setNote(getNote());
            vendor.setPhone(getPhone());
            vendor.setRoad(getRoad());
            vendor.setSoi(getSoi());
            vendor.setTaxNo(getTax_no());
            vendor.setZipcode(getZipcode());


            if ((getTax_id() != null) && (getTax_id().length() > 0)) {
                Tax tax = new Tax(getTax_id());
                vendor.setTax(tax);
            }

            if ((getTerm_id() != null) && (getTerm_id().length() > 0)) {
                Term term = new Term(getTerm_id());
                vendor.setTerm(term);
            }

            Subdist subdist = new Subdist(getSubdist_id());
            vendor.setSubdist(subdist);

            Province province = new Province(getProvince());
            vendor.setProvince(province);

            District district = new District(getDistrict());
            vendor.setDistrict(district);

            Country country = new Country(getCountry_id());
            vendor.setCountry(country);

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();

            if (getMode().equals(MODE_EDIT)) {
                poFacade.editVendor(vendor);
                checkVendor_id(vendor.getVendId());
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                message("Save Complete");

            } else if (getMode().equals(MODE_NEW)) {
                String strNewVendor_id = poFacade.createVendor(vendor);
                checkVendor_id(strNewVendor_id);
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
        if (getVendor_id().length() == 7) {
            Vendor vendor = new Vendor();
            vendor.setVendId(getVendor_id());
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            poFacade.deleteVendor(vendor);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Vendor ID");
        }
    }
}
