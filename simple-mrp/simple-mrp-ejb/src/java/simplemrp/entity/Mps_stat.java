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
@Table(name = "mps_stat")
@NamedQueries({
    @NamedQuery(name = "Mps_stat.findAll", query = "SELECT m FROM Mps_stat m")})
public class Mps_stat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STAT")
    private Character stat;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "mpsstat", fetch = FetchType.LAZY)
    private Collection<Mps> mpsCollection;

    public Mps_stat() {
    }

    public Mps_stat(Character stat) {
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

    public Collection<Mps> getMpsCollection() {
        return mpsCollection;
    }

    public void setMpsCollection(Collection<Mps> mpsCollection) {
        this.mpsCollection = mpsCollection;
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
        if (!(object instanceof Mps_stat)) {
            return false;
        }
        Mps_stat other = (Mps_stat) object;
        if ((this.stat == null && other.stat != null) || (this.stat != null && !this.stat.equals(other.stat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Mps_stat[stat=" + stat + "]";
    }

}
