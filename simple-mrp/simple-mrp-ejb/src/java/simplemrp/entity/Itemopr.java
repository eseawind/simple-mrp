/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
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
@Table(name = "itemopr")
@NamedQueries({
    @NamedQuery(name = "Itemopr.findAll", query = "SELECT i FROM Itemopr i")})
public class Itemopr implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemoprPK itemoprPK;
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
    @JoinColumn(name = "WC", referencedColumnName = "WC")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Workcenter workcenter;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemopr", fetch = FetchType.LAZY)
    private Collection<Itemmatl> itemmatlCollection;

    public Itemopr() {
    }

    public Itemopr(ItemoprPK itemoprPK) {
        this.itemoprPK = itemoprPK;
    }

    public Itemopr(String item, int opr) {
        this.itemoprPK = new ItemoprPK(item, opr);
    }

    public ItemoprPK getItemoprPK() {
        return itemoprPK;
    }

    public void setItemoprPK(ItemoprPK itemoprPK) {
        this.itemoprPK = itemoprPK;
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

    public Workcenter getWorkcenter() {
        return workcenter;
    }

    public void setWorkcenter(Workcenter workcenter) {
        this.workcenter = workcenter;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Collection<Itemmatl> getItemmatlCollection() {
        return itemmatlCollection;
    }

    public void setItemmatlCollection(Collection<Itemmatl> itemmatlCollection) {
        this.itemmatlCollection = itemmatlCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemoprPK != null ? itemoprPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemopr)) {
            return false;
        }
        Itemopr other = (Itemopr) object;
        if ((this.itemoprPK == null && other.itemoprPK != null) || (this.itemoprPK != null && !this.itemoprPK.equals(other.itemoprPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Itemopr[itemoprPK=" + itemoprPK + "]";
    }

}
