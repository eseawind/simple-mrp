/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.master;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import simplemrp.entity.Item;
import simplemrp.entity.Product;
import simplemrp.entity.Item_source;
import simplemrp.entity.Item_stat;
import simplemrp.entity.Uom;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public class ItemBean extends ItemAttr {
    private String MODE_NEW = "NEW";
    private String MODE_EDIT = "EDIT";

    /** Creates a new instance of ItemBean */
    public ItemBean() throws Exception {
    }

    public void doSearch(ActionEvent e) throws Exception {
        String strSearchItem = getSearchItem().trim();
        String strSearchDesc = getSearchDesc().trim();

        if ((strSearchItem.length() == 0) && (strSearchDesc.length() == 0)) {
            message("Please Enter Search Condition");
        } else {
            searchItem(strSearchItem, strSearchDesc);
        }
    }

    private void searchItem(String p_strSearchItem, String p_strSearchDesc) throws Exception {
        if (p_strSearchItem.length() > 0) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            List<Item> ls = maFacade.searchItem(p_strSearchItem, p_strSearchDesc);

            setLsItem(ls);
        }
    }

    public void doSelect(ActionEvent e) throws Exception {
        String strItem = FacesUtils.getRequestParameter("p_item");
        checkItem(strItem);
    }

    private void checkItem(String p_strItem) throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Item item = maFacade.getItem(p_strItem);

        setMode(MODE_EDIT);

        setItem(item.getItem());
        setDescription(item.getDescription());
        setProduct(item.getProduct().getProduct());
        setSource(item.getItemsource().getSource().toString());
        setStat(item.getItemstat().getStat().toString());
        setWarranty(item.getWarranty());
        setUom(item.getUom().getUom());
        setLeadtime(item.getLeadtime());
        setSafetystock(item.getSafetystock());
        setCdate(item.getCdate());
        setCuser(item.getCuser());
        setUdate(item.getUdate());
        setUuser(item.getUuser());

        loadProduct();
        loadSource();
        loadStat();
        loadUom();
    }

    private void loadProduct() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Product> lsAllProduct = maFacade.getListProduct();

        List lsProduct = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllProduct.size(); i++) {
            Product product = lsAllProduct.get(i);
            SelectItem selectItem = new SelectItem(product.getProduct(), product.getDescription());

            lsProduct.add(selectItem);
        }

        setLsProduct(lsProduct);
    }

    private void loadSource() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Item_source> lsAllItem_source = maFacade.getListItem_source();

        List lsSource = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllItem_source.size(); i++) {
            Item_source item_source = lsAllItem_source.get(i);
            SelectItem selectItem = new SelectItem(item_source.getSource(), item_source.getDescription());

            lsSource.add(selectItem);
        }

        setLsSource(lsSource);
    }

    private void loadStat() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Item_stat> lsAllItem_stat = maFacade.getListItem_stat();

        List lsStat = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllItem_stat.size(); i++) {
            Item_stat item_stat = lsAllItem_stat.get(i);
            SelectItem selectItem = new SelectItem(item_stat.getStat(), item_stat.getDescription());

            lsStat.add(selectItem);
        }

        setLsStat(lsStat);
    }

    private void loadUom() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Uom> lsAllUom = maFacade.getListUom();

        List lsUom = new ArrayList<SelectItem>();
        for (int i = 0; i < lsAllUom.size(); i++) {
            Uom uom = lsAllUom.get(i);
            SelectItem selectItem = new SelectItem(uom.getUom(), uom.getDescription());

            lsUom.add(selectItem);
        }

        setLsUom(lsUom);
    }

    public void doNew(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        loadProduct();
        loadSource();
        loadStat();
        loadUom();
    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() {
        setItem(null);
        setDescription(null);
        setProduct(null);
        setSource(null);
        setStat(null);
        setWarranty(null);
        setUom(null);
        setLeadtime(null);
        setSafetystock(null);
        setCdate(null);
        setCuser(null);
        setUdate(null);
        setUuser(null);

        setMode(MODE_EDIT);
        setLsProduct(null);
        setLsSource(null);
        setLsStat(null);
        setLsUom(null);
    }

    public void doSave(ActionEvent e) throws Exception {
//        try {
//            Customer customer = new Customer();
//            customer.setCustId(cust_id);
//            customer.setName(name);
//            customer.setAddr1(addr1);
//            customer.setAddr2(addr2);
//            customer.setRoad(road);
//            customer.setSoi(soi);
//            customer.setZipcode(zipcode);
//            customer.setPhone(phone);
//            customer.setFax(fax);
//            customer.setEmail(email);
//
//            Prefixname prefixname = new Prefixname(prefix_id);
//            customer.setPrefixname(prefixname);
//
//            if ((tax_id != null) && (tax_id.length() > 0)) {
//                Tax tax = new Tax(tax_id);
//                customer.setTax(tax);
//            }
//
//            Subdist subdist = new Subdist(subdist_id);
//            customer.setSubdist(subdist);
//
//            Province province = new Province(province_id);
//            customer.setProvince(province);
//
//            District district = new District(district_id);
//            customer.setDistrict(district);
//
//            Country country = new Country(country_id);
//            customer.setCountry(country);
//
//            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
//
//            if (getMode().equals(MODE_EDIT)) {
//                customer.setUuser(uuser);
//
//                coFacade.editCustomer(customer);
//                if (getKeyword().trim().length() > 0) {
//                    checkKeyword(getKeyword().trim());
//                }
//                checkCust_id(customer.getCustId());
//                message("Save Complete");
//
//            } else if (getMode().equals(MODE_NEW)) {
//                customer.setCuser(cuser);
//
//                String strNewCust_id = coFacade.createCustomer(customer);
//                checkCust_id(strNewCust_id);
//                if (getKeyword().trim().length() > 0) {
//                    checkKeyword(getKeyword().trim());
//                }
//                message("Create Complete");
//
//            } else {
//                message("Unknown Operation Mode");
//            }
//        } catch (Exception ex) {
//            message(ex.getMessage());
//        }
    }

    public void doDelete(ActionEvent e) throws Exception {
//        Customer customer = new Customer();
//        customer.setCustId(getCust_id());
//        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
//        coFacade.deleteCustomer(customer);
//
//        clearEditScreen();
//        if (getKeyword().trim().length() > 0) {
//            checkKeyword(getKeyword().trim());
//        }
//
//        message("Delete Complete");
    }
}
