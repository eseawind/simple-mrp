/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.to;

import java.io.Serializable;

/**
 *
 * @author wisaruthkea
 */
public class JobRecvItemTO implements Serializable {
    private String itemId;
    private String wareHouseId;
    private String locationId;
    private Integer toBeRecv;

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the wareHouseId
     */
    public String getWareHouseId() {
        return wareHouseId;
    }

    /**
     * @param wareHouseId the wareHouseId to set
     */
    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the toBeRecv
     */
    public Integer getToBeRecv() {
        return toBeRecv;
    }

    /**
     * @param toBeRecv the toBeRecv to set
     */
    public void setToBeRecv(Integer toBeRecv) {
        this.toBeRecv = toBeRecv;
    }


}
