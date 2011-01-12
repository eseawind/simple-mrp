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
public class ForecastDemandBean extends ForecastDemandAttr {
    
    /** Creates a new instance of ForecastDemandBean */
    public ForecastDemandBean() {
        super();
    }
    
    public void doAdd(ActionEvent e){
        System.out.println("Add Receive");
    }

    public void doDelete(ActionEvent e){
        System.out.println("Delete Receive");
    }

}
