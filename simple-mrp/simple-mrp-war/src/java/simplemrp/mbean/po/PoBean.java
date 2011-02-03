/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.po;

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
            po.setInvDate(getInvDate());
            po.setInvNum(getInvNum());
            po.setNote(getNote());
            po.setPoDate(getPoDate());

            Po_stat po_stat = new Po_stat();
            po_stat.setStat(getStat());
            po.setPostat(po_stat);

            Vendor vendor = new Vendor();
            vendor.setVendId(getVendId());
            po.setVendor(vendor);
            
            po.setUuser(getSessionUserId());

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();

            if(getMode().equals(MODE_EDIT)) {
                poFacade.editPo(po);

                checkPoId(po.getPoId());

                if((getSearchVendId().trim().length() > 0) || (getPoDate() != null)) {
                    searchPO(getSearchVendId().trim().toUpperCase(), getPoDate());
                }

                message("Save Complete");

            } else if(getMode().equals(MODE_NEW)) {
                String strNewPoId = poFacade.createPo(po);

                checkPoId(strNewPoId);

                if((getSearchVendId().trim().length() > 0) || (getPoDate() != null)) {
                    searchPO(getSearchVendId().trim().toUpperCase(), getPoDate());
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
                setInvDate(po.getInvDate());
                setInvNum(po.getInvNum());
                setNote(po.getNote());
                setPoDate(po.getPoDate());
                setPoId(po.getPoId());
                setStat(po.getPostat().getStat());
                setVendId(po.getVendor().getVendId());
                setVendDesc(po.getVendor().getDescription());

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

    public void doCheckVendId(ActionEvent e) throws Exception {
        checkVendId(getVendId().trim().toUpperCase());
    }

    private void checkVendId(String p_strVendId) {
        try {
            p_strVendId = StringUtil.prefixString(p_strVendId, 7);
            
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            Vendor vendor = poFacade.getVendor(p_strVendId);

            if(vendor == null) {
                setVendId(null);
                setVendDesc(null);

                message("Find Not Found");

            } else {
                setVendId(vendor.getVendId());
                setVendDesc(vendor.getDescription());
            }
        } catch(Exception ex) {
            message(ex.getMessage());
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
            String strSearchVendId = StringUtil.prefixString(getSearchVendId().trim(), 7);
            Date dtSearchPoDate = getSearchPoDate();

            setSearchVendId(strSearchVendId);
            setSearchPoDate(dtSearchPoDate);

            if((strSearchVendId.length() == 0) && (dtSearchPoDate == null)) {
                message("Please Enter Search Condition");
            } else {
                searchPO(strSearchVendId, dtSearchPoDate);
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
        
    }

    private void searchPO(String p_strVendId, Date p_dtPoDate) throws Exception {
        if((p_strVendId.length() > 0) || (p_dtPoDate != null)) {
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            List<Po> lsPo = poFacade.searchPo(p_strVendId, p_dtPoDate);

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
        setInvDate(null);
        setInvNum(null);
        setNote(null);
        setPoDate(null);
        setStat(null);
        setVendDesc(null);
        setVendId(null);
        
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
}