/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Country;
import simplemrp.entity.District;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;

/**
 *
 * @author Golf
 */
@Remote
public interface MaFacadeRemote {
    public List<Country> getListCountry() throws Exception;

    public List<Province> getListProvince(Integer p_intCountry_id) throws Exception;

    public List<District> getListDistrict(Integer p_intProvince_id) throws Exception;

    public List<Subdist> getListSubdist(Integer p_intSubdist_id) throws Exception;

    public Subdist getSubdist(Integer p_intSubdist_id) throws Exception;

    public List<Tax> getListTax() throws Exception;
}
