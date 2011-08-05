/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class CustOrderShippingAttr extends AbstractManageBean {
    //Search
    private String searchCo;

    //Search result
    private String cust;
    private Date transactionDate;

    //Coitem list table and edit
    private List<CoShipItemBean> lsCoShipItemBean;

    //Optional resource
    private List<SelectItem> lsWarehouse;
    
    
    public CustOrderShippingAttr(){
        lsCoShipItemBean = new ArrayList<CoShipItemBean>();
        lsWarehouse = new ArrayList<SelectItem>();
        
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
    public List<SelectItem> getLsWarehouse() {
        return lsWarehouse;
    }

    /**
     * @param lsWarehouse the lsWarehouse to set
     */
    public void setLsWarehouse(List<SelectItem> lsWarehouse) {
        this.lsWarehouse = lsWarehouse;
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
