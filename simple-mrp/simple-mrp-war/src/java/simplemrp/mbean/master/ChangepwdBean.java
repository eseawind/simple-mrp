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

        if(!getPwdOld().equals(usr.getPwd())) {
            message("Wrong password!!!");
        } else if(!getPwdNew().equals(getPwdConfirm())) {
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

        if(getUsrIdNew().trim().equals("")) {
            message("Please enter new user ID");
        } else if(getUsrNmeNew().trim().equals("")) {
            message("Please enter new user name");
        } else {
            Usr usr = new Usr(getUsrIdNew());
            usr.setUsr_name(getUsrNmeNew());
            usr.setPwd(getUsrIdNew());

            if(getApp_pr()) {
                usr.setApp_pr('Y');
            } else {
                usr.setApp_pr('N');
            }

            if(getRls_job()) {
                usr.setRls_job('Y');
            } else {
                usr.setRls_job('N');
            }

            if(getRls_mps()) {
                usr.setRls_mps('Y');
            } else {
                usr.setRls_mps('N');
            }

            try {
                ma.createUsr(usr);
                message("Create Complete!!!");
                setPwdOld(null);
                setPwdNew(null);
                setPwdConfirm(null);
                setUsrNmeNew(null);
                setUsrIdNew(null);
                setRls_job(null);
                setRls_mps(null);
                setApp_pr(null);

            } catch(Exception ex) {
                message(ex.getMessage());
            }
        }
    }

    public void doDelete(ActionEvent e) throws Exception {
        try {
            Usr usr = new Usr(getUsrIdNew().trim());
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            maFacade.deleteUsr(usr);
            message("Delete complete");
            setUsrNmeNew(null);
            setUsrIdNew(null);
            setRls_job(null);
            setRls_mps(null);
            setApp_pr(null);

        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }
}
