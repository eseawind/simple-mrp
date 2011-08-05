/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Golf
 */
@Embeddable
public class LocPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "WHSE")
    private String whse;
    @Basic(optional = false)
    @Column(name = "LOC")
    private String loc;

    public LocPK() {
    }

    public LocPK(String whse, String loc) {
        this.whse = whse;
        this.loc = loc;
    }

    public String getWhse() {
        return whse;
    }

    public void setWhse(String whse) {
        this.whse = whse;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (whse != null ? whse.hashCode() : 0);
        hash += (loc != null ? loc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocPK)) {
            return false;
        }
        LocPK other = (LocPK) object;
        if ((this.whse == null && other.whse != null) || (this.whse != null && !this.whse.equals(other.whse))) {
            return false;
        }
        if ((this.loc == null && other.loc != null) || (this.loc != null && !this.loc.equals(other.loc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.LocPK[whse=" + whse + ", loc=" + loc + "]";
    }

}
