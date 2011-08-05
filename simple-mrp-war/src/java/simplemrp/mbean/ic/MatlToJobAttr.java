/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class MatlToJobAttr extends AbstractManageBean {
    //search
    private String jobId;

    //search result
    // one
    private String jobItemId;
    private String jobItemDesc;
    private Integer qty;
    private Date transactionDate;
    // to many
    private List<MatlToJobItem> lsMatlToJobItem;
    
    //resource
    private List<SelectItem> lsWarehouse;
    

    public MatlToJobAttr(){
        lsMatlToJobItem =new ArrayList<MatlToJobItem>();
        lsWarehouse = new ArrayList<SelectItem>();
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
     * @return the jobItemId
     */
    public String getJobItemId() {
        return jobItemId;
    }

    /**
     * @param jobItemId the jobItemId to set
     */
    public void setJobItemId(String jobItemId) {
        this.jobItemId = jobItemId;
    }

    /**
     * @return the jobItemDesc
     */
    public String getJobItemDesc() {
        return jobItemDesc;
    }

    /**
     * @param jobItemDesc the jobItemDesc to set
     */
    public void setJobItemDesc(String jobItemDesc) {
        this.jobItemDesc = jobItemDesc;
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
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
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


}
