/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Po;

/**
 *
 * @author Golf
 */
@Local
public interface InfPoBo {
    public List<Po> searchPo(String p_strPoId, Date p_dtPoDate) throws Exception;

    public Po findPo(String p_strPo_id) throws Exception;

    public void editPo(Po p_po) throws Exception;

    public void removePo(Po p_po) throws Exception;
    
    public String createPo(Po p_po) throws Exception;
}
