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
@Table(name = "co_stat")
@NamedQueries({
    @NamedQuery(name = "Co_stat.findAll", query = "SELECT c FROM Co_stat c")})
public class Co_stat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STAT")
    private Character stat;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costat", fetch = FetchType.LAZY)
    private Collection<Coitem> coitemCollection;
    @OneToMany(mappedBy = "costat", fetch = FetchType.LAZY)
    private Collection<Co> coCollection;

    public Co_stat() {
    }

    public Co_stat(Character stat) {
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

    public Collection<Coitem> getCoitemCollection() {
        return coitemCollection;
    }

    public void setCoitemCollection(Collection<Coitem> coitemCollection) {
        this.coitemCollection = coitemCollection;
    }

    public Collection<Co> getCoCollection() {
        return coCollection;
    }

    public void setCoCollection(Collection<Co> coCollection) {
        this.coCollection = coCollection;
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
        if (!(object instanceof Co_stat)) {
            return false;
        }
        Co_stat other = (Co_stat) object;
        if ((this.stat == null && other.stat != null) || (this.stat != null && !this.stat.equals(other.stat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Co_stat[stat=" + stat + "]";
    }

}
