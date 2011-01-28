/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Vendor;

import javax.ejb.Remote;
import simplemrp.entity.Po;
import simplemrp.entity.Po_stat;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;

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

    //Po management
    public List<Po> searchPo(String p_strVendId, Date p_dtPoDate) throws Exception;
    public Po getPo(String strPo_id) throws Exception;
    public String createPo(Po p_po) throws Exception;
    public void editPo(Po p_po) throws Exception;
    public void deletePo(Po p_po) throws Exception;

    //Poitem management
    public List<Poitem> getPoitemByPo(String p_strPo_id) throws Exception;
    public Poitem getPoitem(PoitemPK p_pkPoitem) throws Exception;
    public Integer createPoitem(Poitem p_poitem) throws Exception;
    public void editPoitem(Poitem p_poitem) throws Exception;
    public void deletePoitem(Poitem p_poitem) throws Exception;


    //Po_stat management
    public List<Po_stat> getListPo_stat() throws Exception;

}
