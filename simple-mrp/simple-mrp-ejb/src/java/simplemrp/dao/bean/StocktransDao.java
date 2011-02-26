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
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Stocktrans;
import simplemrp.util.ParamBinder;

/**
 *
 * @author Golf
 */
@Stateless
public class StocktransDao extends AbstractDao<Stocktrans> implements InfStocktransDao {

    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public StocktransDao() {
        super(Stocktrans.class);
    }

    @Override
    public Integer getNextPK() {
        String sql = "select max(o.transId) from Stocktrans as o";
        Query q = em.createQuery(sql);
        Integer newKey = (Integer) q.getSingleResult();
        if (newKey == null) {
            newKey = 1;
        } else {
            newKey += 1;
        }
        return newKey;
    }

     @Override
    public List<Stocktrans> findByItemTransDate(String p_strTransItem, Date p_dtTransDateFrom, Date p_dtTransDateTo) {
        ParamBinder pb = new ParamBinder();
        StringBuilder condition = new StringBuilder();

        if((p_strTransItem != null) && (p_strTransItem.length() > 0)) {
            condition.append("st.itemloc.itemlocPK.item = :item \n");
            pb.put("item", p_strTransItem);
        }

        if(p_dtTransDateFrom != null) {
            if(condition.length() > 0) {
                condition.append(" and ");
            }

            condition.append("st.transDate > :trans_dateFrom \n");
            pb.put("trans_dateFrom", p_dtTransDateFrom);
        }

          if(p_dtTransDateTo != null) {
            if(condition.length() > 0) {
                condition.append(" and ");
            }

            condition.append("st.transDate < :trans_dateTo \n");
            pb.put("trans_dateTo", p_dtTransDateTo);
        }
        StringBuilder sql = new StringBuilder();
        sql.append("select distinct st \n");
        sql.append("from Stocktrans as st \n");
        sql.append("where ").append(condition);

        Query q = em.createQuery(sql.toString());
        q = pb.bind(q);

        return q.getResultList();
    }
}
