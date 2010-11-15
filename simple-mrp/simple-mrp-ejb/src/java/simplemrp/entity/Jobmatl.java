/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "jobmatl")
@NamedQueries({
    @NamedQuery(name = "Jobmatl.findAll", query = "SELECT j FROM Jobmatl j")})
public class Jobmatl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobmatlPK jobmatlPK;
    @Column(name = "QTY")
    private Double qty;
    @Column(name = "CUSER")
    private String cuser;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "UUSER")
    private String uuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @JoinColumns({
        @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", insertable = false, updatable = false),
        @JoinColumn(name = "OPR", referencedColumnName = "OPR", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jobopr jobopr;
    @JoinColumn(name = "MATL", referencedColumnName = "ITEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    public Jobmatl() {
    }

    public Jobmatl(JobmatlPK jobmatlPK) {
        this.jobmatlPK = jobmatlPK;
    }

    public Jobmatl(String jobId, int opr, int seq) {
        this.jobmatlPK = new JobmatlPK(jobId, opr, seq);
    }

    public JobmatlPK getJobmatlPK() {
        return jobmatlPK;
    }

    public void setJobmatlPK(JobmatlPK jobmatlPK) {
        this.jobmatlPK = jobmatlPK;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public Jobopr getJobopr() {
        return jobopr;
    }

    public void setJobopr(Jobopr jobopr) {
        this.jobopr = jobopr;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobmatlPK != null ? jobmatlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobmatl)) {
            return false;
        }
        Jobmatl other = (Jobmatl) object;
        if ((this.jobmatlPK == null && other.jobmatlPK != null) || (this.jobmatlPK != null && !this.jobmatlPK.equals(other.jobmatlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Jobmatl[jobmatlPK=" + jobmatlPK + "]";
    }

}
