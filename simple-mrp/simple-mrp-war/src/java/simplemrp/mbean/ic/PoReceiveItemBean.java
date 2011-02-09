/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.mbean.AbstractManageBean;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;
/**
 *
 * @author wisaruthkea
 */
public class PoReceiveItemBean extends AbstractManageBean {

    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    private IcFacadeRemote ic = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private Integer poSeq;
    private String itemId;
    private String itemDesc;
    private String selectedWarehouse;
    private String selectedLocation;
    private Double onHand;
    private Double qtyOrder;
    private Double qtyReceived;
    private Double toBeReceive;
    private Double maxToBeReceive=0.0;
    //resource
    private List<SelectItem> lsLocation;

    public PoReceiveItemBean() {
        lsLocation = new ArrayList<SelectItem>();
    }

    //Operation
    public void doCheckWarehouse(ActionEvent e) throws Exception {
        log.debug("docheckLocation lWhse =" + this.selectedWarehouse);
        getLsLocation().clear();
        Whse whse = ma.getWhse(this.selectedWarehouse);
        if (whse != null) {
            for (Loc loc : whse.getLocCollection()) {
                SelectItem item = new SelectItem(loc.getLocPK().getLoc(), loc.getDescription());
                getLsLocation().add(item);
            }
        } else {
            this.maxToBeReceive = 0.0;
            this.onHand = 0.0;
            this.toBeReceive = 0.0;
        }

    }

    public void doCheckLocation(ActionEvent e) {
        log.debug("docheckLocation whse=" + this.selectedWarehouse + " location=" + this.selectedLocation + " item=" + this.itemId);
        //clear data
        this.onHand = 0.0;
        this.maxToBeReceive = 0.0;
        Itemloc itemloc = ic.findItemLocation(this.selectedWarehouse, this.selectedLocation, this.itemId);
        if (itemloc != null) {
            this.onHand = itemloc.getOnhand();
            
            if ((this.qtyOrder - this.qtyReceived) > this.onHand) {
                this.maxToBeReceive = this.onHand;
            } else {
                this.setMaxToBeReceive(this.qtyOrder - this.qtyReceived);
            }
        } else {
            this.toBeReceive = 0.0;
        }
    }

    /**
     * @return the selectedWarehouse
     */
    public String getSelectedWarehouse() {
        return selectedWarehouse;
    }

    /**
     * @param selectedWarehouse the selectedWarehouse to set
     */
    public void setSelectedWarehouse(String selectedWarehouse) {
        this.selectedWarehouse = selectedWarehouse;
    }

    /**
     * @return the selectedLocation
     */
    public String getSelectedLocation() {
        return selectedLocation;
    }

    /**
     * @param selectedLocation the selectedLocation to set
     */
    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    /**
     * @return the toBeReceive
     */
    public Double getToBeReceive() {
        return toBeReceive;
    }

    /**
     * @param toBeReceive the toBeReceive to set
     */
    public void setToBeReceive(Double toBeReceive) {
        this.toBeReceive = toBeReceive;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * @return the onHand
     */
    public Double getOnHand() {
        return onHand;
    }

    /**
     * @param onHand the onHand to set
     */
    public void setOnHand(Double onHand) {
        this.onHand = onHand;
    }

    /**
     * @return the qtyOrder
     */
    public Double getQtyOrder() {
        return qtyOrder;
    }

    /**
     * @param qtyOrder the qtyOrder to set
     */
    public void setQtyOrder(Double qtyOrder) {
        this.qtyOrder = qtyOrder;
    }

    /**
     * @return the qtyReceive
     */
    public Double getQtyReceived() {
        return qtyReceived;
    }

    /**
     * @param qtyReceive the qtyReceive to set
     */
    public void setQtyReceived(Double qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    /**
     * @return the maxToBeReceive
     */
    public Double getMaxToBeReceive() {
        return maxToBeReceive;
    }

    /**
     * @param maxToBeReceive the maxToBeReceive to set
     */
    public void setMaxToBeReceive(Double maxToBeReceive) {
        this.maxToBeReceive = maxToBeReceive;
    }

    /**
     * @return the lsLocation
     */
    public List<SelectItem> getLsLocation() {
        return lsLocation;
    }

    /**
     * @param lsLocation the lsLocation to set
     */
    public void setLsLocation(List<SelectItem> lsLocation) {
        this.lsLocation = lsLocation;
    }

    /**
     * @return the poSeq
     */
    public Integer getPoSeq() {
        return poSeq;
    }

    /**
     * @param poSeq the poSeq to set
     */
    public void setPoSeq(Integer poSeq) {
        this.poSeq = poSeq;
    }
}
