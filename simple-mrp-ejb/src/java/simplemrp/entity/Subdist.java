/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "subdist")
@NamedQueries({
    @NamedQuery(name = "Subdist.findAll", query = "SELECT s FROM Subdist s")})
public class Subdist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUBDIST_ID")
    private Integer subdistId;
    @Column(name = "SUBDIST_NAME")
    private String subdistName;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @OneToMany(mappedBy = "subdist", fetch = FetchType.LAZY)
    private Collection<Customer> customerCollection;
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;
    @OneToMany(mappedBy = "subdist", fetch = FetchType.LAZY)
    private Collection<Vendor> vendorCollection;

    public Subdist() {
    }

    public Subdist(Integer subdistId) {
        this.subdistId = subdistId;
    }

    public Integer getSubdistId() {
        return subdistId;
    }

    public void setSubdistId(Integer subdistId) {
        this.subdistId = subdistId;
    }

    public String getSubdistName() {
        return subdistName;
    }

    public void setSubdistName(String subdistName) {
        this.subdistName = subdistName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Collection<Vendor> getVendorCollection() {
        return vendorCollection;
    }

    public void setVendorCollection(Collection<Vendor> vendorCollection) {
        this.vendorCollection = vendorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdistId != null ? subdistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subdist)) {
            return false;
        }
        Subdist other = (Subdist) object;
        if ((this.subdistId == null && other.subdistId != null) || (this.subdistId != null && !this.subdistId.equals(other.subdistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Subdist[subdistId=" + subdistId + "]";
    }

}
