/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Tax;

/**
 *
 * @author Golf
 */
@Local
public interface InfTaxDao {

    void create(Tax tax);

    void edit(Tax tax);

    void remove(Tax tax);

    Tax find(Object id);

    List<Tax> findAll();

    List<Tax> findRange(int[] range);

    int count();

}
