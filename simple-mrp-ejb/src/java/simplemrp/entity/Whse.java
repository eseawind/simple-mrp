/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "whse")
@NamedQueries({
    @NamedQuery(name = "Whse.findAll", query = "SELECT w FROM Whse w")})
public class Whse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WHSE")
    private String whse;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "whse1", fetch = FetchType.LAZY)
    private Collection<Loc> locCollection;

    public Whse() {
    }

    public Whse(String whse) {
        this.whse = whse;
    }

    public String getWhse() {
        return whse;
    }

    public void setWhse(String whse) {
        this.whse = whse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Loc> getLocCollection() {
        return locCollection;
    }

    public void setLocCollection(Collection<Loc> locCollection) {
        this.locCollection = locCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (whse != null ? whse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Whse)) {
            return false;
        }
        Whse other = (Whse) object;
        if ((this.whse == null && other.whse != null) || (this.whse != null && !this.whse.equals(other.whse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Whse[whse=" + whse + "]";
    }

}
