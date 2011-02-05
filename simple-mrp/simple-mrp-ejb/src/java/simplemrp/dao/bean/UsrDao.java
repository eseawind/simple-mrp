/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import simplemrp.dao.AbstractFacade;
import simplemrp.dao.InfUsrDao;
import simplemrp.entity.Usr;

/**
 *
 * @author Golf
 */
@Stateless
public class UsrDao extends AbstractFacade<Usr> implements InfUsrDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsrDao() {
        super(Usr.class);
    }

    @Override
    public List<Usr> findByUsr_name(String p_strUsr_name) {
        String sql = "select distinct u from Usr as u where u.usr_name = ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, p_strUsr_name);
        return q.getResultList();
    }
}
