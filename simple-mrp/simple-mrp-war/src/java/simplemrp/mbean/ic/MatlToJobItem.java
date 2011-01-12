/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import simplemrp.entity.Jobmatl;

/**
 *
 * @author wisaruthkea
 */
class MatlToJobItem extends Jobmatl {
    private String selectedWarehouse;
    private String selectedLocation;
    private String toBeIssue;

    public MatlToJobItem(){
        
    }
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
     * @return the toBeIssue
     */
    public String getToBeIssue() {
        return toBeIssue;
    }

    /**
     * @param toBeIssue the toBeIssue to set
     */
    public void setToBeIssue(String toBeIssue) {
        this.toBeIssue = toBeIssue;
    }
}
