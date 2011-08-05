/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Job;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class JobOrderRecvAttr extends AbstractManageBean {
    private String jobId;
    private String itemId;
    private String itemDesc;
    private Date transactionDate;
    private Double onHand;
    private Integer qtyOrder;
    private Integer qtyComplete;
    private Integer toBeComplete=0;
    private Integer maxToBeComplte=0;
    private String selectedWarehouse;
    private String selectedLocation;

    //Search
    private String searchJobId;
    //Search Result
    private List<Job> lsJob;

    //Prop
    private List<SelectItem> lsWarehouse;
    private List<SelectItem> lsLocation;

    public JobOrderRecvAttr(){
        lsWarehouse = new ArrayList<SelectItem>();
        lsLocation = new ArrayList<SelectItem>();
    }
    /**
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
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
     * @return the lsJob
     */
    public List<Job> getLsJob() {
        return lsJob;
    }

    /**
     * @param lsJob the lsJob to set
     */
    public void setLsJob(List<Job> lsJob) {
        this.lsJob = lsJob;
    }

    /**
     * @return the qtyOrder
     */
    public Integer getQtyOrder() {
        return qtyOrder;
    }

    /**
     * @param qtyOrder the qtyOrder to set
     */
    public void setQtyOrder(Integer qtyOrder) {
        this.qtyOrder = qtyOrder;
    }

    /**
     * @return the qtyComplete
     */
    public Integer getQtyComplete() {
        return qtyComplete;
    }

    /**
     * @param qtyComplete the qtyComplete to set
     */
    public void setQtyComplete(Integer qtyComplete) {
        this.qtyComplete = qtyComplete;
    }

    /**
     * @return the maxToBeComplte
     */
    public Integer getMaxToBeComplte() {
        return maxToBeComplte;
    }

    /**
     * @param maxToBeComplte the maxToBeComplte to set
     */
    public void setMaxToBeComplte(Integer maxToBeComplte) {
        this.maxToBeComplte = maxToBeComplte;
    }

    /**
     * @return the searchJobId
     */
    public String getSearchJobId() {
        return searchJobId;
    }

    /**
     * @param searchJobId the searchJobId to set
     */
    public void setSearchJobId(String searchJobId) {
        this.searchJobId = searchJobId;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return the lsWarehouse
     */
    public List<SelectItem> getLsWarehouse() {
        return lsWarehouse;
    }

    /**
     * @param lsWarehouse the lsWarehouse to set
     */
    public void setLsWarehouse(List<SelectItem> lsWarehouse) {
        this.lsWarehouse = lsWarehouse;
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
     * @return the toBeComplete
     */
    public Integer getToBeComplete() {
        return toBeComplete;
    }

    /**
     * @param toBeComplete the toBeComplete to set
     */
    public void setToBeComplete(Integer toBeComplete) {
        this.toBeComplete = toBeComplete;
    }


}
