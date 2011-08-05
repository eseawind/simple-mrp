/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfPoitemBo {
    public List<Poitem> getPoitemByPo(String p_strPo_id) throws Exception;

    public Poitem getPoitem(PoitemPK p_pkPoitem) throws Exception;

    public Integer createPoitem(Poitem p_poitem) throws Exception;

    public void editPoitem(Poitem p_poitem) throws Exception;

    public void removePoitem(Poitem p_poitem) throws Exception;

    public List<Poitem> getPoitemByPr(String p_strPr_id);
    
}
