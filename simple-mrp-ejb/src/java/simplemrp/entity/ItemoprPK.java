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
public class ItemoprPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ITEM")
    private String item;
    @Basic(optional = false)
    @Column(name = "OPR")
    private int opr;

    public ItemoprPK() {
    }

    public ItemoprPK(String item, int opr) {
        this.item = item;
        this.opr = opr;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
        hash += (item != null ? item.hashCode() : 0);
        hash += (int) opr;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemoprPK)) {
            return false;
        }
        ItemoprPK other = (ItemoprPK) object;
        if ((this.item == null && other.item != null) || (this.item != null && !this.item.equals(other.item))) {
            return false;
        }
        if (this.opr != other.opr) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.ItemoprPK[item=" + item + ", opr=" + opr + "]";
    }

}
