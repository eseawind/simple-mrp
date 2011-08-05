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
@Table(name = "district")
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d")})
public class District implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DISTRICT_ID")
    private Integer districtId;
    @Column(name = "DISTRICT_NAME")
    private String districtName;
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private Collection<Subdist> subdistCollection;
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "PROVINCE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;
    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private Collection<Vendor> vendorCollection;

    public District() {
    }

    public District(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Collection<Subdist> getSubdistCollection() {
        return subdistCollection;
    }

    public void setSubdistCollection(Collection<Subdist> subdistCollection) {
        this.subdistCollection = subdistCollection;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
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
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.District[districtId=" + districtId + "]";
    }

}
