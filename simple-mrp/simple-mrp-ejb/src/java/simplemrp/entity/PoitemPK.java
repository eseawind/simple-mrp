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
public class PoitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PO_ID")
    private String poId;
    @Basic(optional = false)
    @Column(name = "PO_SEQ")
    private int poSeq;

    public PoitemPK() {
    }

    public PoitemPK(String poId, int poSeq) {
        this.poId = poId;
        this.poSeq = poSeq;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public int getPoSeq() {
        return poSeq;
    }

    public void setPoSeq(int poSeq) {
        this.poSeq = poSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poId != null ? poId.hashCode() : 0);
        hash += (int) poSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoitemPK)) {
            return false;
        }
        PoitemPK other = (PoitemPK) object;
        if ((this.poId == null && other.poId != null) || (this.poId != null && !this.poId.equals(other.poId))) {
            return false;
        }
        if (this.poSeq != other.poSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.PoitemPK[poId=" + poId + ", poSeq=" + poSeq + "]";
    }

}
