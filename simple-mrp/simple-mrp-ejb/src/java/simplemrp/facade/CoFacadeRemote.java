/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import javax.ejb.Remote;
import simplemrp.entity.Bank;

/**
 *
 * @author Golf
 */
@Remote
public interface CoFacadeRemote {
    public Bank getBank(String bank_id) throws Exception;
}
