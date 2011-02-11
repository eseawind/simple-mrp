/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfPoBo;
import simplemrp.bo.InfPo_statBo;
import simplemrp.bo.InfPoitemBo;
import simplemrp.bo.InfPrBo;
import simplemrp.bo.InfPr_statBo;
import simplemrp.bo.InfPritemBo;
import simplemrp.bo.InfBankBo;
import simplemrp.entity.Bank;
import simplemrp.entity.Po;
import simplemrp.entity.Po_stat;
import simplemrp.entity.Vendor;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.bo.InfVendorBo;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Pr;
import simplemrp.entity.Pr_stat;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.PoFacadeRemote)
public class PoFacade implements PoFacadeRemote {

    @EJB
    private InfVendorBo vendorBo;

    @EJB
    private InfPoBo poBo;

    @EJB
    private InfPoitemBo poitemBo;

    @EJB
    private InfPo_statBo po_statBo;

    @EJB
    private InfPr_statBo pr_statBo;

    @EJB
    private InfPrBo prBo;

    @EJB
    private InfPritemBo pritemBo;

    @EJB
    private InfBankBo bankBo;

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

    @Override
    public List<Po> searchPo(String p_strVendId, Date p_dtPoDate) throws Exception {
        return poBo.searchPo(p_strVendId, p_dtPoDate);
    }

    @Override
    public Po getPo(String strPo_id) throws Exception {
        return poBo.findPo(strPo_id);
    }

    @Override
    public String createPo(Po p_po) throws Exception {
        return poBo.createPo(p_po);
    }

    @Override
    public void editPo(Po p_po) throws Exception {
        poBo.editPo(p_po);
    }

    @Override
    public void deletePo(Po p_po) throws Exception {
        poBo.removePo(p_po);
    }

    @Override
    public List<Po_stat> getListPo_stat() throws Exception {
        return po_statBo.getListPo_stat();
    }

    @Override
    public List<Poitem> getPoitemByPo(String p_strPo_id) throws Exception {
        return poitemBo.getPoitemByPo(p_strPo_id);
    }

    @Override
    public Poitem getPoitem(PoitemPK p_pkPoitem) throws Exception {
        return poitemBo.getPoitem(p_pkPoitem);
    }

    @Override
    public Integer createPoitem(Poitem p_poitem) throws Exception {
        return poitemBo.createPoitem(p_poitem);
    }

    @Override
    public void editPoitem(Poitem p_poitem) throws Exception {
        poitemBo.editPoitem(p_poitem);
    }

    @Override
    public void deletePoitem(Poitem p_poitem) throws Exception {
        poitemBo.removePoitem(p_poitem);
    }

    @Override
    public List<Pr_stat> getListPr_stat() throws Exception {
        return pr_statBo.getListPr_stat();
    }

    @Override
    public List<Pr> searchPr(String p_strRequester, Date p_dtReqDate) throws Exception {
        return prBo.searchPr(p_strRequester, p_dtReqDate);
    }

    @Override
    public Pr getPr(String strPr_id) throws Exception {
        return prBo.findPr(strPr_id);
    }

    @Override
    public String createPr(Pr p_pr) throws Exception {
        return prBo.createPr(p_pr);
    }

    @Override
    public void editPr(Pr p_pr) throws Exception {
        prBo.editPr(p_pr);
    }

    @Override
    public void deletePr(Pr p_pr) throws Exception {
        prBo.removePr(p_pr);
    }

    @Override
    public List<Pritem> getPritemByPr(String p_strPr_id) throws Exception {
        return pritemBo.getPritemByPr(p_strPr_id);
    }

    @Override
    public Pritem getPritem(PritemPK p_pkPritem) throws Exception {
        return pritemBo.getPritem(p_pkPritem);
    }

    @Override
    public Integer createPritem(Pritem p_poitem) throws Exception {
        return pritemBo.createPritem(p_poitem);
    }

    @Override
    public void editPritem(Pritem p_poitem) throws Exception {
        pritemBo.editPritem(p_poitem);
    }

    @Override
    public void deletePritem(Pritem p_poitem) throws Exception {
        pritemBo.removePritem(p_poitem);
    }

    @Override
    public List<Bank> getListBank() throws Exception {
        return bankBo.getListBank();
    }
}
