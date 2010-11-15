/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Job_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfJob_statDao {

    void create(Job_stat job_stat);

    void edit(Job_stat job_stat);

    void remove(Job_stat job_stat);

    Job_stat find(Object id);

    List<Job_stat> findAll();

    List<Job_stat> findRange(int[] range);

    int count();

}
