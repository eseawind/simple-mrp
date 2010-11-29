/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Prefixname;

/**
 *
 * @author Golf
 */
@Local
public interface InfPrefixnameDao {

    void create(Prefixname prefixname);

    void edit(Prefixname prefixname);

    void remove(Prefixname prefixname);

    Prefixname find(Object id);

    List<Prefixname> findAll();

    List<Prefixname> findRange(int[] range);

    int count();

}
