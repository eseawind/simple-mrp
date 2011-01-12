/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfCoitemBo {
    public List<Coitem> getCoitemByCo(String p_strCo_id) throws Exception;
    public Coitem getCoitem(CoitemPK p_pkCoitem) throws Exception;
    public Integer createCoitem(Coitem p_coitem) throws Exception;
    public void editCoitem(Coitem p_coitem) throws Exception;
    public void removeCoitem(Coitem p_coitem) throws Exception;
}
