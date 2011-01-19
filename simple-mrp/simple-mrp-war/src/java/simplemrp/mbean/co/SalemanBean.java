/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.co;

import java.util.List;
import javax.faces.event.ActionEvent;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Slsman;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;


/**
 *
 * @author wisaruthkea
 */
public class SalemanBean extends SalemanAttr {
    
   
    private List<Slsman> lsSlsman;

     private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;
       private boolean disbSlsman_id;


    /** Creates a new instance of SalemanBean */
    public SalemanBean()throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbSlsman_id(false);
    }



   public List<Slsman> getLsSlsman() {

        return lsSlsman;
    }

    public void setLsSlsman(List<Slsman> lsSlsman) {
        this.lsSlsman = lsSlsman;
    }




    public boolean isDisbDel() {
        return disbDel;
    }

    public void setDisbDel(boolean disbDel) {
        this.disbDel = disbDel;
    }

    public boolean isDisbNew() {
        return disbNew;
    }

    public void setDisbNew(boolean disbNew) {
        this.disbNew = disbNew;
    }

    public boolean isDisbSave() {
        return disbSave;
    }

    public void setDisbSave(boolean disbSave) {
        this.disbSave = disbSave;
    }

    public boolean isDisbSlsman_id() {
        return disbSlsman_id;
    }

    public void setDisbSlsman_id(boolean disbSlsman_id) {
        this.disbSlsman_id = disbSlsman_id;
    }

 public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter SaleMan Name");
        } else {
            checkKeyword(strKeyword);
        }
    }
  private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            List<Slsman> ls = coFacade.searchSlsman(p_strKeyword);


            setLsSlsman(ls);
        }
    }
    public void doSelect(ActionEvent e) throws Exception {
        String strSlsman_id = FacesUtils.getRequestParameter("p_slsman_id");
        checkSlsman_id(strSlsman_id);
    }
     public void doCheckSlsman_id(ActionEvent e) throws Exception {
          checkSlsman_id(StringUtil.zeroLeading(getSlsman(), 7));

    }
      private void checkSlsman_id(String p_strSlsman_id) throws Exception {
          setMode(MODE_EDIT);
        setDisbSlsman_id(false);

        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        Slsman slsman = coFacade.getSlsman(p_strSlsman_id);

      

        if(slsman != null) {
            setSlsman(slsman.getSlsman());
            setFname(slsman.getFname());
            setLname(slsman.getLname());


            setDisbNew(false);
            setDisbSave(false);
            setDisbDel(false);


        } else {
            clearEditScreen();

        }
    }


  public void doNew(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);
        setDisbSlsman_id(true);



    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() {
        setSlsman(null);
        setFname(null);
        setLname(null);


        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbSlsman_id(false);

        setMode(MODE_EDIT);


    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Slsman slsman = new Slsman();
            slsman.setSlsman(getSlsman());
            slsman.setFname(getFname());
            slsman.setLname(getLname());




            CoFacadeRemote coFacade = EJBLookup.getCoFacade();

            if (getMode().equals(MODE_EDIT)) {

              //  slsman.setUuser(getUuser());

                coFacade.editSlsman(slsman);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkSlsman_id(slsman.getSlsman());
                message("Save Complete");


            } else if (getMode().equals(MODE_NEW)) {

              //   slsman.setCuser(getCuser());

                String strNewSlsman_id = coFacade.createSlsman(slsman);
                checkSlsman_id(strNewSlsman_id);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                message("Create Complete");
            } else {
                FacesUtils.addInfoMessage("Unknown Operation Mode");
            }
        } catch (Exception ex) {
            FacesUtils.addInfoMessage(ex.getMessage());
        }
    }

    public void doDelete(ActionEvent e) throws Exception {
        
       if (getSlsman().length() == 7) {
            Slsman slsman = new Slsman();
            slsman.setSlsman(getSlsman());
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            coFacade.deleteSlsman(slsman);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Customer ID");
        }

    }

}
