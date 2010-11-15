/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Uom;

/**
 *
 * @author Golf
 */
@Local
public interface InfUomDao {

    void create(Uom uom);

    void edit(Uom uom);

    void remove(Uom uom);

    Uom find(Object id);

    List<Uom> findAll();

    List<Uom> findRange(int[] range);

    int count();

}
