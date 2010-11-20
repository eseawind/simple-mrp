/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerDao() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findByName(String name) {
        String sql = "select distinct c from Customer as c where c.name like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name + "%");
        return q.getResultList();
    }
}
