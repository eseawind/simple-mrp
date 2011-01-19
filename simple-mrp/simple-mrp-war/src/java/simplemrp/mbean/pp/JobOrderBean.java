/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import javax.faces.event.ActionEvent;


/**
 *
 * @author wisaruthkea
 */
public class JobOrderBean extends JobOrderAttr {

    /** Creates a new instance of JobOrderBean */
    public JobOrderBean() {
        super();
    }

      //operation
    public void doNew(ActionEvent e){
        System.out.println("New");
    }
    public void doSave(ActionEvent e){
        System.out.println("Save");
    }
    public void doDelete(ActionEvent e){
        System.out.println("Delete");
    }
}
