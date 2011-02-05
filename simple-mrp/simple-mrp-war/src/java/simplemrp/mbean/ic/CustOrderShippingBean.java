/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.entity.Whse;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.mbean.ic.to.CoOrderItemTO;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class CustOrderShippingBean extends CustOrderShippingAttr {
    private IcFacadeRemote ic = (IcFacadeRemote)EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private MaFacadeRemote ma = (MaFacadeRemote)EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    public CustOrderShippingBean() throws Exception{
        super();
        init();
    }
    private void init() throws Exception{
        List<Whse> results = ma.getListWhse();
        for(Whse w:results){
            SelectItem item = new SelectItem(w.getWhse(), w.getDescription());
            super.getLsWarehouse().add(item);
        }

    }
    
     //operation

    public void doSave(ActionEvent e){
        log.info("save coid="+super.getSearchCo());
        CoOrderItemTO to = null;
        List<CoOrderItemTO> lsTo = new ArrayList<CoOrderItemTO>();
        for(CoShipItemBean item:super.getLsCoShipItemBean()){
            to = new CoOrderItemTO();
            to.setItemId(item.getItemId());
            to.setWareHouseId(item.getSelectedWarehouse());
            to.setLocationId(item.getSelectedLocation());
            to.setToBeShip(item.getToBeShip());
            lsTo.add(to);
        }
        ic.saveCoShipped(super.getSearchCo(),super.getTransactionDate(),lsTo);
        message("Save CO ID="+super.getSearchCo()+" Success.");
    }
    public void doSearch(ActionEvent e){
        log.info("Search CO Shipping input="+super.getSearchCo());
        clear();
        try{
            Co results = ic.findCo(super.getSearchCo());
            if(results==null){
                message("CO id="+super.getSearchCo()+" not found.");
                return;
            }
            fillValue(results);
        }catch(Exception ex){
            message("find co fail cause,"+ex.getMessage());
        }
    }
    
    private void clear(){
        super.setCust(null);
        super.setTransactionDate(null);
        super.getLsCoShipItemBean().clear();
    }
    
    private void fillValue(Co co){
        super.setCust(co.getCustomer().getCustId()+":"+co.getCustomer().getName());
        
        CoShipItemBean cib = null;
        for(Coitem coitem:co.getCoitemCollection()){
            cib = new CoShipItemBean();
            cib.setItemId(coitem.getItem().getItem());
            cib.setItemDesc(coitem.getItem().getDescription());
            cib.setQtyOrder(coitem.getQty());
            cib.setQtyShipped(coitem.getQtyship());
            
            super.getLsCoShipItemBean().add(cib);
        }
    }
    
}
