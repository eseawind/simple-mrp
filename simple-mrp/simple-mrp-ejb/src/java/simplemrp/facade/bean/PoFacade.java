/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.entity.Vendor;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.bo.InfVendorBo;
import simplemrp.bo.bean.VendorBo;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.PoFacadeRemote)
public class PoFacade implements PoFacadeRemote {

    @EJB
    private InfVendorBo vendorBo;

    @Override
    public List<Vendor> searchVendor(String p_strKeyword) throws Exception {
        return vendorBo.searchVendor(p_strKeyword);
    }

    @Override
    public Vendor getVendor(String p_strVendor_id) throws Exception {
        return vendorBo.findVendor(p_strVendor_id);
    }

    @Override
    public String createVendor(Vendor p_vendor) throws Exception {
        return vendorBo.createVendor(p_vendor);
    }

    @Override
    public void editVendor(Vendor p_vendor) throws Exception {
        vendorBo.editVendor(p_vendor);
    }

    @Override
    public void deleteVendor(Vendor p_vendor) throws Exception {
        vendorBo.removeVendor(p_vendor);
    }


    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
