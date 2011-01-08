/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.po;

import javax.faces.event.ActionEvent;

/**
 *
 * @author kajook
 */
public class PurchaseRequisitionBean extends PurchaseRequisitionAttr {
    public PurchaseRequisitionBean(){
        super();
    }
     //operation
    public void doNew(ActionEvent e){

        System.out.println("New PR");
    }
    public void doSave(ActionEvent e){

        System.out.println("Save PR");
    }
    public void doDelete(ActionEvent e){

        System.out.println("Delete PR");
    }
    public void doSearch(ActionEvent e){

        System.out.println("Select PR");
    }
    public void doClear(ActionEvent e){
        System.out.println("Clear PR");
    }

    //search result table operation
    public void doSelect(ActionEvent e){
        System.out.println("Select PR");
    }
}
