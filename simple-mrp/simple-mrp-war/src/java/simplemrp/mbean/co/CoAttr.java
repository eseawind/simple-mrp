/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.co;

import java.util.List;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Term;
import simplemrp.mbean.AbstractManageBean;

/**
 *
 * @author Golf
 */
public class CoAttr extends AbstractManageBean {
    private String searchCustName;

    protected String coId;
    protected String custId;
    protected String custName;
    protected String custPo;
    protected String duedate;
    protected String term;
    protected String costat;
    protected String slsman;
    protected String tax;
    protected String uuser;
    protected String cuser;
    protected String cdate;
    protected String udate;
    private List<Term> lsTerm;
    private List<Co_stat> lsCoStat;

    public String getSearchCustName() {
        return searchCustName;
    }

    public void setSearchCustName(String searchCustName) {
        this.searchCustName = searchCustName;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getCostat() {
        return costat;
    }

    public void setCostat(String costat) {
        this.costat = costat;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPo() {
        return custPo;
    }

    public void setCustPo(String custPo) {
        this.custPo = custPo;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getSlsman() {
        return slsman;
    }

    public void setSlsman(String slsman) {
        this.slsman = slsman;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getUuser() {
        return uuser;
    }

    public void setUuser(String uuser) {
        this.uuser = uuser;
    }

    public List<Co_stat> getLsCoStat() {
        return lsCoStat;
    }

    public void setLsCoStat(List<Co_stat> lsCoStat) {
        this.lsCoStat = lsCoStat;
    }

    public List<Term> getLsTerm() {
        return lsTerm;
    }

    public void setLsTerm(List<Term> lsTerm) {
        this.lsTerm = lsTerm;
    }
}
