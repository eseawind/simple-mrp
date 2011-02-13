/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.facade.bean;

import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfCountryBo;
import simplemrp.bo.InfDistrictBo;
import simplemrp.bo.InfItemBo;
import simplemrp.bo.InfItem_sourceBo;
import simplemrp.bo.InfItem_statBo;
import simplemrp.bo.InfProductBo;
import simplemrp.bo.InfProvinceBo;
import simplemrp.bo.InfSubdistBo;
import simplemrp.bo.InfTaxBo;
import simplemrp.bo.InfTermBo;
import simplemrp.bo.InfUomBo;
import simplemrp.bo.InfWhseBo;
import simplemrp.bo.InfLocBo;
import simplemrp.bo.InfWorkcenterBo;
import simplemrp.bo.InfUsrBo;
import simplemrp.entity.Country;
import simplemrp.entity.District;
import simplemrp.entity.Item;
import simplemrp.entity.Item_source;
import simplemrp.entity.Item_stat;
import simplemrp.entity.Loc;
import simplemrp.entity.Product;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.entity.Term;
import simplemrp.entity.Uom;
import simplemrp.entity.Usr;
import simplemrp.entity.Workcenter;
import simplemrp.entity.Whse;
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless(mappedName = BindingName.MaFacadeRemote)
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
    @EJB
    private InfItemBo itemBo;
    @EJB
    private InfProductBo productBo;
    @EJB
    private InfItem_sourceBo item_sourceBo;
    @EJB
    private InfItem_statBo item_statBo;
    @EJB
    private InfTermBo termBo;
    @EJB
    private InfWhseBo whseBo;
      @EJB
    private InfLocBo locBo;
    @EJB
    private InfUomBo uomBo;
     @EJB
    private InfUsrBo usrBo;

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

    @Override
    public List<Item> searchItem(String p_strItem, String p_strDesc) throws Exception {
        return itemBo.searchItem(p_strItem, p_strDesc);
    }

    @Override
    public List<Product> getListProduct() throws Exception {
        return productBo.getListProduct();
    }

    @Override
    public List<Item_source> getListItem_source() throws Exception {
        return item_sourceBo.getListItem_source();
    }

    @Override
    public List<Item_stat> getListItem_stat() throws Exception {
        return item_statBo.getListItem_stat();
    }

    @Override
    public List<Uom> getListUom() throws Exception {
        return uomBo.getListUom();
    }

    @Override
    public Item getItem(String p_strItem) throws Exception {
        return itemBo.getItem(p_strItem);
    }

    @Override
    public void deleteItem(Item p_item) throws Exception {
        itemBo.removeItem(p_item);
    }

    @Override
    public void editItem(Item p_item) throws Exception {
        itemBo.editItem(p_item);
    }

    @Override
    public String createItem(Item p_item) throws Exception {
        String strItem = itemBo.createItem(p_item);

        return strItem;
    }

    @Override
    public List<Term> getListTerm() throws Exception {
        return termBo.getListTerm();
    }

    @Override
    public List<Uom> searchUom(String p_strUom) {
        return uomBo.searchUom(p_strUom);
    }

    @Override
    public Uom getUom(String p_strUom) throws Exception {
        return uomBo.getUom(p_strUom);
    }

    @Override
    public String createUom(Uom p_uom) throws Exception {
        return uomBo.createUom(p_uom);
    }

    @Override
    public void editUom(Uom p_uom) throws Exception {
        uomBo.editUom(p_uom);
    }

    @Override
    public void deleteUom(Uom p_uom) throws Exception {
        uomBo.removeUom(p_uom);
    }

    @Override
    public List<Product> searchProduct(String p_strProduct) {
        return productBo.searchProduct(p_strProduct);
    }

    @Override
    public Product getProduct(String p_strProduct) throws Exception {
        return productBo.getProduct(p_strProduct);
    }

    @Override
    public String createProduct(Product p_product) throws Exception {
        return productBo.createProduct(p_product);
    }

    @Override
    public void editProduct(Product p_product) throws Exception {
        productBo.editProduct(p_product);
    }

    @Override
    public void deleteProduct(Product p_product) throws Exception {
        productBo.removeProduct(p_product);
    }

    @Override
    public List<Whse> getListWhse() throws Exception {
        return whseBo.getListWhse();
    }

    @Override
    public List<Whse> searchWhse(String p_strWhse) {
        return whseBo.searchWhse(p_strWhse);
    }

    @Override
    public Whse getWhse(String p_strWhse) throws Exception {
        Whse whse = whseBo.getWhse(p_strWhse);
        if (whse != null) {
            Collection<Loc> lsLoc = whse.getLocCollection();
            //Lazy load Location in Whse
            if (lsLoc != null) {
                lsLoc.toString();
            }
        }
        return whse;
    }

    @Override
    public String createWhse(Whse p_whse) throws Exception {
        return whseBo.createWhse(p_whse);
    }

    @Override
    public void editWhse(Whse p_whse) throws Exception {
        whseBo.editWhse(p_whse);
    }

    @Override
    public void deleteWhse(Whse p_whse) throws Exception {
        whseBo.removeWhse(p_whse);
    }

   @Override
    public List<Loc> searchLoc(String p_strLoc) {
        return locBo.searchLoc(p_strLoc);
    }

    @Override
    public Loc getLoc(LocPK p_locPK) throws Exception {
        return locBo.getLoc(p_locPK);


    }
 @Override
    public void createLoc(Loc p_loc) throws Exception {
        locBo.createLoc(p_loc);
    }

    @Override
    public void editLoc(Loc p_loc) throws Exception {
       locBo.editLoc(p_loc);
    }

    @Override
    public void deleteLoc(Loc p_loc) throws Exception {
        locBo.removeLoc(p_loc);
    }

    @Override
    public Usr getUsr(String usrId) throws Exception {
        return usrBo.findUsr(usrId);
    }

    @Override
    public void editUsr(Usr usr) throws Exception {
        usrBo.editUsr(usr);
    }

}
