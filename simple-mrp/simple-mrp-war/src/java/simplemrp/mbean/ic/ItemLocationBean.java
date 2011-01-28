/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.List;
import javax.ejb.EJBException;
import javax.faces.event.ActionEvent;
import simplemrp.entity.Itemloc;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class ItemLocationBean extends ItemLocationAttr {

    private IcFacadeRemote icFacadeRemote = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);

    /** Creates a new instance of ItemLocationBean */
    public ItemLocationBean() {
        super();
    }
    //operation

    public void doSearch(ActionEvent e) {
        try {
            log.debug("doSearch param={warehouse:"+super.getSearchWarehouse()+",location:"+super.getSearchLocation()+"}");
            List<Itemloc> results = icFacadeRemote.searchItemLocation(super.getSearchWarehouse(), super.getSearchLocation());
            log.debug("doSearch results size="+results.size());
            super.setLsItemLoc(results);
        } catch (EJBException ex) {
            message("search error cause," + ex.getMessage());
        } catch (Exception ex) {
            message("unknow error cause," + ex.getMessage());
        }
    }
}
