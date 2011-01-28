/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Itemloc;

/**
 *
 * @author Golf
 */
@Remote
public interface IcFacadeRemote {
    public List<Itemloc> searchItemLocation(String warehouse,String location);
}
