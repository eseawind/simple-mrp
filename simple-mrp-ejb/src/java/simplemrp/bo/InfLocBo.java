/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;


/**
 *
 * @author GSD008
 */
@Local
public interface InfLocBo {

   

    public Loc getLoc(LocPK p_locPK);

    public List<Loc> searchLoc(String p_strKeyword);

    public void removeLoc(Loc p_loc) throws Exception;

    public void createLoc(Loc p_loc) throws Exception;

    public void editLoc(Loc p_loc) throws Exception;



   


}
