/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Item;

/**
 *
 * @author Golf
 */
@Local
public interface InfItemBo {
    public List<Item> searchItem(String p_strItem, String p_strDesc) throws Exception;

    public Item getItem(String p_strItem) throws Exception;
}
