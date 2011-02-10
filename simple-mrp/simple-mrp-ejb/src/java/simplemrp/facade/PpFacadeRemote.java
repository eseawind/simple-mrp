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
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Mps;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;
import simplemrp.entity.Workcenter;

/**
 *
 * @author Golf
 */
@Remote
public interface PpFacadeRemote {
    ////////////////// JOB ORDER ////////////////////
    public List<Job_stat> listJobStat();
    public Job getJob(String inputJobId);
    public List<Job> searchJob(String searchJobKey, Date p_dtJobDate);
    public void removeJob(String jobid);
    public String createJob(Job p_job);
    public void editJob(Job p_job) throws Exception;
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

    //Itemopr manage
    public List<Itemopr> getItemoprByItem(String p_strItem) throws Exception;
    public Itemopr getItemopr(ItemoprPK p_pkItemopr) throws Exception;
    public Integer createItemopr(Itemopr p_itemopr) throws Exception;
    public void editItemopr(Itemopr p_itemopr) throws Exception;
    public void deleteItemopr(Itemopr p_itemopr) throws Exception;
    public List<Itemopr> getBomDeatil(String p_strItem) throws Exception;

    //Workcenter manage
    public List<Workcenter> searchWorkcenter(String p_strKeyword) throws Exception;
    public Workcenter getWorkcenter(String p_strWorkcenter) throws Exception;
    public String createWorkcenter(Workcenter p_workcenter) throws Exception;
    public void editWorkcenter(Workcenter p_workcenter) throws Exception;
    public void deleteWorkcenter(Workcenter p_workcenter) throws Exception;
    public List<Workcenter> getListWorkcenter() throws Exception;

    //Itemmatl Manage
    public List<Itemmatl> getItemmatlByItemopr(String p_strItem, Integer p_intOpr) throws Exception;
    public Itemmatl getItemmatl(ItemmatlPK p_pkItemmatl) throws Exception;
    public Integer createItemmatl(Itemmatl p_itemmatl) throws Exception;
    public void editItemmatl(Itemmatl p_itemmatl) throws Exception;
    public void deleteItemmatl(Itemmatl p_itemmatl) throws Exception;
}
