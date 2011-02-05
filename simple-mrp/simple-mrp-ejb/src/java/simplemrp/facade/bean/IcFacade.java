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
import simplemrp.bo.InfItemBo;
import simplemrp.dao.InfItemlocDao;
import simplemrp.entity.Co;
import simplemrp.entity.Coitem;
import simplemrp.entity.Itemloc;
import simplemrp.facade.IcFacadeRemote;
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
}
