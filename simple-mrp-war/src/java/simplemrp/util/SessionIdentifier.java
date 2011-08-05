/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.util;

/**
 *
 * @author Golf
 */
public class SessionIdentifier {
    private String m_user_id;
    private Boolean m_changepwd;

    public SessionIdentifier(String p_strUser_id) {
        m_user_id = p_strUser_id;
    }

    public String getUser_id() {
        return m_user_id;
    }

    public void setUser_id(String user_id) {
        this.m_user_id = user_id;
    }

    public Boolean getChangepwd() {
        return m_changepwd;
    }

    public void setChangepwd(Boolean changepwd) {
        this.m_changepwd = changepwd;
    }
}
