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
import simplemrp.dao.InfCoitemDao;
import simplemrp.entity.Coitem;

/**
 *
 * @author Golf
 */
@Stateless
public class CoitemDao extends AbstractDao<Coitem> implements InfCoitemDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CoitemDao() {
        super(Coitem.class);
    }

    @Override
    public List<Coitem> findByCo(String p_strCoId) {
        String sql = "select distinct c from Coitem as ci where ci.coitemPK.coSeq = :coId order by ci.";
        Query q = em.createQuery(sql);
        q.setParameter("coId", p_strCoId);
        return q.getResultList();
    }


    @Override
    public Integer getNextCo_seq() {
        String sql = "select max(ci.coitemPK.coSeq) from Coitem as ci";
        Query q = em.createQuery(sql);
        
        Integer intLastCo_seq = (Integer)q.getSingleResult();
        if(intLastCo_seq == null) {
            intLastCo_seq = new Integer(0);
        }

        Integer intNext = new Integer(intLastCo_seq.intValue() + 1);

        return intNext;
    }
}
