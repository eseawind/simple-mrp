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
import simplemrp.dao.InfUomDao;
import simplemrp.entity.Uom;

/**
 *
 * @author Golf
 */
@Stateless
public class UomDao extends AbstractDao<Uom> implements InfUomDao {
    @PersistenceContext(unitName = "simple-mrp-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UomDao() {
        super(Uom.class);
    }
 @Override
    public List<Uom> findByName(String name){
        String sql = "select distinct o from Uom as o where o.uom like ?1";
        Query q = em.createQuery(sql);
        q.setParameter(1, name+"%");
        return q.getResultList();
    }

    @Override
    public String getNextUom() {
        String strPrefix = "S";

        String sql = "select max(u.Uom) from Slsman as u";
        Query q = em.createQuery(sql);
        String strLastUom = (String)q.getSingleResult();
        if((strLastUom == null) || (strLastUom.length() == 0)) {
            strLastUom = "S000000";
        }
        strLastUom = strLastUom.replaceFirst(strPrefix, "");

        Integer intNext = new Integer(strLastUom).intValue() + 1;

        String strNextUom = "000000" + intNext;
        strNextUom = strPrefix + strNextUom.substring(strNextUom.length() - 6, strNextUom.length());

        return strNextUom;
    }
}
