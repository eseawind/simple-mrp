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
public class ItemLocationBean extends ItemLocationAttr {

    /** Creates a new instance of ItemLocationBean */
    public ItemLocationBean() {
        super();
    }
     //operation
    public void doSearch(ActionEvent e){
        System.out.println("Search CO Shipping");
        //TODO set value to lsCoItem;
    }

}
