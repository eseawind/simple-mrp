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
import simplemrp.bo.InfJoboprBo;
import simplemrp.dao.InfJoboprDao;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.Jobopr;
import simplemrp.entity.JoboprPK;

/**
 *
 * @author Golf
 */
@Stateless
public class JoboprBo implements InfJoboprBo {
    @EJB
    private InfJoboprDao joboprDao;
    @EJB
    private InfJobmatlBo jobmatlBo;

    @Override
    public List<Jobopr> getJoboprByJob(String p_strJob) throws Exception {
        List<Jobopr> lsJobopr = joboprDao.findByJob(p_strJob);

        for(int i = 0; i < lsJobopr.size(); i++) {
            Jobopr jobopr = lsJobopr.get(i);
            jobopr.getItem().toString();
            jobopr.getWorkcenter().toString();
        }

        return lsJobopr;
    }

    @Override
    public Jobopr getJobopr(JoboprPK p_pkJobopr) throws Exception {
        Jobopr itemopr = joboprDao.find(p_pkJobopr);

        if(itemopr != null) {
            itemopr.getItem().toString();
            itemopr.getWorkcenter().toString();
        }

        return itemopr;
    }

    @Override
    public Integer createJobopr(Jobopr p_jobopr) throws Exception {
        Integer intNextOpr = joboprDao.getNextOpr(p_jobopr.getJoboprPK().getJobId());
        p_jobopr.getJoboprPK().setOpr(intNextOpr);

        p_jobopr.setUdate(DateUtil.getDate());

        p_jobopr.setCdate(p_jobopr.getUdate());
        p_jobopr.setCuser(p_jobopr.getUuser());

        joboprDao.create(p_jobopr);

        return intNextOpr;
    }

    @Override
    public void editJobopr(Jobopr p_jobopr) throws Exception {
        JoboprPK joboprPK = p_jobopr.getJoboprPK();

        Jobopr jobopr = joboprDao.find(joboprPK);
        jobopr.setWorkcenter(p_jobopr.getWorkcenter());

        jobopr.setUdate(DateUtil.getDate());
        jobopr.setUuser(p_jobopr.getUuser());

        joboprDao.edit(jobopr);
    }

    @Override
    public void removeJobopr(Jobopr p_jobopr) throws Exception {
        List<Jobmatl> lsJobmatl = jobmatlBo.getJobmatlByJobopr(p_jobopr.getJoboprPK().getJobId(), p_jobopr.getJoboprPK().getOpr());
        for(int i=0; i<lsJobmatl.size(); i++) {
            Jobmatl jobmatl = lsJobmatl.get(i);
            jobmatlBo.removeJobmatl(jobmatl);
        }
        joboprDao.remove(p_jobopr);
    }

    @Override
    public List<Jobopr> getBomDeatil(String p_strJobId) throws Exception {
        List<Jobopr> lsJobopr = joboprDao.findByJob(p_strJobId);

        for(int i = 0; i < lsJobopr.size(); i++) {
            Jobopr jobopr = lsJobopr.get(i);
            jobopr.getItem().toString();
            jobopr.getWorkcenter().toString();

            List<Jobmatl> lsJobmatl = jobopr.getJobmatlList();
            for(int j = 0; j < lsJobmatl.size(); j++) {
                Jobmatl jobmatl = lsJobmatl.get(j);
                jobmatl.getItem().toString();

                if(jobmatl.getItem().getUom() != null){
                    jobmatl.getItem().getUom().toString();
                }
            }
        }

        return lsJobopr;
    }

    @Override
    public List<Jobopr> getByJob(String p_strJobID) throws Exception {
        List<Jobopr> lsJobopr = null;

        try {
            lsJobopr = joboprDao.findByJob(p_strJobID);
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return lsJobopr;
    }
}
