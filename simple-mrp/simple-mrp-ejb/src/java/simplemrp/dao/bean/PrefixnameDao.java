/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import simplemrp.dao.InfPrefixnameDao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.entity.Prefixname;

/**
 *
 * @author Golf
 */
@Stateless
public class PrefixnameDao extends AbstractFacade<Prefixname> implements InfPrefixnameDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PrefixnameDao() {
        super(Prefixname.class);
    }

}
