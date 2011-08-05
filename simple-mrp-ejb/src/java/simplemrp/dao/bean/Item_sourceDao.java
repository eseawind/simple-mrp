/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfItem_sourceDao;
import simplemrp.entity.Item_source;

/**
 *
 * @author Golf
 */
@Stateless
public class Item_sourceDao extends AbstractDao<Item_source> implements InfItem_sourceDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Item_sourceDao() {
        super(Item_source.class);
    }

}
