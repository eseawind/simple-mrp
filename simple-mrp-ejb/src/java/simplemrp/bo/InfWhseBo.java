/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Whse;


/**
 *
 * @author GSD008
 */
@Local
public interface InfWhseBo {

     public List<Whse> getListWhse() throws java.lang.Exception;
     public Whse getWhse(String strWhse);

    public List<Whse> searchWhse(String p_strKeyword);

    public void removeWhse(Whse p_whse) throws Exception;

    public String createWhse(Whse p_whse) throws Exception;

    public void editWhse(Whse p_whse) throws Exception;

    public Whse findWhse(String p_strWhse) throws Exception;
    
}
