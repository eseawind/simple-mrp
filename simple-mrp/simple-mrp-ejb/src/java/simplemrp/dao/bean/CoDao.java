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
import simplemrp.dao.InfCoDao;
import simplemrp.entity.Co;

/**
 *
 * @author Golf
 */
@Stateless
public class CoDao extends AbstractDao<Co> implements InfCoDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CoDao() {
        super(Co.class);
    }

    @Override
    public List<Co> findByCustomerId(String p_strCustomerId) {
        String sql = "select distinct c from Co as c where c.customer.custId = ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, p_strCustomerId);
        return q.getResultList();
    }


    @Override
    public String getNextCo_id() {
        String strPrefix = "C";

        String sql = "select max(c.coId) from Co as c";
        Query q = em.createQuery(sql);
        String strLastCo_id = (String)q.getSingleResult();

        if(strLastCo_id == null) {
            strLastCo_id = "000000";
        }
        strLastCo_id = strLastCo_id.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastCo_id).intValue() + 1;

        String strNextCo_id = "000000" + intNext;
        strNextCo_id = strPrefix + strNextCo_id.substring(strNextCo_id.length() - 6, strNextCo_id.length());

        return strNextCo_id;
    }
}
