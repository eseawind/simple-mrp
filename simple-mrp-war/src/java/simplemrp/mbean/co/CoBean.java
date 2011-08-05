/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.mbean.co;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Co;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Customer;
import simplemrp.entity.Slsman;
import simplemrp.entity.Tax;
import simplemrp.entity.Term;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.constant.CoConstant;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;
import simplemrp.constant.MasterConstant;

/**
 *
 * @author wisaruthkea
 */
public class CoBean extends CoAttr {

    //select resource
    public CoBean() {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbCoID(false);
    }

    //operation
    public void doNewCo(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_NEW);

        setDisbNew(true);
        setDisbSave(false);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbCoID(true);

        loadCoStat();
        loadTerm();
        loadTax();

        setCostat(CoConstant.CO_STAT_ORDER);
        setTerm(MasterConstant.TERM_CASH);
    }

    public void doSaveCo(ActionEvent e) throws Exception {
        try {
            if(getCustId().trim().length() == 0) {
                throw new Exception("Please enter customer ID");
            }

            if(getOrderdate() == null) {
                throw new Exception("Please enter orderdate");
            }

            if(getDuedate() == null) {
                throw new Exception("Please enter duedate");
            }

            if(getSlsman().trim().length() == 0) {
                throw new Exception("Please enter saleman");
            }

            Co co = new Co();
            co.setCoId(getCoId());
            co.setCustPo(getCustPo());
            co.setOrderdate(getOrderdate());
            co.setDuedate(getDuedate());

            Term term = new Term();
            term.setTermId(getTerm());
            co.setTerm(term);

            Tax tax = new Tax();
            tax.setTaxId(getTax());
            co.setTax(tax);

            Co_stat co_stat = new Co_stat();
            co_stat.setStat(getCostat());
            co.setCostat(co_stat);

            Slsman slsman = new Slsman();
            slsman.setSlsman(getSlsman());
            co.setSlsman(slsman);

            Customer customer = new Customer();
            customer.setCustId(getCustId());
            co.setCustomer(customer);

            co.setUuser(getSessionUserId());

            CoFacadeRemote coFacade = EJBLookup.getCoFacade();

            if(getMode().equals(MODE_EDIT)) {
                coFacade.editCo(co);

                checkCoId(co.getCoId());

                if(getSearchCustId().trim().length() > 0) {
                    searchCO(getSearchCustId().trim());
                }

                message("Save Complete");

            } else if(getMode().equals(MODE_NEW)) {
                String strNewCoId = coFacade.createCo(co);

                checkCoId(strNewCoId);

                if(getSearchCustId().trim().length() > 0) {
                    searchCO(getSearchCustId().trim());
                }

                message("Create Complete");

            } else {
                message("Unknown Operation Mode");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckCoId(ActionEvent e) throws Exception {
        checkCoId(StringUtil.prefixString(getCoId().trim(), 7));
    }

    private void checkCoId(String p_strCoId) throws Exception {
        try {
            setMode(MODE_EDIT);
            setDisbCoID(false);

            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            Co co = coFacade.getCo(p_strCoId);

            if(co != null) {
                setCoId(co.getCoId());
                setCustId(co.getCustomer().getCustId());
                setCustName(co.getCustomer().getName());
                setCustPo(co.getCustPo());
                setOrderdate(co.getOrderdate());
                setDuedate(co.getDuedate());
                setTerm(co.getTerm().getTermId());
                setCostat(getCostat());
                setSlsman(co.getSlsman().getSlsman());
                setTax(co.getTax().getTaxId());
                setUuser(co.getUuser());
                setCuser(co.getCuser());
                setCdate(co.getCdate());
                setUdate(co.getUdate());

                setDisbNew(false);
                setDisbSave(false);
                setDisbDel(false);
                setDisbAddDtl(false);

                loadCoitem(co.getCoId());
                loadCoStat();
                loadTerm();
                loadTax();
            } else {
                clearEditScreen();
                message("Find Not Found");
            }
        } catch(Exception e) {
            message(e.getMessage());
        }
    }

    public void doCheckCusId(ActionEvent e) throws Exception {
        checkCustId(getCustId().trim());
    }

    private void checkCustId(String p_strCustId) {
        try {
            p_strCustId = StringUtil.prefixZero(p_strCustId, 7);
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            Customer customer = coFacade.getCustomer(p_strCustId);

            if(customer == null) {
                setCustId(null);
                setCustName(null);

                message("Find Not Found");

            } else {
                setCustId(customer.getCustId());
                setCustName(customer.getName());
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckSlsman(ActionEvent e) throws Exception {
        checkSlsman(StringUtil.prefixString(getSlsman().trim(), 7));
        
    }

    private void checkSlsman(String p_strSlsman) {
        try {
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            Slsman slsman = coFacade.getSlsman(p_strSlsman);

            if(slsman == null) {
                setSlsman(null);
                message("Find Not Found");
            } else {
                setSlsman(slsman.getSlsman());
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doDeleteCo(ActionEvent e) throws Exception {
        try {
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            Co co = new Co();
            co.setCoId(getCoId());

            coFacade.deleteCo(co);

            clearEditScreen();

            message("Delete Complete");

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doSearchCo(ActionEvent e) throws Exception {
        String strSearchCustId = getSearchCustId().trim();

        strSearchCustId = StringUtil.prefixZero(strSearchCustId, 7);

        setSearchCustId(strSearchCustId);

        if((strSearchCustId.length() == 0)) {
            message("Please Enter Customer ID");
        } else {
            searchCO(strSearchCustId);
        }
    }

    private void searchCO(String p_strCustId) throws Exception {
        if(p_strCustId.length() > 0) {
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            List<Co> lsCo = coFacade.searchCo(p_strCustId);

            setLsCo(lsCo);
        }
    }

    private void searchCoitem(String p_strCoId) throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Coitem> lsCoitem = coFacade.getCoitemByCo(p_strCoId);

        setLsCoItem(lsCoitem);
    }

    public void doClear(ActionEvent e) {
        clearEditScreen();
    }

    //table operation
    public void doSelectCo(ActionEvent e) {
        try {
            String strCo_id = FacesUtils.getRequestParameter("p_co_id");
            checkCoId(strCo_id);
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void loadTerm() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Term> lsAllTerm = maFacade.getListTerm();

        List lsTerm = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllTerm.size(); i++) {
            Term term = lsAllTerm.get(i);
            SelectItem selectItem = new SelectItem(term.getTermId(), term.getDescription());

            lsTerm.add(selectItem);
        }

        setLsTerm(lsTerm);
    }

    private void loadTax() throws Exception {
        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        List<Tax> lsAllTax = maFacade.getListTax();

        List lsTax = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllTax.size(); i++) {
            Tax tax = lsAllTax.get(i);
            SelectItem selectItem = new SelectItem(tax.getTaxId(), tax.getDescription());

            lsTax.add(selectItem);
        }

        setLsTax(lsTax);
    }

    private void loadCoStat() throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Co_stat> lsAllCoStat = coFacade.getListCo_stat();

        List lsCoStat = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllCoStat.size(); i++) {
            Co_stat coStat = lsAllCoStat.get(i);
            SelectItem selectItem = new SelectItem(coStat.getStat(), coStat.getDescription());

            lsCoStat.add(selectItem);
        }

        setLsCoStat(lsCoStat);
    }

    private void loadCoitem(String p_strCoId) throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Coitem> lsCoitem = coFacade.getCoitemByCo(p_strCoId);

        setLsCoItem(lsCoitem);
    }

    private void clearEditScreen() {
        setCoId(null);
        setCustId(null);
        setCustName(null);
        setCustPo(null);
        setOrderdate(null);
        setDuedate(null);
        setTerm(null);
        setCostat(null);
        setSlsman(null);
        setTax(null);
        setUuser(null);
        setCuser(null);
        setCdate(null);
        setUdate(null);

        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbAddDtl(true);
        setDisbCoID(false);

        setMode(MODE_EDIT);
        setLsCoItem(null);
        setLsCoStat(null);
        setLsTerm(null);
        setLsTax(null);
    }

    public void doDeleteCoitem(ActionEvent e) {
        try {
            String strP_co_id = FacesUtils.getRequestParameter("p_co_id");
            Integer intP_co_seq = StringUtil.toInteger(FacesUtils.getRequestParameter("p_co_seq"));

            CoitemPK coitemPK = new CoitemPK(strP_co_id, intP_co_seq);
            Coitem coitem = new Coitem();
            coitem.setCoitemPK(coitemPK);

            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            coFacade.deleteCoitem(coitem);

            loadCoitem(coitemPK.getCoId());

            if(getSearchCustId().trim().length() > 0) {
                searchCO(getSearchCustId().trim());
            }


            message("Delete Comlete");
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
