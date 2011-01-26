/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Workcenter;


/**
 *
 * @author GSD008
 */
@Local
public interface InfWorkcenterBo {

    public List<Workcenter> getListWorkcenter() throws java.lang.Exception;
    public Workcenter getWorkcenter(String strWorkcenter);

    public List<Workcenter> searchWorkcenter(String p_strKeyword);

    public void removeWorkcenter(Workcenter p_workcenter) throws Exception;

    public String createWorkcenter(Workcenter p_workcenter) throws Exception;

    public void editWorkcenter(Workcenter p_workcenter) throws Exception;

    public Workcenter findWorkcenter(String p_strWorkcenter) throws Exception;
    
}
