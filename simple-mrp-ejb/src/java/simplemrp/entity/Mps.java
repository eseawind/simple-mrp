/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "mps")
@NamedQueries({
    @NamedQuery(name = "Mps.findAll", query = "SELECT m FROM Mps m")})
public class Mps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MPS_ID")
    private String mpsId;
    @Column(name = "REF_ID")
    private String refId;
    @Column(name = "REF_SEQ")
    private Integer refSeq;
    @Column(name = "DUEDATE")
    @Temporal(TemporalType.DATE)
    private Date duedate;
    @Column(name = "QTY")
    private Integer qty;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "CUSER")
    private String cuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Column(name = "UUSER")
    private String uuser;
    @Column(name = "RELEASER")
    private String releaser;
    @JoinColumn(name = "MPS_TYPE", referencedColumnName = "MPS_TYPE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mps_type mpstype;
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mps_stat mpsstat;
    @JoinColumn(name = "ITEM", referencedColumnName = "ITEM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    public Mps() {
    }

    public Mps(String mpsId) {
        this.mpsId = mpsId;
    }

    public Mps(String mpsId, String refId) {
        this.mpsId = mpsId;
        this.refId = refId;
    }

    public String getMpsId() {
        return mpsId;
    }

    public void setMpsId(String mpsId) {
        this.mpsId = mpsId;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Integer getRefSeq() {
        return refSeq;
    }

    public void setRefSeq(Integer refSeq) {
        this.refSeq = refSeq;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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

    public Mps_type getMpstype() {
        return mpstype;
    }

    public void setMpstype(Mps_type mpstype) {
        this.mpstype = mpstype;
    }

    public Mps_stat getMpsstat() {
        return mpsstat;
    }

    public void setMpsstat(Mps_stat mpsstat) {
        this.mpsstat = mpsstat;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getReleaser() {
        return releaser;
    }

    public void setReleaser(String releaser) {
        this.releaser = releaser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mpsId != null ? mpsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mps)) {
            return false;
        }
        Mps other = (Mps) object;
        if ((this.mpsId == null && other.mpsId != null) || (this.mpsId != null && !this.mpsId.equals(other.mpsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Mps[mpsId=" + mpsId + "]";
    }

}
