/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Mps;

/**
 *
 * @author wisaruthkea
 */
@Local
public interface InfMpsBo {

    public Mps find(String mpsId);

    public List<Mps> findAll();

    public String create(Mps mps);

    public List<Mps> findByDueDate(Date dueDate);

    public void remove(String mpsId);

    public void save(Mps mps);

}