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
@Table(name = "co")
@NamedQueries({
    @NamedQuery(name = "Co.findAll", query = "SELECT c FROM Co c")})
public class Co implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CO_ID")
    private String coId;
    @Column(name = "CUST_PO")
    private String custPo;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Column(name = "DUEDATE")
    @Temporal(TemporalType.DATE)
    private Date duedate;
    @Column(name = "UUSER")
    private String uuser;
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "CUSER")
    private String cuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "co", fetch = FetchType.LAZY)
    private Collection<Coitem> coitemCollection;
    @JoinColumn(name = "TERM_ID", referencedColumnName = "TERM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Term term;
    @JoinColumn(name = "TAX_ID", referencedColumnName = "TAX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tax tax;
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(fetch = FetchType.LAZY)
    private Co_stat costat;
    @JoinColumn(name = "SLSMAN", referencedColumnName = "SLSMAN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Slsman slsman;
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Co() {
    }

    public Co(String coId) {
        this.coId = coId;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getCustPo() {
        return custPo;
    }

    public void setCustPo(String custPo) {
        this.custPo = custPo;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
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

    public Collection<Coitem> getCoitemCollection() {
        return coitemCollection;
    }

    public void setCoitemCollection(Collection<Coitem> coitemCollection) {
        this.coitemCollection = coitemCollection;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Co_stat getCostat() {
        return costat;
    }

    public void setCostat(Co_stat costat) {
        this.costat = costat;
    }

    public Slsman getSlsman() {
        return slsman;
    }

    public void setSlsman(Slsman slsman) {
        this.slsman = slsman;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coId != null ? coId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Co)) {
            return false;
        }
        Co other = (Co) object;
        if ((this.coId == null && other.coId != null) || (this.coId != null && !this.coId.equals(other.coId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Co[coId=" + coId + "]";
    }

}
