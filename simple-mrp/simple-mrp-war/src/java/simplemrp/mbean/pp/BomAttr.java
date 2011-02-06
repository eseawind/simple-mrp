package simplemrp.mbean.pp;

import java.util.List;
import simplemrp.entity.Item;
import simplemrp.entity.Itemopr;
import simplemrp.mbean.AbstractManageBean;

public class BomAttr extends AbstractManageBean {

    private String searchItem;
    private String searchDesc;

    private String item;
    private String itemDesc;

    private List<Item> lsItem;
    private List<Itemopr> lsItemopr;
    
    private boolean disbNewOpr;

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

    public List<Item> getLsItem() {
        return lsItem;
    }

    public void setLsItem(List<Item> lsItem) {
        this.lsItem = lsItem;
    }

    public List<Itemopr> getLsItemopr() {
        return lsItemopr;
    }

    public void setLsItemopr(List<Itemopr> lsItemopr) {
        this.lsItemopr = lsItemopr;
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

    public boolean isDisbNewOpr() {
        return disbNewOpr;
    }

    public void setDisbNewOpr(boolean disbNewOpr) {
        this.disbNewOpr = disbNewOpr;
    }
}
