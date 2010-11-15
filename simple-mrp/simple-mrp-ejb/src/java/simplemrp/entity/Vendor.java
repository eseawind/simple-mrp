/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "vendor")
@NamedQueries({
    @NamedQuery(name = "Vendor.findAll", query = "SELECT v FROM Vendor v")})
public class Vendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VEND_ID")
    private String vendId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TAX_NO")
    private String taxNo;
    @Column(name = "BANK_ACCT")
    private String bankAcct;
    @Column(name = "NOTE")
    private String note;
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
    @JoinColumn(name = "TERM_ID", referencedColumnName = "TERM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Term term;
    @JoinColumn(name = "TAX_ID", referencedColumnName = "TAX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tax tax;
    @JoinColumn(name = "SUBDIST_ID", referencedColumnName = "SUBDIST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subdist subdist;
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "PROVINCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
    @JoinColumn(name = "PAY_TYPE", referencedColumnName = "PAY_TYPE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Payment_type paymenttype;
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;
    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private Collection<Pritem> pritemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor", fetch = FetchType.LAZY)
    private Collection<Po> poCollection;

    public Vendor() {
    }

    public Vendor(String vendId) {
        this.vendId = vendId;
    }

    public String getVendId() {
        return vendId;
    }

    public void setVendId(String vendId) {
        this.vendId = vendId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
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

    public Payment_type getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Payment_type paymenttype) {
        this.paymenttype = paymenttype;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Collection<Pritem> getPritemCollection() {
        return pritemCollection;
    }

    public void setPritemCollection(Collection<Pritem> pritemCollection) {
        this.pritemCollection = pritemCollection;
    }

    public Collection<Po> getPoCollection() {
        return poCollection;
    }

    public void setPoCollection(Collection<Po> poCollection) {
        this.poCollection = poCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendId != null ? vendId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.vendId == null && other.vendId != null) || (this.vendId != null && !this.vendId.equals(other.vendId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Vendor[vendId=" + vendId + "]";
    }

}
