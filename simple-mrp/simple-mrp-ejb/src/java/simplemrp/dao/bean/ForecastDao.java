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

    @Override
    public List<Forecast> findForMpsGen() throws Exception {
        List<Forecast> lsForecast = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f ");
            sql.append("FROM Forecast AS f ");
            sql.append("WHERE f.mps_id IS NULL ");
            sql.append("ORDER BY f.item ");

            Query q = em.createQuery(sql.toString());
            lsForecast = q.getResultList();

        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return lsForecast;
    }

    @Override
    public List<Forecast> findByMps(String p_strMps_id) throws Exception {
        List<Forecast> lsForecast = null;

        try {
            String sql = "SELECT o FROM Forecast o WHERE o.mps_id=:mps_id";
            Query q = em.createQuery(sql);
            q.setParameter("mps_id", p_strMps_id);
            
            lsForecast = q.getResultList();

        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        return lsForecast;
    }
}
