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
@Table(name = "workcenter")
@NamedQueries({
    @NamedQuery(name = "Workcenter.findAll", query = "SELECT w FROM Workcenter w")})
public class Workcenter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WC")
    private String wc;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workcenter", fetch = FetchType.LAZY)
    private Collection<Itemopr> itemoprCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workcenter", fetch = FetchType.LAZY)
    private Collection<Jobopr> joboprCollection;

    public Workcenter() {
    }

    public Workcenter(String wc) {
        this.wc = wc;
    }

    public String getWc() {
        return wc;
    }

    public void setWc(String wc) {
        this.wc = wc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Itemopr> getItemoprCollection() {
        return itemoprCollection;
    }

    public void setItemoprCollection(Collection<Itemopr> itemoprCollection) {
        this.itemoprCollection = itemoprCollection;
    }

    public Collection<Jobopr> getJoboprCollection() {
        return joboprCollection;
    }

    public void setJoboprCollection(Collection<Jobopr> joboprCollection) {
        this.joboprCollection = joboprCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wc != null ? wc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workcenter)) {
            return false;
        }
        Workcenter other = (Workcenter) object;
        if ((this.wc == null && other.wc != null) || (this.wc != null && !this.wc.equals(other.wc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Workcenter[wc=" + wc + "]";
    }

}
