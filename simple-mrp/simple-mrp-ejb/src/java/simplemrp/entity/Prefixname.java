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
@Table(name = "prefixname")
@NamedQueries({
    @NamedQuery(name = "Prefixname.findAll", query = "SELECT p FROM Prefixname p")})
public class Prefixname implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prefix_id")
    private Integer prefixId;
    @Column(name = "prefixname")
    private String prefixname;
    @OneToMany(mappedBy = "prefixname", fetch = FetchType.LAZY)
    private Collection<Customer> customerCollection;

    public Prefixname() {
    }

    public Prefixname(Integer prefixId) {
        this.prefixId = prefixId;
    }

    public Integer getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(Integer prefixId) {
        this.prefixId = prefixId;
    }

    public String getPrefixname() {
        return prefixname;
    }

    public void setPrefixname(String prefixname) {
        this.prefixname = prefixname;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prefixId != null ? prefixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prefixname)) {
            return false;
        }
        Prefixname other = (Prefixname) object;
        if ((this.prefixId == null && other.prefixId != null) || (this.prefixId != null && !this.prefixId.equals(other.prefixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Prefixname[prefixId=" + prefixId + "]";
    }

}
