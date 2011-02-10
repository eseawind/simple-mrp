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
import simplemrp.mbean.ic.to.CoOrderItemTO;
import simplemrp.mbean.ic.to.JobRecvItemTO;
import simplemrp.mbean.ic.to.PoRecvItemTO;

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
    public void saveCoShipping(String coId,Date tranDate,List<CoOrderItemTO> lsCoOrderItem);

    //Item Location
    public Itemloc findItemLocation(String whseId,String locationId,String itemId);


    ///////////// Purchase Order Receive //////
    public void savePoReceive(String poId,Date tranDate,List<PoRecvItemTO> lsPoOrderItem);

    ///////////// Job Order Receive
    public void saveJobReceive(String jobId,Date transDate,JobRecvItemTO to);
}
