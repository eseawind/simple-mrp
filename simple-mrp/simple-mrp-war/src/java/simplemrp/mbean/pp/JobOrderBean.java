/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.pp;

import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Item;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author wisaruthkea
 */
public class JobOrderBean extends JobOrderAttr {

    private PpFacadeRemote ppFacadeRemote = (PpFacadeRemote) EJBLookup.getEJBInstance(BindingName.PpFacadeRemote);

    /** Creates a new instance of JobOrderBean */
    public JobOrderBean() {
        //super();
        init();
    }

    private void init() {
        log.debug("initial ");
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbJobId(false);
        fillJobStatList();
        log.debug("filled JobStatList");

    }

    private void fillJobStatList() {
        List<Job_stat> lsJobStatResource = ppFacadeRemote.listJobStat();
        SelectItem selectItem = null;
        for (Job_stat stat : lsJobStatResource) {
            selectItem = new SelectItem(stat.getStat(), stat.getDescription(), stat.getDescription());
            super.addJobStat(selectItem);
        }

    }
    private void fillPage(Job job){
        super.setJobId(job.getJobId());
        super.setItemCode(job.getItem().getItem());
        super.setJobDate(job.getJobdate());
        super.setQtyOrder(job.getQty());
        super.setQtyComplete(job.getQtycomplete());
        super.setJobStat(job.getJobstat().getStat());
        super.setNote(job.getNote());
        super.setcUser(job.getCuser());
        super.setcDate(job.getCdate());
        super.setuDate(job.getUdate());
        super.setuUser(job.getUuser());
        super.setDisbDel(false);
        super.setDisbSave(false);
    }

    private void clearEditScreen() {
        super.setJobId(null);
        super.setItemCode(null);
        super.setJobDate(null);
        super.setQtyOrder(0);
        super.setQtyComplete(0);
        super.setJobStat('c');
        super.setNote(null);
        super.setcUser(null);
        super.setcDate(null);
        super.setuUser(null);
        super.setuDate(null);
        setMode(MODE_NEW);
    }
    //operation

    public void doNew(ActionEvent e) {
        log.debug("do New");
        clearEditScreen();
        super.setMode(super.MODE_NEW);
        setDisbJobId(true);
        setDisbSave(false);
    }

    public void doSave(ActionEvent e) {
        Job job = new Job();
        if (MODE_EDIT.endsWith(super.getMode())) {
            job.setJobId(super.getJobId());
        }
        Item item = new Item();
        item.setItem(super.getItemCode());
        job.setItem(item);
        job.setJobdate(super.getJobDate());
        job.setQty(super.getQtyOrder());
        job.setQtycomplete(super.getQtyComplete());
        Job_stat stat = new Job_stat();
        stat.setStat(super.getJobStat());
        job.setJobstat(stat);
        job.setNote(super.getNote());

        try {
            if (super.MODE_NEW.equals(super.getMode())) {
                job.setCuser(super.getSessionUserId());
                job.setCdate(new Date());
                String jobId = ppFacadeRemote.createJob(job);
                Job currentJob = ppFacadeRemote.getJob(jobId);
                fillPage(currentJob);
                // is save success change to edit mode
                super.setMode(super.MODE_EDIT);
                message("New Complete");
            } else
            if (super.MODE_EDIT.equals(super.getMode())) {
                job.setCuser(super.getcUser());
                job.setCdate(super.getcDate());
                job.setUuser(super.getSessionUserId());
                job.setUdate(new Date());
                ppFacadeRemote.editJob(job);
                message("Save Complete");
            } else {
                message("Unknow operation.");
            }
        } catch (Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doDelete(ActionEvent e) {
        try {
            ppFacadeRemote.removeJob(super.getJobId());
            message("Delete " + super.getJobId() + " complete.");
            
        } catch (Exception ex) {
            message("Delete " + super.getJobId() + " fail." + ex);
        }
        clearEditScreen();
        init();
    }

    public void doSearch(ActionEvent e) {
        List<Job> lsJob = ppFacadeRemote.searchJob(super.getSearchJobId());
        super.setLsJob(lsJob);
    }

    public void doSelectJob(ActionEvent e) {
        clearEditScreen();
        String jobId = FacesUtils.getRequestParameter("p_job_id");
        log.debug("selectjob="+jobId);
        Job selectJob = ppFacadeRemote.getJob(jobId);
        log.debug("selectjob="+jobId+" result="+selectJob);
        if(selectJob!=null){
            fillPage(selectJob);
        } else {
            message("Job id:"+jobId+" not found or already deleted.");
        }
        super.setDisbJobId(true);
        super.setMode(MODE_EDIT);
    }
}
