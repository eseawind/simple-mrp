/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Term;

/**
 *
 * @author Golf
 */
@Local
public interface InfTermDao {

    void create(Term term);

    void edit(Term term);

    void remove(Term term);

    Term find(Object id);

    List<Term> findAll();

    List<Term> findRange(int[] range);

    int count();

}
