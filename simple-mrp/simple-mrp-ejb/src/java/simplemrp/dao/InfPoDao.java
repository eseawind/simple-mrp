/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Po;

/**
 *
 * @author Golf
 */
@Local
public interface InfPoDao {

    void create(Po po);

    void edit(Po po);

    void remove(Po po);

    Po find(Object id);

    List<Po> findAll();

    List<Po> findRange(int[] range);

    int count();

    public List<Po> findByVendIdDate(String p_strVendId, Date p_dtPoDate);

    public String getNextPo_id();
}
