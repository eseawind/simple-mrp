/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfDistrictBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfDistrictDao;
import simplemrp.entity.District;

/**
 *
 * @author Golf
 */
@Stateless
public class DistrictBo implements InfDistrictBo {
    @EJB
    private InfDistrictDao districtDao;

    @Override
    public List<District> getDistrictInProvince(Integer p_intProvince) throws Exception {
        return districtDao.findByProvince(p_intProvince);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
