/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfUomBo;
import simplemrp.dao.InfUomDao;
import simplemrp.entity.Uom;

/**
 *
 * @author Golf
 */
@Stateless
public class UomBo implements InfUomBo {
    
    @EJB
    private InfUomDao uomDao;

    @Override
    public List<Uom> getListUom() throws Exception {
        return uomDao.findAll();
    }
 
}
