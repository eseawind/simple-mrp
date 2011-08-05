/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfVendorBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfVendorDao;
import simplemrp.entity.Vendor;
import org.sit.common.utils.DateUtil;

import simplemrp.entity.Vendor;

/**
 *
 * @author Golf
 */
@Stateless
public class VendorBo implements InfVendorBo {

    @EJB
    private InfVendorDao vendorDao;

    @Override
    public List<Vendor> searchVendor(String p_strName) throws Exception {
        return vendorDao.findByName(p_strName);
    }

    @Override
    public Vendor findVendor(String p_strVend_id) throws Exception {
        Vendor vendor = vendorDao.find(p_strVend_id);
        if (vendor != null) {
            if (vendor.getTerm() != null) {
                vendor.getTerm().toString();
            }
            if (vendor.getTax() != null) {
                vendor.getTax().toString();
            }
            if (vendor.getBank() != null) {
                vendor.getBank().toString();
            }
            if (vendor.getSubdist() != null) {
                vendor.getSubdist().toString();
            }
            if (vendor.getDistrict() != null) {
                vendor.getDistrict().getDistrictId().toString();
            }
            if (vendor.getProvince() != null) {
                vendor.getProvince().getProvinceId().toString();
            }
            if (vendor.getCountry() != null) {
                vendor.getCountry().getCountryId().toString();
            }
        }

        return vendor;
    }

    @Override
    public void editVendor(Vendor p_Vendor) throws Exception {
        try {
            vendorDao.edit(p_Vendor);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeVendor(Vendor p_Vendor) throws Exception {
        vendorDao.remove(p_Vendor);
    }

    @Override
    public String createVendor(Vendor p_Vendor) throws Exception {
        String strNextVendor_id = vendorDao.getNextVendor_id();
        p_Vendor.setVendId(strNextVendor_id);

        vendorDao.create(p_Vendor);

        return p_Vendor.getVendId();
    }
}
