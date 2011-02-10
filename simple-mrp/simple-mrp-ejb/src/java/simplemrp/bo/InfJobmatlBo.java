/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Jobmatl;
import simplemrp.entity.JobmatlPK;

/**
 *
 * @author Golf
 */
@Local
public interface InfJobmatlBo {
    public List<Jobmatl> getJobmatlByJobopr(String p_strJob, Integer p_intOpr) throws Exception;
    public Jobmatl getJobmatl(JobmatlPK p_pkJobmatl) throws Exception;
    public Integer createJobmatl(Jobmatl p_jobmatl) throws Exception;
    public void editJobmatl(Jobmatl p_jobmatl) throws Exception;
    public void removeJobmatl(Jobmatl p_jobmatl) throws Exception;
}
