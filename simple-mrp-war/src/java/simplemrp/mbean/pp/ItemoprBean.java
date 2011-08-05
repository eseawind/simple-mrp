package simplemrp.mbean.pp;


import javax.faces.event.ActionEvent;
import simplemrp.entity.Item;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Workcenter;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.EJBLookup;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Golf
 */
public class ItemoprBean extends ItemoprAttr {

    /** Creates a new instance of ItemoprBean */
    public ItemoprBean() {
    }

    public void loadDetail(ActionEvent e) {
        try {
            String strMode = getP_mode();
            String strItem = getP_item();

            if(strMode.equals(MODE_EDIT)) {
                Integer intOpr = getP_opr();

                checkItemopr(strItem, intOpr);
            } else {
                setMode(MODE_NEW);
                MaFacadeRemote maFacade = EJBLookup.getMaFacade();
                Item item = maFacade.getItem(strItem);

                setItem(item.getItem());
                setItemDesc(item.getDescription());
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void checkItemopr(String p_strItem, Integer p_intOpr) {
        try {
            setMode(MODE_EDIT);
            
            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            ItemoprPK itemoprPK = new ItemoprPK(p_strItem, p_intOpr);
            Itemopr itemopr = ppFacade.getItemopr(itemoprPK);

            if(itemopr != null) {
                setItem(itemopr.getItem1().getItem());
                setItemDesc(itemopr.getItem1().getDescription());

                setOpr(itemopr.getItemoprPK().getOpr());

                setWc(itemopr.getWorkcenter().getWc());
                setWcDesc(itemopr.getWorkcenter().getDescription());

                setCdate(itemopr.getCdate());
                setCuser(itemopr.getCuser());
                setUdate(itemopr.getUdate());
                setUuser(itemopr.getUuser());
            } else {
                message("Find not found");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doSave(ActionEvent e) {
        try {
            Itemopr itemopr = new Itemopr();

            Item item = new Item(getItem().trim().toUpperCase());
            itemopr.setItem1(item);
            
            Workcenter workcenter = new Workcenter(getWc().trim().toUpperCase());
            itemopr.setWorkcenter(workcenter);


            itemopr.setUuser(getSessionUserId());

            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();

            if(getMode().equals(MODE_NEW)) {
                ItemoprPK itemoprPK = new ItemoprPK();
                itemoprPK.setItem(item.getItem());

                itemopr.setItemoprPK(itemoprPK);

                Integer intOpr = ppFacade.createItemopr(itemopr);

                checkItemopr(getItem(), intOpr);

                message("Save Complete");
            } else if(getMode().equals(MODE_EDIT)) {
                ItemoprPK itemoprPK = new ItemoprPK(getItem(), getOpr());
                itemopr.setItemoprPK(itemoprPK);

                ppFacade.editItemopr(itemopr);

                checkItemopr(itemoprPK.getItem(), itemoprPK.getOpr());

                message("Save Complete");
            } else {
                message("Unoknow Operation Mode");
            }

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckWc(ActionEvent e) {
        try {
            String strWc = getWc();
            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            Workcenter wc = ppFacade.getWorkcenter(strWc);

            if(wc != null) {
                setWc(wc.getWc());
                setWcDesc(wc.getDescription());
            } else {
                setWc(null);
                setWcDesc(null);
                message("Find Not Found");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
