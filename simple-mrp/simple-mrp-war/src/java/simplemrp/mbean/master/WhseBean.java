/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.master;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Whse;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;
/**
 *
 * @author GSD008
 */
public class WhseBean extends WhseAttr{

   private List<Whse> lsWhse;
        private boolean disbSave;
        private boolean disbDel;
        private boolean disbNew;
        private boolean disbWhse;


    /** Creates a new instance of WhseBean */
    public WhseBean()throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbWhse(false);
      
    }



   public List<Whse> getLsWhse() {
       if(lsWhse == null) {
           lsWhse = new ArrayList<Whse>();
       }
        return lsWhse;
    }

    public void setLsWhse(List<Whse> lsWhse) {
        this.lsWhse = lsWhse;
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

    public boolean isDisbWhse() {
        return disbWhse;
    }

    public void setDisbWhse(boolean disbWhse) {
        this.disbWhse = disbWhse;
    }

 public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter Whse Name");
        } else {
            checkKeyword(strKeyword);
        }
    }
  private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            List<Whse> ls = maFacade.searchWhse(p_strKeyword);


            setLsWhse(ls);
        }
    }
    public void doSelect(ActionEvent e) throws Exception {
        String strWhse = FacesUtils.getRequestParameter("p_whse");
        checkWhse(strWhse);
    }
     public void doCheckWhse(ActionEvent e) throws Exception {
          checkWhse(StringUtil.prefixZero(getWhse(), 7));

    }
      private void checkWhse(String p_strWhse) throws Exception {
          setMode(MODE_EDIT);
        setDisbWhse(false);

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Whse whse = maFacade.getWhse(p_strWhse);



        if(whse != null) {
            setWhse(whse.getWhse());
            setDescription(whse.getDescription());



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
        setDisbWhse(true);



    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() {
        setWhse(null);
        setDescription(null);



        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbWhse(false);

        setMode(MODE_EDIT);


    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Whse whse = new Whse();
            whse.setWhse(getWhse());
            whse.setDescription(getDescription());




            MaFacadeRemote maFacade = EJBLookup.getMaFacade();

            if (getMode().equals(MODE_EDIT)) {



                maFacade.editWhse(whse);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkWhse(whse.getWhse());
                message("Save Complete");


            } else if (getMode().equals(MODE_NEW)) {


                String strNewWhse = maFacade.createWhse(whse);
                checkWhse(strNewWhse);
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

       if (getWhse() !=null) {
            Whse whse = new Whse();
            whse.setWhse(getWhse());
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
           maFacade.deleteWhse(whse);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Whse");
        }

    }
}

