/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfWorkcenterDao;
import simplemrp.entity.Workcenter;

/**
 *
 * @author Golf
 */
@Stateless
public class WorkcenterDao extends AbstractDao<Workcenter> implements InfWorkcenterDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkcenterDao() {
        super(Workcenter.class);
    }

}
