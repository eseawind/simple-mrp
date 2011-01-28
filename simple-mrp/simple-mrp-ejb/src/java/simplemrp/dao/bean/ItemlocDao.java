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
import simplemrp.dao.InfItemlocDao;
import simplemrp.entity.Itemloc;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemlocDao extends AbstractDao<Itemloc> implements InfItemlocDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemlocDao() {
        super(Itemloc.class);
    }

    @Override
    public List<Itemloc> findByParam(String warehouse, String location) {
        String sql = "SELECT o FROM Itemloc o WHERE o.itemlocPK.whse LIKE :warehouse AND o.itemlocPK.loc LIKE :location";
        Query q = em.createQuery(sql);
        q.setParameter("warehouse", "%"+warehouse+"%");
        q.setParameter("location", "%"+location+"%");
        return q.getResultList();
    }

}
