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
public class CustOrderShippingBean extends CustOrderShippingAttr {
    public CustOrderShippingBean(){
        super();
    }
    
     //operation

    public void doSave(ActionEvent e){
         System.out.println("Save CO Shipping");
        for(CoShipItemBean item:super.getLsCoShipItemBean()){
            System.out.println("item id="+item.getItem()+",selectedWarehouse="+item.getSelectedWarehouse());
        }
       
    }
    public void doSearch(ActionEvent e){
        System.out.println("Search CO Shipping");
        //TODO set value to lsCoItem;
    }
    
}
