/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import simplemrp.constant.PoConstant;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Item;
import simplemrp.entity.Po_stat;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Vendor;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.EJBLookup;

/**
 *
 * @author Golf
 */
public class PoitemBean extends PoitemAttr {

    /** Creates a new instance of PoitemBean */
    public PoitemBean() {
    }

    public void loadDetail(ActionEvent e) {
        try {
            String strMode = getP_mode();
            String strPoId = getP_poId();

            if(strMode.equals(MODE_EDIT)) {
                Integer intPoSeq = getP_poSeq();

                checkPoitem(strPoId, intPoSeq);
            } else {
                setMode(MODE_NEW);
                setPoId(strPoId);
                setStat(PoConstant.PO_STAT_ORDER);
                loadPoStat();
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void addPoitem(String p_strPoId) {
        setMode(MODE_NEW);
    }

    private void checkPoitem(String p_strPoId, Integer p_intPoSeq) {
        try {
            setMode(MODE_EDIT);
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            PoitemPK poitemPK = new PoitemPK(p_strPoId, p_intPoSeq);
            Poitem poitem = poFacade.getPoitem(poitemPK);

            if(poitem != null) {
                setPoId(poitem.getPoitemPK().getPoId());
                setPoSeq(poitem.getPoitemPK().getPoSeq());
                setItem(poitem.getItem().getItem());
                setItemDesc(poitem.getItem().getDescription());
                setQty(poitem.getQty());
                setQtyRcv(poitem.getQtyRcv());
                setDueDate(poitem.getDueDate());

                if(poitem.getVendor() == null) {
                    setVendId(null);
                    setVendDesc(null);
                } else {
                    setVendId(poitem.getVendor().getVendId());
                    setVendDesc(poitem.getVendor().getDescription());
                }
 
                setVendItem(poitem.getVendItem());
                setPrId(poitem.getPritem().getPritemPK().getPrId());
                setPrSeq(poitem.getPritem().getPritemPK().getPrSeq());
                setNote(poitem.getNote());
                setStat(poitem.getPostat().getStat());

                setUdate(poitem.getUdate());
                setUuser(poitem.getUuser());

                setCdate(poitem.getCdate());
                setCuser(poitem.getCuser());

                loadPoStat();
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void loadPoStat() throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Po_stat> lsAllPoitemStat = poFacade.getListPo_stat();

        List lsPoStat = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllPoitemStat.size(); i++) {
            Po_stat coStat = lsAllPoitemStat.get(i);
            SelectItem selectItem = new SelectItem(coStat.getStat(), coStat.getDescription());

            lsPoStat.add(selectItem);
        }

        setLsPoitemStat(lsPoStat);
    }

    public void doSave(ActionEvent e) {
        try {
            Poitem poitem = new Poitem();
            poitem.setNote(getNote());

            Po_stat po_stat = new Po_stat();
            po_stat.setStat(getStat());
            poitem.setPostat(po_stat);

            Item item = new Item();
            item.setItem(getItem());
            poitem.setItem(item);

            if(getVendId().length() > 0) {
                Vendor vendor = new Vendor();
                vendor.setVendId(getVendId());
                poitem.setVendor(vendor);
            }


            poitem.setQty(getQty());

            poitem.setUuser(getSessionUserId());

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();

            if(getMode().equals(MODE_NEW)) {
                PoitemPK poitemPK = new PoitemPK();
                poitemPK.setPoId(getPoId());
                poitem.setPoitemPK(poitemPK);

                Integer intPoSeq = poFacade.createPoitem(poitem);

                checkPoitem(getPoId(), intPoSeq);

                message("Save Complete");
            } else if(getMode().equals(MODE_EDIT)) {
                PoitemPK poitemPK = new PoitemPK(getPoId(), getPoSeq());
                poitem.setPoitemPK(poitemPK);

                poFacade.editPoitem(poitem);

                checkPoitem(getPoId(), getPoSeq());

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

    public void doCheckVendId(ActionEvent e) {
        try {
            String strVendId = StringUtil.prefixString(getVendId().trim(), 7);
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            Vendor vendor = poFacade.getVendor(strVendId);

            if(vendor != null) {
                setVendId(vendor.getVendId());
                setVendDesc(vendor.getDescription());
            } else {
                setVendId(null);
                setVendDesc(null);
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
