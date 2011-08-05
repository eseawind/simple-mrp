/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.District;

/**
 *
 * @author Golf
 */
@Local
public interface InfDistrictDao {

    void create(District district);

    void edit(District district);

    void remove(District district);

    District find(Object id);

    List<District> findAll();

    List<District> findRange(int[] range);

    int count();

    List<District> findByProvince(Integer p_intProvince_id) throws Exception;
}
