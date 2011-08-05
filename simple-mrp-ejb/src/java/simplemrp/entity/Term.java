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
@Table(name = "term")
@NamedQueries({
    @NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t")})
public class Term implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TERM_ID")
    private String termId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DUE_DAYS")
    private Integer dueDays;
    @Column(name = "CASH_ONLY")
    private String cashOnly;
    @OneToMany(mappedBy = "term", fetch = FetchType.LAZY)
    private Collection<Vendor> vendorCollection;
    @OneToMany(mappedBy = "term", fetch = FetchType.LAZY)
    private Collection<Co> coCollection;

    public Term() {
    }

    public Term(String termId) {
        this.termId = termId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDueDays() {
        return dueDays;
    }

    public void setDueDays(Integer dueDays) {
        this.dueDays = dueDays;
    }

    public String getCashOnly() {
        return cashOnly;
    }

    public void setCashOnly(String cashOnly) {
        this.cashOnly = cashOnly;
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
        hash += (termId != null ? termId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Term)) {
            return false;
        }
        Term other = (Term) object;
        if ((this.termId == null && other.termId != null) || (this.termId != null && !this.termId.equals(other.termId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Term[termId=" + termId + "]";
    }

}
