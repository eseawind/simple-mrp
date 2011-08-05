/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.to.CoOrderItemTO;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfCoShipBo {
    

//    public void saveCoShipping(String coId, Date tranDate, List<CoOrderItemTO> lsCoOrderItem) throws Exception;

    public void saveCoShipping_V2(String coId, Date tranDate, CoOrderItemTO[] arrCoOrderItem) throws Exception;
}
