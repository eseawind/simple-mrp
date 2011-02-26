/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Pr;

/**
 *
 * @author Golf
 */
@Local
public interface InfPrBo {

    
    public String createPr(Pr p_pr) throws Exception;

    
    public void removePr(Pr p_pr) throws Exception;

    
    public void editPr(Pr p_pr) throws Exception;

    
    public Pr findPr(String p_strPr_id) throws Exception;

    
    public List<Pr> searchPr(String p_strPrId, String p_strRequester, Date p_dtReqDate) throws Exception;
    
}
