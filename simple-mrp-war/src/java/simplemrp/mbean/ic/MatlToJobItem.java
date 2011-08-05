/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.Jobmatl;
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
public class MatlToJobItem extends AbstractManageBean {
    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    private IcFacadeRemote ic = (IcFacadeRemote)EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);

    private Integer operation;
    private Integer sequence;
    private String matl;
    private String selectedWarehouse;
    private String selectedLocation;
    private Double onHand;
    private Double qtyRequest;
    private Double qtyIssued;
    private Double toBeIssue;
    private Double maxToBeIssue=0.0;

    //resource
    private List<SelectItem> lsLocation;
    

    public MatlToJobItem(){
        lsLocation = new ArrayList<SelectItem>();
    }

    //operation
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
            this.maxToBeIssue=0.0;
            this.onHand=0.0;
            this.toBeIssue=0.0;
        }

    }

    public void doCheckLocation(ActionEvent e) {
        log.debug("docheckLocation whse="+this.selectedWarehouse+" location=" + this.selectedLocation+" item(matl)="+this.matl);
        //clear data
        this.onHand=0.0;
        this.maxToBeIssue=0.0;
        Itemloc itemloc = ic.findItemLocation(this.selectedWarehouse, this.selectedLocation, this.matl);
        if(itemloc!=null){
            this.onHand = itemloc.getOnhand();
            this.qtyIssued = (this.qtyIssued!=null)?this.qtyIssued:0;
            if((this.qtyRequest-this.qtyIssued)>this.onHand){
                this.setMaxToBeIssue(this.onHand);
            } else {
                this.setMaxToBeIssue(this.qtyRequest-this.qtyIssued);
            }
        } else {
            this.toBeIssue=0.0;
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
     * @return the matl
     */
    public String getMatl() {
        return matl;
    }

    /**
     * @param matl the matl to set
     */
    public void setMatl(String matl) {
        this.matl = matl;
    }

    /**
     * @return the qtyRequest
     */
    public Double getQtyRequest() {
        return qtyRequest;
    }

    /**
     * @param qtyRequest the qtyRequest to set
     */
    public void setQtyRequest(Double qtyRequest) {
        this.qtyRequest = qtyRequest;
    }

    /**
     * @return the qtyIssued
     */
    public Double getQtyIssued() {
        return qtyIssued;
    }

    /**
     * @param qtyIssued the qtyIssued to set
     */
    public void setQtyIssued(Double qtyIssued) {
        this.qtyIssued = qtyIssued;
    }

    /**
     * @return the toBeIssue
     */
    public Double getToBeIssue() {
        return toBeIssue;
    }

    /**
     * @param toBeIssue the toBeIssue to set
     */
    public void setToBeIssue(Double toBeIssue) {
        this.toBeIssue = toBeIssue;
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
     * @return the operation
     */
    public Integer getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    /**
     * @return the sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * @return the maxToBeIssue
     */
    public Double getMaxToBeIssue() {
        return maxToBeIssue;
    }

    /**
     * @param maxToBeIssue the maxToBeIssue to set
     */
    public void setMaxToBeIssue(Double maxToBeIssue) {
        this.maxToBeIssue = maxToBeIssue;
    }
}
