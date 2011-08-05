/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfUomBo;
import simplemrp.dao.InfUomDao;
import simplemrp.entity.Uom;

/**
 *
 * @author Golf
 */
@Stateless
public class UomBo implements InfUomBo {

    @EJB
    private InfUomDao uomDao;

    @Override
    public Uom getUom(String strUom) {
        return uomDao.find(strUom);
    }

    @Override
    public List<Uom> searchUom(String p_strKeyword) {
        return uomDao.findByName(p_strKeyword);
    }

    @Override
    public Uom findUom(String p_strUom) throws Exception {
        Uom uom = uomDao.find(p_strUom);

        return uom;
    }

    @Override
    public void editUom(Uom p_uom) throws Exception {
        try {
            uomDao.edit(p_uom);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public void removeUom(Uom p_uom) throws Exception {
        uomDao.remove(p_uom);
    }

    @Override
    public String createUom(Uom p_uom) throws Exception {
      //  String strNextUom = uomDao.getNextUom();
       // p_uom.setUom(strNextUom);

        uomDao.create(p_uom);

        return p_uom.getUom();
    }

    @Override
    public List<Uom> getListUom() throws Exception {
        return uomDao.findAll();
    }

}
