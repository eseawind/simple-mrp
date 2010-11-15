/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Itemopr;

/**
 *
 * @author Golf
 */
@Local
public interface InfItemoprDao {

    void create(Itemopr itemopr);

    void edit(Itemopr itemopr);

    void remove(Itemopr itemopr);

    Itemopr find(Object id);

    List<Itemopr> findAll();

    List<Itemopr> findRange(int[] range);

    int count();

}
