/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfItempriceDao;
import simplemrp.entity.Itemprice;

/**
 *
 * @author Golf
 */
@Stateless
public class ItempriceDao extends AbstractDao<Itemprice> implements InfItempriceDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ItempriceDao() {
        super(Itemprice.class);
    }

}
