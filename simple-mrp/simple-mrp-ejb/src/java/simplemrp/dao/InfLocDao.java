/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfLocDao {

    void create(Loc loc);

    void edit(Loc loc);

    void remove(Loc loc);

    Loc find(Object id);

    List<Loc> findAll();

    List<Loc> findRange(int[] range);

    int count();
     public List<Loc> findByName(String p_strKeyword);

   
}
