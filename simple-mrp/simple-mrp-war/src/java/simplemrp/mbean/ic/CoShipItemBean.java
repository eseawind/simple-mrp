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
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.mbean.AbstractManageBean;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class CoShipItemBean extends AbstractManageBean {
    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    private IcFacadeRemote ic = (IcFacadeRemote)EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private String itemId;
    private String itemDesc;
    private String selectedWarehouse;
    private String selectedLocation;
    private Double qtyOrder;
    private Double qtyShipped;
    private Double maxToBeShip=0.0;
    private Double toBeShip=0.0;
    private Double onHand=0.0;
    //resource
    private List<SelectItem> lsLocation;

    public CoShipItemBean() {
        lsLocation = new ArrayList<SelectItem>();
    }
    //Operation

    public void doCheckWarehouse(ActionEvent e) throws Exception {
        log.debug("docheckLocation lWhse =" + this.selectedWarehouse);
        lsLocation.clear();
        Whse whse = ma.getWhse(this.selectedWarehouse);
        if (whse != null) {
            for (Loc loc : whse.getLocCollection()) {
                SelectItem item = new SelectItem(loc.getLocPK().getLoc(),loc.getDescription());
                lsLocation.add(item);
            }
        } else{
            this.maxToBeShip=0.0;
            this.onHand=0.0;
            this.toBeShip=0.0;
        }

    }

    public void doCheckLocation(ActionEvent e) {
        log.debug("docheckLocation whse="+this.selectedWarehouse+" location=" + this.selectedLocation+" item="+this.itemId);
        //clear data
        this.onHand=0.0;
        this.setMaxToBeShip((Double) 0.0);
        Itemloc itemloc = ic.findItemLocation(this.selectedWarehouse, this.selectedLocation, this.itemId);
        if(itemloc!=null){
            this.onHand = itemloc.getOnhand();
            if(this.onHand<this.qtyOrder){
                this.setMaxToBeShip(this.onHand);
            } else {
                this.setMaxToBeShip(this.qtyOrder);
            }
        } else {
            this.toBeShip=0.0;
        }
    }

    public String getSelectedWarehouse() {
        return selectedWarehouse;
    }

    public void setSelectedWarehouse(String selectedWarehouse) {
        this.selectedWarehouse = selectedWarehouse;
    }

    public String getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
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
     * @return the qtyShipped
     */
    public Double getQtyShipped() {
        return qtyShipped;
    }

    /**
     * @param qtyShipped the qtyShipped to set
     */
    public void setQtyShipped(Double qtyShipped) {
        this.qtyShipped = qtyShipped;
    }

    /**
     * @return the toBeShip
     */
    public Double getToBeShip() {
        return toBeShip;
    }

    /**
     * @param toBeShip the toBeShip to set
     */
    public void setToBeShip(Double toBeShip) {
        this.toBeShip = toBeShip;
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
     * @return the maxToBeShip
     */
    public Double getMaxToBeShip() {
        return maxToBeShip;
    }

    /**
     * @param maxToBeShip the maxToBeShip to set
     */
    public void setMaxToBeShip(Double maxToBeShip) {
        this.maxToBeShip = maxToBeShip;
    }
}
