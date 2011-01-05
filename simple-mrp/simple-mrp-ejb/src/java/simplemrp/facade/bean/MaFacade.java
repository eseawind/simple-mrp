/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCountryBo;
import simplemrp.bo.InfDistrictBo;
import simplemrp.bo.InfProvinceBo;
import simplemrp.bo.InfSubdistBo;
import simplemrp.bo.InfTaxBo;
import simplemrp.entity.Country;
import simplemrp.entity.District;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.MaFacadeRemote)
public class MaFacade implements MaFacadeRemote {
    @EJB
    private InfCountryBo countryBo;
    @EJB
    private InfProvinceBo provinceBo;
    @EJB
    private InfDistrictBo districtBo;
    @EJB
    private InfSubdistBo subdistBo;
    @EJB
    private InfTaxBo taxBo;

    @Override
    public List<Country> getListCountry() throws Exception {
        return countryBo.getListCountry();
    }

    @Override
    public List<Province> getListProvince(Integer p_intCountry_id) throws Exception {
        return provinceBo.getProvinceInCountry(p_intCountry_id);
    }

    @Override
    public List<District> getListDistrict(Integer p_intProvince_id) throws Exception {
        return districtBo.getDistrictInProvince(p_intProvince_id);
    }

    @Override
    public List<Subdist> getListSubdist(Integer p_intSubdist_id) throws Exception {
        return subdistBo.getSubdistInDistrict(p_intSubdist_id);
    }

    @Override
    public Subdist getSubdist(Integer p_intSubdist_id) throws Exception {
        return subdistBo.getSubdist(p_intSubdist_id);
    }

    @Override
    public List<Tax> getListTax() throws Exception {
        return taxBo.getListTax();
    }

}
