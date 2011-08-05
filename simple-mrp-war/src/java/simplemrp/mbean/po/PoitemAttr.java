/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class PoitemAttr extends AbstractManageBean {

    private String p_poId;
    private Integer p_poSeq;
    private String p_mode;
    private String mode;

    private String poId;
    private Integer poSeq;
    private String item;
    private String itemDesc;
    private Character stat;
    private Double qty;
    private Double qtyRcv;
    private Double unitPrice;
    private Date dueDate;
    
    private String vendItem;
    private String prId;
    private Integer prSeq;
    private String note;
    private String uuser;
    private String cuser;
    private Date cdate;
    private Date udate;

    private List<SelectItem> lsPoitemStat;

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

    public String getP_poId() {
        return p_poId;
    }

    public void setP_poId(String p_poId) {
        this.p_poId = p_poId;
    }

    public Integer getP_poSeq() {
        return p_poSeq;
    }

    public void setP_poSeq(Integer p_poSeq) {
        this.p_poSeq = p_poSeq;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public Integer getPoSeq() {
        return poSeq;
    }

    public void setPoSeq(Integer poSeq) {
        this.poSeq = poSeq;
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

    public Double getQtyRcv() {
        return qtyRcv;
    }

    public void setQtyRcv(Double qtyRcv) {
        this.qtyRcv = qtyRcv;
    }

    public Character getStat() {
        return stat;
    }

    public void setStat(Character stat) {
        this.stat = stat;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getVendItem() {
        return vendItem;
    }

    public void setVendItem(String vendItem) {
        this.vendItem = vendItem;
    }

    public void setLsPoitemStat(List<SelectItem> lsPoitemStat) {
        this.lsPoitemStat = lsPoitemStat;
    }

    public List<SelectItem> getLsPoitemStat() {
        if(lsPoitemStat == null) {
            lsPoitemStat = new ArrayList<SelectItem>();
        }
        return lsPoitemStat;
    }
   
}
