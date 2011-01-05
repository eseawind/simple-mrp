/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfSubdistBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfSubdistDao;
import simplemrp.entity.Subdist;

/**
 *
 * @author Golf
 */
@Stateless
public class SubdistBo implements InfSubdistBo {
    
    @EJB
    private InfSubdistDao subdistDao;

    @Override
    public List<Subdist> getSubdistInDistrict(Integer p_intDistrictId) throws Exception {
        return subdistDao.findByDistrict(p_intDistrictId);
    }

    @Override
    public Subdist getSubdist(Integer p_intSubdist_id) throws Exception {
        return subdistDao.find(p_intSubdist_id);
    }
 }
