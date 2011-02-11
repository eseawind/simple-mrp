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
import simplemrp.entity.Pr;
import simplemrp.entity.Pr_stat;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;
import simplemrp.entity.Bank;

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
    public List<Bank> getListBank() throws Exception;

    //Po management
    public List<Po> searchPo(Date p_dtPoDate) throws Exception;
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

    //Pr_stat management
    public List<Pr_stat> getListPr_stat() throws Exception;

    //Pr management
    public List<Pr> searchPr(String p_strRequester, Date p_dtReqDate) throws Exception;
    public Pr getPr(String strPr_id) throws Exception;
    public String createPr(Pr p_pr) throws Exception;
    public void editPr(Pr p_pr) throws Exception;
    public void deletePr(Pr p_pr) throws Exception;

    //Pritem management
    public List<Pritem> getPritemByPr(String p_strPr_id) throws Exception;
    public Pritem getPritem(PritemPK p_pkPritem) throws Exception;
    public Integer createPritem(Pritem p_poitem) throws Exception;
    public void editPritem(Pritem p_poitem) throws Exception;
    public void deletePritem(Pritem p_poitem) throws Exception;

}
