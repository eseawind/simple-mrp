/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfItemDao;
import simplemrp.entity.Item;

/**
 *
 * @author Golf
 */
@Stateless
public class ItemDao extends AbstractDao<Item> implements InfItemDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemDao() {
        super(Item.class);
    }

}
