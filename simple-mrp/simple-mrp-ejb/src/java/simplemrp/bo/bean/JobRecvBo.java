/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfJobRecvBo;
import simplemrp.bo.InfPoRecvBo;
import simplemrp.constant.IcConstant;
import simplemrp.dao.InfItemlocDao;
import simplemrp.dao.InfJobDao;
import simplemrp.dao.InfPoitemDao;
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;
import simplemrp.entity.Job;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Stocktrans;
import simplemrp.to.JobRecvItemTO;
import simplemrp.to.PoRecvItemTO;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class JobRecvBo implements InfJobRecvBo {

    @EJB
    InfStocktransDao stockTranDao;
    @EJB
    InfItemlocDao itemLocDao;
    @EJB
    InfJobDao jobDao;

    @Override
    public void saveJobRecv(String jobId, Date tranDate, JobRecvItemTO to) throws Exception {
        try {
            if(to.getToBeRecv() != 0.0) { //skiped if to be ship = 0
                ItemlocPK pk = new ItemlocPK(to.getWareHouseId(), to.getLocationId(), to.getItemId());
                Itemloc loc = itemLocDao.find(pk);
                //update item onhand quantity on item location
                updateItemLocOnhand(loc, to);

                //create stock transaction
                createStockTransaction(jobId, loc, to, tranDate);

                //update receive quantity on jobitem

                updateQtyReceived(jobId, to.getToBeRecv());
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    private void updateItemLocOnhand(Itemloc loc, JobRecvItemTO to) {
        Double currentOnhand = loc.getOnhand();
        Double afterShipped = currentOnhand + to.getToBeRecv();
        loc.setOnhand(afterShipped);
        itemLocDao.edit(loc);
    }

    private void createStockTransaction(String jobId, Itemloc loc, JobRecvItemTO to, Date transDate) {
        Integer transId = stockTranDao.getNextPK();
        Stocktrans e = new Stocktrans();
        e.setTransId(transId);
        e.setItemloc(loc);
        e.setTransType(IcConstant.STOCK_TRANS_TYPE_JOBRCV);
        e.setTransDate(transDate);
        e.setRefId(jobId);
        e.setRefSeq(0);
        e.setQty(to.getToBeRecv());
        e.setCdate(new Date());
        stockTranDao.edit(e);
    }

    private void updateQtyReceived(String jobId, Integer qtyToBeRecv) {
        Job job = jobDao.find(jobId);

        Integer currentCompleted = job.getQtycomplete() == null ? 0 : job.getQtycomplete();
        Integer afterPlusShip = currentCompleted + qtyToBeRecv;
        job.setQtycomplete(afterPlusShip);

        jobDao.edit(job);
    }
}
