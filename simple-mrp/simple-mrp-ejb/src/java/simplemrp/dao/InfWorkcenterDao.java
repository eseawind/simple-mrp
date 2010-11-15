/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Workcenter;

/**
 *
 * @author Golf
 */
@Local
public interface InfWorkcenterDao {

    void create(Workcenter workcenter);

    void edit(Workcenter workcenter);

    void remove(Workcenter workcenter);

    Workcenter find(Object id);

    List<Workcenter> findAll();

    List<Workcenter> findRange(int[] range);

    int count();

}
