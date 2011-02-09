/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.mbean.ic.to.PoRecvItemTO;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfPoRecvBo {

    public void savePoRecv(String poId, Date tranDate, List<PoRecvItemTO> lsPoOrderItem);

}
