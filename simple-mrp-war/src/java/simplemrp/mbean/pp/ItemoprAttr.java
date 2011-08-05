package simplemrp.mbean.pp;


import java.util.Date;
import simplemrp.mbean.AbstractManageBean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Golf
 */
public class ItemoprAttr extends AbstractManageBean {
    private String p_item;
    private Integer p_opr;
    private String p_mode;

    private String mode;
    private String item;
    private String itemDesc;
    private Integer opr;

    private String wc;
    private String wcDesc;

    private String uuser;
    private String cuser;
    private Date cdate;
    private Date udate;

    public ItemoprAttr() {
        
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

    public Integer getOpr() {
        return opr;
    }

    public void setOpr(Integer opr) {
        this.opr = opr;
    }

    public String getP_item() {
        return p_item;
    }

    public void setP_item(String p_item) {
        this.p_item = p_item;
    }

    public String getP_mode() {
        return p_mode;
    }

    public void setP_mode(String p_mode) {
        this.p_mode = p_mode;
    }

    public Integer getP_opr() {
        return p_opr;
    }

    public void setP_opr(Integer p_opr) {
        this.p_opr = p_opr;
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

    public String getWc() {
        return wc;
    }

    public void setWc(String wc) {
        this.wc = wc;
    }

    public String getWcDesc() {
        return wcDesc;
    }

    public void setWcDesc(String wcDesc) {
        this.wcDesc = wcDesc;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
