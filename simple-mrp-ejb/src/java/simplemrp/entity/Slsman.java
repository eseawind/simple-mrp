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
@Table(name = "slsman")
@NamedQueries({
    @NamedQuery(name = "Slsman.findAll", query = "SELECT s FROM Slsman s")})
public class Slsman implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SLSMAN")
    private String slsman;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "LNAME")
    private String lname;
    @OneToMany(mappedBy = "slsman", fetch = FetchType.LAZY)
    private Collection<Co> coCollection;

    public Slsman() {
    }

    public Slsman(String slsman) {
        this.slsman = slsman;
    }

    public String getSlsman() {
        return slsman;
    }

    public void setSlsman(String slsman) {
        this.slsman = slsman;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
        hash += (slsman != null ? slsman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slsman)) {
            return false;
        }
        Slsman other = (Slsman) object;
        if ((this.slsman == null && other.slsman != null) || (this.slsman != null && !this.slsman.equals(other.slsman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Slsman[slsman=" + slsman + "]";
    }

}
