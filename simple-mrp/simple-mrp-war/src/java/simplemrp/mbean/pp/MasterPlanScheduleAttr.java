/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Mps_stat;
import simplemrp.entity.Mps_type;

/**
 *
 * @author wisaruthkea
 */
public class MasterPlanScheduleAttr {
    //รหัสแผนการผลิต
    private String mpsId;
    //รหัสสินค้า
    private String itemName;
    //ชนิดของเอกสารอ้างอิง
    private String mpsType;
    //รหัสเอกสาร
    private String refId;
    //ลำดับเอกสาร
    private String refSeqInt;
    //วันที่ส่งของ
    private Date dueDate;
    //จำนวนที่ต้องการ
    private int qty;
    //สถานะ
    private String mpsStat;
    
    private String cUser;
    private Date cDate;
    private String uUser;
    private Date uDate;

    //resource
    private List<Mps_type> lsMpsType;
    private List<Mps_stat> lsMpsStat;

    public MasterPlanScheduleAttr(){
        lsMpsType = new ArrayList<Mps_type>();
        lsMpsStat = new ArrayList<Mps_stat>();
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
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the mpsType
     */
    public String getMpsType() {
        return mpsType;
    }

    /**
     * @param mpsType the mpsType to set
     */
    public void setMpsType(String mpsType) {
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
    public String getRefSeqInt() {
        return refSeqInt;
    }

    /**
     * @param refSeqInt the refSeqInt to set
     */
    public void setRefSeqInt(String refSeqInt) {
        this.refSeqInt = refSeqInt;
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
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the mpsStat
     */
    public String getMpsStat() {
        return mpsStat;
    }

    /**
     * @param mpsStat the mpsStat to set
     */
    public void setMpsStat(String mpsStat) {
        this.mpsStat = mpsStat;
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
     * @return the lsMpsType
     */
    public List<Mps_type> getLsMpsType() {
        return lsMpsType;
    }

    /**
     * @param lsMpsType the lsMpsType to set
     */
    public void setLsMpsType(List<Mps_type> lsMpsType) {
        this.lsMpsType = lsMpsType;
    }

    /**
     * @return the lsMpsStat
     */
    public List<Mps_stat> getLsMpsStat() {
        return lsMpsStat;
    }

    /**
     * @param lsMpsStat the lsMpsStat to set
     */
    public void setLsMpsStat(List<Mps_stat> lsMpsStat) {
        this.lsMpsStat = lsMpsStat;
    }


}
