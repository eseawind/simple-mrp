/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.bo.InfItemmatlBo;
import simplemrp.bo.InfItemoprBo;
import simplemrp.bo.InfJobBo;
import simplemrp.bo.InfJobmatlBo;
import simplemrp.bo.InfJoboprBo;
import simplemrp.constant.PpConstant;
import simplemrp.dao.InfJobDao;
import simplemrp.dao.InfJob_statDao;
import simplemrp.dao.InfUsrDao;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.Itemopr;
import simplemrp.entity.Job;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.JobmatlPK;
import simplemrp.entity.Jobopr;
import simplemrp.entity.JoboprPK;
import simplemrp.entity.Usr;

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
    @EJB
    private InfUsrDao usrDao;
    @EJB
    private InfItemoprBo itemoprBo;
    @EJB
    private InfItemmatlBo itemmatlBo;

    @EJB
    private InfJoboprBo joboprBo;
    @EJB
    private InfJobmatlBo jobmatlBo;

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
    public List<Job> searchJob(String searchJobKey, Date p_dtJobDate) {
        return jobDao.searchByJobId(searchJobKey, p_dtJobDate);
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
    public List<Job> findByJobDate(Date p_jobDate) {
        return jobDao.findByJobDate(p_jobDate);
    }

    @Override
    public List<Job_stat> listJobStat() {
        return jobStatDao.findAll();
    }

    @Override
    public void editJob(Job p_job) throws Exception {
        try {
            Job job = jobDao.find(p_job.getJobId());
            job.setItem(p_job.getItem());
            job.setJobdate(p_job.getJobdate());
            job.setNote(p_job.getNote());
            job.setQty(p_job.getQty());

            job.setUuser(p_job.getUuser());
            job.setUdate(DateUtil.getDate());

            boolean isReleaseJob = false;

            if(job.getJobstat().getStat().equals(PpConstant.JOB_STAT_FIRM)) {
                if(p_job.getJobstat().getStat().equals(PpConstant.JOB_STAT_RELEASE)) {
                    Usr usr = usrDao.find(p_job.getUuser());

                    if(usr.getRls_job().equals('Y')) {
                        job.setJobstat(p_job.getJobstat());
                        job.setReleaser(p_job.getUuser());

                        isReleaseJob = true;
                    } else {
                        throw new Exception("Could not release job");
                    }
                }
            } else if(job.getJobstat().getStat().equals(PpConstant.JOB_STAT_RELEASE)) {
                if(p_job.getJobstat().getStat().equals(PpConstant.JOB_STAT_FIRM)) {
                    throw new Exception("Could not change job status");
                }
            } else {
                job.setJobstat(p_job.getJobstat());
            }
            
            jobDao.edit(job);

            if(isReleaseJob) {
                releaseJob(job.getJobId());
            }
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public void releaseJob(String p_strJob_id) throws Exception {
        try {
            Job job = jobDao.find(p_strJob_id);

            List<Itemopr> lsItemopr = itemoprBo.getItemoprByItem(job.getItem().getItem());

            if((lsItemopr != null) && (lsItemopr.size() > 0)) {
                for(int idxItemopr=0; idxItemopr<lsItemopr.size(); idxItemopr++) {
                    Itemopr itemopr = lsItemopr.get(idxItemopr);

                    Jobopr jobopr = new Jobopr();
                    JoboprPK joboprPK = new JoboprPK(job.getJobId(), itemopr.getItemoprPK().getOpr());

                    jobopr.setJoboprPK(joboprPK);
                    jobopr.setItem(itemopr.getItem1());
                    jobopr.setJob(job);
                    jobopr.setWorkcenter(itemopr.getWorkcenter());

                    jobopr.setUuser(job.getUuser());
                    jobopr.setUdate(DateUtil.getDate());

                    jobopr.setCuser(job.getUuser());
                    jobopr.setCdate(DateUtil.getDate());

                    Integer intNewOpr = joboprBo.createJobopr(jobopr);

                    if(intNewOpr == null) {
                        throw new Exception("Could not create job operation");
                    } else {
                        List<Itemmatl> lsItemmatl = itemmatlBo.getItemmatlByItemopr(itemopr.getItemoprPK().getItem(), itemopr.getItemoprPK().getOpr());

                        for(int idxItemmatl=0; idxItemmatl<lsItemmatl.size(); idxItemmatl++) {
                            Itemmatl itemmatl = lsItemmatl.get(idxItemmatl);

                            Jobmatl jobmatl = new Jobmatl();
                            JobmatlPK jobmatlPK = new JobmatlPK(jobopr.getJoboprPK().getJobId(), itemmatl.getItemmatlPK().getOpr(), itemmatl.getItemmatlPK().getSeq());
                            jobmatl.setJobmatlPK(jobmatlPK);

                            jobmatl.setItem(itemmatl.getMatl());

                            jobmatl.setQtyReq(new Double(job.getQty().doubleValue() * itemmatl.getQty().doubleValue()));

                            jobmatl.setUuser(job.getUuser());
                            jobmatl.setUdate(DateUtil.getDate());

                            jobmatl.setCuser(job.getUuser());
                            jobmatl.setCdate(DateUtil.getDate());

                            Integer intNewSeq = jobmatlBo.createJobmatl(jobmatl);

                            if(intNewSeq == null) {
                                throw new Exception("Could not create job material");
                            }
                        }
                    }
                }
            } else {
                throw new Exception("BOM is not define");
            }
        } catch(Exception ex) {
            throw new Exception(ex.getCause().getMessage(), ex);
        }
    }
}
