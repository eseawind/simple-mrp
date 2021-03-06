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
public class JobmatlPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private String jobId;
    @Basic(optional = false)
    @Column(name = "OPR")
    private int opr;
    @Basic(optional = false)
    @Column(name = "SEQ")
    private int seq;

    public JobmatlPK() {
    }

    public JobmatlPK(String jobId, int opr, int seq) {
        this.jobId = jobId;
        this.opr = opr;
        this.seq = seq;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getOpr() {
        return opr;
    }

    public void setOpr(int opr) {
        this.opr = opr;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        hash += (int) opr;
        hash += (int) seq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobmatlPK)) {
            return false;
        }
        JobmatlPK other = (JobmatlPK) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        if (this.opr != other.opr) {
            return false;
        }
        if (this.seq != other.seq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.JobmatlPK[jobId=" + jobId + ", opr=" + opr + ", seq=" + seq + "]";
    }

}
