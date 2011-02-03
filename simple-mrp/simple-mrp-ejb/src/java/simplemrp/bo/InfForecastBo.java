/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Forecast;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfForecastBo {

    public List<Forecast> findByForecastDate(Date forecaseDate);

    public void remove(String forecase_id);

    public String create(Forecast forecase);

    public List<Forecast> findAll();

    public Forecast find(String forecast_id);

}
