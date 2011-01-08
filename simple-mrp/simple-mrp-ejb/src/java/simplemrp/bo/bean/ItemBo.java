/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfItemBo;
import simplemrp.dao.InfItemDao;
import simplemrp.entity.Item;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemBo implements InfItemBo {
    @EJB
    private InfItemDao itemDao;

    @Override
    public List<Item> searchItem(String p_strItem, String p_strDesc) throws Exception {
        return itemDao.findByItemDesc(p_strItem, p_strDesc);
    }

    @Override
    public Item getItem(String p_strItem) throws Exception {
        return itemDao.find(p_strItem);
    }
}
