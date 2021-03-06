/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.bo.InfItemBo;
import simplemrp.dao.InfItemDao;
import simplemrp.dao.InfItemlocDao;
import simplemrp.entity.Item;
import simplemrp.entity.Itemloc;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemBo implements InfItemBo {

    @EJB
    private InfItemDao itemDao;
    @EJB
    private InfItemlocDao itemLocDao;

    @Override
    public List<Item> searchItem(String p_strItem, String p_strDesc) throws Exception {
        return itemDao.findByItemDesc(p_strItem, p_strDesc);
    }

    @Override
    public Item getItem(String p_strItem) throws Exception {
        Item item = itemDao.find(p_strItem);

        
        if(item != null) {
            if(item.getItemstat() != null) {
                item.getItemstat().toString();
            }

            if(item.getItemsource() != null) {
                item.getItemsource().toString();
            }

            if(item.getProduct() != null) {
                item.getProduct().toString();
            }

            if(item.getUom() != null) {
                item.getUom().toString();
            }
        }
        
        return item;
    }

    @Override
    public void editItem(Item p_item) throws Exception {
        try {
            Item item = itemDao.find(p_item.getItem());
            p_item.setCdate(item.getCdate());
            p_item.setCuser(item.getCuser());
            p_item.setUdate(DateUtil.getDate());

            itemDao.edit(p_item);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeItem(Item p_item) throws Exception {
        itemDao.remove(p_item);
    }

    @Override
    public String createItem(Item p_item) throws Exception {
        p_item.setItem(p_item.getItem().toUpperCase());

        Item itemCheck = itemDao.find(p_item.getItem());

        if(itemCheck == null) {
            p_item.setCdate(DateUtil.getDate());
            p_item.setUdate(DateUtil.getDate());

            itemDao.create(p_item);
        } else {
            throw new Exception("Duplicated Item " + p_item.getItem());
        }

        return p_item.getItem();
    }

    @Override
    public List<Itemloc> searchItemLocation(String warehouse, String location) {
         List<Itemloc> results = itemLocDao.findByParam(warehouse, location);
         //Lazy load Item 
         for(Itemloc itemloc:results){
             Item i = itemloc.getItem1();
             if(i!=null){
                 i.toString();
             }
         }
        return itemLocDao.findByParam(warehouse,location);
    }
}
