/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.co;


import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class SalemanAttr extends AbstractManageBean {

    private String mode;
    private String slsman;
    private String fname;
    private String lname;
    private String keyword;

    public String getSlsman() {
        return slsman;
    }

    public void setSlsman(String slsman) {
        this.slsman = slsman;
    }

   public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
     public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }




}
