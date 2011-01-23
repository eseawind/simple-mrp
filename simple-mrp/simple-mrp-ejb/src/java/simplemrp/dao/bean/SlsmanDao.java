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
import simplemrp.dao.InfSlsmanDao;
import simplemrp.entity.Slsman;

/**
 *
 * @author Golf
 */
@Stateless
public class SlsmanDao extends AbstractDao<Slsman> implements InfSlsmanDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SlsmanDao() {
        super(Slsman.class);
    }
    @Override
    public List<Slsman> findByName(String name){
        String sql = "select distinct o from Slsman as o where o.fname like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name+"%");
        return q.getResultList();
    }

    @Override
    public String getNextSlsman() {
        String strPrefix = "S";

        String sql = "select max(s.slsman) from Slsman as s";
        Query q = em.createQuery(sql);
        String strLastSlsman = (String)q.getSingleResult();
        if((strLastSlsman == null) || (strLastSlsman.length() == 0)) {
            strLastSlsman = "S000000";
        }
        strLastSlsman = strLastSlsman.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastSlsman).intValue() + 1;

        String strNextSlsman = "000000" + intNext;
        strNextSlsman = strPrefix + strNextSlsman.substring(strNextSlsman.length() - 6, strNextSlsman.length());

        return strNextSlsman;
    }
}
