/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Co_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfCo_statBo {
    public List<Co_stat> getListCo_stat();
}
