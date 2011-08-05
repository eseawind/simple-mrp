/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfItem_statDao;
import simplemrp.entity.Item_stat;

/**
 *
 * @author Golf
 */
@Stateless
public class Item_statDao extends AbstractDao<Item_stat> implements InfItem_statDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Item_statDao() {
        super(Item_stat.class);
    }

}
