/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.List;
import javax.ejb.EJB;
import simplemrp.bo.InfBankBo;
import javax.ejb.Stateless;
import simplemrp.dao.InfBankDao;
import simplemrp.entity.Bank;

/**
 *
 * @author Golf
 */
@Stateless
public class BankBo implements InfBankBo {
    @EJB
    private InfBankDao bankDao;

    @Override
    public List<Bank> getListBank() {
        return bankDao.findAll();
    }
}
