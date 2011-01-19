/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Vendor;

/**
 *
 * @author Golf
 */
@Local
public interface InfVendorDao {

    void create(Vendor vendor);

    void edit(Vendor vendor);

    void remove(Vendor vendor);

    Vendor find(Object id);

    List<Vendor> findAll();

    List<Vendor> findRange(int[] range);

    int count();

    List<Vendor> findByName(String name);

    String getNextVendor_id();

}
