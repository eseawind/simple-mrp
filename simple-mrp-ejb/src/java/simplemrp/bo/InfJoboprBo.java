/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Jobopr;
import simplemrp.entity.JoboprPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfJoboprBo {
    public List<Jobopr> getJoboprByJob(String p_strJob) throws Exception;
    public Jobopr getJobopr(JoboprPK p_pkJobopr) throws Exception;
    public Integer createJobopr(Jobopr p_jobopr) throws Exception;
    public void editJobopr(Jobopr p_jobopr) throws Exception;
    public void removeJobopr(Jobopr p_jobopr) throws Exception;
    public List<Jobopr> getBomDeatil(String p_strJobId) throws Exception;
    public List<Jobopr> getByJob(String p_strJobID) throws Exception;
}
