/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.co;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Customer;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class CustomerAttr extends AbstractManageBean {
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
    private boolean disbCust_id;

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

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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

    public void setPrefix_id(Integer prefix_id) {
        this.prefix_id = prefix_id;
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

    public boolean isDisbCust_id() {
        return disbCust_id;
    }

    public void setDisbCust_id(boolean disbCust_id) {
        this.disbCust_id = disbCust_id;
    }
}
