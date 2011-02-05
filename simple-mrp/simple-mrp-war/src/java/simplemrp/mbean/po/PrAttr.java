/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Pr;
import simplemrp.entity.Pritem;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class PrAttr extends AbstractManageBean {
    private String mode;

    private String searchRequester;
    private Date searchReqDate;

    private String prId;
    private String requester;
    private String approver;
    private String note;

    private Character stat;
    private Date reqDate;

    private String cuser;
    private Date cdate;
    private String uuser;
    private Date udate;

    private List<SelectItem> lsPrStat;
    private List<Pr> lsPr;
    private List<Pritem> lsPrItem;

    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;
    private boolean disbPrId;
    private boolean disbAddDtl;

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public boolean isDisbAddDtl() {
        return disbAddDtl;
    }

    public void setDisbAddDtl(boolean disbAddDtl) {
        this.disbAddDtl = disbAddDtl;
    }

    public boolean isDisbDel() {
        return disbDel;
    }

    public void setDisbDel(boolean disbDel) {
        this.disbDel = disbDel;
    }

    public boolean isDisbNew() {
        return disbNew;
    }

    public void setDisbNew(boolean disbNew) {
        this.disbNew = disbNew;
    }

    public boolean isDisbPrId() {
        return disbPrId;
    }

    public void setDisbPrId(boolean disbPrId) {
        this.disbPrId = disbPrId;
    }

    public boolean isDisbSave() {
        return disbSave;
    }

    public void setDisbSave(boolean disbSave) {
        this.disbSave = disbSave;
    }

    public List<Pr> getLsPr() {
        return lsPr;
    }

    public void setLsPr(List<Pr> lsPr) {
        this.lsPr = lsPr;
    }

    public List<Pritem> getLsPrItem() {
        return lsPrItem;
    }

    public void setLsPrItem(List<Pritem> lsPrItem) {
        this.lsPrItem = lsPrItem;
    }

    public List<SelectItem> getLsPrStat() {
        if(lsPrStat == null) {
            lsPrStat = new ArrayList<SelectItem>();
        }
        return lsPrStat;
    }

    public void setLsPrStat(List<SelectItem> lsPrStat) {
        this.lsPrStat = lsPrStat;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public Date getSearchReqDate() {
        return searchReqDate;
    }

    public void setSearchReqDate(Date searchReqDate) {
        this.searchReqDate = searchReqDate;
    }

    public String getSearchRequester() {
        return searchRequester;
    }

    public void setSearchRequester(String searchRequester) {
        this.searchRequester = searchRequester;
    }

    public Character getStat() {
        return stat;
    }

    public void setStat(Character stat) {
        this.stat = stat;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }
}
