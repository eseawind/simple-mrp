/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Vendor;

/**
 *
 * @author Golf
 */
@Local
public interface InfVendorBo {
    public List<Vendor> searchVendor(String p_strName) throws Exception;

    public Vendor findVendor(String p_strVend_id) throws Exception;

    public void editVendor(Vendor p_Vendor) throws Exception;

    public void removeVendor(Vendor p_Vendor) throws Exception;

    public String createVendor(Vendor p_Vendor) throws Exception;
}
