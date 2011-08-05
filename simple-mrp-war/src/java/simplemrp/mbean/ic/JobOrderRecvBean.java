/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.ic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.Job;
import simplemrp.entity.Loc;
import simplemrp.entity.Whse;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.to.JobRecvItemTO;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author wisaruthkea
 */
public class JobOrderRecvBean extends JobOrderRecvAttr {

    private PpFacadeRemote ppFacadeRemote = (PpFacadeRemote) EJBLookup.getEJBInstance(BindingName.PpFacadeRemote);
    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    private IcFacadeRemote ic = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);

    /** Creates a new instance of JobOrderRecvBean */
    public JobOrderRecvBean() throws Exception {
        super();
        init();
    }

    private void init() throws Exception {
    }

    public void doSearch(ActionEvent e) {
        String searchJobId = super.getSearchJobId().trim();
        List<Job> result = new ArrayList<Job>();
        if (searchJobId.length() > 0) {
            setSearchJobId(searchJobId);
            result = ppFacadeRemote.searchJob(super.getSearchJobId(), null);
        }
        super.setLsJob(result);
    }

    public void doSelectJob(ActionEvent e) throws Exception {
        String selectedJobId = FacesUtils.getRequestParameter("p_job_id");
        selectJob(selectedJobId);
    }

    private void selectJob(String p_strJobId) throws Exception {
        //reset page
        clearEditScreen();
        //get result
        Job job = ppFacadeRemote.getJob(p_strJobId);
        this.fillPage(job);

        //init warehouse
        super.getLsWarehouse().clear(); //clear list
        List<Whse> results = ma.getListWhse();
        
        for (Whse w : results) {
            SelectItem item = new SelectItem(w.getWhse(), w.getDescription());
            super.getLsWarehouse().add(item);
        }
    }

    public void doSave(ActionEvent e) {
        log.debug("save jobid=" + super.getJobId() + " itemid=" + super.getItemId() + " tobecomplete=" + super.getToBeComplete());
        JobRecvItemTO to = new JobRecvItemTO();
        to.setItemId(super.getItemId());
        to.setWareHouseId(super.getSelectedWarehouse());
        to.setLocationId(super.getSelectedLocation());
        to.setToBeRecv(super.getToBeComplete());
        to.setCuser(getSessionUserId());
        try {
            ic.saveJobReceive(super.getJobId(), super.getTransactionDate(), to);
            //Reload job Data
            Job job = ppFacadeRemote.getJob(super.getJobId());
            this.fillPage(job);
            //Reload onhand
            this.doCheckLocation(e);
            selectJob(super.getJobId());
            message("Save Job ID '" + super.getJobId() + "' success.");
        } catch (Exception ex) {
            message("Save Job ID=" + super.getJobId() + " Fail " + ex.getMessage());
        }
    }

    public void doCheckWarehouse(ActionEvent e) throws Exception {
        log.debug("docheckLocation lWhse =" + super.getSelectedWarehouse());
        super.getLsLocation().clear(); //clear list
        Whse whse = ma.getWhse(super.getSelectedWarehouse());
        if (whse != null) {
            for (Loc loc : whse.getLocCollection()) {
                SelectItem item = new SelectItem(loc.getLocPK().getLoc(), loc.getDescription());
                super.getLsLocation().add(item);
            }
        } else {
            super.setMaxToBeComplte(0);
            super.setOnHand(0.0);
            super.setToBeComplete(0);

        }

    }

    public void doCheckLocation(ActionEvent e) {
        log.debug("docheckLocation whse=" + super.getSelectedWarehouse() + " location=" + super.getSelectedLocation() + " item=" + super.getItemId());
        //clear data
        super.setOnHand(0.0);
        super.setMaxToBeComplte(0);
        Integer qtyComplete = super.getQtyComplete()!=null?super.getQtyComplete():0;
        Itemloc itemloc = ic.findItemLocation(super.getSelectedWarehouse(), super.getSelectedLocation(), super.getItemId());
        if (itemloc != null) {
            log.debug("item on hand=" + itemloc.getOnhand());
            super.setOnHand(itemloc.getOnhand());
            Integer diff = super.getQtyOrder() - qtyComplete;
            super.setMaxToBeComplte(diff);
        } else {
            super.setToBeComplete(0);
        }
    }

    private void fillPage(Job job) {
        super.setJobId(job.getJobId());
        super.setItemId(job.getItem().getItem());
        super.setItemDesc(job.getItem().getDescription());
        super.setQtyOrder(job.getQty());
        super.setQtyComplete(job.getQtycomplete());
        super.setTransactionDate(new Date());
        //super.setToBeComplete(0);
    }

    private void clearEditScreen() {
        super.setJobId(null);
        super.setItemId(null);
        super.setItemDesc(null);
        super.setSelectedWarehouse("-1");
        super.setSelectedLocation("-1");
        super.setOnHand(0.0);
        super.setQtyOrder(0);
        super.setQtyComplete(0);
        super.setTransactionDate(new Date());
        super.setToBeComplete(0);
        super.setMaxToBeComplte(0);
    }
}
