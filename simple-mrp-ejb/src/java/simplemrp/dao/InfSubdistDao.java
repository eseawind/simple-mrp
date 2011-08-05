/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Subdist;

/**
 *
 * @author Golf
 */
@Local
public interface InfSubdistDao {

    void create(Subdist subdist);

    void edit(Subdist subdist);

    void remove(Subdist subdist);

    Subdist find(Object id);

    List<Subdist> findAll();

    List<Subdist> findRange(int[] range);

    int count();

    List<Subdist> findByDistrict(Integer p_intDistrict_id) throws Exception;

}
