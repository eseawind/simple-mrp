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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "stocktrans")
@NamedQueries({
    @NamedQuery(name = "Stocktrans.findAll", query = "SELECT s FROM Stocktrans s")})
public class Stocktrans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANS_ID")
    private Integer transId;
    @Column(name = "TRANS_TYPE")
    private Character transType;
    @Basic(optional = false)
    @Column(name = "TRANS_DATE")
    @Temporal(TemporalType.DATE)
    private Date transDate;
    @Column(name = "REF_ID")
    private String refId;
    @Column(name = "REF_SEQ")
    private Integer refSeq;
    @Basic(optional = false)
    @Column(name = "QTY")
    private double qty;
    @Column(name = "CUSER")
    private String cuser;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @JoinColumns({
        @JoinColumn(name = "WHSE", referencedColumnName = "WHSE"),
        @JoinColumn(name = "LOC", referencedColumnName = "LOC"),
        @JoinColumn(name = "ITEM", referencedColumnName = "ITEM")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Itemloc itemloc;

    public Stocktrans() {
    }

    public Stocktrans(Integer transId) {
        this.transId = transId;
    }

    public Stocktrans(Integer transId, Date transDate, double qty) {
        this.transId = transId;
        this.transDate = transDate;
        this.qty = qty;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Character getTransType() {
        return transType;
    }

    public void setTransType(Character transType) {
        this.transType = transType;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
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

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
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

    public Itemloc getItemloc() {
        return itemloc;
    }

    public void setItemloc(Itemloc itemloc) {
        this.itemloc = itemloc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stocktrans)) {
            return false;
        }
        Stocktrans other = (Stocktrans) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Stocktrans[transId=" + transId + "]";
    }

}
