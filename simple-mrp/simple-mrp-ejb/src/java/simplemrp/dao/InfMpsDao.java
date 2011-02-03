/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Mps;

/**
 *
 * @author Golf
 */
@Local
public interface InfMpsDao {

    void create(Mps mps);

    void edit(Mps mps);

    void remove(Mps mps);

    Mps find(Object id);

    List<Mps> findAll();

    List<Mps> findRange(int[] range);

    int count();

    public List<Mps> findByDueDate(Date dueDate);

    public String getNextId();

}
