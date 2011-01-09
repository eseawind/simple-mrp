/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import simplemrp.entity.Coitem;

/**
 *
 * @author wisaruthkea
 */
public class CoShipItemBean extends Coitem {
    private String selectedWarehouse;
    private String selectedLocation;
    private String toBeShip;

    public String getSelectedWarehouse() {
        return selectedWarehouse;
    }

    public void setSelectedWarehouse(String selectedWarehouse) {
        this.selectedWarehouse = selectedWarehouse;
    }

    public String getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getToBeShip() {
        return toBeShip;
    }

    public void setToBeShip(String toBeShip) {
        this.toBeShip = toBeShip;
    }
}
