/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Co;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Coitem;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;

/**
 *
 * @author wisaruthkea
 */
public class CustOrderShippingAttr {
    //Search
    private String searchCo;

    //Search result
    private String cust;
    private Date transactionDate;

    //Coitem list table and edit
    private List<CoShipItemBean> lsCoShipItemBean;

    //Optional resource
    private List<Whse> lsWarehouse;
    private List<Loc> lsLocation;
    
    public CustOrderShippingAttr(){
        lsWarehouse = new ArrayList<Whse>();
        lsLocation = new ArrayList<Loc>();
    }

    /**
     * @return the searchCo
     */
    public String getSearchCo() {
        return searchCo;
    }

    /**
     * @param searchCo the searchCo to set
     */
    public void setSearchCo(String searchCo) {
        this.searchCo = searchCo;
    }

    /**
     * @return the cust
     */
    public String getCust() {
        return cust;
    }

    /**
     * @param cust the cust to set
     */
    public void setCust(String cust) {
        this.cust = cust;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * @return the lsWarehouse
     */
    public List<Whse> getLsWarehouse() {
        return lsWarehouse;
    }

    /**
     * @param lsWarehouse the lsWarehouse to set
     */
    public void setLsWarehouse(List<Whse> lsWarehouse) {
        this.lsWarehouse = lsWarehouse;
    }

    /**
     * @return the lsLocation
     */
    public List<Loc> getLsLocation() {
        return lsLocation;
    }

    /**
     * @param lsLocation the lsLocation to set
     */
    public void setLsLocation(List<Loc> lsLocation) {
        this.lsLocation = lsLocation;
    }

    /**
     * @return the lsCoShipItemBean
     */
    public List<CoShipItemBean> getLsCoShipItemBean() {
        return lsCoShipItemBean;
    }

    /**
     * @param lsCoShipItemBean the lsCoShipItemBean to set
     */
    public void setLsCoShipItemBean(List<CoShipItemBean> lsCoShipItemBean) {
        this.lsCoShipItemBean = lsCoShipItemBean;
    }
}
