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
public class CoOrderItemTO implements Serializable {
    private Integer coSeq;
    private String itemId;
    private String wareHouseId;
    private String locationId;
    private Double toBeShip;

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
     * @return the toBeShip
     */
    public Double getToBeShip() {
        return toBeShip;
    }

    /**
     * @param toBeShip the toBeShip to set
     */
    public void setToBeShip(Double toBeShip) {
        this.toBeShip = toBeShip;
    }

    public void setCoSeq(Integer coSeq) {
       this.coSeq = coSeq;
    }
    public Integer getCoSeq(){
        return this.coSeq;
    }
}
