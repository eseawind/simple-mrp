/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfUomDao;
import simplemrp.entity.Uom;

/**
 *
 * @author Golf
 */
@Stateless
public class UomDao extends AbstractDao<Uom> implements InfUomDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UomDao() {
        super(Uom.class);
    }

}
