/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.master;


import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Uom;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;
/**
 *
 * @author GSD008
 */
public class UomBean extends UomAttr{


        private List<Uom> lsUom;
        private boolean disbSave;
        private boolean disbDel;
        private boolean disbNew;
        private boolean disbUom;


    /** Creates a new instance of UomBean */
    public UomBean()throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbUom(false);
    }



   public List<Uom> getLsUom() {
       if(lsUom == null) {
           lsUom = new ArrayList<Uom>();
       }
        return lsUom;
    }

    public void setLsUom(List<Uom> lsUom) {
        this.lsUom = lsUom;
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

    public boolean isDisbUom() {
        return disbUom;
    }

    public void setDisbUom(boolean disbUom) {
        this.disbUom = disbUom;
    }

 public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter Uom Name");
        } else {
            checkKeyword(strKeyword);
        }
    }
  private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            List<Uom> ls = maFacade.searchUom(p_strKeyword);


            setLsUom(ls);
        }
    }
    public void doSelect(ActionEvent e) throws Exception {
        String strUom = FacesUtils.getRequestParameter("p_uom");
        checkUom(strUom);
    }
     public void doCheckUom(ActionEvent e) throws Exception {
          checkUom(StringUtil.prefixZero(getUom(), 7));

    }
      private void checkUom(String p_strUom) throws Exception {
          setMode(MODE_EDIT);
        setDisbUom(false);

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Uom uom = maFacade.getUom(p_strUom);



        if(uom != null) {
            setUom(uom.getUom());
            setDescription(uom.getDescription());



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
        setDisbUom(true);



    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() {
        setUom(null);
        setDescription(null);



        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbUom(false);

        setMode(MODE_EDIT);


    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Uom uom = new Uom();
            uom.setUom(getUom());
            uom.setDescription(getDescription());




            MaFacadeRemote maFacade = EJBLookup.getMaFacade();

            if (getMode().equals(MODE_EDIT)) {



                maFacade.editUom(uom);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkUom(uom.getUom());
                message("Save Complete");


            } else if (getMode().equals(MODE_NEW)) {

            
                String strNewUom = maFacade.createUom(uom);
                checkUom(strNewUom);
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

       if (getUom() !=null) {
            Uom uom = new Uom();
            uom.setUom(getUom());
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
           maFacade.deleteUom(uom);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Uom");
        }

    }
}
