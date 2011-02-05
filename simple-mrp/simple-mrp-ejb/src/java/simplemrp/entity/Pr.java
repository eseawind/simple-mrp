/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "pr")
@NamedQueries({
    @NamedQuery(name = "Pr.findAll", query = "SELECT p FROM Pr p")})
public class Pr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PR_ID")
    private String prId;
    @Column(name = "REQUESTER")
    private String requester;
    @Column(name = "APPROVER")
    private String approver;
    @Column(name = "REQ_DATE")
    @Temporal(TemporalType.DATE)
    private Date reqDate;
    @Column(name = "NOTE")
    private String note;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pr", fetch = FetchType.LAZY)
    private Collection<Pritem> pritemCollection;
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pr_stat prstat;

    public Pr() {
    }

    public Pr(String prId) {
        this.prId = prId;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<Pritem> getPritemCollection() {
        return pritemCollection;
    }

    public void setPritemCollection(Collection<Pritem> pritemCollection) {
        this.pritemCollection = pritemCollection;
    }

    public Pr_stat getPrstat() {
        return prstat;
    }

    public void setPrstat(Pr_stat prstat) {
        this.prstat = prstat;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prId != null ? prId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pr)) {
            return false;
        }
        Pr other = (Pr) object;
        if ((this.prId == null && other.prId != null) || (this.prId != null && !this.prId.equals(other.prId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Pr[prId=" + prId + "]";
    }

}
