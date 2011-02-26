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
import javax.persistence.TemporalType;
import org.sit.common.utils.SQLUtil;
import simplemrp.dao.InfPoDao;
import simplemrp.entity.Po;
import simplemrp.util.ParamBinder;

/**
 *
 * @author Golf
 */
@Stateless
public class PoDao extends AbstractDao<Po> implements InfPoDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PoDao() {
        super(Po.class);
    }

    @Override
    public List<Po> findByDate(String p_strPoId, Date p_dtPoDate) {
        ParamBinder pb = new ParamBinder();

        StringBuilder condition = new StringBuilder();

        if((p_strPoId != null) && (p_strPoId.length() > 0)) {
            condition.append(" p.poId LIKE :poId ");
            pb.put("poId", p_strPoId + "%");
        }

        if(p_dtPoDate != null) {
            if(condition.length() > 0) {
                condition.append(" AND ");
            }
            condition.append(" p.poDate = :poDate ");
            pb.put("poDate", p_dtPoDate);
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT distinct p ");
        sql.append("FROM Po AS p ");
        sql.append("WHERE ").append(condition);

//        System.out.println(sql.toString());
        
        Query q = em.createQuery(sql.toString());
        q = pb.bind(q);

//        System.out.println(q.toString());

        return q.getResultList();
    }

    @Override
    public String getNextPo_id() {
        String strPrefix = "P";

        String sql = "select max(p.poId) from Po as p";
        Query q = em.createQuery(sql);
        String strLastPo_id = (String)q.getSingleResult();

        if(strLastPo_id == null) {
            strLastPo_id = "000000";
        }
        strLastPo_id = strLastPo_id.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastPo_id).intValue() + 1;

        String strNextPo_id = "000000" + intNext;
        strNextPo_id = strPrefix + strNextPo_id.substring(strNextPo_id.length() - 6, strNextPo_id.length());

        return strNextPo_id;
    }

}
