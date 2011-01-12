/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import simplemrp.entity.Forecast;

/**
 *
 * @author wisaruthkea
 */
public class ForecastItem extends Forecast {
    private boolean isSelected;

    /**
     * @return the isSelected
     */
    public boolean isIsSelected() {
        return isSelected;
    }

    /**
     * @param isSelected the isSelected to set
     */
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
