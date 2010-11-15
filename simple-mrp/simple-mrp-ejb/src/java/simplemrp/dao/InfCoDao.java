/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Co;

/**
 *
 * @author Golf
 */
@Local
public interface InfCoDao {

    void create(Co co);

    void edit(Co co);

    void remove(Co co);

    Co find(Object id);

    List<Co> findAll();

    List<Co> findRange(int[] range);

    int count();

}
