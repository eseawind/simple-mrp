/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfPritemBo {
    public List<Pritem> getPritemByPr(String p_strPr_id) throws Exception;

    public Pritem getPritem(PritemPK p_pkPritem) throws Exception;

    public Integer createPritem(Pritem p_pritem) throws Exception;

    public void editPritem(Pritem p_pritem) throws Exception;

    public void removePritem(Pritem p_pritem) throws Exception;
}
