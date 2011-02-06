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
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;
import simplemrp.entity.Whse;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author GSD008
 */
public class LocBean extends LocAttr {

    private List<Loc> lsLoc;
    private boolean disbSave;
    private boolean disbDel;
    private boolean disbNew;
    private boolean disbLoc;

    /** Creates a new instance of LocBean */
    public LocBean() throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbLoc(false);
        loadWhse();
    }
private void loadWhse() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Whse> lsAllWhse = maFacade.getListWhse();

        List lsWhse = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllWhse.size(); i++) {
            Whse whse = lsAllWhse.get(i);
            SelectItem selectItem = new SelectItem(whse.getWhse(), whse.getDescription());

            lsWhse.add(selectItem);
        }

        setLsWhse(lsWhse);
    }
    public List<Loc> getLsLoc() {
        if (lsLoc == null) {
            lsLoc = new ArrayList<Loc>();
        }
        return lsLoc;
    }

    public void setLsLoc(List<Loc> lsLoc) {
        this.lsLoc = lsLoc;
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

    public boolean isDisbLoc() {
        return disbLoc;
    }

    public void setDisbLoc(boolean disbLoc) {
        this.disbLoc = disbLoc;
    }

    public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter Location Name");
        } else {
            checkKeyword(strKeyword);
        }
    }

    private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            List<Loc> ls = maFacade.searchLoc(p_strKeyword);


            setLsLoc(ls);
        }
    }

    public void doSelect(ActionEvent e) throws Exception {
         String strLoc = FacesUtils.getRequestParameter("p_loc");
         String strWhse = FacesUtils.getRequestParameter("p_whse");
        checkLoc(strLoc ,strWhse);
    }

    public void doCheckLoc(ActionEvent e) throws Exception {
      

    }

    private void checkLoc(String p_strLoc,String p_strWhse) throws Exception {
        setMode(MODE_EDIT);
        setDisbLoc(false);

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        LocPK locPK = new LocPK();
        locPK.setLoc(p_strLoc);
        locPK.setWhse(p_strWhse);
        Loc loc = maFacade.getLoc(locPK);

        if (loc != null) {
               setLoc(loc.getLocPK().getLoc());
               setWhse(loc.getLocPK().getWhse());
               setDescription(loc.getDescription());

            setDisbNew(false);
            setDisbSave(false);
            setDisbDel(false);
            loadWhse();

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
        setDisbLoc(true);



    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() throws Exception {
        setLoc(null);
        setWhse(null);
        setDescription(null);



        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbLoc(false);

        setMode(MODE_EDIT);

        loadWhse();


    }

    public void doSave(ActionEvent e) throws Exception {
        try {

            Loc loc = new Loc();
            LocPK locPK = new LocPK();
            locPK.setLoc(getLoc().trim().toUpperCase());
            locPK.setWhse(getWhse());
            loc.setLocPK(locPK);
            loc.setDescription(getDescription());

            MaFacadeRemote maFacade = EJBLookup.getMaFacade();

            if (getMode().equals(MODE_EDIT)) {
                maFacade.editLoc(loc);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkLoc(loc.getLocPK().getLoc(),loc.getLocPK().getWhse());
                message("Save Complete");


            } else if (getMode().equals(MODE_NEW)) {
                maFacade.createLoc(loc);
                checkLoc(loc.getLocPK().getLoc(),loc.getLocPK().getWhse());
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

        if (getLoc() != null) {
            Loc loc = new Loc();
            LocPK locPK = new LocPK();
            locPK.setLoc(getLoc().trim().toUpperCase());
            locPK.setWhse(getWhse());
            loc.setLocPK(locPK);

            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            maFacade.deleteLoc(loc);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Location");
        }

    }
}
