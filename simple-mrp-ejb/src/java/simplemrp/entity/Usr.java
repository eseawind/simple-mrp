/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Golf
 */
@Entity
@Table(name = "usr")
@NamedQueries({
    @NamedQuery(name = "Usr.findAll", query = "SELECT u FROM Usr u")})
public class Usr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usr_id")
    private String usr_id;
    @Basic(optional = false)
    @Column(name = "usr_name")
    private String usr_name;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "app_pr")
    private Character app_pr;
    @Column(name = "rls_job")
    private Character rls_job;
    @Column(name = "rls_mps")
    private Character rls_mps;

    public Usr() {
    }

    public Usr(String usrId) {
        this.usr_id = usrId;
    }

    public Usr(String usrId, String usrName) {
        this.usr_id = usrId;
        this.usr_name = usrName;
    }

    public Character getApp_pr() {
        return app_pr;
    }

    public void setApp_pr(Character app_pr) {
        this.app_pr = app_pr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Character getRls_job() {
        return rls_job;
    }

    public void setRls_job(Character rls_job) {
        this.rls_job = rls_job;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public Character getRls_mps() {
        return rls_mps;
    }

    public void setRls_mps(Character rls_mps) {
        this.rls_mps = rls_mps;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usr_id != null ? usr_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(!(object instanceof Usr)) {
            return false;
        }
        Usr other = (Usr) object;
        if((this.usr_id == null && other.usr_id != null) || (this.usr_id != null && !this.usr_id.equals(other.usr_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplemrp.entity.Usr[usrId=" + usr_id + "]";
    }

}
