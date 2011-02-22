/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.sit.common.utils.OperationResult;
import simplemrp.entity.Mps;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfMpsBo {

    public Mps find(String mpsId);

    public List<Mps> findAll();

    public String create(Mps mps);

    public List<Mps> findByCreateDate(Date p_dtCreate);

    public void remove(String mpsId) throws Exception;

    public void save(Mps mps) throws Exception ;

    public OperationResult generateMPS(String p_strUsr_id) throws Exception;

//    public String getLastId();

}
