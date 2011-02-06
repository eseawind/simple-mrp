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
import simplemrp.bo.InfItemoprBo;
import simplemrp.bo.InfJobBo;
import simplemrp.bo.InfMpsBo;
import simplemrp.dao.InfMpsDao;
import simplemrp.dao.InfMps_statDao;
import simplemrp.dao.InfMps_typeDao;
import simplemrp.entity.Forecast;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;
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
    @EJB
    private InfMpsBo mpsBo;
    @EJB
    private InfMps_statDao mpsStatDao;
    @EJB
    private InfMps_typeDao mpsTypeDao;
    @EJB
    private InfItemoprBo itemoprBo;

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
        if(job != null) {
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
    public String createForecase(Forecast forecase) {
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

    @Override
    public Mps getMps(String mpsId) {
        return mpsBo.find(mpsId);
    }

    @Override
    public List<Mps> listMps() {
        return mpsBo.findAll();
    }

    @Override
    public List<Mps> searchMps(Date dueDate) {
        return mpsBo.findByDueDate(dueDate);
    }

    @Override
    public String createMps(Mps mps) {
        return mpsBo.create(mps);
    }

    @Override
    public void removeMps(String mpsId) {
        mpsBo.remove(mpsId);
    }

    @Override
    public void editMps(Mps mps) {
        mpsBo.save(mps);

    }

    @Override
    public List<Mps_stat> listMpsStat() {
        return mpsStatDao.findAll();
    }

    @Override
    public List<Mps_type> listMpsType() {
        return mpsTypeDao.findAll();
    }

    @Override
    public List<Itemopr> getItemoprByItem(String p_strItem) throws Exception {
        return itemoprBo.getItemoprByItem(p_strItem);
    }

    @Override
    public Itemopr getItemopr(ItemoprPK p_pkItemopr) throws Exception {
        return itemoprBo.getItemopr(p_pkItemopr);
    }

    @Override
    public Integer createItemopr(Itemopr p_itemopr) throws Exception {
        return itemoprBo.createItemopr(p_itemopr);
    }

    @Override
    public void editItemopr(Itemopr p_itemopr) throws Exception {
        itemoprBo.editItemopr(p_itemopr);
    }

    @Override
    public void deleteItemopr(Itemopr p_itemopr) throws Exception {
        itemoprBo.removeItemopr(p_itemopr);
    }
}
