/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Forecast;

/**
 *
 * @author Golf
 */
@Local
public interface InfForecastDao {

    void create(Forecast forecast);

    void edit(Forecast forecast);

    void remove(Forecast forecast);

    Forecast find(Object id);

    List<Forecast> findAll();

    List<Forecast> findRange(int[] range);

    int count();

    public List<Forecast> findByForecastDate(Date forecaseDate);

}
