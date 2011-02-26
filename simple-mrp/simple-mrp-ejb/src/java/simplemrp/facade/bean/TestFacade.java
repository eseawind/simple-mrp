/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.facade.bean;

import java.util.List;
import javax.ejb.Stateless;
import simplemrp.entity.Po;
import simplemrp.facade.TestFacadeRemote;
import simplemrp.to.CoOrderItemTO;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless(mappedName = BindingName.TestFacadeRemote)
public class TestFacade implements TestFacadeRemote {

    @Override
    public Integer countList(List<Po> p_lsPo) throws Exception {
        return p_lsPo.size();
    }

    @Override
    public Integer countList_2(List<CoOrderItemTO> p_ls) throws Exception {
        return p_ls.size();
    }

    @Override
    public Integer countList_3(Po[] p_a) throws Exception {
        return new Integer(p_a.length);
    }

    @Override
    public Integer countList_4(CoOrderItemTO[] p_a) throws Exception {
        return new Integer(p_a.length);
    }
}
