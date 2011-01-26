/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;

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
    public List<Job> searchByJobId(String job_id_key);
    public List<Job> findByJobDate(Date jobDate);
    public String getNextJob();

}
