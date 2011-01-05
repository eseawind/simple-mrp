/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfTaxBo;
import simplemrp.dao.InfTaxDao;
import simplemrp.entity.Tax;

/**
 *
 * @author Golf
 */
@Stateless
public class TaxBo implements InfTaxBo {
    @EJB
    private InfTaxDao taxDao;

    @Override
    public List<Tax> getListTax() {
        return taxDao.findAll();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
