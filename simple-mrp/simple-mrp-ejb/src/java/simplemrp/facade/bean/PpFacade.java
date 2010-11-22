/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import javax.ejb.Stateless;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.PpFacadeRemote)
public class PpFacade implements PpFacadeRemote {

}
