/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import javax.ejb.Stateless;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.MaFacadeRemote)
public class MaFacade implements MaFacadeRemote {

}
