/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;



import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfLocBo;
import simplemrp.dao.InfLocDao;
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;

/**
 *
 * @author GSD008
 */
@Stateless
public class LocBo implements InfLocBo {

    @EJB
    private InfLocDao locDao;

    @Override
    public Loc getLoc(LocPK p_locPK) {
        return locDao.find(p_locPK);
    }

    @Override
    public List<Loc> searchLoc(String p_strKeyword) {
        return locDao.findByName(p_strKeyword);
    }

   
    @Override
    public void editLoc(Loc p_loc) throws Exception {
        try {
            locDao.edit(p_loc);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeLoc(Loc p_loc) throws Exception {
        locDao.remove(p_loc);
    }

    @Override
    public void createLoc(Loc p_loc) throws Exception {
        Loc loc = locDao.find(p_loc.getLocPK());

        if (loc == null) {
            locDao.create(p_loc);
        } else {
            throw new Exception("Duplicate Location");
        }
    }

  
}
