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

}
