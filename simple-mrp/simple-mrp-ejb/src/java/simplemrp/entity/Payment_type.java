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
@Table(name = "payment_type")
@NamedQueries({
    @NamedQuery(name = "Payment_type.findAll", query = "SELECT p FROM Payment_type p")})
public class Payment_type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAY_TYPE")
    private String payType;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "paymenttype", fetch = FetchType.LAZY)
    private Collection<Vendor> vendorCollection;

    public Payment_type() {
    }

    public Payment_type(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (payType != null ? payType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment_type)) {
            return false;
        }
        Payment_type other = (Payment_type) object;
        if ((this.payType == null && other.payType != null) || (this.payType != null && !this.payType.equals(other.payType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Payment_type[payType=" + payType + "]";
    }

}
