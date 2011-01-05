/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Subdist;

/**
 *
 * @author Golf
 */
@Local
public interface InfSubdistBo {

    public List<Subdist> getSubdistInDistrict(Integer p_intDistrictId) throws Exception;

    public Subdist getSubdist(Integer p_intSubdist_id) throws Exception;
}
