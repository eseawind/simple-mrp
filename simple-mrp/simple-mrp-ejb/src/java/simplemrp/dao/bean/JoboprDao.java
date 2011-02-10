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
import simplemrp.dao.InfJoboprDao;
import simplemrp.entity.Jobopr;

/**
 *
 * @author Golf
 */
@Stateless
public class JoboprDao extends AbstractDao<Jobopr> implements InfJoboprDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public JoboprDao() {
        super(Jobopr.class);
    }

    @Override
    public List<Jobopr> findByJob(String p_strJobId) {
        String sql = "select distinct jo from Jobopr as jo where jo.joboprPK.jobId = :jobId order by jo.joboprPK.opr";
        Query q = em.createQuery(sql);
        q.setParameter("jobId", p_strJobId);
        return q.getResultList();
    }

    @Override
    public Integer getNextOpr(String p_strJobId) {
        String sql = "select max(jo.joboprPK.opr) from Jobopr as jo where jo.joboprPK.jobId = :jobId";
        Query q = em.createQuery(sql);
        q.setParameter("jobId", p_strJobId);

        Integer intNextOpr = (Integer)q.getSingleResult();
        if(intNextOpr == null) {
            intNextOpr = new Integer(0);
        }

        Integer intNext = ((intNextOpr / 10) + 1) * 10;

        return intNext;
    }
}
