/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
