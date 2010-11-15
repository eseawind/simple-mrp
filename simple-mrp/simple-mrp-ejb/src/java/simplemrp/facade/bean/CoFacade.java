/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.bean.InfBankBo;
import simplemrp.entity.Bank;
import simplemrp.facade.CoFacadeRemote;

/**
 *
 * @author Golf
 */
@Stateless (mappedName = "simplemrp.CoFacadeRemote")
public class CoFacade implements CoFacadeRemote {
    @EJB
    private InfBankBo bankBo;


    @Override
    public Bank getBank(String bank_id) throws Exception {
        return bankBo.find(bank_id);
    }
}
