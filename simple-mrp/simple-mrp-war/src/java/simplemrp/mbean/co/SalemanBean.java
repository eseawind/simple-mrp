/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.co;

import java.util.List;
import javax.faces.event.ActionEvent;
import simplemrp.entity.Slsman;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.util.BindingName;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;


/**
 *
 * @author wisaruthkea
 */
public class SalemanBean {
    private final static String MODE_NEW = "NEW";
    private final static String MODE_EDIT = "EDIT";
    private String mode;
    private String firstName;
    private String lastName;
    private String keyword;
    private List<Slsman> lsSaleman;

    /** Creates a new instance of SalemanBean */
    public SalemanBean() {
    }

    //ACTION
    public void doSelect(ActionEvent e){
        System.out.println("doSelect");
    }
    public void doSearch(ActionEvent e) throws Exception{
        FacesUtils.addErrorMessage("hello message");
        System.out.println("doSearch Saleman");
        CoFacadeRemote coFacade = (CoFacadeRemote)EJBLookup.getEJBInstance(BindingName.CoFacadeRemote);
        //CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Slsman> ls = coFacade.searchSaleman(getKeyword());
        setLsSaleman(ls);
    }
    public void doEdit(ActionEvent e){
        System.out.println("doEdit");
    }
    public void doTest(ActionEvent e){
        System.out.println("Dooooooooo Tessttttt...");
        //NewSessionBeanRemote nsb = (NewSessionBeanRemote)EJBLookup.getEJBInstance(NewSessionBeanRemote.class.getName());
        //nsb.ListSaleman();
        
    }
    
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Slsman> getLsSaleman() {
        return lsSaleman;
    }

    public void setLsSaleman(List<Slsman> lsSaleman) {
        this.lsSaleman = lsSaleman;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
