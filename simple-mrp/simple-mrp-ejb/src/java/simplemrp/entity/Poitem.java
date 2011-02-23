/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "poitem")
@NamedQueries({
    @NamedQuery(name = "Poitem.findAll", query = "SELECT p FROM Poitem p")})
public class Poitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PoitemPK poitemPK;
    @Column(name = "QTY")
    private Double qty;
    @Column(name = "QTY_RCV")
    private Double qtyRcv;
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "VEND_ITEM")
    private String vendItem;
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
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Po_stat postat;
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @JoinColumns({
        @JoinColumn(name = "PR_ID", referencedColumnName = "PR_ID"),
        @JoinColumn(name = "PR_SEQ", referencedColumnName = "PR_SEQ")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Pritem pritem;
    @JoinColumn(name = "PO_ID", referencedColumnName = "PO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Po po;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM")
    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;

    public Poitem() {
    }

    public Poitem(PoitemPK poitemPK) {
        this.poitemPK = poitemPK;
    }

    public Poitem(String poId, int poSeq) {
        this.poitemPK = new PoitemPK(poId, poSeq);
    }

    public PoitemPK getPoitemPK() {
        return poitemPK;
    }

    public void setPoitemPK(PoitemPK poitemPK) {
        this.poitemPK = poitemPK;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getQtyRcv() {
        return qtyRcv;
    }

    public void setQtyRcv(Double qtyRcv) {
        this.qtyRcv = qtyRcv;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getVendItem() {
        return vendItem;
    }

    public void setVendItem(String vendItem) {
        this.vendItem = vendItem;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Po_stat getPostat() {
        return postat;
    }

    public void setPostat(Po_stat postat) {
        this.postat = postat;
    }

    public Pritem getPritem() {
        return pritem;
    }

    public void setPritem(Pritem pritem) {
        this.pritem = pritem;
    }

    public Po getPo() {
        return po;
    }

    public void setPo(Po po) {
        this.po = po;
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
        hash += (poitemPK != null ? poitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poitem)) {
            return false;
        }
        Poitem other = (Poitem) object;
        if ((this.poitemPK == null && other.poitemPK != null) || (this.poitemPK != null && !this.poitemPK.equals(other.poitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Poitem[poitemPK=" + poitemPK + "]";
    }

}
