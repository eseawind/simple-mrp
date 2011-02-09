/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Itemmatl;

/**
 *
 * @author Golf
 */
@Local
public interface InfItemmatlDao {

    void create(Itemmatl itemmatl);

    void edit(Itemmatl itemmatl);

    void remove(Itemmatl itemmatl);

    Itemmatl find(Object id);

    List<Itemmatl> findAll();

    List<Itemmatl> findRange(int[] range);

    int count();
    
    public List<Itemmatl> findByItemopr(String p_strItem, Integer p_intOpr);

    public Integer getNextSeq(String p_strItem, Integer p_intOpr);

}
