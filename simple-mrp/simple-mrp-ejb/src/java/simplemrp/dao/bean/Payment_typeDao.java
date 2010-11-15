/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfPayment_typeDao;
import simplemrp.entity.Payment_type;

/**
 *
 * @author Golf
 */
@Stateless
public class Payment_typeDao extends AbstractDao<Payment_type> implements InfPayment_typeDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public Payment_typeDao() {
        super(Payment_type.class);
    }

}
