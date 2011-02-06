/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.master;


import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.mbean.AbstractManageBean;
/**
 *
 * @author GSD008
 */
public class LocAttr extends AbstractManageBean{

    private String mode;
    private String loc;
    private String whse;
    private String description;
    private String keyword;
     private List<SelectItem> lsWhse;
     public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
  public String getWhse() {
        return whse;
    }

    public void setWhse(String whse) {
        this.whse = whse;
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
 public List<SelectItem> getLsWhse() {
        if(lsWhse == null) {
            lsWhse = new ArrayList<SelectItem>();
        }

        return lsWhse;
    }

    public void setLsWhse(List<SelectItem> lsWhse) {
        this.lsWhse = lsWhse;
    }


}
