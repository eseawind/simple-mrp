/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import simplemrp.dao.InfJobDao;
import simplemrp.entity.Job;

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
    public List<Job> searchByJobId(String input){
        String sql = "SELECT o FROM Job as o WHERE o.jobId LIKE :jobIdKey";
        Query q = em.createQuery(sql);
        q.setParameter("jobIdKey", "%"+input+"%");
        return q.getResultList();
    }
    @Override
    public List<Job> findByJobDate(Date jobDate){
        String sql = "SELECT o FROM Job as o WHERE o.jobDate=:jobDate";
        Query q= em.createQuery(sql);
        q.setParameter("jobDate", jobDate);
        return q.getResultList();
    }
    
    @Override
    public String getNextJob(){
        String strPrefix = "J";

        String sql = "SELECT MAX(j.jobId) from Job as j";
        Query q = em.createQuery(sql);
        String strLastJob = (String)q.getSingleResult();
        if(strLastJob==null){
            return strPrefix+"000000";
        }
        strLastJob = strLastJob.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastJob).intValue() + 1;

        String strNextJob = "000000" + intNext;
        strNextJob = strPrefix + strNextJob.substring(strNextJob.length() - 6, strNextJob.length());

        return strNextJob;
    }

}
