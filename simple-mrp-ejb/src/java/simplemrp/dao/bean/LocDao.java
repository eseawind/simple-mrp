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
import simplemrp.dao.InfLocDao;
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;
/**
 *
 * @author Golf
 */
@Stateless
public class LocDao extends AbstractDao<Loc> implements InfLocDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public LocDao() {
        super(Loc.class);
    }
 @Override
    public List<Loc> findByName(String name){
        String sql = "select distinct l from Loc as l where l.locPK.loc like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name+"%");
        return q.getResultList();
    }

   
}
