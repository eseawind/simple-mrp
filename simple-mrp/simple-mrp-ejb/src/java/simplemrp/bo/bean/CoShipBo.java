/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.awt.Stroke;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCoShipBo;
import simplemrp.constant.IcConstant;
import simplemrp.dao.InfCoitemDao;
import simplemrp.dao.InfItemlocDao;
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;
import simplemrp.entity.Stocktrans;
import simplemrp.mbean.ic.to.CoOrderItemTO;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class CoShipBo implements InfCoShipBo {

    @EJB
    InfStocktransDao stockTranDao;
    @EJB
    InfItemlocDao itemLocDao;
    @EJB
    InfCoitemDao coItemDao;

    @Override
    public void saveCoShipping(String coId, Date tranDate, List<CoOrderItemTO> lsCoOrderItem) {
        System.out.println("Save coid=" + coId + " trandate=" + tranDate + " list=" + lsCoOrderItem);
        for (CoOrderItemTO to : lsCoOrderItem) {
            if (to.getToBeShip() != 0.0) { //skiped if to be ship = 0
                ItemlocPK pk = new ItemlocPK(to.getWareHouseId(), to.getLocationId(), to.getItemId());
                Itemloc loc = itemLocDao.find(pk);
                //update item onhand quantity on item location
                updateItemLocOnhand(loc, to);

                //create stock transaction
                createStockTransaction(coId, loc, to, tranDate);

                //update shipped quantity on coitem
                CoitemPK coitemPK = new CoitemPK(coId, to.getCoSeq());
                updateQtyShipped(coitemPK, to.getToBeShip());
            }
        }
    }

    private void updateItemLocOnhand(Itemloc loc, CoOrderItemTO to) {
        Double currentOnhand = loc.getOnhand();
        Double afterShipped = currentOnhand - to.getToBeShip();
        loc.setOnhand(afterShipped);
        itemLocDao.edit(loc);
    }

    private void createStockTransaction(String coId, Itemloc loc, CoOrderItemTO to, Date transDate) {
        Stocktrans e = new Stocktrans();
        Integer transId = stockTranDao.getNextPK();
        e.setTransId(transId);
        e.setItemloc(loc);
        e.setTransType(IcConstant.STOCK_TRANS_TYPE_COSHIP);
        e.setTransDate(transDate);
        e.setRefId(coId);
        e.setRefSeq(to.getCoSeq());
        e.setQty(to.getToBeShip());
        e.setCdate(new Date());
    }

    private void updateQtyShipped(CoitemPK pk, Double qtyToBeShip) {
        Coitem coitem = coItemDao.find(pk);
        Double currentShipped = coitem.getQtyship();
        Double afterPlusShip = currentShipped + qtyToBeShip;
        coitem.setQtyship(afterPlusShip);
        coItemDao.edit(coitem);
    }
}
