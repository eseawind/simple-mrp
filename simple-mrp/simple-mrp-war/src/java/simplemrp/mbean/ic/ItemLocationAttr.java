/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.List;
import simplemrp.entity.Itemloc;

/**
 *
 * @author wisaruthkea
 */
public class ItemLocationAttr {

    //result
    private String searchWarehouse;
    private String searchLocation;
    private List<Itemloc> lsItemLoc;

    public ItemLocationAttr(){
        lsItemLoc = new ArrayList<Itemloc>();
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
}
