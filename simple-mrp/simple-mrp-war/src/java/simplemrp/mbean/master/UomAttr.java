/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.master;


import simplemrp.mbean.AbstractManageBean;
/**
 *
 * @author GSD008
 */
public class UomAttr extends AbstractManageBean{

    private String mode;
    private String uom;
    private String description;
    private String keyword;

     public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

   public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
