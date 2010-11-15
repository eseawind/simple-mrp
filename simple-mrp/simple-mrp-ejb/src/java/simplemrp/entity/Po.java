/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "po")
@NamedQueries({
    @NamedQuery(name = "Po.findAll", query = "SELECT p FROM Po p")})
public class Po implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PO_ID")
    private String poId;
    @Column(name = "PO_DATE")
    @Temporal(TemporalType.DATE)
    private Date poDate;
    @Column(name = "INV_DATE")
    @Temporal(TemporalType.DATE)
    private Date invDate;
    @Column(name = "INV_NUM")
    private String invNum;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "CUSER")
    private String cuser;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "UUSER")
    private String uuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "po", fetch = FetchType.LAZY)
    private Collection<Poitem> poitemCollection;
    @JoinColumn(name = "VEND_ID", referencedColumnName = "VEND_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vendor vendor;
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Po_stat postat;

    public Po() {
    }

    public Po(String poId) {
        this.poId = poId;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public String getInvNum() {
        return invNum;
    }

    public void setInvNum(String invNum) {
        this.invNum = invNum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public Collection<Poitem> getPoitemCollection() {
        return poitemCollection;
    }

    public void setPoitemCollection(Collection<Poitem> poitemCollection) {
        this.poitemCollection = poitemCollection;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Po_stat getPostat() {
        return postat;
    }

    public void setPostat(Po_stat postat) {
        this.postat = postat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poId != null ? poId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Po)) {
            return false;
        }
        Po other = (Po) object;
        if ((this.poId == null && other.poId != null) || (this.poId != null && !this.poId.equals(other.poId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Po[poId=" + poId + "]";
    }

}
