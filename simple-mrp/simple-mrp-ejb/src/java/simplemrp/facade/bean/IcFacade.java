/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade.bean;

import javax.ejb.Stateless;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.util.BindingName;

/**
 *
 * @author Golf
 */
@Stateless (mappedName=BindingName.IcFacadeRemote)
public class IcFacade implements IcFacadeRemote {

}
