/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic.to;

import java.io.Serializable;

/**
 *
 * @author wisaruthkea
 */
public class PoRecvItemTO implements Serializable {
    private Integer poSeq;
    private String itemId;
    private String wareHouseId;
    private String locationId;
    private Double toBeRecv;

    /**
     * @return the poSeq
     */
    public Integer getPoSeq() {
        return poSeq;
    }

    /**
     * @param poSeq the poSeq to set
     */
    public void setPoSeq(Integer poSeq) {
        this.poSeq = poSeq;
    }

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
    public Double getToBeRecv() {
        return toBeRecv;
    }

    /**
     * @param toBeRecv the toBeRecv to set
     */
    public void setToBeRecv(Double toBeRecv) {
        this.toBeRecv = toBeRecv;
    }
}
