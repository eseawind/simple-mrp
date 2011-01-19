/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;

/**
 *
 * @author wisaruthkea
 */
public class JobOrderAttr {
    private String jobId;
    private String itemCode;
    private Date jobDate;
    private int qtyOrder;
    private int qtyComplete;
    private String jobStat;
    private String note;
    private String cUser;
    private Date cDate;
    private String uUser;
    private Date uDate;

    //select resource
    private List<Job_stat> lsJobStat;

    public JobOrderAttr(){
        lsJobStat = new ArrayList<Job_stat>();
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
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the jobDate
     */
    public Date getJobDate() {
        return jobDate;
    }

    /**
     * @param jobDate the jobDate to set
     */
    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    /**
     * @return the qtyComplete
     */
    public int getQtyComplete() {
        return qtyComplete;
    }

    /**
     * @param qtyComplete the qtyComplete to set
     */
    public void setQtyComplete(int qtyComplete) {
        this.qtyComplete = qtyComplete;
    }

    /**
     * @return the jobStat
     */
    public String getJobStat() {
        return jobStat;
    }

    /**
     * @param jobStat the jobStat to set
     */
    public void setJobStat(String jobStat) {
        this.jobStat = jobStat;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the cUser
     */
    public String getcUser() {
        return cUser;
    }

    /**
     * @param cUser the cUser to set
     */
    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    /**
     * @return the cDate
     */
    public Date getcDate() {
        return cDate;
    }

    /**
     * @param cDate the cDate to set
     */
    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    /**
     * @return the uUser
     */
    public String getuUser() {
        return uUser;
    }

    /**
     * @param uUser the uUser to set
     */
    public void setuUser(String uUser) {
        this.uUser = uUser;
    }

    /**
     * @return the uDate
     */
    public Date getuDate() {
        return uDate;
    }

    /**
     * @param uDate the uDate to set
     */
    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }

    /**
     * @return the lsJobStat
     */
    public List<Job_stat> getLsJobStat() {
        return lsJobStat;
    }

    /**
     * @param lsJobStat the lsJobStat to set
     */
    public void setLsJobStat(List<Job_stat> lsJobStat) {
        this.lsJobStat = lsJobStat;
    }

    /**
     * @return the qtyOrder
     */
    public int getQtyOrder() {
        return qtyOrder;
    }

    /**
     * @param qtyOrder the qtyOrder to set
     */
    public void setQtyOrder(int qtyOrder) {
        this.qtyOrder = qtyOrder;
    }

    
}
