/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
