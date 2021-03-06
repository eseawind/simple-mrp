/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean;

import java.io.Serializable;
import org.apache.log4j.Logger;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public abstract class AbstractManageBean implements Serializable {
    protected transient Logger log = Logger.getLogger(this.getClass());
    protected String MODE_NEW = "NEW";
    protected String MODE_EDIT = "EDIT";
    
    protected final void message(String p_strMsg) {
        FacesUtils.addInfoMessage(p_strMsg);
    }

    protected final String getSessionUserId() {
        LoginBean loginBean = (LoginBean)FacesUtils.getManagedBean("loginBean");
        String strUsr_id = loginBean.getUsr_id();
        return strUsr_id;
    }
}
