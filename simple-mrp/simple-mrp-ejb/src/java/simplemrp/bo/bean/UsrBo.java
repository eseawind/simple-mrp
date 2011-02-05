/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfUsrBo;
import simplemrp.dao.InfUsrDao;
import simplemrp.entity.Usr;

/**
 *
 * @author Golf
 */
@Stateless
public class UsrBo implements InfUsrBo {
    @EJB
    private InfUsrDao usrDao;

    @Override
    public List<Usr> searchUsr(String p_strUsr_name) throws Exception {
        return usrDao.findByUsr_name(p_strUsr_name);
    }

    @Override
    public Usr findUsr(String p_strUsr_id) throws Exception {
        Usr usr = usrDao.find(p_strUsr_id);

        return usr;
    }

    @Override
    public void editUsr(Usr p_usr) throws Exception {
        try {
            usrDao.edit(p_usr);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeUsr(Usr p_usr) throws Exception {
        if(p_usr.getUsr_id().equals("admin")) {
            throw new Exception("Could not delete admin user");
        } else {
            usrDao.remove(p_usr);
        }
    }

    @Override
    public String createUsr(Usr p_usr) throws Exception {
        Usr usr = usrDao.find(p_usr.getUsr_id());

        if(usr == null) {
            usrDao.create(p_usr);
        } else {
            throw new Exception("Duplicate user");
        }

        return p_usr.getUsr_id();
    }
}
