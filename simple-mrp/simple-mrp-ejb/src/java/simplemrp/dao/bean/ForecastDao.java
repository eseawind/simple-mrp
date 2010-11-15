/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplemrp.dao.InfForecastDao;
import simplemrp.entity.Forecast;

/**
 *
 * @author Golf
 */
@Stateless
public class ForecastDao extends AbstractDao<Forecast> implements InfForecastDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ForecastDao() {
        super(Forecast.class);
    }

}
