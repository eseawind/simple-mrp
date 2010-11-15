/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Pr_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfPr_statDao {

    void create(Pr_stat pr_stat);

    void edit(Pr_stat pr_stat);

    void remove(Pr_stat pr_stat);

    Pr_stat find(Object id);

    List<Pr_stat> findAll();

    List<Pr_stat> findRange(int[] range);

    int count();

}
