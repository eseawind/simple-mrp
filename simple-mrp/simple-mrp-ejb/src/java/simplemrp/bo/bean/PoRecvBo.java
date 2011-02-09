/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfPoRecvBo;
import simplemrp.constant.IcConstant;
import simplemrp.dao.InfItemlocDao;
import simplemrp.dao.InfPoitemDao;
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Stocktrans;
import simplemrp.mbean.ic.to.PoRecvItemTO;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class PoRecvBo implements InfPoRecvBo {
    @EJB
    InfStocktransDao stockTranDao;

    @EJB
    InfItemlocDao itemLocDao;
    
    @EJB
    InfPoitemDao poItemDao;

    @Override
    public void savePoRecv(String poId, Date tranDate, List<PoRecvItemTO> lsPoOrderItem) {
        System.out.println("Save poId="+poId+" trandate="+tranDate+" list="+lsPoOrderItem);
        for(PoRecvItemTO to:lsPoOrderItem){
            if (to.getToBeRecv() != 0.0) { //skiped if to be ship = 0
                ItemlocPK pk = new ItemlocPK(to.getWareHouseId(), to.getLocationId(), to.getItemId());
                Itemloc loc = itemLocDao.find(pk);
                //update item onhand quantity on item location
                updateItemLocOnhand(loc, to);

                //create stock transaction
                createStockTransaction(poId, loc, to, tranDate);

                //update shipped quantity on coitem
                PoitemPK poitemPK = new PoitemPK(poId, to.getPoSeq());
                updateQtyReceived(poitemPK, to.getToBeRecv());
            }
        }
    }
    private void updateItemLocOnhand(Itemloc loc, PoRecvItemTO to) {
        Double currentOnhand = loc.getOnhand();
        Double afterShipped = currentOnhand + to.getToBeRecv();
        loc.setOnhand(afterShipped);
        itemLocDao.edit(loc);
    }

    private void createStockTransaction(String poId, Itemloc loc, PoRecvItemTO to, Date transDate) {
        Integer transId = stockTranDao.getNextPK();
        Stocktrans e = new Stocktrans();
        e.setTransId(transId);
        e.setItemloc(loc);
        e.setTransType(IcConstant.STOCK_TRANS_TYPE_PORCV);
        e.setTransDate(transDate);
        e.setRefId(poId);
        e.setRefSeq(to.getPoSeq());
        e.setQty(to.getToBeRecv());
        e.setCdate(new Date());
        stockTranDao.edit(e);
    }

    private void updateQtyReceived(PoitemPK pk, Double qtyToBeRecv) {
        Poitem poitem = poItemDao.find(pk);
        Double currentReceived = poitem.getQtyRcv()==null?0:poitem.getQtyRcv();
        Double afterPlusShip = currentReceived + qtyToBeRecv;
        poitem.setQtyRcv(afterPlusShip);
        poItemDao.edit(poitem);
    }

}
