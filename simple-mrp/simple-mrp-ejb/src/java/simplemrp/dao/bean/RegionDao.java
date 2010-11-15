/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfRegionDao;
import simplemrp.entity.Region;

/**
 *
 * @author Golf
 */
@Stateless
public class RegionDao extends AbstractDao<Region> implements InfRegionDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionDao() {
        super(Region.class);
    }

}
