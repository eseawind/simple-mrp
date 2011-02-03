/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfMpsBo;
import simplemrp.dao.InfMpsDao;
import simplemrp.entity.Mps;

/**
 *
 * @author wisaruthkea
 */
@Stateless
public class MpsBo implements InfMpsBo {
    @EJB
    private InfMpsDao mpsDao;

    @Override
    public Mps find(String mpsId) {
        Mps result = mpsDao.find(mpsId);
        doLazyLoad(result);
        return result;
    }

    @Override
    public List<Mps> findAll() {
        List<Mps> result = mpsDao.findAll();
        //lazy load value
        for(Mps m:result){
            doLazyLoad(m);
        }
        return result;
    }

    @Override
    public String create(Mps mps) {
        String id = mpsDao.getNextId();
        mps.setMpsId(id);
        mpsDao.create(mps);
        return id;
    }

    @Override
    public List<Mps> findByDueDate(Date dueDate) {
        List<Mps> result = mpsDao.findByDueDate(dueDate);
        //lazy load value
        for(Mps m:result){
            doLazyLoad(m);
        }
        return result;
    }
    private void doLazyLoad(Mps m){
        if(m.getItem()!=null){
                m.getItem().toString();
            }
            if(m.getMpsstat()!=null){
                m.getMpsstat().toString();
            }
            if(m.getMpstype()!=null){
                m.getMpstype().toString();
            }
    }

    @Override
    public void remove(String mpsId) {
        Mps mps = new Mps(mpsId);
        mpsDao.remove(mps);
    }

    @Override
    public void save(Mps mps) {
        mpsDao.edit(mps);
    }

}
