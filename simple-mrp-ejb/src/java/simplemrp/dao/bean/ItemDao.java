/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.sit.common.utils.SQLUtil;
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

    @Override
    public List<Item> findByItemDesc(String item, String description) throws Exception {
        List<Item> lsItem = null;

        StringBuilder filter = new StringBuilder();

        if((item != null) && (item.length() > 0)) {
            filter.append("i.item like ").append(SQLUtil.convert(item + "%")).append(" \n");
        }

        if((description != null) && (description.length() > 0)) {
            if(filter.length() > 0) {
                filter.append("and ");
            }
            filter.append("i.description like ").append(SQLUtil.convert("%" + description + "%")).append(" \n");
        }

        if(filter.length() > 0) {
            StringBuilder sql = new StringBuilder("select distinct i from Item as i where ").append(filter);
            Query q = em.createQuery(sql.toString());
            lsItem = q.getResultList();
        } else {
            lsItem = new ArrayList<Item>();
        }

        return lsItem;
    }

}
