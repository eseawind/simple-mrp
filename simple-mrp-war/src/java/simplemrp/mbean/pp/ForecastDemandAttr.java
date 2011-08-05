/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Forecast;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class ForecastDemandAttr extends AbstractManageBean {
    private String itemId;
    private Integer qty =0;
    private Date forecaseDate;
    //fileds
    private List<Forecast> lsForecast;

    //search by
    private Date searchForecaseDate;

    //operation attr
    private String selectedDeleteItemId;

    public ForecastDemandAttr(){
        lsForecast = new ArrayList<Forecast>();
    }

    /**
     * @return the lsForecast
     */
    public List<Forecast> getLsForecast() {
        return lsForecast;
    }

    /**
     * @param lsForecast the lsForecast to set
     */
    public void setLsForecast(List<Forecast> lsForecast) {
        this.lsForecast = lsForecast;
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
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * @return the forecaseDate
     */
    public Date getForecaseDate() {
        return forecaseDate;
    }

    /**
     * @param forecaseDate the forecaseDate to set
     */
    public void setForecaseDate(Date forecaseDate) {
        this.forecaseDate = forecaseDate;
    }

    /**
     * @return the searchForecaseDate
     */
    public Date getSearchForecaseDate() {
        return searchForecaseDate;
    }

    /**
     * @param searchForecaseDate the searchForecaseDate to set
     */
    public void setSearchForecaseDate(Date searchForecaseDate) {
        this.searchForecaseDate = searchForecaseDate;
    }

    /**
     * @return the selectedDeleteItemId
     */
    public String getSelectedDeleteItemId() {
        return selectedDeleteItemId;
    }

    /**
     * @param selectedDeleteItemId the selectedDeleteItemId to set
     */
    public void setSelectedDeleteItemId(String selectedDeleteItemId) {
        this.selectedDeleteItemId = selectedDeleteItemId;
    }


}
