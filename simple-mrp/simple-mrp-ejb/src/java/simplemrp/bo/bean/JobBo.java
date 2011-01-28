/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfJobBo;
import simplemrp.dao.InfJobDao;
import simplemrp.dao.InfJob_statDao;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class JobBo implements InfJobBo {

    @EJB
    private InfJobDao jobDao;
    @EJB
    private InfJob_statDao jobStatDao;
    @Override
    public Job getJob(String inputJobId) {
        Job j = jobDao.find(inputJobId);
        if(j==null){
            return null;
        }
        if(j.getItem()!=null){
            j.getItem().toString();
        }
        if(j.getJobstat()!=null){
            j.getJobstat().toString();
        }
        return j;
    }

    @Override
    public List<Job> searchJob(String searchJobKey) {
        return jobDao.searchByJobId(searchJobKey);
    }

    @Override
    public void removeJob(Job p_job) {
        jobDao.remove(p_job);
    }

    @Override
    public String createJob(Job p_job) {
        String nextJobId = jobDao.getNextJob();
        p_job.setJobId(nextJobId);
        jobDao.create(p_job);
        return p_job.getJobId();
    }

    @Override
    public void editJob(Job p_job) {
        jobDao.edit(p_job);
    }

    @Override
    public List<Job> findByJobDate(Date p_jobDate) {
        return jobDao.findByJobDate(p_jobDate);
    }

    @Override
    public List<Job_stat> listJobStat() {
        return jobStatDao.findAll();
    }
}
