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
public class MatlToJobItemTO implements Serializable {
    private Integer opr;
    private Integer seq;
    private String matlId;
    private String wareHouseId;
    private String locationId;
    private Double toBeIssue;

    /**
     * @return the opr
     */
    public Integer getOpr() {
        return opr;
    }

    /**
     * @param opr the opr to set
     */
    public void setOpr(Integer opr) {
        this.opr = opr;
    }

    /**
     * @return the matlId
     */
    public String getMatlId() {
        return matlId;
    }

    /**
     * @param matlId the matlId to set
     */
    public void setMatlId(String matlId) {
        this.matlId = matlId;
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
     * @return the toBeIssue
     */
    public Double getToBeIssue() {
        return toBeIssue;
    }

    /**
     * @param toBeIssue the toBeIssue to set
     */
    public void setToBeIssue(Double toBeIssue) {
        this.toBeIssue = toBeIssue;
    }

    /**
     * @return the seq
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
