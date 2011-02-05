/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.entity.Po;
import simplemrp.entity.Poitem;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class PoAttr extends AbstractManageBean {

    private String mode;

    private String searchVendId;
    private Date searchPoDate;
    
    private String poId;
    private Date poDate;
    private Character stat;
    private String note;
    private String cuser;
    private Date cdate;
    private String uuser;
    private Date udate;

    private List<SelectItem> lsPoStat;
    private List<Po> lsPo;
    private List<Poitem> lsPoItem;

    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;
    private boolean disbPoId;
    private boolean disbAddDtl;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public Date getSearchPoDate() {
        return searchPoDate;
    }

    public void setSearchPoDate(Date searchPoDate) {
        this.searchPoDate = searchPoDate;
    }

    public String getSearchVendId() {
        return searchVendId;
    }

    public void setSearchVendId(String searchVendId) {
        this.searchVendId = searchVendId;
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

    public List<SelectItem> getLsPoStat() {
        if(lsPoStat == null) {
            lsPoStat = new ArrayList<SelectItem>();
        }

        return lsPoStat;
    }

    public void setLsPoStat(List<SelectItem> lsPoStat) {
        this.lsPoStat = lsPoStat;
    }

    public List<Po> getLsPo() {
        if(lsPo == null) {
            lsPo = new ArrayList<Po>();
        }
        return lsPo;
    }

    public void setLsPo(List<Po> lsPo) {
        this.lsPo = lsPo;
    }

    public List<Poitem> getLsPoItem() {
        if(lsPoItem == null) {
            lsPoItem = new ArrayList<Poitem>();
        }
        return this.lsPoItem;
    }

    public void setLsPoItem(List<Poitem> lsPoItem) {
        this.lsPoItem = lsPoItem;
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

    public boolean isDisbSave() {
        return disbSave;
    }

    public void setDisbSave(boolean disbSave) {
        this.disbSave = disbSave;
    }

    public boolean isDisbPoId() {
        return disbPoId;
    }

    public void setDisbPoId(boolean disbPoId) {
        this.disbPoId = disbPoId;
    }

    public boolean isDisbAddDtl() {
        return disbAddDtl;
    }

    public void setDisbAddDtl(boolean disbAddDtl) {
        this.disbAddDtl = disbAddDtl;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
