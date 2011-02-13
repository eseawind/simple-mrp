/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.dao.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import simplemrp.constant.CoConstant;
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
        String sql = "select distinct ci from Coitem as ci where ci.coitemPK.coId = :coId order by ci.coitemPK.coSeq";
        Query q = em.createQuery(sql);
        q.setParameter("coId", p_strCoId);
        return q.getResultList();
    }

    @Override
    public Integer getNextCo_seq(String p_strCo_id) {
        String sql = "select max(ci.coitemPK.coSeq) from Coitem as ci where ci.coitemPK.coId = :coId";
        Query q = em.createQuery(sql);
        q.setParameter("coId", p_strCo_id);

        Integer intLastCo_seq = (Integer) q.getSingleResult();
        if(intLastCo_seq == null) {
            intLastCo_seq = new Integer(0);
        }

        Integer intNext = new Integer(intLastCo_seq.intValue() + 1);

        return intNext;
    }

    @Override
    public List<Coitem> findForMpsGen() throws Exception {
        List<Coitem> lsCoitem = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ci \n");
            sql.append("FROM Coitem as ci \n");
            sql.append("WHERE ((ci.qty > ci.qtyship) OR (ci.qtyship IS NULL)) \n");
            sql.append("AND ci.mps_id IS NULL \n");
            sql.append("AND ci.costat.stat = '").append(CoConstant.CO_STAT_ORDER).append("' \n");
            sql.append("ORDER BY ci.coitemPK.coId, ci.coitemPK.coSeq \n");

            Query q = em.createQuery(sql.toString());
            lsCoitem = q.getResultList();
            
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return lsCoitem;
    }
}
