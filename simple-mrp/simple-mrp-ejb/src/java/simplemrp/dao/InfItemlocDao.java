/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Itemloc;

/**
 *
 * @author Golf
 */
@Local
public interface InfItemlocDao {

    void create(Itemloc itemloc);

    void edit(Itemloc itemloc);

    void remove(Itemloc itemloc);

    Itemloc find(Object id);

    List<Itemloc> findAll();

    List<Itemloc> findRange(int[] range);

    int count();

    public List<Itemloc> findByParam(String warehouse, String location);

}
