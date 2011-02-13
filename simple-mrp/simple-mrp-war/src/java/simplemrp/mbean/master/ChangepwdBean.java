/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.master;

import javax.faces.event.ActionEvent;
import simplemrp.entity.Usr;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;

/**
 *
 * @author Golf
 */
public class ChangepwdBean extends ChangepwdAttr {

    private MaFacadeRemote ma = (MaFacadeRemote) EJBLookup.getEJBInstance(BindingName.MaFacadeRemote);
    /** Creates a new instance of ChangepwdBean */
    public ChangepwdBean() {
    }

    public void doSave(ActionEvent e) throws Exception {

        Usr usr = ma.getUsr(getUsrId());

        if (!getPwdOld().equals(usr.getPwd())) {
            message("Wrong password!!!");
        } else if (!getPwdNew().equals(getPwdConfirm())) {
            message("Confirm password not match!!!");
        } else {
            usr.setPwd(getPwdNew());
            ma.editUsr(usr);
            message("Change Complete!!!");
        }

    }

    public void doClear(ActionEvent e) {
        setPwdConfirm("");
        setPwdNew("");
        setUsrId("");
    }
}
