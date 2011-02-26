/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import javax.ejb.Remote;
import simplemrp.entity.Po;
import simplemrp.to.CoOrderItemTO;

/**
 *
 * @author Golf
 */
@Remote
public interface TestFacadeRemote {

    public Integer countList(List<Po> p_lsPo) throws Exception;

    public Integer countList_2(List<CoOrderItemTO> p_ls) throws Exception;

    public Integer countList_3(Po[] p_a) throws Exception;

    public Integer countList_4(CoOrderItemTO[] p_a) throws Exception;
}
