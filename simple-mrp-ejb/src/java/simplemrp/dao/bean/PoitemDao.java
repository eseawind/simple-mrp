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
import simplemrp.dao.InfPoitemDao;
import simplemrp.entity.Poitem;

/**
 *
 * @author Golf
 */
@Stateless
public class PoitemDao extends AbstractDao<Poitem> implements InfPoitemDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PoitemDao() {
        super(Poitem.class);
    }

    @Override
    public List<Poitem> findByPo(String p_strPoId) {
        String sql = "select distinct pi from Poitem as pi where pi.poitemPK.poId = :poId order by pi.poitemPK.poSeq";
        Query q = em.createQuery(sql);
        q.setParameter("poId", p_strPoId);
        return q.getResultList();
    }

     @Override
    public List<Poitem> findByPr(String p_strPr_id) {
        String sql = "SELECT o FROM Poitem o WHERE o.pritem.pritemPK.prId = :prId ORDER BY o.poitemPK.poSeq";
         //System.out.println("\n\n\n\n\n Find by PRR \n\n\n\n\n\n");
         //String sql = "SELECT o FROM Poitem o";
        Query q = em.createQuery(sql);
        q.setParameter("prId", p_strPr_id);
        List<Poitem> lsPoitem = q.getResultList();
        for(Poitem item:lsPoitem){
            item.getPo().toString();
        }
        return lsPoitem;
    }

    @Override
    public Integer getNextPo_seq(String p_strPoId) {
        String sql = "select max(pi.poitemPK.poSeq) from Poitem as pi where pi.poitemPK.poId = :poId order by pi.poitemPK.poSeq";
        Query q = em.createQuery(sql);
        q.setParameter("poId", p_strPoId);

        Integer intLastPo_seq = (Integer)q.getSingleResult();
        if(intLastPo_seq == null) {
            intLastPo_seq = new Integer(0);
        }

        Integer intNext = new Integer(intLastPo_seq.intValue() + 1);

        return intNext;
    }


}
