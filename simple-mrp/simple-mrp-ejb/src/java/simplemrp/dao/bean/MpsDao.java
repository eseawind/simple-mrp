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
import simplemrp.dao.InfMpsDao;
import simplemrp.entity.Mps;

/**
 *
 * @author Golf
 */
@Stateless
public class MpsDao extends AbstractDao<Mps> implements InfMpsDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MpsDao() {
        super(Mps.class);
    }

    @Override
    public List<Mps> findByCdate(Date p_cdate) {
        String sql = "SELECT o FROM Mps o WHERE o.cdate=:cdate";
        Query q = em.createQuery(sql);
        q.setParameter("cdate", p_cdate);
        return q.getResultList();
    }

    @Override
    public String getNextId() {
        String sql = "select max(o.mpsId) from Mps o";
        Query q = em.createQuery(sql);
        String strLastId = (String)q.getSingleResult();
        if(strLastId==null){
            return "0000001";
        }
        Integer intNext = new Integer(strLastId).intValue() + 1;

        String strNextCust_id = "0000000" + intNext;
        strNextCust_id = strNextCust_id.substring(strNextCust_id.length() - 7, strNextCust_id.length());

        return strNextCust_id;
    }

//    @Override
//    public String getLastId() {
//        String sql = "select max(o.mpsId) from Mps o";
//        Query q = em.createQuery(sql);
//        String strLastId = (String)q.getSingleResult();
//
//        return strLastId;
//    }
    
}
