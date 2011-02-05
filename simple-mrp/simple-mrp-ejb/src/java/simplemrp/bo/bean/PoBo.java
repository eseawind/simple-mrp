/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.ArrayList;
import simplemrp.bo.InfPoBo;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.sit.common.utils.DateUtil;
import simplemrp.dao.InfPoDao;
import simplemrp.entity.Po;

/**
 *
 * @author Golf
 */
@Stateless
public class PoBo implements InfPoBo {
    @EJB
    private InfPoDao poDao;

    @Override
    public List<Po> searchPo(String p_strVendId, Date p_dtPoDate) throws Exception {
        List<Po> lsPo = poDao.findByVendIdDate(p_strVendId, p_dtPoDate);
  
        for(int i=0; i<lsPo.size(); i++) {
            Po po = lsPo.get(i);
            po.getPostat().toString();
        }

        return lsPo;
    }

    @Override
    public Po findPo(String p_strPo_id) throws Exception {
        Po po = poDao.find(p_strPo_id);
        if (po != null) {
            po.getPostat().toString();
        }

        return po;
    }

    @Override
    public void editPo(Po p_po) throws Exception {
        try {
            Po po = findPo(p_po.getPoId());

            p_po.setCdate(po.getCdate());
            p_po.setCuser(po.getCuser());
            p_po.setUdate(DateUtil.getDate());

            poDao.edit(p_po);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removePo(Po p_po) throws Exception {
        poDao.remove(p_po);
    }

    @Override
    public String createPo(Po p_po) throws Exception {
        String strNextPo_id = poDao.getNextPo_id();

        p_po.setPoId(strNextPo_id);

        p_po.setUdate(DateUtil.getDate());

        p_po.setCdate(p_po.getUdate());
        p_po.setCuser(p_po.getUuser());

        poDao.create(p_po);

        return p_po.getPoId();
    } 
}
