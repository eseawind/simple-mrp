/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class PoReceiveAttr extends AbstractManageBean {
    //search input
    private String searchPo;
    //search result
    private Date transactionDate;
    private List<PoReceiveItemBean> lsPoReceiveItemBean;

    //Option select
    private List<SelectItem> lsWarehouse;
    

    public PoReceiveAttr(){
        lsPoReceiveItemBean = new ArrayList<PoReceiveItemBean>();
        lsWarehouse = new ArrayList<SelectItem>();
        
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
    public List<SelectItem> getLsWarehouse() {
        return lsWarehouse;
    }

    /**
     * @param lsWarehouse the lsWarehouse to set
     */
    public void setLsWarehouse(List<SelectItem> lsWarehouse) {
        this.lsWarehouse = lsWarehouse;
    }

}
