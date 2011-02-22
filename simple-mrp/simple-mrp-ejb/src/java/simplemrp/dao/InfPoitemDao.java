/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Poitem;

/**
 *
 * @author Golf
 */
@Local
public interface InfPoitemDao {

    void create(Poitem poitem);

    void edit(Poitem poitem);

    void remove(Poitem poitem);

    Poitem find(Object id);

    List<Poitem> findAll();

    List<Poitem> findRange(int[] range);

    int count();

    public List<Poitem> findByPo(String p_strPoId);

    public Integer getNextPo_seq(String p_strPoId);

    public List<Poitem> findByPr(String p_strPr_id);
}
