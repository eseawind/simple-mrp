/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Uom;

/**
 *
 * @author Golf
 */
@Local
public interface InfUomBo {

   public List<Uom> getListUom() throws java.lang.Exception;
     public Uom getUom(String strUom);

    public List<Uom> searchUom(String p_strKeyword);

    public void removeUom(Uom p_uom) throws Exception;

    public String createUom(Uom p_uom) throws Exception;

    public void editUom(Uom p_uom) throws Exception;

    public Uom findUom(String p_strUom) throws Exception;

}
