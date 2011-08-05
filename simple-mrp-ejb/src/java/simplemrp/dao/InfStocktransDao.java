/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.dao;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import simplemrp.entity.Stocktrans;

/**
 *
 * @author Golf
 */
@Local
public interface InfStocktransDao {

    void create(Stocktrans stocktrans);

    void edit(Stocktrans stocktrans);

    void remove(Stocktrans stocktrans);

    Stocktrans find(Object id);

    List<Stocktrans> findAll();

    List<Stocktrans> findRange(int[] range);

    public List<Stocktrans> findByItemTransDate(String p_strTransItem, Date p_dtTransDateFrom, Date p_dtTransDateTo);

    int count();
    Integer getNextPK();

}
