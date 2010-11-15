/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfCustomerDao;
import simplemrp.entity.Customer;

/**
 *
 * @author Golf
 */
@Stateless
public class CustomerDao extends AbstractDao<Customer> implements InfCustomerDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerDao() {
        super(Customer.class);
    }

}
