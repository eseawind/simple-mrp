/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Mps_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfMps_statDao {

    void create(Mps_stat mps_stat);

    void edit(Mps_stat mps_stat);

    void remove(Mps_stat mps_stat);

    Mps_stat find(Object id);

    List<Mps_stat> findAll();

    List<Mps_stat> findRange(int[] range);

    int count();

}
