/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "itemprice")
@NamedQueries({
    @NamedQuery(name = "Itemprice.findAll", query = "SELECT i FROM Itemprice i")})
public class Itemprice implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItempricePK itempricePK;
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "PRICE")
    private Double price;
    @Basic(optional = false)
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Basic(optional = false)
    @Column(name = "UUSER")
    private String uuser;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item1;

    public Itemprice() {
    }

    public Itemprice(ItempricePK itempricePK) {
        this.itempricePK = itempricePK;
    }

    public Itemprice(ItempricePK itempricePK, Date udate, String uuser) {
        this.itempricePK = itempricePK;
        this.udate = udate;
        this.uuser = uuser;
    }

    public Itemprice(String item, Date effdate) {
        this.itempricePK = new ItempricePK(item, effdate);
    }

    public ItempricePK getItempricePK() {
        return itempricePK;
    }

    public void setItempricePK(ItempricePK itempricePK) {
        this.itempricePK = itempricePK;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itempricePK != null ? itempricePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemprice)) {
            return false;
        }
        Itemprice other = (Itemprice) object;
        if ((this.itempricePK == null && other.itempricePK != null) || (this.itempricePK != null && !this.itempricePK.equals(other.itempricePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Itemprice[itempricePK=" + itempricePK + "]";
    }

}
