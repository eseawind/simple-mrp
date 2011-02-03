/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import simplemrp.entity.Forecast;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;

/**
 *
 * @author Golf
 */
@Remote
public interface PpFacadeRemote {
    ////////////////// JOB ORDER ////////////////////
    public List<Job_stat> listJobStat();
    public Job getJob(String inputJobId);
    public List<Job> searchJob(String searchJobKey);
    public void removeJob(String jobid);
    public String createJob(Job p_job);
    public void editJob(Job p_job);
    public List<Job> findByJobDate(Date p_jobDate);

    ///////////////// FORECASE DEMAND ///////////////
    public Forecast getForecast(String forecast_id);
    public List<Forecast> listForecast();
    public List<Forecast> searchForecast(Date forecaseDate);
    public String createForecase(Forecast forecase);
    public void removeForecase(String forecase_id);
    
}
