/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Coitem;

/**
 *
 * @author Golf
 */
@Local
public interface InfCoitemDao {

    void create(Coitem coitem);

    void edit(Coitem coitem);

    void remove(Coitem coitem);

    Coitem find(Object id);

    List<Coitem> findAll();

    List<Coitem> findRange(int[] range);

    int count();

    public List<Coitem> findByCo(String p_strCoId);

    public Integer getNextCo_seq(String p_strCo_id);

}
