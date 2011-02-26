/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfMatlToJobBo;
import simplemrp.constant.IcConstant;
import simplemrp.dao.InfItemlocDao;
import simplemrp.dao.InfJobmatlDao;
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.JobmatlPK;
import simplemrp.entity.Stocktrans;
import simplemrp.to.MatlToJobItemTO;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class MatlToJobBo implements InfMatlToJobBo {

     @EJB
    InfStocktransDao stockTranDao;
    @EJB
    InfItemlocDao itemLocDao;
    @EJB
    InfJobmatlDao jobMatlDao;


    @Override
    public void saveMatlToJob(String jobId, Date transDate, List<MatlToJobItemTO> lsTo) {
       System.out.println("saveMatlToJob jobId="+jobId+" trans="+transDate+" list="+lsTo);
            for (MatlToJobItemTO to : lsTo) {
            if (to.getToBeIssue() != 0.0) { //skiped if to be ship = 0
                ItemlocPK pk = new ItemlocPK(to.getWareHouseId(), to.getLocationId(), to.getMatlId());
                Itemloc loc = itemLocDao.find(pk);
                System.out.println("find itemloc="+pk.toString()+" results="+loc);
                //update item onhand quantity on item location
                updateItemLocOnhand(loc, to);

                //create stock transaction
                createStockTransaction(jobId, loc, to, transDate);

                //update issued quantity on jobMatl
                JobmatlPK jobmatlPK = new JobmatlPK(jobId, to.getOpr(),to.getSeq());
                updateQtyIssued(jobmatlPK, to.getToBeIssue());
            }
        }
    }

    @Override
    public void saveMatlToJob_V2(String jobId, Date transDate, MatlToJobItemTO[] arrTo) throws Exception {
        try {
            for(int i = 0; i < arrTo.length; i++) {
                MatlToJobItemTO to = arrTo[i];
                if(to.getToBeIssue() != 0.0) { //skiped if to be ship = 0
                    ItemlocPK pk = new ItemlocPK(to.getWareHouseId(), to.getLocationId(), to.getMatlId());
                    Itemloc loc = itemLocDao.find(pk);
                    System.out.println("find itemloc=" + pk.toString() + " results=" + loc);
                    //update item onhand quantity on item location
                    updateItemLocOnhand(loc, to);

                    //create stock transaction
                    createStockTransaction(jobId, loc, to, transDate);

                    //update issued quantity on jobMatl
                    JobmatlPK jobmatlPK = new JobmatlPK(jobId, to.getOpr(), to.getSeq());
                    updateQtyIssued(jobmatlPK, to.getToBeIssue());
                }
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

     private void updateItemLocOnhand(Itemloc loc, MatlToJobItemTO to) {
        Double currentOnhand = loc.getOnhand();
        Double afterIssued = currentOnhand - to.getToBeIssue();
        loc.setOnhand(afterIssued);
        itemLocDao.edit(loc);
    }

    private void createStockTransaction(String coId, Itemloc loc, MatlToJobItemTO to, Date transDate) {
        Stocktrans e = new Stocktrans();
        Integer transId = stockTranDao.getNextPK();
        e.setTransId(transId);
        e.setItemloc(loc);
        e.setTransType(IcConstant.STOCK_TRANS_TYPE_JOBMATL);
        e.setTransDate(transDate);
        e.setRefId(coId);
        e.setRefSeq(to.getOpr());
        e.setQty(to.getToBeIssue());
        e.setCdate(new Date());
        stockTranDao.edit(e);
    }

    private void updateQtyIssued(JobmatlPK pk, Double qtyToBeShip) {
        Jobmatl jobmatl = jobMatlDao.find(pk);
        Double currentShipped = jobmatl.getQtyShip()==null?0:jobmatl.getQtyShip();
        Double afterPlusShip = currentShipped + qtyToBeShip;
        jobmatl.setQtyShip(afterPlusShip);
        jobMatlDao.edit(jobmatl);
    }

}
