/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

import simplemrp.constant.PoConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Po;
import simplemrp.entity.Po_stat;
import simplemrp.entity.Vendor;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author wisaruthkea
 */
public class PoBean extends PoAttr {

    //select resource
    public PoBean() {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbPoId(false);
    }

    //operation
    public void doNewPo(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbPoId(true);

        loadPoStat();

        setStat(PoConstant.PO_STAT_ORDER);
    }

    public void doSavePo(ActionEvent e) throws Exception {
        try {
            Po po = new Po();
            po.setNote(getNote());
            po.setPoDate(getPoDate());

            Po_stat po_stat = new Po_stat();
            po_stat.setStat(getStat());
            po.setPostat(po_stat);

            if(getVendId().length() > 0) {
                Vendor vendor = new Vendor();
                vendor.setVendId(getVendId());
                po.setVendor(vendor);
            }

            po.setUuser(getSessionUserId());

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();

            if(getMode().equals(MODE_EDIT)) {
                po.setPoId(getPoId());
                poFacade.editPo(po);

                checkPoId(po.getPoId());

                if((getSearchPoId().length() > 0) || (getSearchPoDate() != null)) {
                    searchPO(getSearchPoId(), getSearchPoDate());
                }

                message("Save Complete");

            } else if(getMode().equals(MODE_NEW)) {
                String strNewPoId = poFacade.createPo(po);

                checkPoId(strNewPoId);

                if((getSearchPoId().length() > 0) || (getSearchPoDate() != null)) {
                    searchPO(getSearchPoId(), getSearchPoDate());
                }

                message("Create Complete");

            } else {
                message("Unknown Operation Mode");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckPoId(ActionEvent e) throws Exception {
        checkPoId(StringUtil.prefixString(getPoId().trim(), 7));
    }

    private void checkPoId(String p_strPoId) throws Exception {
        try {
            setMode(MODE_EDIT);
            setDisbPoId(false);

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            Po po = poFacade.getPo(p_strPoId);

            if(po != null) {
                setPoId(po.getPoId());
                setNote(po.getNote());
                setPoDate(po.getPoDate());
                setPoId(po.getPoId());
                setStat(po.getPostat().getStat());

                if(po.getVendor() == null) {
                    setVendId(null);
                    setVendDesc(null);
                } else {
                    setVendId(po.getVendor().getVendId());
                    setVendDesc(po.getVendor().getDescription());
                }

                setUuser(po.getUuser());
                setCuser(po.getCuser());
                setCdate(po.getCdate());
                setUdate(po.getUdate());

                setDisbNew(false);
                setDisbSave(false);
                setDisbAddDtl(false);
                setDisbDel(false);

                loadPoitem(po.getPoId());
                loadPoStat();

            } else {
                clearEditScreen();
                message("Find Not Found");
            }
        } catch(Exception e) {
            message(e.getMessage());
        }
    }

    public void doDeletePo(ActionEvent e) throws Exception {
        try {
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            Po po = new Po();
            po.setPoId(getPoId());

            poFacade.deletePo(po);

            clearEditScreen();

            message("Delete Complete");

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doSearchPo(ActionEvent e) throws Exception {
        try {
            String strSearchPoId = getSearchPoId();
            Date dtSearchPoDate = getSearchPoDate();

            setSearchPoId(strSearchPoId);
            setSearchPoDate(dtSearchPoDate);

            if((strSearchPoId.length() == 0) && (dtSearchPoDate == null)) {
                message("Please enter search condition");
            } else {
                searchPO(strSearchPoId, dtSearchPoDate);
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
        
    }

    private void searchPO(String p_strPoId, Date p_dtPoDate) throws Exception {
        if((p_strPoId.length() > 0) || (p_dtPoDate != null)) {
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            List<Po> lsPo = poFacade.searchPo(p_strPoId, p_dtPoDate);

            setLsPo(lsPo);
        }
    }

    private void searchPoitem(String p_strPoId) throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Poitem> lsPoitem = poFacade.getPoitemByPo(p_strPoId);

        setLsPoItem(lsPoitem);
    }

    public void doClear(ActionEvent e) {
        clearEditScreen();
    }

    //table operation
    public void doSelectPo(ActionEvent e) {
        try {
            String strPo_id = FacesUtils.getRequestParameter("p_po_id");
            checkPoId(strPo_id);
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void loadPoStat() throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Po_stat> lsAllPoStat = poFacade.getListPo_stat();

        List lsPoStat = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllPoStat.size(); i++) {
            Po_stat poStat = lsAllPoStat.get(i);
            SelectItem selectItem = new SelectItem(poStat.getStat(), poStat.getDescription());

            lsPoStat.add(selectItem);
        }

        setLsPoStat(lsPoStat);
    }

    private void loadPoitem(String p_strPoId) throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Poitem> lsPoitem = poFacade.getPoitemByPo(p_strPoId);

        setLsPoItem(lsPoitem);
    }

    private void clearEditScreen() {
        setPoId(null);
        setNote(null);
        setPoDate(null);
        setStat(null);

        setVendId(null);
        setVendDesc(null);
        
        setUuser(null);
        setCuser(null);
        setCdate(null);
        setUdate(null);

        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbPoId(false);

        setMode(MODE_EDIT);
        setLsPoItem(null);
        setLsPoStat(null);
    }

    public void doDeletePoitem(ActionEvent e) {
        try {
            String strP_po_id = FacesUtils.getRequestParameter("p_po_id");
            Integer intP_po_seq = StringUtil.toInteger(FacesUtils.getRequestParameter("p_po_seq"));

            PoitemPK poitemPK = new PoitemPK(strP_po_id, intP_po_seq);
            Poitem poitem = new Poitem();
            poitem.setPoitemPK(poitemPK);

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            poFacade.deletePoitem(poitem);

            loadPoitem(poitemPK.getPoId());

            message("Delete Comlete");
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
