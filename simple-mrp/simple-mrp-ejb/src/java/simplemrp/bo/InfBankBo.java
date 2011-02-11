/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Bank;

/**
 *
 * @author Golf
 */
@Local
public interface InfBankBo {

    public List<Bank> getListBank();
    
}
