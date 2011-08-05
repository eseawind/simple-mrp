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
import simplemrp.dao.InfProvinceDao;
import simplemrp.entity.Province;

/**
 *
 * @author Golf
 */
@Stateless
public class ProvinceDao extends AbstractDao<Province> implements InfProvinceDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinceDao() {
        super(Province.class);
    }

    @Override
    public List<Province> findByCountry(Integer p_intCountry_id) throws Exception {
        String sql = "select distinct p from Province as p where p.country.countryId = ?1 order by p.provinceName";
        Query q = em.createQuery(sql);
        q.setParameter(1, p_intCountry_id);
        return q.getResultList();
    }

}
