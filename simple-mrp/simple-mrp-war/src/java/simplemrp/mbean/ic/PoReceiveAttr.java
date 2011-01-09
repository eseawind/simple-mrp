/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;

/**
 *
 * @author wisaruthkea
 */
public class PoReceiveAttr {
    //search input
    private String searchPo;
    //search result
    private String vendor;
    private Date transactionDate;
    private List<PoReceiveItemBean> lsPoReceiveItemBean;

    //Option select
    private List<Whse> lsWarehouse;
    private List<Loc> lsLocation;

    public PoReceiveAttr(){
        lsWarehouse = new ArrayList<Whse>();
        lsLocation = new ArrayList<Loc>();
    }
    /**
     * @return the searchPo
     */
    public String getSearchPo() {
        return searchPo;
    }

    /**
     * @param searchPo the searchPo to set
     */
    public void setSearchPo(String searchPo) {
        this.searchPo = searchPo;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
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
     * @return the lsPoReceiveItemBean
     */
    public List<PoReceiveItemBean> getLsPoReceiveItemBean() {
        return lsPoReceiveItemBean;
    }

    /**
     * @param lsPoReceiveItemBean the lsPoReceiveItemBean to set
     */
    public void setLsPoReceiveItemBean(List<PoReceiveItemBean> lsPoReceiveItemBean) {
        this.lsPoReceiveItemBean = lsPoReceiveItemBean;
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
}
