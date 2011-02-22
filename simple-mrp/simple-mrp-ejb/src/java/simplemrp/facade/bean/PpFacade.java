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
import org.sit.common.utils.OperationResult;
import simplemrp.bo.InfForecastBo;
import simplemrp.bo.InfItemmatlBo;
import simplemrp.bo.InfItemoprBo;
import simplemrp.bo.InfJobBo;
import simplemrp.bo.InfJobmatlBo;
import simplemrp.bo.InfJoboprBo;
import simplemrp.bo.InfMpsBo;
import simplemrp.bo.InfWorkcenterBo;
import simplemrp.dao.InfMpsDao;
import simplemrp.dao.InfMps_statDao;
import simplemrp.dao.InfMps_typeDao;
import simplemrp.entity.Forecast;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.Jobopr;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;
import simplemrp.entity.Workcenter;
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
    @EJB
    private InfItemmatlBo itemmatlBo;
    @EJB
    private InfWorkcenterBo workcenterBo;
    @EJB
    private InfJobmatlBo jobMatlBo;
    @EJB
    private InfJoboprBo joboprBo;

    @Override
    public Job getJob(String inputJobId) {
        return jobBo.getJob(inputJobId);
    }

    @Override
    public List<Job> searchJob(String searchJobKey, Date p_dtJobDate) {
        return jobBo.searchJob(searchJobKey, p_dtJobDate);
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
    public void editJob(Job p_job) throws Exception {
        jobBo.editJob(p_job);
    }

    @Override
    public void releaseJob(String p_strJob_id) throws Exception {
        jobBo.releaseJob(p_strJob_id);
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
        return mpsBo.findByCreateDate(dueDate);
    }

    @Override
    public String createMps(Mps mps) {
        return mpsBo.create(mps);
    }

    @Override
    public void removeMps(String mpsId) throws Exception {
        try {
            mpsBo.remove(mpsId);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void editMps(Mps mps) throws Exception {
        try {
            mpsBo.save(mps);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
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

    @Override
    public List<Itemopr> getBomDeatil(String p_strItem) throws Exception {
        return itemoprBo.getBomDeatil(p_strItem);
    }

    @Override
    public List<Workcenter> getListWorkcenter() throws Exception {
        return workcenterBo.getListWorkcenter();
    }

    @Override
    public List<Workcenter> searchWorkcenter(String p_strWorkcenter) {
        return workcenterBo.searchWorkcenter(p_strWorkcenter);
    }

    @Override
    public Workcenter getWorkcenter(String p_strWorkcenter) throws Exception {
        return workcenterBo.getWorkcenter(p_strWorkcenter);
    }

    @Override
    public String createWorkcenter(Workcenter p_workcenter) throws Exception {
        return workcenterBo.createWorkcenter(p_workcenter);
    }

    @Override
    public void editWorkcenter(Workcenter p_workcenter) throws Exception {
        workcenterBo.editWorkcenter(p_workcenter);
    }

    @Override
    public void deleteWorkcenter(Workcenter p_workcenter) throws Exception {
        workcenterBo.removeWorkcenter(p_workcenter);
    }

    @Override
    public List<Itemmatl> getItemmatlByItemopr(String p_strItem, Integer p_intOpr) throws Exception {
        return itemmatlBo.getItemmatlByItemopr(p_strItem, p_intOpr);
    }

    @Override
    public Itemmatl getItemmatl(ItemmatlPK p_pkItemmatl) throws Exception {
        return itemmatlBo.getItemmatl(p_pkItemmatl);
    }

    @Override
    public Integer createItemmatl(Itemmatl p_itemmatl) throws Exception {
        return itemmatlBo.createItemmatl(p_itemmatl);
    }

    @Override
    public void editItemmatl(Itemmatl p_itemmatl) throws Exception {
        itemmatlBo.editItemmatl(p_itemmatl);
    }

    @Override
    public void deleteItemmatl(Itemmatl p_itemmatl) throws Exception {
        itemmatlBo.removeItemmatl(p_itemmatl);
    }

    @Override
    public List<Jobmatl> getJobMatlByJobId(String jobId) {
        return jobMatlBo.getJobmatlByJobId(jobId);
    }

    @Override
    public OperationResult generateMPS(String p_strUsr_id) throws Exception {
        return mpsBo.generateMPS(p_strUsr_id);
    }

    @Overide
    public List<Jobopr> getJoboprByJob(String p_strJobId) throws Exception {
        return joboprBo.getJoboprByJob(p_strJobId);
    }
}
