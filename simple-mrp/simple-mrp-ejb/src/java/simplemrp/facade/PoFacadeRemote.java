/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Vendor;

import javax.ejb.Remote;

/**
 *
 * @author Golf
 */
@Remote
public interface PoFacadeRemote {

    //Vendor Manage
    public List<Vendor> searchVendor(String p_strKeyword) throws Exception;
    public Vendor getVendor(String p_strVendor_id) throws Exception;
    public String createVendor(Vendor p_vendor) throws Exception;
    public void editVendor(Vendor p_vendor) throws Exception;
    public void deleteVendor(Vendor p_vendor) throws Exception;
    
}
