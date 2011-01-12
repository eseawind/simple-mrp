/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfCoitemBo;
import javax.ejb.Stateless;
import simplemrp.dao.bean.CoitemDao;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;

/**
 *
 * @author Golf
 */
@Stateless
public class CoitemBo implements InfCoitemBo {
    @EJB
    private CoitemDao coitemDao;


    @Override
    public List<Coitem> getCoitemByCo(String p_strCo_id) throws Exception {
        return coitemDao.findByCo(p_strCo_id);
    }

    @Override
    public Coitem getCoitem(CoitemPK p_pkCoitem) throws Exception {
        return coitemDao.find(p_pkCoitem);
    }

    @Override
    public Integer createCoitem(Coitem p_coitem) throws Exception {
        Integer intNextCoSeq = coitemDao.getNextCo_seq();
        p_coitem.getCoitemPK().setCoSeq(intNextCoSeq);
        
        coitemDao.create(p_coitem);

        return intNextCoSeq;
    }

    @Override
    public void editCoitem(Coitem p_coitem) throws Exception {
        coitemDao.edit(p_coitem);
    }

    @Override
    public void removeCoitem(Coitem p_coitem) throws Exception {
        coitemDao.remove(p_coitem);
    }
}
