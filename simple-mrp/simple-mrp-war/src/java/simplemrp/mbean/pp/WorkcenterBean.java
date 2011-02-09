/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Workcenter;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author GSD008
 */
public class WorkcenterBean extends WorkcenterAttr{ 

        private List<Workcenter> lsWorkcenter;
        private boolean disbSave;
        private boolean disbDel;
        private boolean disbNew;
        private boolean disbWorkcenter;


    /** Creates a new instance of WorkcenterBean */
    public WorkcenterBean()throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbWorkcenter(false);
    }



   public List<Workcenter> getLsWorkcenter() {
       if(lsWorkcenter == null) {
           lsWorkcenter = new ArrayList<Workcenter>();
       }
        return lsWorkcenter;
    }

    public void setLsWorkcenter(List<Workcenter> lsWorkcenter) {
        this.lsWorkcenter = lsWorkcenter;
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

    public boolean isDisbWorkcenter() {
        return disbWorkcenter;
    }

    public void setDisbWorkcenter(boolean disbWorkcenter) {
        this.disbWorkcenter = disbWorkcenter;
    }

 public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter Workcenter Name");
        } else {
            checkKeyword(strKeyword);
        }
    }
  private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
            List<Workcenter> ls = ppFacade.searchWorkcenter(p_strKeyword);


            setLsWorkcenter(ls);
        }
    }
    public void doSelect(ActionEvent e) throws Exception {
        String strWorkcenter = FacesUtils.getRequestParameter("p_workcenter");
        checkWorkcenter(strWorkcenter);
    }
     public void doCheckWorkcenter(ActionEvent e) throws Exception {
          checkWorkcenter(StringUtil.prefixZero(getWc(), 7));

    }
      private void checkWorkcenter(String p_strWorkcenter) throws Exception {
          setMode(MODE_EDIT);
        setDisbWorkcenter(false);

        PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
        Workcenter workcenter = ppFacade.getWorkcenter(p_strWorkcenter);



        if(workcenter != null) {
            setWc(workcenter.getWc());
            setDescription(workcenter.getDescription());



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
        setDisbWorkcenter(true);



    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() {
        setWc(null);
        setDescription(null);



        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbWorkcenter(false);

        setMode(MODE_EDIT);


    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Workcenter workcenter = new Workcenter();
            workcenter.setWc(getWc());
            workcenter.setDescription(getDescription());




            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();

            if (getMode().equals(MODE_EDIT)) {



                ppFacade.editWorkcenter(workcenter);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkWorkcenter(workcenter.getWc());
                message("Save Complete");


            } else if (getMode().equals(MODE_NEW)) {


                String strNewWorkcenter = ppFacade.createWorkcenter(workcenter);
                checkWorkcenter(strNewWorkcenter);
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

       if (getWc() !=null) {
            Workcenter workcenter = new Workcenter();
            workcenter.setWc(getWc());
            PpFacadeRemote ppFacade = EJBLookup.getPpFacade();
           ppFacade.deleteWorkcenter(workcenter);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Workcenter");
        }

    }
}

