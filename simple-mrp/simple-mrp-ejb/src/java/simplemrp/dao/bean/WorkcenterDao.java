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
import simplemrp.dao.InfWorkcenterDao;
import simplemrp.entity.Workcenter;

/**
 *
 * @author Golf
 */
@Stateless
public class WorkcenterDao extends AbstractDao<Workcenter> implements InfWorkcenterDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkcenterDao() {
        super(Workcenter.class);
    }
 @Override
    public List<Workcenter> findByName(String name){
        String sql = "select distinct w from Workcenter as w where w.wc like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name+"%");
        return q.getResultList();
    }

    @Override
    public String getNextWorkcenter() {
        String strPrefix = "S";

        String sql = "select max(w.wc) from Workcenter as w";
        Query q = em.createQuery(sql);
        String strLastWorkcenter = (String)q.getSingleResult();
        if((strLastWorkcenter == null) || (strLastWorkcenter.length() == 0)) {
            strLastWorkcenter = "S000000";
        }
        strLastWorkcenter = strLastWorkcenter.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastWorkcenter).intValue() + 1;

        String strNextWorkcenter = "000000" + intNext;
        strNextWorkcenter = strPrefix + strNextWorkcenter.substring(strNextWorkcenter.length() - 6, strNextWorkcenter.length());

        return strNextWorkcenter;
    }
}
