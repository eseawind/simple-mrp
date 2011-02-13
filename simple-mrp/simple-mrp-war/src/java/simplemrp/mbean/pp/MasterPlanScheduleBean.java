/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Item;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author wisaruthkea
 */
public class MasterPlanScheduleBean extends MasterPlanScheduleAttr {

    private PpFacadeRemote pp = (PpFacadeRemote) EJBLookup.getEJBInstance(BindingName.PpFacadeRemote);
    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);

    /** Creates a new instance of MasterPlanScheduleBean */
    public MasterPlanScheduleBean() {
        super();
        init();
    }

    private void init() {
        List<Mps_stat> lsS = pp.listMpsStat();
        for (Mps_stat stat : lsS) {
            super.getLsMpsStat().add(new SelectItem(stat.getStat(), stat.getDescription()));
        }
        List<Mps_type> lsT = pp.listMpsType();
        for (Mps_type type : lsT) {
            super.getLsMpsType().add(new SelectItem(type.getMpsType(), type.getDescription()));
        }
        super.setDsbNew(false);
        super.setDsbSave(true);
        super.setDsbDelete(true);
    }

    //operation
    public void doNew(ActionEvent e) {
        clear();
        super.setMode(MODE_NEW);
        super.setMpsId("autogenId");
        super.setDsbNew(true);
        super.setDsbSave(false);
    }

    public void doSave(ActionEvent e) {
        log.info("save");
        try {
            Mps newMps = new Mps(super.getMpsId());
            Item mpsItem = ma.getItem(super.getItemId());
            if (mpsItem == null) {
                message("Item " + super.getItemId() + " not found.");
                return;
            }
            newMps.setItem(mpsItem);
            Mps_type type = new Mps_type(super.getMpsType());
            newMps.setMpstype(type);
            newMps.setRefId(super.getRefId());
            newMps.setRefSeq(super.getRefSeqInt());
            newMps.setDuedate(super.getDueDate());
            newMps.setQty(super.getQty());
            Mps_stat status = new Mps_stat(super.getMpsStat());
            newMps.setMpsstat(status);
            if (MODE_EDIT.equals(getMode())) {
                newMps.setCuser(super.getcUser());
                newMps.setCdate(super.getcDate());
                newMps.setUuser(super.getSessionUserId());
                newMps.setUdate(new Date());
                pp.editMps(newMps);
                message("save " + super.getMpsId() + " success");
            }
            
            if (MODE_NEW.equals(getMode())) {
                newMps.setCuser(super.getSessionUserId());
                newMps.setCdate(new Date());
                String id = pp.createMps(newMps);
                super.setMpsId(id);
                setMode(MODE_EDIT);
                message("crate new mps success");

            } 
            //reload mps
            Mps current = pp.getMps(super.getMpsId());
            fillPageValue(current);
        } catch (Exception ex) {
            message("save fail cause," + ex.getMessage());
        }



    }

    public void doDelete(ActionEvent e) {
        log.info("delete");
        pp.removeMps(super.getMpsId());
        message("delete " + super.getMpsId() + " success.");
        clear();
        super.setDsbSave(true);
        super.setDsbNew(false);
    }

    public void doSearch(ActionEvent e) {
        log.info("search input=" + super.getSearchDueDate());
        List<Mps> results = new ArrayList<Mps>();
        if (super.getSearchDueDate() == null) {
            results = pp.listMps();
        } else {
            results = pp.searchMps(super.getSearchDueDate());
        }
        super.setLsMps(results);
    }

    public void doEdit(ActionEvent e) {
        super.setMode(MODE_EDIT);
        super.setDsbDelete(false);
        super.setDsbNew(false);
        super.setDsbSave(false);

        String selectedMpsId = FacesUtils.getRequestParameter("p_mps_id");
        Mps current = pp.getMps(selectedMpsId);
        fillPageValue(current);
    }

    public void confirmPlan(ActionEvent e) {
        log.info("confirm plan");
    }

    private void clear() {
        super.setMpsId(null);
        super.setItemId(null);
        super.setRefId(null);
        super.setRefSeqInt(0);
        super.setDueDate(null);
        super.setQty(0);
        super.setcUser(null);
        super.setcDate(null);
        super.setuUser(null);
        super.setuDate(null);
    }

    private void fillPageValue(Mps mps) {
        super.setMpsId(mps.getMpsId());
        super.setItemId(mps.getItem().getItem());
        super.setMpsType(mps.getMpstype().getMpsType());
        super.setRefId(mps.getRefId());
        super.setRefSeqInt(mps.getRefSeq());
        super.setDueDate(mps.getDuedate());
        super.setQty(mps.getQty());
        super.setMpsStat(mps.getMpsstat().getStat());
        super.setcUser(mps.getCuser());
        super.setcDate(mps.getCdate());
        super.setuUser(mps.getUuser());
        super.setuDate(mps.getUdate());
    }

    public void doGenerateMPS(ActionEvent e) {
        try {

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
