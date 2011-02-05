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
}
