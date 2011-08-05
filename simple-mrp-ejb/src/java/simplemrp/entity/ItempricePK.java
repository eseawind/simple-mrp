/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Golf
 */
@Embeddable
public class ItempricePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ITEM")
    private String item;
    @Basic(optional = false)
    @Column(name = "EFFDATE")
    @Temporal(TemporalType.DATE)
    private Date effdate;

    public ItempricePK() {
    }

    public ItempricePK(String item, Date effdate) {
        this.item = item;
        this.effdate = effdate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getEffdate() {
        return effdate;
    }

    public void setEffdate(Date effdate) {
        this.effdate = effdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item != null ? item.hashCode() : 0);
        hash += (effdate != null ? effdate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItempricePK)) {
            return false;
        }
        ItempricePK other = (ItempricePK) object;
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        if ((this.effdate == null && other.effdate != null) || (this.effdate != null && !this.effdate.equals(other.effdate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.ItempricePK[item=" + item + ", effdate=" + effdate + "]";
    }

}
