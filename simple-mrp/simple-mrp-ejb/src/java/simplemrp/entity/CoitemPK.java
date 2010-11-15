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
public class CoitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CO_ID")
    private String coId;
    @Basic(optional = false)
    @Column(name = "CO_SEQ")
    private int coSeq;

    public CoitemPK() {
    }

    public CoitemPK(String coId, int coSeq) {
        this.coId = coId;
        this.coSeq = coSeq;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public int getCoSeq() {
        return coSeq;
    }

    public void setCoSeq(int coSeq) {
        this.coSeq = coSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coId != null ? coId.hashCode() : 0);
        hash += (int) coSeq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoitemPK)) {
            return false;
        }
        CoitemPK other = (CoitemPK) object;
        if ((this.coId == null && other.coId != null) || (this.coId != null && !this.coId.equals(other.coId))) {
            return false;
        }
        if (this.coSeq != other.coSeq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.CoitemPK[coId=" + coId + ", coSeq=" + coSeq + "]";
    }

}
