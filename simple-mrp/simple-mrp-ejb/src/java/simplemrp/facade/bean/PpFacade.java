/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.facade.bean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityExistsException;
import simplemrp.bo.InfForecastBo;
import simplemrp.bo.InfJobBo;
import simplemrp.entity.Forecast;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless(mappedName = BindingName.PpFacadeRemote)
public class PpFacade implements PpFacadeRemote {

    ///////////////////////////////////////////////////////////
    //////////////////// JOB ORDER ////////////////////////////
    @EJB
    private InfJobBo jobBo;
    @EJB
    private InfForecastBo forecastBo;

    @Override
    public Job getJob(String inputJobId) {
        return jobBo.getJob(inputJobId);
    }

    @Override
    public List<Job> searchJob(String searchJobKey) {
        return jobBo.searchJob(searchJobKey);
    }

    @Override
    public void removeJob(String jobid) {
        Job job = jobBo.getJob(jobid);
        if (job != null) {
            jobBo.removeJob(job);
        }
    }

    @Override
    public String createJob(Job p_job) {
        return jobBo.createJob(p_job);
    }

    @Override
    public void editJob(Job p_job) {
        jobBo.editJob(p_job);
    }

    @Override
    public List<Job> findByJobDate(Date p_jobDate) {
        return jobBo.findByJobDate(p_jobDate);
    }

    @Override
    public List<Job_stat> listJobStat() {
        return jobBo.listJobStat();
    }
    //////////////////// END JOB ORDER ////////////////////////////
    ////////////////////////////////////////////////////////////

    //////////////////FORECASE ///////////////////////
    @Override
    public List<Forecast> searchForecast(Date forecaseDate) {
        return forecastBo.findByForecastDate(forecaseDate);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String createForecase(Forecast forecase){
        String result = "";

        result = forecastBo.create(forecase);

        return result;
    }

    @Override
    public void removeForecase(String forecase_id) {
        forecastBo.remove(forecase_id);
    }

    @Override
    public List<Forecast> listForecast() {
        return forecastBo.findAll();
    }

    @Override
    public Forecast getForecast(String forecast_id) {
        return forecastBo.find(forecast_id);
    }
}
