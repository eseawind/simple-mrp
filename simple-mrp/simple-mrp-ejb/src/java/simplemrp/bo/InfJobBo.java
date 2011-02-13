/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfJobBo {
    public Job getJob(String inputJobId);

    public List<Job> searchJob(String searchJobKey, Date p_dtJobDate);

    public void removeJob(Job p_job);

    public String createJob(Job p_job);

    public void editJob(Job p_job) throws Exception;

    public List<Job> findByJobDate(Date p_jobDate);

    public List<Job_stat> listJobStat();

    public void releaseJob(String p_strJob_id) throws Exception;
}
