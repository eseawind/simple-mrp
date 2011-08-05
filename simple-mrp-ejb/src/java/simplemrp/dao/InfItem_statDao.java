/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Item_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfItem_statDao {

    void create(Item_stat item_stat);

    void edit(Item_stat item_stat);

    void remove(Item_stat item_stat);

    Item_stat find(Object id);

    List<Item_stat> findAll();

    List<Item_stat> findRange(int[] range);

    int count();

}
