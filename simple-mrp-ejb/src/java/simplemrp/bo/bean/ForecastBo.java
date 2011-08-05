/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityExistsException;
import simplemrp.bo.InfForecastBo;
import simplemrp.dao.InfForecastDao;
import simplemrp.entity.Forecast;
import simplemrp.entity.Item;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class ForecastBo implements InfForecastBo {

    @EJB
    private InfForecastDao forecastDao;

    @Override
    public void editForecast(Forecast p_forecast) throws Exception {
        forecastDao.edit(p_forecast);
    }

    @Override
    public List<Forecast> findByForecastDate(Date forecaseDate) {
        List<Forecast> results = forecastDao.findByForecastDate(forecaseDate);
        //LAZYLOAD
        if(results!=null){
            for(Forecast f:results){
                if(f.getItem1()!=null){
                    f.getItem1().toString();
                }
            }
        }
        return results;
    }

    @Override
    public void remove(String forecase_id) {
        Forecast f = new Forecast();
        f.setItem(forecase_id);
        forecastDao.remove(f);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String create(Forecast forecast) {

        Item item = new Item();
        item.setItem(forecast.getItem());
        forecast.setItem1(item);
        forecastDao.create(forecast);
        return forecast.getItem();
    }

    @Override
    public List<Forecast> findAll() {
        List<Forecast> list = forecastDao.findAll();
        //lazy load forecast item
        for (Forecast f : list) {
            if (f.getItem1() != null) {
                f.getItem1().toString();
            }
        }
        return list;
    }

    @Override
    public Forecast find(String forecast_id) {
        return forecastDao.find(forecast_id);
    }


    @Override
    public List<Forecast> getForMpsGen() throws Exception {
        return forecastDao.findForMpsGen();
    }


}
