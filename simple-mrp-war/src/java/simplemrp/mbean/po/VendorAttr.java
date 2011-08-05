/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import simplemrp.mbean.po.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Vendor;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class VendorAttr extends AbstractManageBean {
    private String mode;
    private String vendor_id;
    private String description;
    private String term_id;
    private String tax_id;
    private String tax_no;
    private String par_typ;
    private String bank_id;
    private String bank_acc;
    private String note;
    private String addr1;
    private String addr2;
    private String road;
    private String soi;
    private Integer subdist_id;
    private Integer district;
    private Integer province;
    private String zipcode;
    private Integer country_id;

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getSubdist_id() {
        return subdist_id;
    }

    public void setSubdist_id(Integer subdist_id) {
        this.subdist_id = subdist_id;
    }
    private String phone;
    private String fax;
    private String email;
    private String keyword;

    private List<Vendor> lsVendor;
    private List<SelectItem> lsCountry;
    private List<SelectItem> lsProvince;
    private List<SelectItem> lsDistrict;
    private List<SelectItem> lsSubdist;
    private List<SelectItem> lsTax;
    private List<SelectItem> lsTerm;
    private List<SelectItem> lsPayType;
    private List<SelectItem> lsBank;

    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;
    private boolean disbVendor_id;

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

    public String getMode() {
        return mode;
    }

    public String getBank_acc() {
        return bank_acc;
    }

    public void setBank_acc(String bank_acc) {
        this.bank_acc = bank_acc;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDisbVendor_id() {
        return disbVendor_id;
    }

    public void setDisbVendor_id(boolean disbVendor_id) {
        this.disbVendor_id = disbVendor_id;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<SelectItem> getLsBank() {
        if(lsBank == null) {
            lsBank = new ArrayList<SelectItem>();
        }

        return lsBank;
    }

    public void setLsBank(List<SelectItem> lsBank) {
        this.lsBank = lsBank;
    }

    public List<SelectItem> getLsPayType() {
        if(lsPayType == null) {
            lsPayType = new ArrayList<SelectItem>();
        }
        return lsPayType;
    }

    public void setLsPayType(List<SelectItem> lsPayType) {
        this.lsPayType = lsPayType;
    }

    public List<SelectItem> getLsTerm() {
        if(lsTerm == null) {
            lsTerm = new ArrayList<SelectItem>();
        }
        return lsTerm;
    }

    public void setLsTerm(List<SelectItem> lsTerm) {
        this.lsTerm = lsTerm;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPar_typ() {
        return par_typ;
    }

    public void setPar_typ(String par_typ) {
        this.par_typ = par_typ;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getTax_no() {
        return tax_no;
    }

    public void setTax_no(String tax_no) {
        this.tax_no = tax_no;
    }

    public String getTerm_id() {
        return term_id;
    }

    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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

    public List<SelectItem> getLsCountry() {
        if(lsCountry == null) {
            lsCountry = new ArrayList<SelectItem>();
        }
        return lsCountry;
    }

    public void setLsCountry(List<SelectItem> lsCountry) {
        this.lsCountry = lsCountry;
    }

    public List<Vendor> getLsVendor() {
        if(lsVendor == null) {
            lsVendor = new ArrayList<Vendor>();
        }
        return lsVendor;
    }

    public void setLsVendor(List<Vendor> lsVendor) {

        this.lsVendor = lsVendor;
    }

    public List<SelectItem> getLsDistrict() {
        if(lsDistrict == null) {
            lsDistrict = new ArrayList<SelectItem>();
        }
        return lsDistrict;
    }

    public void setLsDistrict(List<SelectItem> lsDistrict) {
        this.lsDistrict = lsDistrict;
    }

    public List<SelectItem> getLsProvince() {
        if(lsProvince == null) {
            lsProvince = new ArrayList<SelectItem>();
        }
        return lsProvince;
    }

    public void setLsProvince(List<SelectItem> lsProvince) {
        this.lsProvince = lsProvince;
    }

    public List<SelectItem> getLsSubdist() {
        if(lsSubdist == null) {
            lsSubdist = new ArrayList<SelectItem>();
        }
        return lsSubdist;
    }

    public void setLsSubdist(List<SelectItem> lsSubdist) {
        this.lsSubdist = lsSubdist;
    }

    public List<SelectItem> getLsTax() {
        if(lsTax == null) {
            lsTax = new ArrayList<SelectItem>();
        }
        return lsTax;
    }

    public void setLsTax(List<SelectItem> lsTax) {
        this.lsTax = lsTax;
    }

}
