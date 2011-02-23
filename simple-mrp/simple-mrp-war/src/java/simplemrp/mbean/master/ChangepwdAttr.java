/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.master;

import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class ChangepwdAttr extends AbstractManageBean {

    private String usrId;
//    private String usrName;
    private String pwdOld;
    private String pwdNew;
    private String pwdConfirm;
    private String usrIdNew;
    private String usrNmeNew;
    private Boolean adminUsr;

    public String getUsrNmeNew() {
        return usrNmeNew;
    }

    public void setUsrNmeNew(String usrNmeNew) {
        this.usrNmeNew = usrNmeNew;
    }

    public String getUsrIdNew() {
        return usrIdNew;
    }

    public void setUsrIdNew(String usrNew) {
        this.usrIdNew = usrNew;
    }

    public Boolean getAdminUsr() {
        if (getSessionUserId().equals("admin")) {
            return true;
        } else {
            //return false;
            return true;
        }
    }

    public void setAdminUsr(Boolean adminUsr) {
        this.adminUsr = adminUsr;
    }

    public String getPwdConfirm() {
        return pwdConfirm;
    }

    public void setPwdConfirm(String pwdConfirm) {
        this.pwdConfirm = pwdConfirm;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getUsrId() {
        usrId = getSessionUserId();
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }
//    public String getUsrName() {
//        return usrName;
//    }
//
//    public void setUsrName(String usrName) {
//        this.usrName = usrName;
//    }
}
