/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Po;
import simplemrp.entity.Poitem;
import simplemrp.entity.Whse;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class PoReceiveBean extends PoReceiveAttr {
    private MaFacadeRemote maFacade = (MaFacadeRemote)EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    private PoFacadeRemote poFacade = (PoFacadeRemote) EJBLookup.getEJBInstance(BindingName.PoFacadeRemote);

    /** Creates a new instance of PoReceiveBean */
    public PoReceiveBean() throws Exception {
        super();
        init();
    }
    private void init() throws Exception{
         List<Whse> results = maFacade.getListWhse();
        for (Whse w : results) {
            SelectItem item = new SelectItem(w.getWhse(), w.getDescription());
            super.getLsWarehouse().add(item);
        }
    }

    public void doSave(ActionEvent e) {

        System.out.println("Save PO Receive");
    }

    public void doSearch(ActionEvent e) {
        //clear old data
        super.getLsPoReceiveItemBean().clear();
        super.setVendor(null);
        super.setTransactionDate(null);
        try {
            Po result = poFacade.getPo(super.getSearchPo());
            if (result == null) {
                message("P/O ID=" + super.getSearchPo() + " not found.");
                return;
            }
            List<Poitem> ls = poFacade.getPoitemByPo(result.getPoId());
            result.setPoitemCollection(ls);
            fillPageValue(result);
            
        } catch (Exception ex) {
            message("Search P/O Fail cause. " + ex.getMessage());
        }

    }
    
    private void fillPageValue(Po po){
        super.setVendor("UNDER IMPLEMENT");
        super.setTransactionDate(new Date());
        for(Poitem poitem:po.getPoitemCollection()){
            PoReceiveItemBean b = new PoReceiveItemBean();
            b.setItemId(poitem.getItem().getItem());
            b.setItemDesc(poitem.getItem().getDescription());
            b.setOnHand(0.0);
            b.setQtyOrder(poitem.getQty()!=null?poitem.getQty():0);
            b.setQtyReceived(poitem.getQtyRcv()!=null?poitem.getQtyRcv():0);
            b.setToBeReceive(0.0);
            super.getLsPoReceiveItemBean().add(b);
        }
    }
}
