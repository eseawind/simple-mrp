/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import simplemrp.entity.Poitem;

/**
 *
 * @author wisaruthkea
 */
public class PoReceiveItemBean extends Poitem {
    private String selectedWarehouse;
    private String selectedLocation;
    private String toBeReceive;

    /**
     * @return the selectedWarehouse
     */
    public String getSelectedWarehouse() {
        return selectedWarehouse;
    }

    /**
     * @param selectedWarehouse the selectedWarehouse to set
     */
    public void setSelectedWarehouse(String selectedWarehouse) {
        this.selectedWarehouse = selectedWarehouse;
    }

    /**
     * @return the selectedLocation
     */
    public String getSelectedLocation() {
        return selectedLocation;
    }

    /**
     * @param selectedLocation the selectedLocation to set
     */
    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    /**
     * @return the toBeReceive
     */
    public String getToBeReceive() {
        return toBeReceive;
    }

    /**
     * @param toBeReceive the toBeReceive to set
     */
    public void setToBeReceive(String toBeReceive) {
        this.toBeReceive = toBeReceive;
    }
}
