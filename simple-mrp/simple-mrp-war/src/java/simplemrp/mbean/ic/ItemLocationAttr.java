/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class ItemLocationAttr extends AbstractManageBean{

    //result
    private String searchWarehouse;
    private String searchLocation;
    private List<Itemloc> lsItemLoc;

    //select value
    private List<SelectItem> lsWarehouse;
    private List<SelectItem> lsLocation;

    public ItemLocationAttr(){
        lsItemLoc = new ArrayList<Itemloc>();
        lsWarehouse = new ArrayList<SelectItem>();
        lsLocation = new ArrayList<SelectItem>();
    }
    /**
     * @return the searchWarehouse
     */
    public String getSearchWarehouse() {
        return searchWarehouse;
    }

    /**
     * @param searchWarehouse the searchWarehouse to set
     */
    public void setSearchWarehouse(String searchWarehouse) {
        this.searchWarehouse = searchWarehouse;
    }

    /**
     * @return the searchLocation
     */
    public String getSearchLocation() {
        return searchLocation;
    }

    /**
     * @param searchLocation the searchLocation to set
     */
    public void setSearchLocation(String searchLocation) {
        this.searchLocation = searchLocation;
    }

    /**
     * @return the lsItemLoc
     */
    public List<Itemloc> getLsItemLoc() {
        return lsItemLoc;
    }

    /**
     * @param lsItemLoc the lsItemLoc to set
     */
    public void setLsItemLoc(List<Itemloc> lsItemLoc) {
        this.lsItemLoc = lsItemLoc;
    }

    /**
     * @return the lsWarehouse
     */
    public List<SelectItem> getLsWarehouse() {
        return lsWarehouse;
    }

    /**
     * @param lsWarehouse the lsWarehouse to set
     */
    public void setLsWarehouse(List<SelectItem> lsWarehouse) {
        this.lsWarehouse = lsWarehouse;
    }
    public void addWarehouse(SelectItem warehouse){
        this.lsWarehouse.add(warehouse);
    }

    /**
     * @return the lsLocation
     */
    public List<SelectItem> getLsLocation() {
        return lsLocation;
    }

    /**
     * @param lsLocation the lsLocation to set
     */
    public void setLsLocation(List<SelectItem> lsLocation) {
        this.lsLocation = lsLocation;
    }

    void addLocation(SelectItem sItem) {
        this.lsLocation.add(sItem);
    }
}
