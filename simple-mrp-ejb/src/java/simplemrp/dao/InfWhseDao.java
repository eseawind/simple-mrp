/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Whse;

/**
 *
 * @author Golf
 */
@Local
public interface InfWhseDao {

    void create(Whse whse);

    void edit(Whse whse);

    void remove(Whse whse);

    Whse find(Object id);

    List<Whse> findAll();

    List<Whse> findRange(int[] range);

    int count();
       public List<Whse> findByName(String p_strKeyword);

    public String getNextWhse();

}
