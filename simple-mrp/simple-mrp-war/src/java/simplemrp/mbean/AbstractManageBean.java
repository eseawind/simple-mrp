/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean;

import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public abstract class AbstractManageBean {
    
    protected final void message(String p_strMsg) {
        FacesUtils.addInfoMessage(p_strMsg);
    }
}
