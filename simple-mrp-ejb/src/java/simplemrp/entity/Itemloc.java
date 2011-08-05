/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "itemloc")
@NamedQueries({
    @NamedQuery(name = "Itemloc.findAll", query = "SELECT i FROM Itemloc i")})
public class Itemloc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemlocPK itemlocPK;
    @Column(name = "ONHAND")
    private Double onhand;
    @Basic(optional = false)
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Basic(optional = false)
    @Column(name = "UUSER")
    private String uuser;
    @OneToMany(mappedBy = "itemloc", fetch = FetchType.LAZY)
    private Collection<Stocktrans> stocktransCollection;
    @JoinColumns({
        @JoinColumn(name = "WHSE", referencedColumnName = "WHSE", insertable = false, updatable = false),
        @JoinColumn(name = "LOC", referencedColumnName = "LOC", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Loc loc1;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item1;

    public Itemloc() {
    }

    public Itemloc(ItemlocPK itemlocPK) {
        this.itemlocPK = itemlocPK;
    }

    public Itemloc(ItemlocPK itemlocPK, Date udate, String uuser) {
        this.itemlocPK = itemlocPK;
        this.udate = udate;
        this.uuser = uuser;
    }

    public Itemloc(String whse, String loc, String item) {
        this.itemlocPK = new ItemlocPK(whse, loc, item);
    }

    public ItemlocPK getItemlocPK() {
        return itemlocPK;
    }

    public void setItemlocPK(ItemlocPK itemlocPK) {
        this.itemlocPK = itemlocPK;
    }

    public Double getOnhand() {
        return onhand;
    }

    public void setOnhand(Double onhand) {
        this.onhand = onhand;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public Collection<Stocktrans> getStocktransCollection() {
        return stocktransCollection;
    }

    public void setStocktransCollection(Collection<Stocktrans> stocktransCollection) {
        this.stocktransCollection = stocktransCollection;
    }

    public Loc getLoc1() {
        return loc1;
    }

    public void setLoc1(Loc loc1) {
        this.loc1 = loc1;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemlocPK != null ? itemlocPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemloc)) {
            return false;
        }
        Itemloc other = (Itemloc) object;
        if ((this.itemlocPK == null && other.itemlocPK != null) || (this.itemlocPK != null && !this.itemlocPK.equals(other.itemlocPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Itemloc[itemlocPK=" + itemlocPK + "]";
    }

}
