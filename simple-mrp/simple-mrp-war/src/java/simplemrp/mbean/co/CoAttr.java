/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.co;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class CoAttr extends AbstractManageBean {
    private String mode;

    private String searchCustId;
    private String coId;
    private String custId;
    private String custName;
    private String custPo;
    private Date orderdate;
    private Date duedate;
    private String term;
    private Character costat;
    private String slsman;
    private String tax;
    private String uuser;
    private String cuser;
    private Date cdate;
    private Date udate;

    private List<SelectItem> lsTerm;
    private List<SelectItem> lsTax;
    private List<SelectItem> lsCoStat;
    private List<Co> lsCo;
    private List<Coitem> lsCoItem;

    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;
    private boolean disbCoId;
    private boolean disbAddDtl;

    private boolean showCoitem;

    public String getSearchCustId() {
        return searchCustId;
    }

    public void setSearchCustId(String searchCustId) {
        this.searchCustId = searchCustId;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public Character getCostat() {
        return costat;
    }

    public void setCostat(Character costat) {
        this.costat = costat;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPo() {
        return custPo;
    }

    public void setCustPo(String custPo) {
        this.custPo = custPo;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getSlsman() {
        return slsman;
    }

    public void setSlsman(String slsman) {
        this.slsman = slsman;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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

    public List<SelectItem> getLsCoStat() {
        if(lsCoStat == null) {
            lsCoStat = new ArrayList<SelectItem>();
        }

        return lsCoStat;
    }

    public void setLsCoStat(List<SelectItem> lsCoStat) {
        this.lsCoStat = lsCoStat;
    }

    public List<SelectItem> getLsTerm() {
        if(lsTerm == null) {
            lsTerm = new ArrayList<SelectItem>();
        }

        return lsTerm;
    }

    public void setLsTerm(List<SelectItem> lsTerm) {
        this.lsTerm = lsTerm;
    }

    public List<SelectItem> getLsTax() {
        if(lsTax == null) {
            lsTax = new ArrayList<SelectItem>();
        }

        return lsTax;
    }

    public void setLsTax(List<SelectItem> lsTax) {
        this.lsTax = lsTax;
    }

    public List<Co> getLsCo() {
        if(lsCo == null) {
            lsCo = new ArrayList<Co>();
        }
        return lsCo;
    }

    public void setLsCo(List<Co> lsCo) {
        this.lsCo = lsCo;
    }

    public List<Coitem> getLsCoItem() {
        if(lsCoItem == null) {
            lsCoItem = new ArrayList<Coitem>();
        }
        return this.lsCoItem;
    }

    public void setLsCoItem(List<Coitem> lsCoItem) {
        this.lsCoItem = lsCoItem;
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

    public boolean isDisbCoId() {
        return disbCoId;
    }

    public void setDisbCoID(boolean disbCoId) {
        this.disbCoId = disbCoId;
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

    public boolean isShowCoitem() {
        return showCoitem;
    }

    public void setShowCoitem(boolean showCoitem) {
        this.showCoitem = showCoitem;
    }
}
