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
    public List<Po> searchPo(String p_strPoId, Date p_dtPoDate) throws Exception {
        List<Po> lsPo = null;

        try {
            lsPo = poDao.findByDate(p_strPoId, p_dtPoDate);

            for(int i = 0; i < lsPo.size(); i++) {
                Po po = lsPo.get(i);
                po.getPostat().toString();

                if (po.getVendor() != null) {
                    po.getVendor().toString();
                }
            }
        } catch(Exception ex) {
            throw new Exception(ex.getCause().getMessage(), ex);
        }
        

        return lsPo;
    }

    @Override
    public Po findPo(String p_strPo_id) throws Exception {
        Po po = poDao.find(p_strPo_id);
        if (po != null) {
            po.getPostat().toString();
        }

        if (po.getVendor() != null) {
            po.getVendor().toString();
        }

        return po;
    }

    @Override
    public void editPo(Po p_po) throws Exception {
        try {
            Po po = findPo(p_po.getPoId());

            po.setNote(p_po.getNote());
            po.setPoDate(p_po.getPoDate());
            po.setPostat(p_po.getPostat());
            po.setVendor(p_po.getVendor());

            po.setUdate(DateUtil.getDate());
            po.setUuser(p_po.getUuser());

            poDao.edit(po);
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
