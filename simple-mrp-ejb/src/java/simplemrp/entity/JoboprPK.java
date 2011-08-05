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
public class JoboprPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "JOB_ID")
    private String jobId;
    @Basic(optional = false)
    @Column(name = "OPR")
    private int opr;

    public JoboprPK() {
    }

    public JoboprPK(String jobId, int opr) {
        this.jobId = jobId;
        this.opr = opr;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        hash += (int) opr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JoboprPK)) {
            return false;
        }
        JoboprPK other = (JoboprPK) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        if (this.opr != other.opr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.JoboprPK[jobId=" + jobId + ", opr=" + opr + "]";
    }

}
