/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Payment_type;

/**
 *
 * @author Golf
 */
@Local
public interface InfPayment_typeDao {

    void create(Payment_type payment_type);

    void edit(Payment_type payment_type);

    void remove(Payment_type payment_type);

    Payment_type find(Object id);

    List<Payment_type> findAll();

    List<Payment_type> findRange(int[] range);

    int count();

}
