/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean;


/**
 *
 * @author Golf
 */
public class ConstantBean {
    public final String PATTERN_DATE = "dd/MM/yyyy";
    public final String TIMEZONE = "Asia/Bangkok";

    /** Creates a new instance of ConstantBean */
    public ConstantBean() {
    }

    public String getPATTREN_DATE() {
        return PATTERN_DATE;
    }

    public String getTIMEZONE() {
        return TIMEZONE;
    }
}
