/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfSlsmanDao;
import simplemrp.entity.Slsman;

/**
 *
 * @author Golf
 */
@Stateless
public class SlsmanDao extends AbstractDao<Slsman> implements InfSlsmanDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public SlsmanDao() {
        super(Slsman.class);
    }

}
