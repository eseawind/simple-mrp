/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Province;

/**
 *
 * @author Golf
 */
@Local
public interface InfProvinceDao {

    void create(Province province);

    void edit(Province province);

    void remove(Province province);

    Province find(Object id);

    List<Province> findAll();

    List<Province> findRange(int[] range);

    int count();

}
