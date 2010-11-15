/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfJobmatlDao;
import simplemrp.entity.Jobmatl;

/**
 *
 * @author Golf
 */
@Stateless
public class JobmatlDao extends AbstractDao<Jobmatl> implements InfJobmatlDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public JobmatlDao() {
        super(Jobmatl.class);
    }

}
