/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Po_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfPo_statBo {
    public List<Po_stat> getListPo_stat();
}
