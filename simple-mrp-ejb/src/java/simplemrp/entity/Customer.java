/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUST_ID")
    private String custId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDR1")
    private String addr1;
    @Column(name = "ADDR2")
    private String addr2;
    @Column(name = "ROAD")
    private String road;
    @Column(name = "SOI")
    private String soi;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "CUSER")
    private String cuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Column(name = "UUSER")
    private String uuser;
    @JoinColumn(name = "PREFIXNAME", referencedColumnName = "prefix_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Prefixname prefixname;
    @JoinColumn(name = "TAX_ID", referencedColumnName = "TAX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tax tax;
    @JoinColumn(name = "SUBDIST_ID", referencedColumnName = "SUBDIST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subdist subdist;
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "PROVINCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Collection<Co> coCollection;

    public Customer() {
    }

    public Customer(String custId) {
        this.custId = custId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Prefixname getPrefixname() {
        return prefixname;
    }

    public void setPrefixname(Prefixname prefixname) {
        this.prefixname = prefixname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
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

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Subdist getSubdist() {
        return subdist;
    }

    public void setSubdist(Subdist subdist) {
        this.subdist = subdist;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Collection<Co> getCoCollection() {
        return coCollection;
    }

    public void setCoCollection(Collection<Co> coCollection) {
        this.coCollection = coCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Customer[custId=" + custId + "]";
    }

}
