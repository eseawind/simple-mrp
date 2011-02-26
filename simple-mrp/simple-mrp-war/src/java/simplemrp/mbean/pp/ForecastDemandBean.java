/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import simplemrp.entity.Forecast;
import simplemrp.entity.Item;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author wisaruthkea
 */
public class ForecastDemandBean extends ForecastDemandAttr {

    private PpFacadeRemote ppFacadeRemote = (PpFacadeRemote) EJBLookup.getEJBInstance(BindingName.PpFacadeRemote);
    private MaFacadeRemote maFacadeRemote = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);

    /** Creates a new instance of ForecastDemandBean */
    public ForecastDemandBean() {
        super();
    }

    public void doAdd(ActionEvent e) {
        log.debug("doAdd");
        try {
            Item item = maFacadeRemote.getItem(super.getItemId());
            if(item==null){
                message("Item "+super.getItemId()+" Not Found.");
                return;
            }
            Forecast current = ppFacadeRemote.getForecast(super.getItemId());
            if(current!=null){
                message("Forecast "+super.getItemId()+" already exist.");
                return;
            }
            Forecast fc = new Forecast();
            fc.setItem(super.getItemId());
            fc.setQty(super.getQty());
            fc.setFcstdate(super.getForecaseDate());
            ppFacadeRemote.createForecase(fc);
            message("Add complete");
            search(fc.getFcstdate());
        } catch (Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doDelete(ActionEvent e) {
        String selectedDelForcase = FacesUtils.getRequestParameter("del_forecase");
        log.debug("doDelete selectItemid=" + selectedDelForcase);
        ppFacadeRemote.removeForecase(selectedDelForcase);
    }

    public void doSearch(ActionEvent e) throws Exception {
        search(super.getSearchForecaseDate());
    }

    private void search(Date p_dtForecast) throws Exception {
        List<Forecast> results = new ArrayList<Forecast>();
        try {
            if (p_dtForecast != null) {
                results = ppFacadeRemote.searchForecast(p_dtForecast);
            } else {
                results = ppFacadeRemote.listForecast();
                //System.out.println("result="+results);
            }
        } catch (Exception ex) {
            message("search fail cause," + ex.getMessage());
        }
        super.setLsForecast(results);
    }
}
