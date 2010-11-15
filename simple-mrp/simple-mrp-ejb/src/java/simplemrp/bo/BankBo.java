/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import javax.ejb.EJB;
import simplemrp.bo.bean.InfBankBo;
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
    public void create(Bank bank) throws Exception {
        bankDao.create(bank);
    }

    @Override
    public void edit(Bank bank) throws Exception {
        bankDao.edit(bank);
    }

    @Override
    public void remove(Bank bank) throws Exception {
        bankDao.remove(bank);
    }

    @Override
    public Bank find(String bank_id) throws Exception {
        return bankDao.find(bank_id);
    }
 
}
