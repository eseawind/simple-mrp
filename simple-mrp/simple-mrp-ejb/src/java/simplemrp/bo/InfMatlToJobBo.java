/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.to.MatlToJobItemTO;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfMatlToJobBo {

    public void saveMatlToJob(String jobId, Date transDate, List<MatlToJobItemTO> lsTo);
    public void saveMatlToJob_V2(String jobId, Date transDate, MatlToJobItemTO[] arrTo) throws Exception;

}
