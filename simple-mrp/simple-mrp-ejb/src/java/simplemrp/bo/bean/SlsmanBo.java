/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfSlsmanBo;
import simplemrp.dao.InfSlsmanDao;
import simplemrp.entity.Slsman;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class SlsmanBo implements InfSlsmanBo {

    @EJB
    private InfSlsmanDao slsmanDao;

    @Override
    public Slsman getSlsman(String strSale_id) {
        return slsmanDao.find(strSale_id);
    }

    @Override
    public List<Slsman> searchSlsman(String p_strKeyword) {
        return slsmanDao.findByName(p_strKeyword);
    }

    @Override
    public Slsman findSlsman(String p_strSlsman_id) throws Exception {
        Slsman slsman = slsmanDao.find(p_strSlsman_id);

        return slsman;
    }

    @Override
    public void editSlsman(Slsman p_slsman) throws Exception {
        try {
            slsmanDao.edit(p_slsman);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeSlsman(Slsman p_slsman) throws Exception {
        slsmanDao.remove(p_slsman);
    }

    @Override
    public String createSlsman(Slsman p_slsman) throws Exception {
        String strNextSlsman = slsmanDao.getNextSlsman();
        p_slsman.setSlsman(strNextSlsman);
        
        slsmanDao.create(p_slsman);

        return p_slsman.getSlsman();
    }

}
