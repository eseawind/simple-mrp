/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import simplemrp.dao.InfJobmatlDao;
import simplemrp.entity.Jobmatl;

/**
 *
 * @author Golf
 */
@Stateless
public class JobmatlDao extends AbstractDao<Jobmatl> implements InfJobmatlDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public JobmatlDao() {
        super(Jobmatl.class);
    }

    @Override
    public List<Jobmatl> findByJobopr(String p_strJob, Integer p_intOpr) {
        String sql = "select distinct jm from Jobmatl as jm where jm.jobmatlPK.jobId = :jobId and jm.jobmatlPK.opr = :opr order by jm.jobmatlPK.seq";
        Query q = em.createQuery(sql);
        q.setParameter("jobId", p_strJob);
        q.setParameter("opr", p_intOpr);

        return q.getResultList();
    }

    @Override
    public Integer getNextSeq(String p_strJob, Integer p_intOpr) {
        String sql = "select max(jm.jobmatlPK.seq) from Jobmatl as jm where jm.jobmatlPK.jobId = :jobId and jm.jobmatlPK.opr = :opr";
        Query q = em.createQuery(sql);
        q.setParameter("jobId", p_strJob);
        q.setParameter("opr", p_intOpr);

        Integer intLastSeq = (Integer)q.getSingleResult();
        if(intLastSeq == null) {
            intLastSeq = new Integer(0);
        }

        Integer intNext = intLastSeq + 1;

        return intNext;
    }

    @Override
    public List<Jobmatl> findByJobId(String jobId) {
        String sql = "SELECT o FROM Jobmatl o WHERE o.jobmatlPK.jobId=:jobId";
        Query q = em.createQuery(sql);
        q.setParameter("jobId", jobId);
        return q.getResultList();
    }

}
