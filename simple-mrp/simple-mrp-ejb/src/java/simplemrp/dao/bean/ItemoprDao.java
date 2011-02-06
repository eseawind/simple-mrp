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
import simplemrp.dao.InfItemoprDao;
import simplemrp.entity.Itemopr;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemoprDao extends AbstractDao<Itemopr> implements InfItemoprDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemoprDao() {
        super(Itemopr.class);
    }

    @Override
    public List<Itemopr> findByItem(String p_strItem) {
        String sql = "select distinct io from Itemopr as io where io.itemoprPK.item = :item order by io.itemoprPK.item";
        Query q = em.createQuery(sql);
        q.setParameter("item", p_strItem);
        return q.getResultList();
    }

    @Override
    public Integer getNextOpr(String p_strItem) {
        String sql = "select max(io.itemoprPK.opr) from Itemopr as io where io.itemoprPK.item = :item";
        Query q = em.createQuery(sql);
        q.setParameter("item", p_strItem);

        Integer intNextOpr = (Integer)q.getSingleResult();
        if(intNextOpr == null) {
            intNextOpr = new Integer(0);
        }

        Integer intNext = ((intNextOpr / 10) + 1) * 10;

        return intNext;
    }
}
