/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "loc")
@NamedQueries({
    @NamedQuery(name = "Loc.findAll", query = "SELECT l FROM Loc l")})
public class Loc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocPK locPK;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "WHSE", referencedColumnName = "WHSE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Whse whse1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loc1", fetch = FetchType.LAZY)
    private Collection<Itemloc> itemlocCollection;

    public Loc() {
    }

    public Loc(LocPK locPK) {
        this.locPK = locPK;
    }

    public Loc(String whse, String loc) {
        this.locPK = new LocPK(whse, loc);
    }

    public LocPK getLocPK() {
        return locPK;
    }

    public void setLocPK(LocPK locPK) {
        this.locPK = locPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Whse getWhse1() {
        return whse1;
    }

    public void setWhse1(Whse whse1) {
        this.whse1 = whse1;
    }

    public Collection<Itemloc> getItemlocCollection() {
        return itemlocCollection;
    }

    public void setItemlocCollection(Collection<Itemloc> itemlocCollection) {
        this.itemlocCollection = itemlocCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locPK != null ? locPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loc)) {
            return false;
        }
        Loc other = (Loc) object;
        if ((this.locPK == null && other.locPK != null) || (this.locPK != null && !this.locPK.equals(other.locPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Loc[locPK=" + locPK + "]";
    }

}
