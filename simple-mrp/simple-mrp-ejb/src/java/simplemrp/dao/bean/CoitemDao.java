/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfCoitemDao;
import simplemrp.entity.Coitem;

/**
 *
 * @author Golf
 */
@Stateless
public class CoitemDao extends AbstractDao<Coitem> implements InfCoitemDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CoitemDao() {
        super(Coitem.class);
    }

}
