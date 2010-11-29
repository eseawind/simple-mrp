/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfPrefixnamBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfPrefixnameDao;

/**
 *
 * @author Golf
 */
@Stateless
public class PrefixnameBo implements InfPrefixnamBo {
    @EJB
    private InfPrefixnameDao prefixnameDao;

    @Override
    public List getListPrefixname() {
        return prefixnameDao.findAll();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
