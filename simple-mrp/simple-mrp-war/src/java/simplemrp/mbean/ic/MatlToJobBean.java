/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;

import javax.faces.event.ActionEvent;

/**
 *
 * @author wisaruthkea
 */
public class MatlToJobBean extends MatlToJobAttr {
    
    /** Creates a new instance of MatlToJobBean */
    public MatlToJobBean() {
        super();
    }
    public void doSave(ActionEvent e){
        System.out.println("do save");
    }
    public void doSearch(ActionEvent e){
        System.out.println("do search");
    }

}
