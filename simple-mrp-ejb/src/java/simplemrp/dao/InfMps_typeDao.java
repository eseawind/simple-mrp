/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Mps_type;

/**
 *
 * @author Golf
 */
@Local
public interface InfMps_typeDao {

    void create(Mps_type mps_type);

    void edit(Mps_type mps_type);

    void remove(Mps_type mps_type);

    Mps_type find(Object id);

    List<Mps_type> findAll();

    List<Mps_type> findRange(int[] range);

    int count();

}
