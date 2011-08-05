/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfItemLocationBo;
import simplemrp.dao.InfItemlocDao;
import simplemrp.entity.Itemloc;
import simplemrp.entity.ItemlocPK;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class ItemLocationBo implements InfItemLocationBo {
    @EJB
    private InfItemlocDao itemlocDao;

    @Override
    public Itemloc findItemLocation(ItemlocPK pk) {
        return itemlocDao.find(pk);
    }

}
