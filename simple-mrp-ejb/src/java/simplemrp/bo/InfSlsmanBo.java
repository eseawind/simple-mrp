/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Slsman;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfSlsmanBo {

    public Slsman getSlsman(String strSale_id);

    public List<Slsman> searchSlsman(String p_strKeyword);

    public void removeSlsman(Slsman p_slsman) throws Exception;

    public String createSlsman(Slsman p_slsman) throws Exception;

    public void editSlsman(Slsman p_slsman) throws Exception;

    public Slsman findSlsman(String p_strSlsman_id) throws Exception;
}
