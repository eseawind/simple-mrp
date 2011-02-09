/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.pp;

import java.util.List;
import javax.faces.event.ActionEvent;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Item;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public class BomBean extends BomAttr {

    public BomBean() {
        setEditButtonLabel("Show Edit");
        setShowEdit(false);
        setDisbNewOpr(true);
    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
    }

    public void clearEditScreen() {
        setItem(null);
        setItemDesc(null);

        setEditButtonLabel("Show Edit");
        setShowEdit(false);
    }

    public void doSearch(ActionEvent e) throws Exception {
        String strSearchItem = getSearchItem().trim();
        String strSearchDesc = getSearchDesc().trim();

        if((strSearchItem.length() == 0) && (strSearchDesc.length() == 0)) {
            message("Please Enter Search Condition");
        } else {
            searchItem(strSearchItem, strSearchDesc);
        }
    }

    private void searchItem(String p_strSearchItem, String p_strSearchDesc) throws Exception {
        if((p_strSearchItem.length() > 0) || (p_strSearchDesc.length() > 0)) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            List<Item> ls = maFacade.searchItem(p_strSearchItem, p_strSearchDesc);

            setLsItem(ls);
        }
    }

    public void doSelect(ActionEvent e) throws Exception {
        String strItem = FacesUtils.getRequestParameter("p_item");
        checkItem(strItem);
    }

    public void doCheckItem(ActionEvent e) {
        String strItem = getItem().trim().toUpperCase();
        checkItem(strItem);
    }

    private void checkItem(String p_strItem) {
        try {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            Item item = maFacade.getItem(p_strItem);

            setItem(item.getItem());
            setItemDesc(item.getDescription());

            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            List<Itemopr> lsItemopr = ppFacade.getBomDeatil(p_strItem);

            setLsItemopr(lsItemopr);

//            setEditButtonLabel("Show Edit");
//            setShowEdit(false);
            setDisbNewOpr(false);

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doDeleteOpr(ActionEvent e) {
        try {
            Integer intP_opr = StringUtil.toInteger(FacesUtils.getRequestParameter("p_opr"));

            ItemoprPK itemoprPK = new ItemoprPK();
            itemoprPK.setItem(getItem());
            itemoprPK.setOpr(intP_opr);

            Itemopr itemopr = new Itemopr();
            itemopr.setItemoprPK(itemoprPK);

            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            ppFacade.deleteItemopr(itemopr);

            checkItem(itemoprPK.getItem());

            message("Delete Complete");
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doDeleteMatl(ActionEvent e) {
        try {
            Integer intP_opr = StringUtil.toInteger(FacesUtils.getRequestParameter("p_opr"));
            Integer intP_seq = StringUtil.toInteger(FacesUtils.getRequestParameter("p_seq"));

            ItemmatlPK itemmatlPK = new ItemmatlPK(getItem(), intP_opr, intP_seq);

            Itemmatl itemmatl = new Itemmatl();
            itemmatl.setItemmatlPK(itemmatlPK);

            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            ppFacade.deleteItemmatl(itemmatl);

            checkItem(itemmatlPK.getItem());

            message("Delete Complete");
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doShowEdit(ActionEvent e) {
        if(isShowEdit()) {
            setEditButtonLabel("Show Edit");
            setShowEdit(false);
        } else {
            setEditButtonLabel("Hide Edit");
            setShowEdit(true);
        }

    }
}
