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
import simplemrp.dao.InfSubdistDao;
import simplemrp.entity.Subdist;

/**
 *
 * @author Golf
 */
@Stateless
public class SubdistDao extends AbstractDao<Subdist> implements InfSubdistDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SubdistDao() {
        super(Subdist.class);
    }

    @Override
    public List<Subdist> findByDistrict(Integer p_intDistrict_id) throws Exception {
        String sql = "select distinct sd from Subdist as sd where sd.district.districtId = ?1 order by sd.subdistName";
        Query q = em.createQuery(sql);
        q.setParameter(1, p_intDistrict_id);
        return q.getResultList();
    }

}
