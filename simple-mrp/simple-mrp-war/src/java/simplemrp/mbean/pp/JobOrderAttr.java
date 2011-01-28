/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class JobOrderAttr extends AbstractManageBean {
    private String mode;
    
    private String jobId;
    private String itemCode;
    private Date jobDate;
    private int qtyOrder;
    private int qtyComplete;
    private char jobStat;
    private String note;
    private String cUser;
    private Date cDate;
    private String uUser;
    private Date uDate;

    //select resource
    private List<SelectItem> lsJobStat;

    //search input
    private String searchJobId;
    //search result
    private List<Job> lsJob;
    
    
    
    //page option
    private boolean disbJobId;
    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;


    public JobOrderAttr(){
        lsJobStat = new ArrayList<SelectItem>();
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
    public char getJobStat() {
        return jobStat;
    }

    /**
     * @param jobStat the jobStat to set
     */
    public void setJobStat(char jobStat) {
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
    public List<SelectItem> getLsJobStat() {
        return lsJobStat;
    }

    /**
     * @param lsJobStat the lsJobStat to set
     */
    public void setLsJobStat(List<SelectItem> lsJobStat) {
        this.lsJobStat = lsJobStat;
    }

    public void addJobStat(SelectItem i){
        this.lsJobStat.add(i);
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

    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
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
     * @return the disbJobId
     */
    public boolean isDisbJobId() {
        return disbJobId;
    }

    /**
     * @param disbJobId the disbJobId to set
     */
    public void setDisbJobId(boolean disbJobId) {
        this.disbJobId = disbJobId;
    }

    /**
     * @return the disbSave
     */
    public boolean isDisbSave() {
        return disbSave;
    }

    /**
     * @param disbSave the disbSave to set
     */
    public void setDisbSave(boolean disbSave) {
        this.disbSave = disbSave;
    }

    /**
     * @return the disbDel
     */
    public boolean isDisbDel() {
        return disbDel;
    }

    /**
     * @param disbDel the disbDel to set
     */
    public void setDisbDel(boolean disbDel) {
        this.disbDel = disbDel;
    }

    /**
     * @return the disbNew
     */
    public boolean isDisbNew() {
        return disbNew;
    }

    /**
     * @param disbNew the disbNew to set
     */
    public void setDisbNew(boolean disbNew) {
        this.disbNew = disbNew;
    }


    
}
