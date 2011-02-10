/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.bo.InfJobmatlBo;
import simplemrp.dao.InfJobmatlDao;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.JobmatlPK;

/**
 *
 * @author Golf
 */
@Stateless
public class JobmatlBo implements InfJobmatlBo {
    @EJB
    private InfJobmatlDao jobmatlDao;

    @Override
    public List<Jobmatl> getJobmatlByJobopr(String p_strJob, Integer p_intOpr) throws Exception {
        List<Jobmatl> lsJobmatl = jobmatlDao.findByJobopr(p_strJob, p_intOpr);

        for(int i = 0; i < lsJobmatl.size(); i++) {
            Jobmatl jobmatl = lsJobmatl.get(i);
            jobmatl.getItem().toString();
        }

        return lsJobmatl;
    }

    @Override
    public Jobmatl getJobmatl(JobmatlPK p_pkJobmatl) throws Exception {
        Jobmatl jobmatl = jobmatlDao.find(p_pkJobmatl);
        jobmatl.getItem().toString();

        return jobmatl;
    }

    @Override
    public Integer createJobmatl(Jobmatl p_jobmatl) throws Exception {
        if((p_jobmatl.getQtyReq() == null) || (p_jobmatl.getQtyReq().intValue() == 0)) {
            throw new Exception("Invalid quantity");
        }
        Integer intNextSeq = jobmatlDao.getNextSeq(p_jobmatl.getJobmatlPK().getJobId(), p_jobmatl.getJobmatlPK().getOpr());
        p_jobmatl.getJobmatlPK().setSeq(intNextSeq);

        p_jobmatl.setUdate(DateUtil.getDate());

        p_jobmatl.setCdate(p_jobmatl.getUdate());
        p_jobmatl.setCuser(p_jobmatl.getUuser());

        jobmatlDao.create(p_jobmatl);

        return intNextSeq;
    }

    @Override
    public void editJobmatl(Jobmatl p_jobmatl) throws Exception {
        if((p_jobmatl.getQtyReq() == null) || (p_jobmatl.getQtyReq().intValue() == 0)) {
            throw new Exception("Invalid quantity");
        }

        JobmatlPK jobmatlPK = p_jobmatl.getJobmatlPK();

        Jobmatl jobmatl = jobmatlDao.find(jobmatlPK);
        jobmatl.setItem(p_jobmatl.getItem());
        jobmatl.setQtyReq(p_jobmatl.getQtyReq());

        jobmatl.setUdate(DateUtil.getDate());
        jobmatl.setUuser(jobmatl.getUuser());

        jobmatlDao.edit(jobmatl);
    }

    @Override
    public void removeJobmatl(Jobmatl p_jobmatl) throws Exception {
        jobmatlDao.remove(p_jobmatl);
    }
 }
