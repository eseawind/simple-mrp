/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Item_source;

/**
 *
 * @author Golf
 */
@Local
public interface InfItem_sourceBo {

    public List<Item_source> getListItem_source() throws java.lang.Exception;
    
}
