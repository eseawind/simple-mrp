/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfLocDao;
import simplemrp.entity.Loc;

/**
 *
 * @author Golf
 */
@Stateless
public class LocDao extends AbstractDao<Loc> implements InfLocDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public LocDao() {
        super(Loc.class);
    }

}
