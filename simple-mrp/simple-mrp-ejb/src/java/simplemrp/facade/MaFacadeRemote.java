/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Country;
import simplemrp.entity.District;
import simplemrp.entity.Item;
import simplemrp.entity.Item_source;
import simplemrp.entity.Item_stat;
import simplemrp.entity.Product;
import simplemrp.entity.Province;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.entity.Term;
import simplemrp.entity.Uom;
import simplemrp.entity.Whse;
import simplemrp.entity.Workcenter;

/**
 *
 * @author Golf
 */
@Remote
public interface MaFacadeRemote {
    public List<Country> getListCountry() throws Exception;

    public List<Province> getListProvince(Integer p_intCountry_id) throws Exception;

    public List<District> getListDistrict(Integer p_intProvince_id) throws Exception;

    public List<Subdist> getListSubdist(Integer p_intSubdist_id) throws Exception;

    public Subdist getSubdist(Integer p_intSubdist_id) throws Exception;

    public List<Tax> getListTax() throws Exception;

    public List<Item> searchItem(String p_strItem, String p_strDesc) throws Exception;

    public List<Product> getListProduct() throws Exception;

    public List<Item_source> getListItem_source() throws Exception;

    public List<Item_stat> getListItem_stat() throws Exception;

    public List<Uom> getListUom() throws Exception;

    public Item getItem(String p_strItem) throws Exception;

    public void deleteItem(Item p_item) throws Exception;

    public void editItem(Item p_item) throws Exception;

    public String createItem(Item p_item) throws Exception;

    public List<Term> getListTerm() throws Exception;
     //Uom manage
    public List<Uom> searchUom(String p_strKeyword) throws Exception;
    public Uom getUom(String p_strUom) throws Exception;
    public String createUom(Uom p_uom) throws Exception;
    public void editUom(Uom p_uom) throws Exception;
    public void deleteUom(Uom p_uom) throws Exception;
     //Product manage
    public List<Product> searchProduct(String p_strKeyword) throws Exception;
    public Product getProduct(String p_strProduct) throws Exception;
    public String createProduct(Product p_product) throws Exception;
    public void editProduct(Product p_product) throws Exception;
    public void deleteProduct(Product p_product) throws Exception;

      //Whse manage
    public List<Whse> searchWhse(String p_strKeyword) throws Exception;
    public Whse getWhse(String p_strWhse) throws Exception;
    public String createWhse(Whse p_whse) throws Exception;
    public void editWhse(Whse p_whse) throws Exception;
    public void deleteWhse(Whse p_whse) throws Exception;
     public List<Whse> getListWhse() throws Exception;

      //Workcenter manage
    public List<Workcenter> searchWorkcenter(String p_strKeyword) throws Exception;
    public Workcenter getWorkcenter(String p_strWorkcenter) throws Exception;
    public String createWorkcenter(Workcenter p_workcenter) throws Exception;
    public void editWorkcenter(Workcenter p_workcenter) throws Exception;
    public void deleteWorkcenter(Workcenter p_workcenter) throws Exception;
     public List<Workcenter> getListWorkcenter() throws Exception;
}
