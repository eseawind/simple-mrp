/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfCountryBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfCountryDao;
import simplemrp.entity.Country;

/**
 *
 * @author Golf
 */
@Stateless
public class CountryBo implements InfCountryBo {
    @EJB
    private InfCountryDao countryDao;

    @Override
    public List<Country> getListCountry() {
        return countryDao.findAll();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
