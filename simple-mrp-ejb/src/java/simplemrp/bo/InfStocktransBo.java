/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.bo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Stocktrans;


/**
 *
 * @author GSD008
 */
@Local
public interface InfStocktransBo {

    public List<Stocktrans> searchStocktrans(String p_strTransItem, Date p_dtTransDateFrom, Date p_dtTransDateTo);


}
