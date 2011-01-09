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
public class PoReceiveBean extends PoReceiveAttr {

    /** Creates a new instance of PoReceiveBean */
    public PoReceiveBean() {
        super();
    }
     public void doSaveCo(ActionEvent e){

        System.out.println("Save PO Receive");
    }

    public void doSearchCo(ActionEvent e){

        System.out.println("Search PO Receive");
    }

}
