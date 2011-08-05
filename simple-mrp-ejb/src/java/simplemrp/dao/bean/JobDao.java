/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.dao.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import simplemrp.dao.InfJobDao;
import simplemrp.entity.Job;
import simplemrp.util.ParamBinder;

/**
 *
 * @author Golf
 */
@Stateless
public class JobDao extends AbstractDao<Job> implements InfJobDao {

    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobDao() {
        super(Job.class);
    }

    @Override
    public List<Job> searchByJobId(String job_id_key, Date p_dtJobDate) {
        List<Job> lsJob = null;

        ParamBinder pb = new ParamBinder();

        StringBuilder condition = new StringBuilder();

        if((job_id_key != null) && (job_id_key.length() > 0)) {
            condition.append("j.jobId LIKE :jobIdKey ");
            pb.put("jobIdKey", "%" + job_id_key + "%");
        }

        if(p_dtJobDate != null) {
            if(condition.length() > 0) {
                condition.append("AND ");
            }
            condition.append("j.jobdate = :jobDate ");
            pb.put("jobDate", p_dtJobDate);
        }

        if(condition.length() > 0) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct j FROM Job AS j WHERE ").append(condition);

            Query q = em.createQuery(sql.toString());
            q = pb.bind(q);
            
            lsJob = q.getResultList();
        } else {
            lsJob = new ArrayList<Job>();
        }
        return lsJob;
    }

    @Override
    public List<Job> findByJobDate(Date jobDate) {
        String sql = "SELECT o FROM Job as o WHERE o.jobdate=:jobDate";
        Query q = em.createQuery(sql);
        q.setParameter("jobDate", jobDate);
        return q.getResultList();
    }

    @Override
    public String getNextJob() {
        String strPrefix = "J";

        String sql = "SELECT MAX(j.jobId) from Job as j";
        Query q = em.createQuery(sql);
        String strLastJob = (String) q.getSingleResult();
        if(strLastJob == null) {
            strLastJob = strPrefix + "000000";
        }

        strLastJob = strLastJob.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastJob).intValue() + 1;

        String strNextJob = "000000" + intNext;
        strNextJob = strPrefix + strNextJob.substring(strNextJob.length() - 6, strNextJob.length());

        return strNextJob;
    }
}
