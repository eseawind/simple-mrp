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
import simplemrp.dao.InfVendorDao;
import simplemrp.entity.Vendor;

/**
 *
 * @author Golf
 */
@Stateless
public class VendorDao extends AbstractDao<Vendor> implements InfVendorDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendorDao() {
        super(Vendor.class);
    }

    @Override
    public List<Vendor> findByName(String name) {
        String sql = "select distinct v from Vendor as v where v.description like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name + "%");
        return q.getResultList();
    }

    @Override
    public String getNextVendor_id() {
        String strPrefix = "V";

        String sql = "select max(v.vendId) from Vendor as v";
        Query q = em.createQuery(sql);
        String strLastVend_id = (String)q.getSingleResult();

        if(strLastVend_id == null) {
            strLastVend_id = "000000";
        }
        strLastVend_id = strLastVend_id.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastVend_id).intValue() + 1;

        String strNextVend_id = "000000" + intNext;
        strNextVend_id = strPrefix + strNextVend_id.substring(strNextVend_id.length() - 6, strNextVend_id.length());

        return strNextVend_id;
    }



}
