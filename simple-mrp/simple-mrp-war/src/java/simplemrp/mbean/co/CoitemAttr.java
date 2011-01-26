package simplemrp.mbean.co;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.mbean.AbstractManageBean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Golf
 */
class CoitemAttr extends AbstractManageBean {
    private String p_coId;
    private Integer p_coSeq;
    private String p_mode;

    private String mode;
    private String coId;
    private Integer coSeq;
    private String item;
    private String itemDesc;
    private Double qty;
    private Double qtyShip;
    private Double price;
    private Character stat;
    private String uuser;
    private String cuser;
    private Date cdate;
    private Date udate;
    private List<SelectItem> lsCoitemStat;

    public CoitemAttr() {
        
    }

    public String getP_coId() {
        return p_coId;
    }

    public void setP_coId(String p_coId) {
        this.p_coId = p_coId;
    }

    public Integer getP_coSeq() {
        return p_coSeq;
    }

    public void setP_coSeq(Integer p_coSeq) {
        this.p_coSeq = p_coSeq;
    }

    public String getP_mode() {
        return p_mode;
    }

    public void setP_mode(String p_mode) {
        this.p_mode = p_mode;
    }
    
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public Integer getCoSeq() {
        return coSeq;
    }

    public void setCoSeq(Integer coSeq) {
        this.coSeq = coSeq;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getQtyShip() {
        return qtyShip;
    }

    public void setQtyShip(Double qtyShip) {
        this.qtyShip = qtyShip;
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

    public List<SelectItem> getLsCoitemStat() {
        if(lsCoitemStat == null) {
            lsCoitemStat = new ArrayList<SelectItem>();
        }
        return lsCoitemStat;
    }

    public void setLsCoitemStat(List<SelectItem> lsCoitemStat) {
        this.lsCoitemStat = lsCoitemStat;
    }

    
}
