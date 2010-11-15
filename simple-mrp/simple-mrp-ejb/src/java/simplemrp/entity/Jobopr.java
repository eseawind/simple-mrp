/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "jobopr")
@NamedQueries({
    @NamedQuery(name = "Jobopr.findAll", query = "SELECT j FROM Jobopr j")})
public class Jobopr implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JoboprPK joboprPK;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobopr", fetch = FetchType.LAZY)
    private Collection<Jobmatl> jobmatlCollection;
    @JoinColumn(name = "WC", referencedColumnName = "WC")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Workcenter workcenter;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Job job;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    public Jobopr() {
    }

    public Jobopr(JoboprPK joboprPK) {
        this.joboprPK = joboprPK;
    }

    public Jobopr(String jobId, int opr) {
        this.joboprPK = new JoboprPK(jobId, opr);
    }

    public JoboprPK getJoboprPK() {
        return joboprPK;
    }

    public void setJoboprPK(JoboprPK joboprPK) {
        this.joboprPK = joboprPK;
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

    public Collection<Jobmatl> getJobmatlCollection() {
        return jobmatlCollection;
    }

    public void setJobmatlCollection(Collection<Jobmatl> jobmatlCollection) {
        this.jobmatlCollection = jobmatlCollection;
    }

    public Workcenter getWorkcenter() {
        return workcenter;
    }

    public void setWorkcenter(Workcenter workcenter) {
        this.workcenter = workcenter;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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
        hash += (joboprPK != null ? joboprPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobopr)) {
            return false;
        }
        Jobopr other = (Jobopr) object;
        if ((this.joboprPK == null && other.joboprPK != null) || (this.joboprPK != null && !this.joboprPK.equals(other.joboprPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Jobopr[joboprPK=" + joboprPK + "]";
    }

}
