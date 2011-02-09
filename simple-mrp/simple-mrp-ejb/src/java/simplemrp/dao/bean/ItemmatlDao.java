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
import simplemrp.dao.InfItemmatlDao;
import simplemrp.entity.Itemmatl;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemmatlDao extends AbstractDao<Itemmatl> implements InfItemmatlDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemmatlDao() {
        super(Itemmatl.class);
    }

    @Override
    public List<Itemmatl> findByItemopr(String p_strItem, Integer p_intOpr) {
        String sql = "select distinct im from Itemmatl as im where im.itemmatlPK.item = :item and im.itemmatlPK.opr = :opr order by im.itemmatlPK.seq";
        Query q = em.createQuery(sql);
        q.setParameter("item", p_strItem);
        q.setParameter("opr", p_intOpr);

        return q.getResultList();
    }

    @Override
    public Integer getNextSeq(String p_strItem, Integer p_intOpr) {
        String sql = "select max(im.itemmatlPK.seq) from Itemmatl as im where im.itemmatlPK.item = :item and im.itemmatlPK.opr = :opr";
        Query q = em.createQuery(sql);
        q.setParameter("item", p_strItem);
        q.setParameter("opr", p_intOpr);

        Integer intLastSeq = (Integer)q.getSingleResult();
        if(intLastSeq == null) {
            intLastSeq = new Integer(0);
        }

        Integer intNext = intLastSeq + 1;

        return intNext;
    }
}
