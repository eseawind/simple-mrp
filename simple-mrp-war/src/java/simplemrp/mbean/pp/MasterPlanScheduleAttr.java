/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import simplemrp.entity.Mps;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author wisaruthkea
 */
public class MasterPlanScheduleAttr extends AbstractManageBean {
    private String mode;
    private String mpsId;
    private String itemId;
    private Character mpsType;
    private String refId;
    private Integer refSeq;
    private Date dueDate;
    private Integer qty;
    private Character mpsStat;
    
    private String cUser;
    private Date cDate;
    private String uUser;
    private Date uDate;

    private String releaser;

    //search key
    private Date searchCreateDate;
    
    
    //search result
    private List<Mps> lsMps;
    
    //resource
    private List<SelectItem> lsMpsType;
    private List<SelectItem> lsMpsStat;

    //button operation
    private boolean dsbGen;
    private boolean dsbNew;
    private boolean dsbSave;
    private boolean dsbDelete;

    public MasterPlanScheduleAttr(){
        lsMps = new ArrayList<Mps>();
        lsMpsType = new ArrayList<SelectItem>();
        lsMpsStat = new ArrayList<SelectItem>();
    }

    /**
     * @return the mpsId
     */
    public String getMpsId() {
        return mpsId;
    }

    /**
     * @param mpsId the mpsId to set
     */
    public void setMpsId(String mpsId) {
        this.mpsId = mpsId;
    }

    /**
     * @return the itemName
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the mpsType
     */
    public Character getMpsType() {
        return mpsType;
    }

    /**
     * @param mpsType the mpsType to set
     */
    public void setMpsType(Character mpsType) {
        this.mpsType = mpsType;
    }

    /**
     * @return the refId
     */
    public String getRefId() {
        return refId;
    }

    /**
     * @param refId the refId to set
     */
    public void setRefId(String refId) {
        this.refId = refId;
    }

    /**
     * @return the refSeqInt
     */
    public Integer getRefSeq() {
        return refSeq;
    }

    /**
     * @param refSeqInt the refSeqInt to set
     */
    public void setRefSeqInt(Integer refSeqInt) {
        this.refSeq = refSeqInt;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }


    /**
     * @return the cUser
     */
    public String getcUser() {
        return cUser;
    }

    /**
     * @param cUser the cUser to set
     */
    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    /**
     * @return the cDate
     */
    public Date getcDate() {
        return cDate;
    }

    /**
     * @param cDate the cDate to set
     */
    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    /**
     * @return the uUser
     */
    public String getuUser() {
        return uUser;
    }

    /**
     * @param uUser the uUser to set
     */
    public void setuUser(String uUser) {
        this.uUser = uUser;
    }

    /**
     * @return the uDate
     */
    public Date getuDate() {
        return uDate;
    }

    /**
     * @param uDate the uDate to set
     */
    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }


    /**
     * @return the lsMps
     */
    public List<Mps> getLsMps() {
        return lsMps;
    }

    /**
     * @param lsMps the lsMps to set
     */
    public void setLsMps(List<Mps> lsMps) {
        this.lsMps = lsMps;
    }

    /**
     * @return the searchDueDate
     */
    public Date getSearchCreateDate() {
        return searchCreateDate;
    }

    /**
     * @param searchDueDate the searchDueDate to set
     */
    public void setSearchCreateDate(Date searchCreateDate) {
        this.searchCreateDate = searchCreateDate;
    }

    /**
     * @param mpsStat the mpsStat to set
     */
    public void setMpsStat(Character mpsStat) {
        this.mpsStat = mpsStat;
    }

    /**
     * @return the mpsStat
     */
    public Character getMpsStat() {
        return mpsStat;
    }

    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return the lsMpsType
     */
    public List<SelectItem> getLsMpsType() {
        return lsMpsType;
    }

    /**
     * @param lsMpsType the lsMpsType to set
     */
    public void setLsMpsType(List<SelectItem> lsMpsType) {
        this.lsMpsType = lsMpsType;
    }

    /**
     * @return the lsMpsStat
     */
    public List<SelectItem> getLsMpsStat() {
        return lsMpsStat;
    }

    /**
     * @param lsMpsStat the lsMpsStat to set
     */
    public void setLsMpsStat(List<SelectItem> lsMpsStat) {
        this.lsMpsStat = lsMpsStat;
    }

    /**
     * @return the dsbNew
     */
    public boolean isDsbNew() {
        return dsbNew;
    }

    /**
     * @param dsbNew the dsbNew to set
     */
    public void setDsbNew(boolean dsbNew) {
        this.dsbNew = dsbNew;
    }

    /**
     * @return the dsbSave
     */
    public boolean isDsbSave() {
        return dsbSave;
    }

    /**
     * @param dsbSave the dsbSave to set
     */
    public void setDsbSave(boolean dsbSave) {
        this.dsbSave = dsbSave;
    }

    /**
     * @return the dsbDelete
     */
    public boolean isDsbDelete() {
        return dsbDelete;
    }

    /**
     * @param dsbDelete the dsbDelete to set
     */
    public void setDsbDelete(boolean dsbDelete) {
        this.dsbDelete = dsbDelete;
    }

    public String getReleaser() {
        return releaser;
    }

    public void setReleaser(String releaser) {
        this.releaser = releaser;
    }

//    public boolean isDsbGen() {
//        dsbGen = true;
//
//        try {
//            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
//            Usr usr =maFacade.getUsr(getSessionUserId());
//
//            if(usr.getGen_mps() != null) && (usr.getGen_mps().equals('Y'))) {
//                dsbGen = false;
//            }
//        } catch(Exception ex) {
//            dsbGen = true;
//        }
//
//
//        return dsbGen;
//    }

//    public void setDsbGen(boolean dsbGen) {
//        this.dsbGen = dsbGen;
//    }
}
