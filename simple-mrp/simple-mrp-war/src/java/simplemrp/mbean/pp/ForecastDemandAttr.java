/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.List;
import simplemrp.entity.Forecast;

/**
 *
 * @author wisaruthkea
 */
public class ForecastDemandAttr {
    
    //fileds
    private List<ForecastItem> lsForecast;

    public ForecastDemandAttr(){
        lsForecast = new ArrayList<ForecastItem>();
    }

    /**
     * @return the lsForecast
     */
    public List<ForecastItem> getLsForecast() {
        return lsForecast;
    }

    /**
     * @param lsForecast the lsForecast to set
     */
    public void setLsForecast(List<ForecastItem> lsForecast) {
        this.lsForecast = lsForecast;
    }


}
