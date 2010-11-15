/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Po_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfPo_statDao {

    void create(Po_stat po_stat);

    void edit(Po_stat po_stat);

    void remove(Po_stat po_stat);

    Po_stat find(Object id);

    List<Po_stat> findAll();

    List<Po_stat> findRange(int[] range);

    int count();

}
