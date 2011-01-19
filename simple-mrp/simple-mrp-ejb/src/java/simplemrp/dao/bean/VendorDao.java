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
        String sql = "select distinct v from vendor as v where v.description like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name + "%");
        return q.getResultList();
    }

    @Override
    public String getNextVendor_id() {
        String sql = "select max(v.vend_id) from vendor as v";
        Query q = em.createQuery(sql);
        String strLastCust_id = (String)q.getSingleResult();

        Integer intNext = new Integer(strLastCust_id).intValue() + 1;

        String strNextCust_id = "0000000" + intNext;
        strNextCust_id = strNextCust_id.substring(strNextCust_id.length() - 7, strNextCust_id.length());

        return strNextCust_id;
    }



}
