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
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Job;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.Whse;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.to.MatlToJobItemTO;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author wisaruthkea
 */
public class MatlToJobBean extends MatlToJobAttr {

    private PpFacadeRemote pp = (PpFacadeRemote) EJBLookup.getEJBInstance(BindingName.PpFacadeRemote);
    private IcFacadeRemote ic = (IcFacadeRemote) EJBLookup.getEJBInstance(BindingName.IcFacadeRemote);
    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);

    /** Creates a new instance of MatlToJobBean */
    public MatlToJobBean() throws Exception {
        super();
        init();
    }

    private void init() throws Exception {
        List<Whse> results = ma.getListWhse();
        for(Whse w : results) {
            SelectItem item = new SelectItem(w.getWhse(), w.getDescription());
            super.getLsWarehouse().add(item);
        }

    }

    public void doSave(ActionEvent e) {
//        log.info("save material to job id=" + super.getJobId());
        if(super.getTransactionDate() == null) {
            message("please specify transaction date.");
            return;
        }
        List<MatlToJobItemTO> lsTo = new ArrayList<MatlToJobItemTO>();
        MatlToJobItemTO to = null;
        for(MatlToJobItem mtj : super.getLsMatlToJobItem()) {
            to = new MatlToJobItemTO();
            //TODO implement data
            to.setOpr(mtj.getOperation());
            to.setSeq(mtj.getSequence());
            to.setMatlId(mtj.getMatl());
            to.setWareHouseId(mtj.getSelectedWarehouse());
            to.setLocationId(mtj.getSelectedLocation());
            to.setToBeIssue(mtj.getToBeIssue());
            lsTo.add(to);
        }

        MatlToJobItemTO[] arrMatlToJobItemTO = new MatlToJobItemTO[lsTo.size()];
        for(int i = 0; i < lsTo.size(); i++) {
            arrMatlToJobItemTO[i] = lsTo.get(i);
        }

        try {
            ic.saveMatlToJob_V2(super.getJobId(), super.getTransactionDate(), arrMatlToJobItemTO);
            message("Save '" + super.getJobId() + "' success");
            //refresh page
            doSearch(e);
        } catch(Exception ex) {
            message("Save '" + super.getJobId() + "' fail " + ex.getMessage());
        }

    }

    public void doSearch(ActionEvent e) throws Exception {
//        log.debug("Search Job " + StringUtil.prefixString(super.getJobId(), 7));
        try {
            Job job = pp.getJob(StringUtil.prefixString(super.getJobId(), 7));

            if(job != null) {
                List<Jobmatl> jobMatlList = pp.getJobMatlByJobId(job.getJobId());
                fillPage(job, jobMatlList);

            } else {
                message("Job ID '" + super.getJobId() + "' not found.");
                setJobId(null);
                setJobItemDesc(null);
                setJobItemId(null);
                setQty(null);
            }
        } catch(Throwable ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    private void fillPage(Job job, List<Jobmatl> ls) {
        super.getLsMatlToJobItem().clear();

        super.setJobId(job.getJobId());
        super.setJobItemId(job.getItem().getItem());
        super.setJobItemDesc(job.getItem().getDescription());
        super.setQty(job.getQty());
        super.setTransactionDate(new Date());
        MatlToJobItem item = null;
        for(Jobmatl matl : ls) {
            item = new MatlToJobItem();
            item.setOperation(matl.getJobmatlPK().getOpr());
            item.setSequence(matl.getJobmatlPK().getSeq());
            item.setMatl(matl.getItem().getItem());
            item.setSelectedWarehouse("-1");
            item.setSelectedLocation("-1");
            item.setOnHand(0.0);
            item.setQtyRequest(matl.getQtyReq());
            item.setQtyIssued(matl.getQtyShip() == null ? 0 : matl.getQtyShip());
            item.setToBeIssue(0.0);
            super.getLsMatlToJobItem().add(item);
        }
    }
}
