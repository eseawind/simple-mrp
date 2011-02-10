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
        String sql = "select max(jm.joboprPK.seq) from Jobmatl as jm where jm.joboprPK.jobId = :jobId and jm.joboprPK.opr = :opr";
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

}
