/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Itemprice;

/**
 *
 * @author Golf
 */
@Local
public interface InfItempriceDao {

    void create(Itemprice itemprice);

    void edit(Itemprice itemprice);

    void remove(Itemprice itemprice);

    Itemprice find(Object id);

    List<Itemprice> findAll();

    List<Itemprice> findRange(int[] range);

    int count();

}
