/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Pr;

/**
 *
 * @author Golf
 */
@Local
public interface InfPrDao {

    void create(Pr pr);

    void edit(Pr pr);

    void remove(Pr pr);

    Pr find(Object id);

    List<Pr> findAll();

    List<Pr> findRange(int[] range);

    int count();

}
