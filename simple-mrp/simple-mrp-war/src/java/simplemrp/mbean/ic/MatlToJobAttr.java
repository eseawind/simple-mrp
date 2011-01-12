/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;

/**
 *
 * @author wisaruthkea
 */
public class MatlToJobAttr {
    //search
    private String jobId;

    //search result
    // one
    private String jobItem;
    private String qty;
    private Date transactionDate;
    // to many
    private List<MatlToJobItem> lsMatlToJobItem;
    
    //resource
    private List<Whse> lsWarehouse;
    private List<Loc> lsLocation;

    public MatlToJobAttr(){
        lsWarehouse = new ArrayList<Whse>();
        lsLocation = new ArrayList<Loc>();
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
     * @return the jobItem
     */
    public String getJobItem() {
        return jobItem;
    }

    /**
     * @param jobItem the jobItem to set
     */
    public void setJobItem(String jobItem) {
        this.jobItem = jobItem;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
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
     * @return the lsMatlToJobItem
     */
    public List<MatlToJobItem> getLsMatlToJobItem() {
        return lsMatlToJobItem;
    }

    /**
     * @param lsMatlToJobItem the lsMatlToJobItem to set
     */
    public void setLsMatlToJobItem(List<MatlToJobItem> lsMatlToJobItem) {
        this.lsMatlToJobItem = lsMatlToJobItem;
    }

    /**
     * @return the lsWarehouse
     */
    public List<Whse> getLsWarehouse() {
        return lsWarehouse;
    }

    /**
     * @param lsWarehouse the lsWarehouse to set
     */
    public void setLsWarehouse(List<Whse> lsWarehouse) {
        this.lsWarehouse = lsWarehouse;
    }

    /**
     * @return the lsLocation
     */
    public List<Loc> getLsLocation() {
        return lsLocation;
    }

    /**
     * @param lsLocation the lsLocation to set
     */
    public void setLsLocation(List<Loc> lsLocation) {
        this.lsLocation = lsLocation;
    }


}
