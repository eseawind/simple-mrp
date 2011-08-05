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
import simplemrp.dao.InfDistrictDao;
import simplemrp.entity.District;

/**
 *
 * @author Golf
 */
@Stateless
public class DistrictDao extends AbstractDao<District> implements InfDistrictDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DistrictDao() {
        super(District.class);
    }

    @Override
    public List<District> findByProvince(Integer p_intProvince_id) throws Exception {
        String sql = "select distinct d from District as d where d.province.provinceId = ?1 order by d.districtName";
        Query q = em.createQuery(sql);
        q.setParameter(1, p_intProvince_id);
        return q.getResultList();
    }

}
