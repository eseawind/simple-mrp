/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Pr_stat;

/**
 *
 * @author Golf
 */
@Local
public interface InfPr_statBo {
    public List<Pr_stat> getListPr_stat();
}
