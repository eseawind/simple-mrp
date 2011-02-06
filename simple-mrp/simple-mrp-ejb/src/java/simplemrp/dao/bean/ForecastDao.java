/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public List<Forecast> findByForecastDate(Date forecastDate) {
        String sql = "SELECT o FROM Forecast o WHERE o.fcstdate=:forecastDate";
        Query q = em.createQuery(sql);
        q.setParameter("forecastDate", forecastDate);
        return q.getResultList();
    }

}
