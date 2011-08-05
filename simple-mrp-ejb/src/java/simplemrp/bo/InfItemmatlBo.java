/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfItemmatlBo {

    public List<Itemmatl> getItemmatlByItemopr(String p_strItem, Integer p_intOpr) throws Exception;

    public Itemmatl getItemmatl(ItemmatlPK p_pkItemmatl) throws Exception;

    public Integer createItemmatl(Itemmatl p_itemmatl) throws Exception;

    public void editItemmatl(Itemmatl p_itemmatl) throws Exception;

    public void removeItemmatl(Itemmatl p_itemmatl) throws Exception;
    
}
