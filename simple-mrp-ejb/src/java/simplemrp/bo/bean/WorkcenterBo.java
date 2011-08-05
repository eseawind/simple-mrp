/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfWorkcenterBo;
import simplemrp.dao.InfWorkcenterDao;
import simplemrp.entity.Workcenter;

/**
 *
 * @author GSD008
 */
@Stateless
public class WorkcenterBo implements InfWorkcenterBo {
    
   @EJB
    private InfWorkcenterDao workcenterDao;

    @Override
    public Workcenter getWorkcenter(String strWorkcenter) {
        return workcenterDao.find(strWorkcenter);
    }

    @Override
    public List<Workcenter> searchWorkcenter(String p_strKeyword) {
        return workcenterDao.findByName(p_strKeyword);
    }

    @Override
    public Workcenter findWorkcenter(String p_strWorkcenter) throws Exception {
        Workcenter workcenter = workcenterDao.find(p_strWorkcenter);

        return workcenter;
    }

    @Override
    public void editWorkcenter(Workcenter p_workcenter) throws Exception {
        try {
            workcenterDao.edit(p_workcenter);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeWorkcenter(Workcenter p_workcenter) throws Exception {
        workcenterDao.remove(p_workcenter);
    }

    @Override
    public String createWorkcenter(Workcenter p_workcenter) throws Exception {
      //  String strNextWorkcenter = workcenterDao.getNextWorkcenter();
       // p_workcenter.setWorkcenter(strNextWorkcenter);

        workcenterDao.create(p_workcenter);

        return p_workcenter.getWc();
    }

    @Override
    public List<Workcenter> getListWorkcenter() throws Exception {
        return workcenterDao.findAll();
    }

}
