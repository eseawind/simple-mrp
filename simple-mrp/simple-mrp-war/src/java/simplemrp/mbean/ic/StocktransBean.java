/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.entity.Stocktrans;

/**
 *
 * @author GSD008
 */
public class StocktransBean extends StocktransAttr {

    public StocktransBean() {
    }

    public void doSearchStocktrans(ActionEvent e) throws Exception {
        String strSearchTransItem = getSearchTransItem().trim();
        Date dtSearchTransDateFrom = getSearchTransDateFrom();
        Date dtSearchTransDateTo = getSearchTransDateTo();

//        log.info(strSearchTransItem);
//        log.info(dtSearchTransDateFrom);
//        log.info(dtSearchTransDateTo);

        setSearchTransItem(strSearchTransItem);

        if((getSearchTransItem().trim().length() == 0) 
                && (getSearchTransDateFrom() == null)
                && (getSearchTransDateTo() == null)) {
            
            message("Please Enter Search Trans");
        } else {
            searchStocktrans(strSearchTransItem, dtSearchTransDateFrom, dtSearchTransDateTo);
        }
    }

    private void searchStocktrans(String p_strTransItem, Date p_dtTransDateFrom, Date p_dtTransDateTo) throws Exception {
        if((p_strTransItem.length() > 0) || (p_dtTransDateFrom != null) || (p_dtTransDateTo != null)) {
            IcFacadeRemote icFacade = EJBLookup.getIcFacade();
            List<Stocktrans> lsStocktrans = icFacade.searchStocktrans(p_strTransItem, p_dtTransDateFrom, p_dtTransDateTo);

            setLsStocktrans(lsStocktrans);
        }
    }
}
