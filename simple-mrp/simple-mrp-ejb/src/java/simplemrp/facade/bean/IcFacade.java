/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfItemBo;
import simplemrp.dao.InfItemlocDao;
import simplemrp.entity.Itemloc;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.IcFacadeRemote)
public class IcFacade implements IcFacadeRemote {

    @EJB
    private InfItemBo infItemBo;

    @Override
    public List<Itemloc> searchItemLocation(String warehouse, String location) {
        return infItemBo.searchItemLocation(warehouse,location);
    }

}
