/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfCountryDao;
import simplemrp.entity.Country;

/**
 *
 * @author Golf
 */
@Stateless
public class CountryDao extends AbstractDao<Country> implements InfCountryDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryDao() {
        super(Country.class);
    }

}
