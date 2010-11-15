/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Item_source;

/**
 *
 * @author Golf
 */
@Local
public interface InfItem_sourceDao {

    void create(Item_source item_source);

    void edit(Item_source item_source);

    void remove(Item_source item_source);

    Item_source find(Object id);

    List<Item_source> findAll();

    List<Item_source> findRange(int[] range);

    int count();

}
