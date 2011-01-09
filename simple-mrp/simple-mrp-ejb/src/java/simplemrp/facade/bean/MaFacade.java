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
import simplemrp.bo.InfItemBo;
import simplemrp.bo.InfItem_sourceBo;
import simplemrp.bo.InfItem_statBo;
import simplemrp.bo.InfProductBo;
import simplemrp.bo.InfProvinceBo;
import simplemrp.bo.InfSubdistBo;
import simplemrp.bo.InfTaxBo;
import simplemrp.bo.InfUomBo;
import simplemrp.entity.Country;
import simplemrp.entity.District;
import simplemrp.entity.Item;
import simplemrp.entity.Item_source;
import simplemrp.entity.Item_stat;
import simplemrp.entity.Product;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.entity.Uom;
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
    @EJB
    private InfItemBo itemBo;
    @EJB
    private InfProductBo productBo;
    @EJB
    private InfItem_sourceBo item_sourceBo;
    @EJB
    private InfItem_statBo item_statBo;
    @EJB
    private InfUomBo uomBo;


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

}
