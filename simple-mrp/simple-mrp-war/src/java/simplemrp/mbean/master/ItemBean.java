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

    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;

    /** Creates a new instance of ItemBean */
    public ItemBean() throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
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
        if ((p_strSearchItem.length() > 0) || (p_strSearchDesc.length() > 0)) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            List<Item> ls = maFacade.searchItem(p_strSearchItem, p_strSearchDesc);

            setLsItem(ls);
        }
    }

    public void doSelect(ActionEvent e) throws Exception {
        String strItem = FacesUtils.getRequestParameter("p_item");
        checkItem(strItem);
    }

    public void doCheckItem(ActionEvent e) throws Exception {
        checkItem(getItem().trim().toUpperCase());
    }

    private void checkItem(String p_strItem) throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Item item = maFacade.getItem(p_strItem);

        setMode(MODE_EDIT);

        setItem(item.getItem());
        setDescription(item.getDescription());
        setProduct(item.getProduct().getProduct());
        setSource(item.getItemsource().getSource());
        setStat(item.getItemstat().getStat());
        setWarranty(item.getWarranty());
        setUom(item.getUom().getUom());
        setLeadtime(item.getLeadtime());
        setSafetystock(item.getSafetystock());
        setCdate(item.getCdate());
        setCuser(item.getCuser());
        setUdate(item.getUdate());
        setUuser(item.getUuser());

        setDisbNew(false);
        setDisbSave(false);
        setDisbDel(false);

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

    public boolean isDisbDel() {
        return disbDel;
    }

    public void setDisbDel(boolean disbDel) {
        this.disbDel = disbDel;
    }

    public boolean isDisbNew() {
        return disbNew;
    }

    public void setDisbNew(boolean disbNew) {
        this.disbNew = disbNew;
    }

    public boolean isDisbSave() {
        return disbSave;
    }

    public void setDisbSave(boolean disbSave) {
        this.disbSave = disbSave;
    }

    public void doNew(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);

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

        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);

        setLsProduct(null);
        setLsSource(null);
        setLsStat(null);
        setLsUom(null);
    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Item item = new Item();
            item.setItem(getItem().trim().toUpperCase());
            item.setDescription(getDescription().trim());
            item.setWarranty(getWarranty());
            item.setLeadtime(getLeadtime());
            item.setSafetystock(getSafetystock());

            Product product = new Product();
            product.setProduct(getProduct());
            item.setProduct(product);

            Item_source item_source = new Item_source();
            item_source.setSource(getSource());
            item.setItemsource(item_source);

            Item_stat item_stat = new Item_stat();
            item_stat.setStat(getStat());
            item.setItemstat(item_stat);

            Uom uom = new Uom();
            uom.setUom(getUom());
            item.setUom(uom);

            //Dummy code for set create user
            item.setUuser("developer");

            MaFacadeRemote maFacade = EJBLookup.getMaFacade();

            if (getMode().equals(MODE_EDIT)) {
                maFacade.editItem(item);
                if (getSearchItem().trim().length() > 0 || getSearchDesc().trim().length() > 0) {
                    searchItem(getSearchItem(), getSearchDesc());
                }
                checkItem(item.getItem());
                message("Save Complete");

            } else if (getMode().equals(MODE_NEW)) {
//                item.setCuser(getCuser());
                //Dummy code for set create user
                item.setCuser("developer");

                String strItem = maFacade.createItem(item);
                checkItem(strItem);
                if (getSearchItem().trim().length() > 0 || getSearchDesc().trim().length() > 0) {
                    searchItem(getSearchItem(), getSearchDesc());
                }
                message("Create Complete");

            } else {
                message("Unknown Operation Mode");
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            message(ex.getMessage());
        }
    }

    public void doDelete(ActionEvent e) throws Exception {
        try {
            Item item = new Item();
            item.setItem(getItem());
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            maFacade.deleteItem(item);

            clearEditScreen();
            if (getSearchItem().trim().length() > 0 || getSearchDesc().trim().length() > 0) {
                searchItem(getSearchItem(), getSearchDesc());
            }

            message("Delete Complete");
        } catch (Exception ex) {
            message(ex.getMessage());
        }
    }
}
