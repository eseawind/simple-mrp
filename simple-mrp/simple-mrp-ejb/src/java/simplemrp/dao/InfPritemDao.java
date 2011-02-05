/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Pritem;

/**
 *
 * @author Golf
 */
@Local
public interface InfPritemDao {

    void create(Pritem pritem);

    void edit(Pritem pritem);

    void remove(Pritem pritem);

    Pritem find(Object id);

    List<Pritem> findAll();

    List<Pritem> findRange(int[] range);

    int count();

    public List<Pritem> findByPr(String p_strPrId);

    public Integer getNextPr_seq(String p_strPrId);
}
