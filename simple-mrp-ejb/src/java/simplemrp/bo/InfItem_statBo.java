/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import simplemrp.entity.Item_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfItem_statBo {

    List<Item_stat> getListItem_stat() throws Exception;
    
}
