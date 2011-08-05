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
@Table(name = "itemmatl")
@NamedQueries({
    @NamedQuery(name = "Itemmatl.findAll", query = "SELECT i FROM Itemmatl i")})
public class Itemmatl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemmatlPK itemmatlPK;
    @Column(name = "QTY")
    private Double qty;
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

    @JoinColumns({
        @JoinColumn(name = "ITEM", referencedColumnName = "ITEM", insertable = false, updatable = false),
        @JoinColumn(name = "OPR", referencedColumnName = "OPR", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Itemopr itemopr;

    @JoinColumn(name = "MATL", referencedColumnName = "ITEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item matl;

    public Itemmatl() {
    }

    public Itemmatl(ItemmatlPK itemmatlPK) {
        this.itemmatlPK = itemmatlPK;
    }

    public Itemmatl(String item, int opr, int seq) {
        this.itemmatlPK = new ItemmatlPK(item, opr, seq);
    }

    public ItemmatlPK getItemmatlPK() {
        return itemmatlPK;
    }

    public void setItemmatlPK(ItemmatlPK itemmatlPK) {
        this.itemmatlPK = itemmatlPK;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
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

    public Itemopr getItemopr() {
        return itemopr;
    }

    public void setItemopr(Itemopr itemopr) {
        this.itemopr = itemopr;
    }

    public Item getMatl() {
        return matl;
    }

    public void setMatl(Item item1) {
        this.matl = item1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemmatlPK != null ? itemmatlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemmatl)) {
            return false;
        }
        Itemmatl other = (Itemmatl) object;
        if ((this.itemmatlPK == null && other.itemmatlPK != null) || (this.itemmatlPK != null && !this.itemmatlPK.equals(other.itemmatlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Itemmatl[itemmatlPK=" + itemmatlPK + "]";
    }

}
