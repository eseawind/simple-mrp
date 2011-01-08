/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfItem_sourceBo;
import simplemrp.dao.InfItem_sourceDao;
import simplemrp.entity.Item_source;

/**
 *
 * @author Golf
 */
@Stateless
public class Item_sourceBo implements InfItem_sourceBo {
    
    @EJB
    private InfItem_sourceDao item_sourceDao;

    @Override
    public List<Item_source> getListItem_source() throws Exception {
        return item_sourceDao.findAll();
    }
 
}
