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
public class PritemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PR_ID")
    private String prId;
    @Basic(optional = false)
    @Column(name = "PR_SEQ")
    private int prSeq;

    public PritemPK() {
    }

    public PritemPK(String prId, int prSeq) {
        this.prId = prId;
        this.prSeq = prSeq;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public int getPrSeq() {
        return prSeq;
    }

    public void setPrSeq(int prSeq) {
        this.prSeq = prSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prId != null ? prId.hashCode() : 0);
        hash += (int) prSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PritemPK)) {
            return false;
        }
        PritemPK other = (PritemPK) object;
        if ((this.prId == null && other.prId != null) || (this.prId != null && !this.prId.equals(other.prId))) {
            return false;
        }
        if (this.prSeq != other.prSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.PritemPK[prId=" + prId + ", prSeq=" + prSeq + "]";
    }

}
