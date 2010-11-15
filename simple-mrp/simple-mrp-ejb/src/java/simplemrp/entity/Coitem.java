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
@Table(name = "coitem")
@NamedQueries({
    @NamedQuery(name = "Coitem.findAll", query = "SELECT c FROM Coitem c")})
public class Coitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoitemPK coitemPK;
    @Column(name = "QTY")
    private Double qty;
    @Column(name = "QTYSHIP")
    private Double qtyship;
    @Column(name = "QTYINV")
    private Double qtyinv;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "UUSER")
    private String uuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "CUSER")
    private String cuser;
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Co_stat costat;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;
    @JoinColumn(name = "CO_ID", referencedColumnName = "CO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Co co;

    public Coitem() {
    }

    public Coitem(CoitemPK coitemPK) {
        this.coitemPK = coitemPK;
    }

    public Coitem(String coId, int coSeq) {
        this.coitemPK = new CoitemPK(coId, coSeq);
    }

    public CoitemPK getCoitemPK() {
        return coitemPK;
    }

    public void setCoitemPK(CoitemPK coitemPK) {
        this.coitemPK = coitemPK;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getQtyship() {
        return qtyship;
    }

    public void setQtyship(Double qtyship) {
        this.qtyship = qtyship;
    }

    public Double getQtyinv() {
        return qtyinv;
    }

    public void setQtyinv(Double qtyinv) {
        this.qtyinv = qtyinv;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Co_stat getCostat() {
        return costat;
    }

    public void setCostat(Co_stat costat) {
        this.costat = costat;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Co getCo() {
        return co;
    }

    public void setCo(Co co) {
        this.co = co;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coitemPK != null ? coitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coitem)) {
            return false;
        }
        Coitem other = (Coitem) object;
        if ((this.coitemPK == null && other.coitemPK != null) || (this.coitemPK != null && !this.coitemPK.equals(other.coitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Coitem[coitemPK=" + coitemPK + "]";
    }

}
