/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo.bean;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import simplemrp.bo.InfStocktransBo;
import simplemrp.dao.InfStocktransDao;
import simplemrp.entity.Stocktrans;

/**
 *
 * @author GSD008
 */
@Stateless
public class StocktransBo implements InfStocktransBo {
    
     @EJB
    private InfStocktransDao stocktransDao;

     @Override
    public List<Stocktrans> searchStocktrans(String p_strTransItem, Date p_dtTransDatedFrom, Date p_dtTransDateTo)  {
        List<Stocktrans> lsStocktrans = stocktransDao.findByItemTransDate( p_strTransItem,  p_dtTransDatedFrom,  p_dtTransDateTo);
         for (int i = 0; i < lsStocktrans.size(); i++) {
             Stocktrans stocktrans = lsStocktrans.get(i);
             stocktrans.getItemloc().toString();
         }

        return lsStocktrans;
    }

 
}
