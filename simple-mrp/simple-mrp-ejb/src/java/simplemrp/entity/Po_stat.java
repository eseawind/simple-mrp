/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "po_stat")
@NamedQueries({
    @NamedQuery(name = "Po_stat.findAll", query = "SELECT p FROM Po_stat p")})
public class Po_stat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STAT")
    private Character stat;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "postat", fetch = FetchType.LAZY)
    private Collection<Poitem> poitemCollection;
    @OneToMany(mappedBy = "postat", fetch = FetchType.LAZY)
    private Collection<Po> poCollection;

    public Po_stat() {
    }

    public Po_stat(Character stat) {
        this.stat = stat;
    }

    public Character getStat() {
        return stat;
    }

    public void setStat(Character stat) {
        this.stat = stat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Poitem> getPoitemCollection() {
        return poitemCollection;
    }

    public void setPoitemCollection(Collection<Poitem> poitemCollection) {
        this.poitemCollection = poitemCollection;
    }

    public Collection<Po> getPoCollection() {
        return poCollection;
    }

    public void setPoCollection(Collection<Po> poCollection) {
        this.poCollection = poCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stat != null ? stat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Po_stat)) {
            return false;
        }
        Po_stat other = (Po_stat) object;
        if ((this.stat == null && other.stat != null) || (this.stat != null && !this.stat.equals(other.stat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Po_stat[stat=" + stat + "]";
    }

}
