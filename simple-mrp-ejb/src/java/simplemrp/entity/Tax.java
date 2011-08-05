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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "tax")
@NamedQueries({
    @NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t")})
public class Tax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAX_ID")
    private String taxId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "RATE")
    private double rate;
    @OneToMany(mappedBy = "tax", fetch = FetchType.LAZY)
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "tax", fetch = FetchType.LAZY)
    private Collection<Vendor> vendorCollection;
    @OneToMany(mappedBy = "tax", fetch = FetchType.LAZY)
    private Collection<Co> coCollection;

    public Tax() {
    }

    public Tax(String taxId) {
        this.taxId = taxId;
    }

    public Tax(String taxId, double rate) {
        this.taxId = taxId;
        this.rate = rate;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Collection<Vendor> getVendorCollection() {
        return vendorCollection;
    }

    public void setVendorCollection(Collection<Vendor> vendorCollection) {
        this.vendorCollection = vendorCollection;
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
        hash += (taxId != null ? taxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tax)) {
            return false;
        }
        Tax other = (Tax) object;
        if ((this.taxId == null && other.taxId != null) || (this.taxId != null && !this.taxId.equals(other.taxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Tax[taxId=" + taxId + "]";
    }

}
