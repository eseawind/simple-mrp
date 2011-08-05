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
import simplemrp.dao.InfPritemDao;
import simplemrp.entity.Pritem;

/**
 *
 * @author Golf
 */
@Stateless
public class PritemDao extends AbstractDao<Pritem> implements InfPritemDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PritemDao() {
        super(Pritem.class);
    }

    @Override
    public List<Pritem> findByPr(String p_strPrId) {
        String sql = "select distinct pri from Pritem as pri where pri.pritemPK.prId = :prId order by pri.pritemPK.prSeq";
        Query q = em.createQuery(sql);
        q.setParameter("prId", p_strPrId);
        return q.getResultList();
    }


    @Override
    public Integer getNextPr_seq(String p_strPrId) {
        String sql = "select max(pri.pritemPK.prSeq) from Pritem as pri where pri.pritemPK.prId = :prId ";
        Query q = em.createQuery(sql);
        q.setParameter("prId", p_strPrId);

        Integer intLastPr_seq = (Integer)q.getSingleResult();
        if(intLastPr_seq == null) {
            intLastPr_seq = new Integer(0);
        }

        Integer intNext = new Integer(intLastPr_seq.intValue() + 1);

        return intNext;
    }
}
