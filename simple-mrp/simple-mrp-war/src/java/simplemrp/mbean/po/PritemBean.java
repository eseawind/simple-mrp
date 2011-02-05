/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.po;

import javax.faces.event.ActionEvent;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Item;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;
import simplemrp.entity.Vendor;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.EJBLookup;


/**
 *
 * @author Golf
 */
public class PritemBean extends PritemAttr {

    /** Creates a new instance of PritemBean */
    public PritemBean() {
    }

    public void loadDetail(ActionEvent e) {
        try {
            String strMode = getP_mode();
            String strPrId = getP_prId();

            if(strMode.equals(MODE_EDIT)) {
                Integer intPrSeq = getP_prSeq();

                checkPritem(strPrId, intPrSeq);
            } else {
                setMode(MODE_NEW);
                setPrId(strPrId);
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void addPritem(String p_strPrId) {
        setMode(MODE_NEW);
    }

    private void checkPritem(String p_strPrId, Integer p_intPrSeq) {
        try {
            setMode(MODE_EDIT);
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            PritemPK pritemPK = new PritemPK(p_strPrId, p_intPrSeq);
            Pritem pritem = poFacade.getPritem(pritemPK);

            if(pritem != null) {
                setPrId(pritem.getPritemPK().getPrId());
                setPrSeq(pritem.getPritemPK().getPrSeq());
                setItem(pritem.getItem().getItem());
                setItemDesc(pritem.getItem().getDescription());
                setQty(pritem.getQty());
                
                
                
                setDueDate(pritem.getDueDate());
                setNote(pritem.getNote());

                setUdate(pritem.getUdate());
                setUuser(pritem.getUuser());

                setCdate(pritem.getCdate());
                setCuser(pritem.getCuser());
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doSave(ActionEvent e) {
        try {
            Pritem pritem = new Pritem();

            Item item = new Item();
            item.setItem(getItem());
            pritem.setItem(item);
            pritem.setQty(getQty());
            pritem.setDueDate(getDueDate());
            pritem.setNote(getNote());


            pritem.setUuser(getSessionUserId());

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();

            if(getMode().equals(MODE_NEW)) {
                PritemPK pritemPK = new PritemPK();
                pritemPK.setPrId(getPrId());
                pritem.setPritemPK(pritemPK);

                Integer intPrSeq = poFacade.createPritem(pritem);

                checkPritem(getPrId(), intPrSeq);

                message("Save Complete");
            } else if(getMode().equals(MODE_EDIT)) {
                PritemPK pritemPK = new PritemPK(getPrId(), getPrSeq());
                pritem.setPritemPK(pritemPK);

                poFacade.editPritem(pritem);

                checkPritem(getPrId(), getPrSeq());

                message("Save Complete");
            } else {
                message("Unoknow Operation Mode");
            }

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckItem(ActionEvent e) {
        try {
            String strItem = getItem();
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            Item item = maFacade.getItem(strItem);

            if(item != null) {
                setItem(item.getItem());
                setItemDesc(item.getDescription());
            } else {
                setItem(null);
                setItemDesc(null);
                message("Find Not Found");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    

}
