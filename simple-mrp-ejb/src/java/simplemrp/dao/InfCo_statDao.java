/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Co_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfCo_statDao {

    void create(Co_stat co_stat);

    void edit(Co_stat co_stat);

    void remove(Co_stat co_stat);

    Co_stat find(Object id);

    List<Co_stat> findAll();

    List<Co_stat> findRange(int[] range);

    int count();

}
