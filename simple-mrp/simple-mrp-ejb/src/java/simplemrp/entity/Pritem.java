/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "pritem")
@NamedQueries({
    @NamedQuery(name = "Pritem.findAll", query = "SELECT p FROM Pritem p")})
public class Pritem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PritemPK pritemPK;
    @Column(name = "QTY")
    private Double qty;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "UUSER")
    private String uuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @OneToMany(mappedBy = "pritem", fetch = FetchType.LAZY)
    private Collection<Poitem> poitemCollection;
    @JoinColumn(name = "VEND_ID", referencedColumnName = "VEND_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendor vendor;
    @JoinColumn(name = "PR_ID", referencedColumnName = "PR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pr pr;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM")
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    public Pritem() {
    }

    public Pritem(PritemPK pritemPK) {
        this.pritemPK = pritemPK;
    }

    public Pritem(String prId, int prSeq) {
        this.pritemPK = new PritemPK(prId, prSeq);
    }

    public PritemPK getPritemPK() {
        return pritemPK;
    }

    public void setPritemPK(PritemPK pritemPK) {
        this.pritemPK = pritemPK;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Pr getPr() {
        return pr;
    }

    public void setPr(Pr pr) {
        this.pr = pr;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pritemPK != null ? pritemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pritem)) {
            return false;
        }
        Pritem other = (Pritem) object;
        if ((this.pritemPK == null && other.pritemPK != null) || (this.pritemPK != null && !this.pritemPK.equals(other.pritemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Pritem[pritemPK=" + pritemPK + "]";
    }

}
