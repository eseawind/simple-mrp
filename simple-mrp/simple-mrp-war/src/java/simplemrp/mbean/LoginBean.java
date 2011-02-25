/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean;

import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import simplemrp.entity.Usr;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.servlet.AuthorizerFilter;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;
import simplemrp.util.SessionIdentifier;


/**
 *
 * @author Golf
 */
public class LoginBean extends AbstractManageBean {
    private String usr_id;
    private String pwd;

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public void doLogin(ActionEvent e) throws Exception {
        try {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            String strUsr = getUsr_id();
            Usr usr = maFacade.getUsr(strUsr);

            if(usr == null) {
                message("User not found");
            } else if((usr != null) && (!usr.getPwd().equals(getPwd()))) {
                message("Wrong password");
            } else if((usr != null) && (usr.getPwd().equals(getPwd()))) {
                SessionIdentifier sid = new SessionIdentifier(usr.getUsr_id());

                if(usr.getUsr_id().equals(usr.getPwd())) {
                    sid.setChangepwd(Boolean.TRUE);
                } else {
                    sid.setChangepwd(Boolean.FALSE);
                }

                HttpSession session = FacesUtils.getHttpSession(true);

                session.setAttribute(AuthorizerFilter.KEY_SESSION_ID_OBJECT, sid);
                FacesUtils.getExternalContext().redirect("index.jsf");
            }
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

}
