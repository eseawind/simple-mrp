/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfBankDao;
import simplemrp.entity.Bank;

/**
 *
 * @author Golf
 */
@Stateless
public class BankDao extends AbstractDao<Bank> implements InfBankDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BankDao() {
        super(Bank.class);
    }

}
