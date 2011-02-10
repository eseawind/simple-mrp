/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import javax.ejb.Local;
import simplemrp.mbean.ic.to.JobRecvItemTO;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfJobRecvBo {

    public void saveJobRecv(String jobId, Date transDate, JobRecvItemTO jobRecvItem);
}
