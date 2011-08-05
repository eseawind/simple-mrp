/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;



import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfWhseBo;
import simplemrp.dao.InfWhseDao;
import simplemrp.entity.Whse;

/**
 *
 * @author GSD008
 */
@Stateless
public class WhseBo implements InfWhseBo {
    @EJB
    private InfWhseDao whseDao;

    @Override
    public Whse getWhse(String strWhse) {
        return whseDao.find(strWhse);
    }

    @Override
    public List<Whse> searchWhse(String p_strKeyword) {
        return whseDao.findByName(p_strKeyword);
    }

    @Override
    public Whse findWhse(String p_strWhse) throws Exception {
        Whse whse = whseDao.find(p_strWhse);

        return whse;
    }

    @Override
    public void editWhse(Whse p_whse) throws Exception {
        try {
           whseDao.edit(p_whse);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeWhse(Whse p_whse) throws Exception {
        whseDao.remove(p_whse);
    }

    @Override
    public String createWhse(Whse p_whse) throws Exception {


       whseDao.create(p_whse);

        return p_whse.getWhse();
    }

    @Override
    public List<Whse> getListWhse() throws Exception {
        return whseDao.findAll();
    }

}
