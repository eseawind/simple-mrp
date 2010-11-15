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
@Table(name = "mps_type")
@NamedQueries({
    @NamedQuery(name = "Mps_type.findAll", query = "SELECT m FROM Mps_type m")})
public class Mps_type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MPS_TYPE")
    private Character mpsType;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mpstype", fetch = FetchType.LAZY)
    private Collection<Mps> mpsCollection;

    public Mps_type() {
    }

    public Mps_type(Character mpsType) {
        this.mpsType = mpsType;
    }

    public Character getMpsType() {
        return mpsType;
    }

    public void setMpsType(Character mpsType) {
        this.mpsType = mpsType;
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
        hash += (mpsType != null ? mpsType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mps_type)) {
            return false;
        }
        Mps_type other = (Mps_type) object;
        if ((this.mpsType == null && other.mpsType != null) || (this.mpsType != null && !this.mpsType.equals(other.mpsType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Mps_type[mpsType=" + mpsType + "]";
    }

}
