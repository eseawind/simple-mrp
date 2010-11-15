/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Job;

/**
 *
 * @author Golf
 */
@Local
public interface InfJobDao {

    void create(Job job);

    void edit(Job job);

    void remove(Job job);

    Job find(Object id);

    List<Job> findAll();

    List<Job> findRange(int[] range);

    int count();

}
