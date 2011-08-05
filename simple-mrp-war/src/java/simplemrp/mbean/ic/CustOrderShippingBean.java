/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.entity.Whse;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.to.CoOrderItemTO;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class CustOrderShippingBean extends CustOrderShippingAttr {

    private IcFacadeRemote ic = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);

    public CustOrderShippingBean() throws Exception {
        super();
        init();
    }

    private void init() throws Exception {
        List<Whse> results = ma.getListWhse();
        for (Whse w : results) {
            SelectItem item = new SelectItem(w.getWhse(), w.getDescription());
            super.getLsWarehouse().add(item);
        }

    }

    //operation
    public void doSave(ActionEvent e) {
        log.info("save coid=" + super.getSearchCo());
        if(super.getTransactionDate()==null){
            message("please specify transaction date.");
            return;
        }
        CoOrderItemTO to = null;
        List<CoOrderItemTO> lsTo = new ArrayList<CoOrderItemTO>();
        for (CoShipItemBean item : super.getLsCoShipItemBean()) {
            to = new CoOrderItemTO();
            to.setCoSeq(item.getCoSeq());
            to.setItemId(item.getItemId());
            to.setWareHouseId(item.getSelectedWarehouse());
            to.setLocationId(item.getSelectedLocation());
            to.setToBeShip(item.getToBeShip());
            to.setCuser(getSessionUserId());
            lsTo.add(to);
        }

        CoOrderItemTO[] arrCoOrderItemTO = new CoOrderItemTO[lsTo.size()];
        for(int i = 0; i < lsTo.size(); i++) {
            arrCoOrderItemTO[i] = lsTo.get(i);
        }

        try {
//            ic.saveCoShipping(super.getSearchCo(), super.getTransactionDate(), lsTo);
            ic.saveCoShipping_V2(super.getSearchCo(), super.getTransactionDate(), arrCoOrderItemTO);
            doSearch(e);
            message("Save C/O ID=" + super.getSearchCo() + " Success.");
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            message("Save C/O ID=" + super.getSearchCo() + " Fail. cause " + ex.getMessage());
        }

    }

    public void doSearch(ActionEvent e) {
        log.info("Search CO Shipping input=" + super.getSearchCo());
        clear();
        try {
            Co results = ic.findCo(StringUtil.prefixString(super.getSearchCo(), 7));
            if (results == null) {
                setSearchCo(null);
                message("CO id=" + super.getSearchCo() + " not found.");
                return;
            } else {
                setSearchCo(results.getCoId());
            }
            fillValue(results);
        } catch (Exception ex) {
            message("find co fail cause," + ex.getMessage());
        }
    }

    private void clear() {
        super.setCust(null);
        super.setTransactionDate(null);
        super.getLsCoShipItemBean().clear();
    }

    private void fillValue(Co co) {
        super.setCust(co.getCustomer().getCustId() + ":" + co.getCustomer().getName());

        CoShipItemBean cib = null;
        for (Coitem coitem : co.getCoitemCollection()) {
            cib = new CoShipItemBean();
            cib.setCoSeq(coitem.getCoitemPK().getCoSeq());
            cib.setItemId(coitem.getItem().getItem());
            cib.setItemDesc(coitem.getItem().getDescription());
            cib.setQtyOrder(coitem.getQty());
            cib.setQtyShipped(coitem.getQtyship());
            super.getLsCoShipItemBean().add(cib);
        }
    }
}
