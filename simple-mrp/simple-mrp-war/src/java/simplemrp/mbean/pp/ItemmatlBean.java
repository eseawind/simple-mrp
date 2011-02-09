package simplemrp.mbean.pp;

import javax.faces.event.ActionEvent;
import simplemrp.entity.Item;
import simplemrp.entity.Itemopr;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;
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
public class ItemmatlBean extends ItemmatlAttr {

    /** Creates a new instance of ItemmatlBean */
    public ItemmatlBean() {
    }

    public void loadDetail(ActionEvent e) {
        try {
            String strMode = getP_mode();
            String strItem = getP_item();
            Integer intOpr = getP_opr();

            if(strMode.equals(MODE_EDIT)) {
                Integer intSeq = getP_seq();

                checkItemmatl(strItem, intOpr, intSeq);
            } else {
                setMode(MODE_NEW);
                MaFacadeRemote maFacade = EJBLookup.getMaFacade();
                Item item = maFacade.getItem(strItem);

                setItem(item.getItem());
                setItemDesc(item.getDescription());

                setOpr(intOpr);
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void checkItemmatl(String p_strItem, Integer p_intOpr, Integer p_intSeq) {
        try {
            setMode(MODE_EDIT);

            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            ItemmatlPK itemmatlPK = new ItemmatlPK(p_strItem, p_intOpr, p_intSeq);
            Itemmatl itemmatl = ppFacade.getItemmatl(itemmatlPK);

            if(itemmatl != null) {
                MaFacadeRemote maFacade = EJBLookup.getMaFacade();
                Item item = maFacade.getItem(itemmatl.getItemmatlPK().getItem());

                setItem(item.getItem());
                setItemDesc(item.getDescription());

                setOpr(itemmatl.getItemmatlPK().getOpr());
                setSeq(itemmatl.getItemmatlPK().getSeq());

                setMatl(itemmatl.getMatl().getItem());
                setMatlDesc(itemmatl.getMatl().getDescription());

                setQty(itemmatl.getQty());

                setCdate(itemmatl.getCdate());
                setCuser(itemmatl.getCuser());
                setUdate(itemmatl.getUdate());
                setUuser(itemmatl.getUuser());
            } else {
                message("Find not found");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doSave(ActionEvent e) {
        try {
            Itemmatl itemmatl = new Itemmatl();

            Item matl = new Item(getMatl().trim().toUpperCase());
            itemmatl.setMatl(matl);

            itemmatl.setQty(getQty());

            itemmatl.setUuser(getSessionUserId());

            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();

            if(getMode().equals(MODE_NEW)) {
                ItemmatlPK itemmatlPK = new ItemmatlPK();
                itemmatlPK.setItem(getItem());
                itemmatlPK.setOpr(getOpr());

                itemmatl.setItemmatlPK(itemmatlPK);

                Integer intSeq = ppFacade.createItemmatl(itemmatl);

                checkItemmatl(itemmatlPK.getItem(), itemmatlPK.getOpr(), intSeq);

                message("Save Complete");
            } else if(getMode().equals(MODE_EDIT)) {
                ItemmatlPK itemmatlPK = new ItemmatlPK(getItem(), getOpr(), getSeq());
                itemmatl.setItemmatlPK(itemmatlPK);
                
                itemmatl.setItemmatlPK(itemmatlPK);

                ppFacade.editItemmatl(itemmatl);

                checkItemmatl(itemmatlPK.getItem(), itemmatlPK.getOpr(), itemmatlPK.getSeq());

                message("Save Complete");
            } else {
                message("Unoknow Operation Mode");
            }

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckMatl(ActionEvent e) {
        checkMatl(getMatl().trim().toUpperCase());
    }

    private void checkMatl(String p_strMatl) {
        try {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            Item matl = maFacade.getItem(p_strMatl);

            if(matl == null) {
                setMatl(null);
                setMatlDesc(null);

                message("Find Not Found");
            } else {
                setMatl(matl.getItem());
                setMatlDesc(matl.getDescription());
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
