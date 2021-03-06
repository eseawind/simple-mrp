/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.facade.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCoBo;
import simplemrp.bo.InfCoShipBo;
import simplemrp.bo.InfItemBo;
import simplemrp.bo.InfItemLocationBo;
import simplemrp.bo.InfJobRecvBo;
import simplemrp.bo.InfMatlToJobBo;
import simplemrp.bo.InfPoRecvBo;
import simplemrp.bo.InfStocktransBo;
import simplemrp.dao.InfItemlocDao;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;
import simplemrp.entity.Stocktrans;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.to.CoOrderItemTO;
import simplemrp.to.JobRecvItemTO;
import simplemrp.to.MatlToJobItemTO;
import simplemrp.to.PoRecvItemTO;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless(mappedName = BindingName.IcFacadeRemote)
public class IcFacade implements IcFacadeRemote {

    @EJB
    private InfItemBo infItemBo;
    @EJB
    private InfCoBo infCoBo;
    @EJB
    private InfItemLocationBo infItemLocationBo;
    @EJB
    private InfCoShipBo infCoShipBo;
    @EJB
    private InfPoRecvBo infPoRecvBo;
    @EJB
    private InfJobRecvBo infJobRecvBo;

    @EJB
    private InfMatlToJobBo infMatlToJobBo;

    @EJB
    private InfStocktransBo stocktransBo;


    @Override
    public List<Itemloc> searchItemLocation(String warehouse, String location) {
        return infItemBo.searchItemLocation(warehouse, location);
    }

    @Override
    public void saveCo(Co co) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Co findCo(String coId) throws Exception {
        Co co = infCoBo.findCo(coId);
        if (co != null) {
            for (Coitem coitem : co.getCoitemCollection()) {
                coitem.toString();
                if(coitem.getItem()!=null){
                    coitem.getItem().toString();

                }
            }
        }
        return co;
    }

    @Override
    public Itemloc findItemLocation(String whseId, String locationId, String itemId) {
        ItemlocPK pk = new ItemlocPK(whseId, locationId, itemId);
        return infItemLocationBo.findItemLocation(pk);
    }

//    @Override
//    public void saveCoShipping(String coId, Date tranDate, List<CoOrderItemTO> lsCoOrderItem) {
//        infCoShipBo.saveCoShipping(coId,tranDate,lsCoOrderItem);
//    }

    @Override
    public void saveCoShipping_V2(String coId, Date tranDate, CoOrderItemTO[] arrCoOrderItem) throws Exception {
        infCoShipBo.saveCoShipping_V2(coId, tranDate, arrCoOrderItem);
    }

//    @Override
//    public void savePoReceive(String poId, Date tranDate, List<PoRecvItemTO> lsPoOrderItem) {
//        infPoRecvBo.savePoRecv(poId,tranDate,lsPoOrderItem);
//    }

    @Override
    public void savePoReceive_V2(String poId, Date tranDate, PoRecvItemTO[] arrPoOrderItem) throws Exception {
        infPoRecvBo.savePoRecv_V2(poId,tranDate,arrPoOrderItem);
    }

    @Override
    public void saveJobReceive(String jobId, Date transDate,JobRecvItemTO jobRecvItem) throws Exception {
        infJobRecvBo.saveJobRecv(jobId,transDate,jobRecvItem);
    }


//    @Override
//    public void saveMatlToJob(String jobId, Date transDate, List<MatlToJobItemTO> lsTo) {
//        infMatlToJobBo.saveMatlToJob(jobId,transDate,lsTo);
//    }

    @Override
    public void saveMatlToJob_V2(String jobId,Date transDate, MatlToJobItemTO[] arrTo) throws Exception {
        infMatlToJobBo.saveMatlToJob_V2(jobId,transDate, arrTo);
    }


    @Override
    public List<Stocktrans> searchStocktrans(String p_strTransItem, Date p_dtTransDateFrom, Date p_dtTransDateTo) {
        return stocktransBo.searchStocktrans( p_strTransItem, p_dtTransDateFrom, p_dtTransDateTo);
    }


}
