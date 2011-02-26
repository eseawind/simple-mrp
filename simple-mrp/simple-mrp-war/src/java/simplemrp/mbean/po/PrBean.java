package simplemrp.mbean.po;

import simplemrp.constant.PoConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Pr;
import simplemrp.entity.Pr_stat;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Golf
 */
public class PrBean extends PrAttr {

    public PrBean() {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbPrId(false);
    }

    public void doNewPr(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbPrId(true);

        loadPrStat();

        setStat(PoConstant.PR_STAT_REQUEST);
    }

    public void doSavePr(ActionEvent e) throws Exception {
        try {
            Pr pr = new Pr();
            pr.setApprover(getApprover());
            pr.setNote(getNote());

            Pr_stat pr_stat = new Pr_stat();
            pr_stat.setStat(getStat());
            pr.setPrstat(pr_stat);

            pr.setReqDate(getReqDate());
            pr.setRequester(getRequester());

            pr.setUuser(getSessionUserId());

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();

            if(getMode().equals(MODE_EDIT)) {
                pr.setPrId(getPrId());
                
                poFacade.editPr(pr);

                checkPrId(pr.getPrId());

                if((getSearchPrId().trim().length() > 0) || (getSearchRequester().trim().length() > 0) || (getSearchReqDate() != null)) {
                    searchPr(getSearchPrId().trim(), getSearchRequester().trim(), getSearchReqDate());
                }

                message("Save Complete");

            } else if(getMode().equals(MODE_NEW)) {
                String strNewPrId = poFacade.createPr(pr);

                checkPrId(strNewPrId);

                if((getSearchPrId().trim().length() > 0) || (getSearchRequester().trim().length() > 0) || (getSearchReqDate() != null)) {
                    searchPr(getSearchPrId().trim(), getSearchRequester().trim(), getSearchReqDate());
                }

                message("Create Complete");

            } else {
                message("Unknown Operation Mode");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckPrId(ActionEvent e) throws Exception {
        checkPrId(StringUtil.prefixString(getPrId().trim(), 7));
    }

    private void checkPrId(String p_strPrId) throws Exception {
        try {
            setMode(MODE_EDIT);
            setDisbPrId(false);

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            Pr pr = poFacade.getPr(p_strPrId);

            if(pr != null) {
                setApprover(pr.getApprover());
                setNote(pr.getNote());
                setPrId(pr.getPrId());
                setStat(pr.getPrstat().getStat());
                setReqDate(pr.getReqDate());
                setRequester(pr.getRequester());

                setUuser(pr.getUuser());
                setCuser(pr.getCuser());
                setCdate(pr.getCdate());
                setUdate(pr.getUdate());
                
                setDisbNew(false);
                setDisbSave(false);
                if(pr.getPrstat().getStat().equals(PoConstant.PR_STAT_APPROVED)) {
                    setDisbDel(true);
                    setDisbAddDtl(true);
                } else {
                    setDisbDel(false);
                    setDisbAddDtl(false);
                }
                

                loadPritem(pr.getPrId());
                loadPrStat();
            } else {
                clearEditScreen();
                message("Find Not Found");
            }
        } catch(Exception e) {
            message(e.getMessage());
        }
    }

    public void doDeletePr(ActionEvent e) throws Exception {
        try {
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
           Pr pr = new Pr();
            pr.setPrId(getPrId());

            poFacade.deletePr(pr);

            clearEditScreen();

            message("Delete Complete");

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doSearchPR(ActionEvent e) throws Exception {
        String strSearchPrId= getSearchPrId().trim();
        String strSearchRequester= getSearchRequester().trim();
        Date dtSearchReqDate = getSearchReqDate();

        setSearchPrId(strSearchPrId);
        setSearchRequester(strSearchRequester);
        setSearchReqDate(dtSearchReqDate);

        if((strSearchPrId.length() == 0) && (strSearchRequester.length() == 0) && (dtSearchReqDate == null)) {
            message("Please Enter Search Condition");
        } else {
            searchPr(strSearchPrId, strSearchRequester, dtSearchReqDate);
        }
    }

    private void searchPr(String p_strPrId, String p_strRequester, Date p_dtReqDate) throws Exception {
        if((p_strPrId.length() > 0) || (p_strRequester.length() > 0) || (p_dtReqDate != null)) {
            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            List<Pr> lsPr = poFacade.searchPr(p_strPrId, p_strRequester, p_dtReqDate);

            setLsPr(lsPr);
        }
    }

    private void searchPritem(String p_strPrId) throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Pritem> lsPritem = poFacade.getPritemByPr(p_strPrId);

        setLsPrItem(lsPritem);
    }

    public void doClear(ActionEvent e) {
        clearEditScreen();
    }

    //table operation
    public void doSelectPr(ActionEvent e) {
        try {
            String strPr_id = FacesUtils.getRequestParameter("p_pr_id");
            checkPrId(strPr_id);
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void loadPrStat() throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Pr_stat> lsAllPrStat = poFacade.getListPr_stat();

        List lsPrStat = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllPrStat.size(); i++) {
            Pr_stat prStat = lsAllPrStat.get(i);
            SelectItem selectItem = new SelectItem(prStat.getStat(), prStat.getDescription());

            lsPrStat.add(selectItem);
        }

        setLsPrStat(lsPrStat);
    }

    private void loadPritem(String p_strPrId) throws Exception {
        PoFacadeRemote poFacade = EJBLookup.getPoFacade();
        List<Pritem> lsPritem = poFacade.getPritemByPr(p_strPrId);

        setLsPrItem(lsPritem);
    }

    private void clearEditScreen() {
        setApprover(null);
        setNote(null);
        setPrId(null);
        setStat(null);
        setReqDate(null);
        setRequester(null);

        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbPrId(false);

        setMode(MODE_EDIT);
        setLsPrItem(null);
        setLsPrStat(null);
    }

    public void doDeletePritem(ActionEvent e) {
        try {
            String strP_pr_id = FacesUtils.getRequestParameter("p_pr_id");
            Integer intP_pr_seq = StringUtil.toInteger(FacesUtils.getRequestParameter("p_pr_seq"));

            PritemPK pritemPK = new PritemPK(strP_pr_id, intP_pr_seq);
            Pritem pritem = new Pritem();
            pritem.setPritemPK(pritemPK);

            PoFacadeRemote poFacade = EJBLookup.getPoFacade();
            poFacade.deletePritem(pritem);

            loadPritem(pritemPK.getPrId());

            message("Delete Comlete");
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
