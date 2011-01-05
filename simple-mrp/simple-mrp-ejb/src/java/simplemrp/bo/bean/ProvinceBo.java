/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfProvinceBo;
import simplemrp.dao.InfProvinceDao;
import simplemrp.entity.Province;

/**
 *
 * @author Golf
 */
@Stateless
public class ProvinceBo implements InfProvinceBo {
    @EJB
    private InfProvinceDao provinceDao;

    @Override
    public List<Province> getProvinceInCountry(Integer p_intCountry) throws Exception {
        return provinceDao.findByCountry(p_intCountry);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
