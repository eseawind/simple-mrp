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
import simplemrp.dao.InfPrDao;
import simplemrp.entity.Pr;
import simplemrp.util.ParamBinder;

/**
 *
 * @author Golf
 */
@Stateless
public class PrDao extends AbstractDao<Pr> implements InfPrDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PrDao() {
        super(Pr.class);
    }

    @Override
    public List<Pr> findByRequesterReqDate(String p_strPrId, String p_strRequester, Date p_dtReqDate) {
        ParamBinder pb = new ParamBinder();
        StringBuilder condition = new StringBuilder();

        if((p_strPrId != null) && (p_strPrId.length() > 0)) {
            condition.append("p.prId like :prId \n");
            pb.put("prId", p_strPrId + "%");
        }

        if((p_strRequester != null) && (p_strRequester.length() > 0)) {
            if(condition.length() > 0) {
                condition.append(" and ");
            }

            condition.append("p.requester like :requester \n");
            pb.put("requester", p_strRequester + "%");
        }

        if(p_dtReqDate != null) {
            if(condition.length() > 0) {
                condition.append(" and ");
            }

            condition.append("p.reqDate = :reqDate \n");
            pb.put("reqDate", p_dtReqDate);
        }

        StringBuilder sql = new StringBuilder();
        sql.append("select distinct p \n");
        sql.append("from Pr as p \n");
        sql.append("where ").append(condition);

        Query q = em.createQuery(sql.toString());
        q = pb.bind(q);

        return q.getResultList();
    }

    @Override
    public String getNextPr_id() {
        String strPrefix = "R";

        String sql = "select max(p.prId) from Pr as p";
        Query q = em.createQuery(sql);
        String strLastPr_id = (String)q.getSingleResult();

        if(strLastPr_id == null) {
            strLastPr_id = "000000";
        }
        strLastPr_id = strLastPr_id.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastPr_id).intValue() + 1;

        String strNextPr_id = "000000" + intNext;
        strNextPr_id = strPrefix + strNextPr_id.substring(strNextPr_id.length() - 6, strNextPr_id.length());

        return strNextPr_id;
    }

}
