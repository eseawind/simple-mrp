/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfItemoprBo {
    public List<Itemopr> getItemoprByItem(String p_strItem) throws Exception;
    public Itemopr getItemopr(ItemoprPK p_pkItemopr) throws Exception;
    public Integer createItemopr(Itemopr p_itemopr) throws Exception;
    public void editItemopr(Itemopr p_itemopr) throws Exception;
    public void removeItemopr(Itemopr p_itemopr) throws Exception;
    public List<Itemopr> getBomDeatil(String p_strItem) throws Exception;
}
