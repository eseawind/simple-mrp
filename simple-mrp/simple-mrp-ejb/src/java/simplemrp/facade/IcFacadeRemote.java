/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.entity.Itemloc;
import simplemrp.entity.Stocktrans;
import simplemrp.to.CoOrderItemTO;
import simplemrp.to.JobRecvItemTO;
import simplemrp.to.MatlToJobItemTO;
import simplemrp.to.PoRecvItemTO;

/**
 *
 * @author Golf
 */
@Remote
public interface IcFacadeRemote {
    public List<Itemloc> searchItemLocation(String warehouse,String location);

    ///////////// Customer Order Shipping ////////////////////////////////
    public void saveCo(Co co);
    //Lazy load coitem
    public Co findCo(String coId) throws Exception;
//    public void saveCoShipping(String coId,Date tranDate,List<CoOrderItemTO> lsCoOrderItem);
    public void saveCoShipping_V2(String coId, Date tranDate, CoOrderItemTO[] arrCoOrderItem) throws Exception;

    //Item Location
    public Itemloc findItemLocation(String whseId,String locationId,String itemId);


    ///////////// Purchase Order Receive //////
//    public void savePoReceive(String poId,Date tranDate,List<PoRecvItemTO> lsPoOrderItem);
    public void savePoReceive_V2(String poId,Date tranDate, PoRecvItemTO[] arrPoOrderItem) throws Exception;

    ///////////// Job Order Receive
    public void saveJobReceive(String jobId,Date transDate,JobRecvItemTO to) throws Exception;


    //////////// Matl To Job
//    public void saveMatlToJob(String jobId,Date transDate,List<MatlToJobItemTO> lsTo);
    public void saveMatlToJob_V2(String jobId,Date transDate, MatlToJobItemTO[] arrTo) throws Exception;

      //Stocktrans manage
    public List<Stocktrans> searchStocktrans(String p_strTransItem, Date p_dtTransDateFrom, Date p_dtTransDateTo) throws Exception;


}
