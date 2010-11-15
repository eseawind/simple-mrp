/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Bank;

/**
 *
 * @author Golf
 */
@Local
public interface InfBankDao {

    void create(Bank bank);

    void edit(Bank bank);

    void remove(Bank bank);

    Bank find(Object id);

    List<Bank> findAll();

    List<Bank> findRange(int[] range);

    int count();

}
