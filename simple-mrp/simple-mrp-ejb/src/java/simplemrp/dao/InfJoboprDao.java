/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Jobopr;

/**
 *
 * @author Golf
 */
@Local
public interface InfJoboprDao {

    void create(Jobopr jobopr);

    void edit(Jobopr jobopr);

    void remove(Jobopr jobopr);

    Jobopr find(Object id);

    List<Jobopr> findAll();

    List<Jobopr> findRange(int[] range);

    int count();

    public List<Jobopr> findByJob(String p_strJob);

    public Integer getNextOpr(String p_strJobId);
}
