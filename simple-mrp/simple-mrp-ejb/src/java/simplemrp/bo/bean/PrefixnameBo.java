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
import simplemrp.entity.Prefixname;

/**
 *
 * @author Golf
 */
@Stateless
public class PrefixnameBo implements InfPrefixnamBo {
    @EJB
    private InfPrefixnameDao prefixnameDao;

    @Override
    public List<Prefixname> getListPrefixname() {
        return prefixnameDao.findAll();
    }
}
