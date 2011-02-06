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
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;

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

    ///////////////// MPS ///////////////////////////
    public Mps getMps(String mpsId);
    public List<Mps> listMps();
    public List<Mps> searchMps(Date dueDate);
    public String createMps(Mps mps);
    public void editMps(Mps mps);
    public void removeMps(String mpsId);
    public List<Mps_stat> listMpsStat();
    public List<Mps_type> listMpsType();

    public List<Itemopr> getItemoprByItem(String p_strItem) throws Exception;
    public Itemopr getItemopr(ItemoprPK p_pkItemopr) throws Exception;
    public Integer createItemopr(Itemopr p_itemopr) throws Exception;
    public void editItemopr(Itemopr p_itemopr) throws Exception;
    public void deleteItemopr(Itemopr p_itemopr) throws Exception;
    
}
