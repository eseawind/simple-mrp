/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Slsman;

/**
 *
 * @author Golf
 */
@Local
public interface InfSlsmanDao {

    void create(Slsman slsman);

    void edit(Slsman slsman);

    void remove(Slsman slsman);

    Slsman find(Object id);

    List<Slsman> findAll();

    List<Slsman> findRange(int[] range);

    int count();

    public List<Slsman> findByName(String p_strKeyword);

}
