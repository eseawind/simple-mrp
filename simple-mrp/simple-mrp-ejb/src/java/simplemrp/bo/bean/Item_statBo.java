/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfItem_statBo;
import simplemrp.dao.InfItem_statDao;
import simplemrp.entity.Item_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Item_statBo implements InfItem_statBo {

    @EJB
    private InfItem_statDao item_statDao;

    @Override
    public List<Item_stat> getListItem_stat() throws Exception {
        return item_statDao.findAll();
    }
}
