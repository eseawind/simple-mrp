/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.po;

import java.util.ArrayList;
import java.util.List;
import simplemrp.entity.Pr;
import simplemrp.entity.Pr_stat;
import simplemrp.entity.Pritem;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author kajook
 */
public class PurchaseRequisitionAttr extends AbstractManageBean {
    private String pr;
    private String requester;
    private String approver;
    private String reqDate;
    private String note;
    private String prStat;

    //List
    private List<Pritem> lsPritem;

    //Search key
    private String searchPrId;
    private String searchPrStat;
    private String p_pr_id;
    //Search Result
    private List<Pr> lsPr;

    //Select Option Value
    private List<Pr_stat> lsPrStat;

    public PurchaseRequisitionAttr(){
        lsPrStat = new ArrayList<Pr_stat>();
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPrStat() {
        return prStat;
    }

    public void setPrStat(String prStat) {
        this.prStat = prStat;
    }

    public List<Pritem> getLsPritem() {
        return lsPritem;
    }

    public void setLsPritem(List<Pritem> lsPritem) {
        this.lsPritem = lsPritem;
    }

    public String getSearchPrId() {
        return searchPrId;
    }

    public void setSearchPrId(String searchPrId) {
        this.searchPrId = searchPrId;
    }

    public String getSearchPrStat() {
        return searchPrStat;
    }

    public void setSearchPrStat(String searchPrStat) {
        this.searchPrStat = searchPrStat;
    }

    public List<Pr_stat> getLsPrStat() {
        return lsPrStat;
    }

    public void setLsPrStat(List<Pr_stat> lsPrStat) {
        this.lsPrStat = lsPrStat;
    }

    /**
     * @return the lsPr
     */
    public List<Pr> getLsPr() {
        return lsPr;
    }

    /**
     * @param lsPr the lsPr to set
     */
    public void setLsPr(List<Pr> lsPr) {
        this.lsPr = lsPr;
    }

    /**
     * @return the p_pr_id
     */
    public String getP_pr_id() {
        return p_pr_id;
    }

    /**
     * @param p_pr_id the p_pr_id to set
     */
    public void setP_pr_id(String p_pr_id) {
        this.p_pr_id = p_pr_id;
    }
}
