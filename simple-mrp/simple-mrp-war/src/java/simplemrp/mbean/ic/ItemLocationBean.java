/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJBException;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class ItemLocationBean extends ItemLocationAttr {

    private IcFacadeRemote icFacadeRemote = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private MaFacadeRemote maFacadeRemote = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);

    /** Creates a new instance of ItemLocationBean */
    public ItemLocationBean() {
        super();
        init();
    }

    private void init() {
        try {
            SelectItem item;
            List<Whse> resultWhse = maFacadeRemote.getListWhse();
            log.debug("init warehouse size=" + resultWhse.size());
            for (Whse whse : resultWhse) {
                item = new SelectItem();
                item.setLabel(whse.getDescription());
                item.setValue(whse.getWhse());
                super.addWarehouse(item);
            }
        } catch (Exception ex) {
            message("initial fail cause," + ex.getMessage());
        }
    }
    //operation

    public void doSearch(ActionEvent e) {
        try {
            log.debug("doSearch param={warehouse:" + super.getSearchWarehouse() + ",location:" + super.getSearchLocation() + "}");
            List<Itemloc> results = icFacadeRemote.searchItemLocation(super.getSearchWarehouse(), super.getSearchLocation());
            log.debug("doSearch results size=" + results.size());
            super.setLsItemLoc(results);
        } catch (EJBException ex) {
            message("search error cause," + ex.getMessage());
        } catch (Exception ex) {
            message("unknow error cause," + ex.getMessage());
        }
    }

    public void doCheckWarehouse(ActionEvent e) {
        String selectedWhse = super.getSearchWarehouse();
        log.debug("user select whse = " + selectedWhse);
        //clear list box
        super.setLsLocation(new ArrayList<SelectItem>());
        if ("%".equalsIgnoreCase(selectedWhse)) {
            return;
        }
        try {
            Whse whse = maFacadeRemote.getWhse(selectedWhse);
            Collection<Loc> listLoc = whse.getLocCollection();
            log.debug("fetch location size = " + listLoc.size() + " on Warehouse=" + selectedWhse);
            SelectItem sItem = null;
            for (Loc loc : listLoc) {
                sItem = new SelectItem();
                sItem.setValue(loc.getLocPK().getLoc());
                sItem.setLabel(loc.getDescription());
                super.addLocation(sItem);
            }
        } catch (Exception ex) {
            message("fetch location fail cause," + ex.getMessage());
        }
    }

    public void doCheckLocation(ActionEvent e) {
    }
}
