/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
