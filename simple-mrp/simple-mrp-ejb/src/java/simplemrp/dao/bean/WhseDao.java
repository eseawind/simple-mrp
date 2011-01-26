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
import simplemrp.dao.InfWhseDao;
import simplemrp.entity.Whse;




/**
 *
 * @author Golf
 */
@Stateless
public class WhseDao extends AbstractDao<Whse> implements InfWhseDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WhseDao() {
        super(Whse.class);
    }
 @Override
    public List<Whse> findByName(String name){
        String sql = "select distinct w from Whse as w where w.whse like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name+"%");
        return q.getResultList();
    }

    @Override
    public String getNextWhse() {
        String strPrefix = "S";

        String sql = "select max(w.whse) from Whse as w";
        Query q = em.createQuery(sql);
        String strLastWhse = (String)q.getSingleResult();
        if((strLastWhse == null) || (strLastWhse.length() == 0)) {
            strLastWhse = "S000000";
        }
        strLastWhse = strLastWhse.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastWhse).intValue() + 1;

        String strNextWhse = "000000" + intNext;
        strNextWhse = strPrefix + strNextWhse.substring(strNextWhse.length() - 6, strNextWhse.length());

        return strNextWhse;
    }
}
