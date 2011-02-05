/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Usr;

/**
 *
 * @author Golf
 */
@Local
public interface InfUsrBo {
    public List<Usr> searchUsr(String p_strUsr_name) throws Exception;
    public Usr findUsr(String p_strUsr_id) throws Exception;
    public void editUsr(Usr p_usr) throws Exception;
    public void removeUsr(Usr p_usr) throws Exception;
    public String createUsr(Usr p_usr) throws Exception;
}
