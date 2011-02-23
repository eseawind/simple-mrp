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
            setPwdOld("");
            setPwdNew("");
            setPwdConfirm("");
            setUsrNmeNew("");
            setUsrIdNew("");

        }

    }

    public void doClear(ActionEvent e) {
        setPwdOld("");
        setPwdNew("");
        setPwdConfirm("");
        setUsrNmeNew("");
        setUsrIdNew("");
    }

    public void doCreate(ActionEvent e) throws Exception {

        if (getUsrIdNew().trim().equals("") || getUsrNmeNew().trim().equals("")) {
            message("Please fill TextBox!!!");
        } else {
            Usr usr = new Usr(getUsrIdNew());
            usr.setUsr_name(getUsrNmeNew());
            usr.setPwd("1234");
            usr.setApp_pr('N');
            usr.setRls_job('N');
            usr.setRls_mps('N');
            try {
                ma.createUsr(usr);
                message("Create Complete!!!");
                setPwdOld("");
                setPwdNew("");
                setPwdConfirm("");
                setUsrNmeNew("");
                setUsrIdNew("");
            } catch (Exception ex) {
                message(ex.getMessage());
            }
        }

    }
}
