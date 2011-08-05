/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import javax.ejb.Local;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfItemLocationBo {
    public Itemloc findItemLocation(ItemlocPK pk);
}
