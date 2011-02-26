/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Po;
import simplemrp.entity.Poitem;
import simplemrp.entity.Whse;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.to.PoRecvItemTO;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class PoReceiveBean extends PoReceiveAttr {

    private IcFacadeRemote ic = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private MaFacadeRemote maFacade = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    private PoFacadeRemote poFacade = (PoFacadeRemote) EJBLookup.getEJBInstance(BindingName.PoFacadeRemote);

    /** Creates a new instance of PoReceiveBean */
    public PoReceiveBean() throws Exception {
        super();
        init();
    }

    private void init() throws Exception {
        List<Whse> results = maFacade.getListWhse();
        for (Whse w : results) {
            SelectItem item = new SelectItem(w.getWhse(), w.getDescription());
            super.getLsWarehouse().add(item);
        }
    }

    public void doSave(ActionEvent e) {
        log.info("save coid=" + super.getSearchPo());
        if (super.getTransactionDate() == null) {
            message("please specify transaction date.");
            return;
        }
        PoRecvItemTO to = null;
        List<PoRecvItemTO> lsTo = new ArrayList<PoRecvItemTO>();
        for (PoReceiveItemBean item : super.getLsPoReceiveItemBean()) {
            to = new PoRecvItemTO();
            to.setPoSeq(item.getPoSeq());
            to.setItemId(item.getItemId());
            to.setWareHouseId(item.getSelectedWarehouse());
            to.setLocationId(item.getSelectedLocation());
            to.setToBeRecv(item.getToBeReceive());
            lsTo.add(to);
        }

        PoRecvItemTO[] arrPoRecvItemTO = new PoRecvItemTO[lsTo.size()];
        for(int i = 0; i < lsTo.size(); i++) {
            arrPoRecvItemTO[i] = lsTo.get(i);
        }
        try {
            ic.savePoReceive_V2(super.getSearchPo(), super.getTransactionDate(), arrPoRecvItemTO);
            doSearch(e);
            message("Save P/O ID=" + super.getSearchPo() + " Success.");
        } catch (Exception ex) {
            message("Save P/O ID=" + super.getSearchPo() + " Fail. cause " + ex.getMessage());
        }
    }

    public void doSearch(ActionEvent e) {
        //clear old data
        super.getLsPoReceiveItemBean().clear();
        super.setTransactionDate(new Date());
        try {
            Po result = poFacade.getPo(StringUtil.prefixString(super.getSearchPo(), 7));
            if (result == null) {
                message("P/O ID=" + super.getSearchPo() + " not found.");
                setSearchPo(null);
                return;
            } else {
                setSearchPo(result.getPoId());
            }
            List<Poitem> ls = poFacade.getPoitemByPo(result.getPoId());
            result.setPoitemCollection(ls);
            fillPageValue(result);

        } catch (Exception ex) {
            message("Search P/O Fail cause. " + ex.getMessage());
        }

    }

    private void fillPageValue(Po po) {
        super.setTransactionDate(new Date());
        for (Poitem poitem : po.getPoitemCollection()) {
            PoReceiveItemBean b = new PoReceiveItemBean();
            b.setPoSeq(poitem.getPoitemPK().getPoSeq());
            b.setItemId(poitem.getItem().getItem());
            b.setItemDesc(poitem.getItem().getDescription());
            b.setOnHand(0.0);
            b.setQtyOrder(poitem.getQty() != null ? poitem.getQty() : 0);
            b.setQtyReceived(poitem.getQtyRcv() != null ? poitem.getQtyRcv() : 0);
            b.setToBeReceive(0.0);
            super.getLsPoReceiveItemBean().add(b);
        }
    }
}
