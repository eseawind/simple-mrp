/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Jobmatl;

/**
 *
 * @author Golf
 */
@Local
public interface InfJobmatlDao {

    void create(Jobmatl jobmatl);

    void edit(Jobmatl jobmatl);

    void remove(Jobmatl jobmatl);

    Jobmatl find(Object id);

    List<Jobmatl> findAll();

    List<Jobmatl> findRange(int[] range);

    int count();

}
