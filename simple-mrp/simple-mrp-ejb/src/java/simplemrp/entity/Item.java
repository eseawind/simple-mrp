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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ITEM")
    private String item;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "WARRANTY")
    private Integer warranty;
    @Column(name = "LEADTIME")
    private Integer leadtime;
    @Column(name = "SAFETYSTOCK")
    private Double safetystock;
    @Basic(optional = false)
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Basic(optional = false)
    @Column(name = "CUSER")
    private String cuser;
    @Basic(optional = false)
    @Column(name = "UDATE")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Basic(optional = false)
    @Column(name = "UUSER")
    private String uuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Coitem> coitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Jobmatl> jobmatlCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Mps> mpsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item1", fetch = FetchType.LAZY)
    private Collection<Itemopr> itemoprCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Jobopr> joboprCollection;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Poitem> poitemCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "item1", fetch = FetchType.LAZY)
    private Forecast forecast;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Job> jobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matl", fetch = FetchType.LAZY)
    private Collection<Itemmatl> itemmatlCollection;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Collection<Pritem> pritemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item1", fetch = FetchType.LAZY)
    private Collection<Itemprice> itempriceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item1", fetch = FetchType.LAZY)
    private Collection<Itemloc> itemlocCollection;
    @JoinColumn(name = "UOM", referencedColumnName = "UOM")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Uom uom;
    @JoinColumn(name = "STAT", referencedColumnName = "STAT")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item_stat itemstat;
    @JoinColumn(name = "SOURCE", referencedColumnName = "SOURCE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item_source itemsource;
    @JoinColumn(name = "PRODUCT", referencedColumnName = "PRODUCT")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;

    public Item() {
    }

    public Item(String item) {
        this.item = item;
    }

    public Item(String item, Date cdate, String cuser, Date udate, String uuser) {
        this.item = item;
        this.cdate = cdate;
        this.cuser = cuser;
        this.udate = udate;
        this.uuser = uuser;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public Integer getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(Integer leadtime) {
        this.leadtime = leadtime;
    }

    public Double getSafetystock() {
        return safetystock;
    }

    public void setSafetystock(Double safetystock) {
        this.safetystock = safetystock;
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

    public Collection<Coitem> getCoitemCollection() {
        return coitemCollection;
    }

    public void setCoitemCollection(Collection<Coitem> coitemCollection) {
        this.coitemCollection = coitemCollection;
    }

    public Collection<Jobmatl> getJobmatlCollection() {
        return jobmatlCollection;
    }

    public void setJobmatlCollection(Collection<Jobmatl> jobmatlCollection) {
        this.jobmatlCollection = jobmatlCollection;
    }

    public Collection<Mps> getMpsCollection() {
        return mpsCollection;
    }

    public void setMpsCollection(Collection<Mps> mpsCollection) {
        this.mpsCollection = mpsCollection;
    }

    public Collection<Itemopr> getItemoprCollection() {
        return itemoprCollection;
    }

    public void setItemoprCollection(Collection<Itemopr> itemoprCollection) {
        this.itemoprCollection = itemoprCollection;
    }

    public Collection<Jobopr> getJoboprCollection() {
        return joboprCollection;
    }

    public void setJoboprCollection(Collection<Jobopr> joboprCollection) {
        this.joboprCollection = joboprCollection;
    }

    public Collection<Poitem> getPoitemCollection() {
        return poitemCollection;
    }

    public void setPoitemCollection(Collection<Poitem> poitemCollection) {
        this.poitemCollection = poitemCollection;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    public Collection<Itemmatl> getItemmatlCollection() {
        return itemmatlCollection;
    }

    public void setItemmatlCollection(Collection<Itemmatl> itemmatlCollection) {
        this.itemmatlCollection = itemmatlCollection;
    }

    public Collection<Pritem> getPritemCollection() {
        return pritemCollection;
    }

    public void setPritemCollection(Collection<Pritem> pritemCollection) {
        this.pritemCollection = pritemCollection;
    }

    public Collection<Itemprice> getItempriceCollection() {
        return itempriceCollection;
    }

    public void setItempriceCollection(Collection<Itemprice> itempriceCollection) {
        this.itempriceCollection = itempriceCollection;
    }

    public Collection<Itemloc> getItemlocCollection() {
        return itemlocCollection;
    }

    public void setItemlocCollection(Collection<Itemloc> itemlocCollection) {
        this.itemlocCollection = itemlocCollection;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public Item_stat getItemstat() {
        return itemstat;
    }

    public void setItemstat(Item_stat itemstat) {
        this.itemstat = itemstat;
    }

    public Item_source getItemsource() {
        return itemsource;
    }

    public void setItemsource(Item_source itemsource) {
        this.itemsource = itemsource;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item != null ? item.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Item[item=" + item + "]";
    }

}
