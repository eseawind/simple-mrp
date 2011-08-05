/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Item;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public abstract class ItemAttr extends AbstractManageBean {
    private String item;
    private String description;
    private String product;
    private Character source;
    private Character stat;
    private Integer warranty;
    private String uom;
    private Integer leadtime;
    private Double safetystock;
    private Date cdate;
    private String cuser;
    private Date udate;
    private String uuser;
    private String searchItem;
    private String searchDesc;

    private String mode;

    private List<Item> lsItem;
    private List<SelectItem> lsProduct;
    private List<SelectItem> lsStat;
    private List<SelectItem> lsUom;
    private List<SelectItem> lsSource;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(Integer leadtime) {
        this.leadtime = leadtime;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getSafetystock() {
        return safetystock;
    }

    public void setSafetystock(Double safetystock) {
        this.safetystock = safetystock;
    }

    public String getSearchDesc() {
        return searchDesc;
    }

    public void setSearchDesc(String searchDesc) {
        this.searchDesc = searchDesc;
    }

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public Character getSource() {
        return source;
    }

    public void setSource(Character source) {
        this.source = source;
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

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Item> getLsItem() {

        return lsItem;
    }

    public void setLsItem(List<Item> lsItem) {
        this.lsItem = lsItem;
    }

    public List<SelectItem> getLsProduct() {
        if (lsProduct == null) {
            lsProduct = new ArrayList<SelectItem>();
        }
        return lsProduct;
    }

    public void setLsProduct(List<SelectItem> lsProduct) {
        this.lsProduct = lsProduct;
    }

    public List<SelectItem> getLsStat() {
        if (lsStat == null) {
            lsStat = new ArrayList<SelectItem>();
        }
        return lsStat;
    }

    public void setLsStat(List<SelectItem> lsStat) {
        this.lsStat = lsStat;
    }

    public List<SelectItem> getLsUom() {
        if (lsUom == null) {
            lsUom = new ArrayList<SelectItem>();
        }
        return lsUom;
    }

    public void setLsUom(List<SelectItem> lsUom) {
        this.lsUom = lsUom;
    }

    public List<SelectItem> getLsSource() {
        if (lsSource == null) {
            lsSource = new ArrayList<SelectItem>();
        }
        return lsSource;
    }

    public void setLsSource(List<SelectItem> lsSource) {
        this.lsSource = lsSource;
    }
}
