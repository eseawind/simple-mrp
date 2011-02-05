/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import java.util.Date;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class PritemAttr extends AbstractManageBean {
    private String p_prId;
    private Integer p_prSeq;
    private String p_mode;

    private String mode;
    private String prId;
    private Integer prSeq;
    private String item;
    private String itemDesc;
    private Double qty;
    
    private Date dueDate;
    private String note;
    private String uuser;
    private Date udate;
    private String cuser;
    private Date cdate;

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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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

    public String getP_mode() {
        return p_mode;
    }

    public void setP_mode(String p_mode) {
        this.p_mode = p_mode;
    }

    public String getP_prId() {
        return p_prId;
    }

    public void setP_prId(String p_prId) {
        this.p_prId = p_prId;
    }

    public Integer getP_prSeq() {
        return p_prSeq;
    }

    public void setP_prSeq(Integer p_prSeq) {
        this.p_prSeq = p_prSeq;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public Integer getPrSeq() {
        return prSeq;
    }

    public void setPrSeq(Integer prSeq) {
        this.prSeq = prSeq;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
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
