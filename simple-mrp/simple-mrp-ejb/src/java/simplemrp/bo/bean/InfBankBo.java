/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import javax.ejb.Local;
import simplemrp.entity.Bank;

/**
 *
 * @author Golf
 */
@Local
public interface InfBankBo {
    public void create(Bank bank) throws Exception;

    public void edit(Bank bank) throws Exception;

    public void remove(Bank bank) throws Exception;

    public Bank find(String bank_id) throws Exception;

}
