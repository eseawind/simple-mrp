/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Usr;

/**
 *
 * @author Golf
 */
@Local
public interface InfUsrDao {

    void create(Usr usr);

    void edit(Usr usr);

    void remove(Usr usr);

    Usr find(Object id);

    List<Usr> findAll();

    List<Usr> findRange(int[] range);

    int count();

    List<Usr> findByUsr_name(String p_strUsr_name);

}
