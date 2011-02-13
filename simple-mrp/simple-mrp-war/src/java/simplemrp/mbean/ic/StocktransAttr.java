/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.ic;
import simplemrp.mbean.AbstractManageBean;
import java.util.Date;
import java.util.List;
import simplemrp.entity.Stocktrans;
/**
 *
 * @author GSD008
 */
public class StocktransAttr extends AbstractManageBean{

  private String mode;

   private String searchTransItem;
        private Date searchTransDateFrom;
        private Date searchTransDateTo;

        private Integer transId;
        private Character item;
        private Character whse;
        private Character loc;
        private Character transType;
        private Date transDate;
        private String refId;
        private Integer refSeq;
        private double qty;
        private String cuser;
        private Date cdate;
    private List<Stocktrans> lsStocktrans;



public List<Stocktrans> getLsStocktrans() {
        return lsStocktrans;
    }

    public void setLsStocktrans(List<Stocktrans> lsStocktrans) {
        this.lsStocktrans = lsStocktrans;
    }

   

  public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

     public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

       public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    public String getSearchTransItem() {
        return searchTransItem;
    }

      public void setSearchTransItem(String searchTransItem) {
        this.searchTransItem = searchTransItem;
    }
        public Date getSearchTransDateFrom() {
        return searchTransDateFrom;
    }

    public void setSearchTransDateFrom(Date searchTransDateFrom) {
        this.searchTransDateFrom = searchTransDateFrom;
    }
      public Date getSearchTransDateTo() {
        return searchTransDateTo;
    }

    public void setsearchTransDateTo(Date searchTransDateTo) {
        this.searchTransDateTo = searchTransDateTo;
    }

      public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

       public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

     public Character getItem() {
        return item;
    }

    public void setItem(Character item) {
        this.item = item;
    }

     public Character getWhse() {
        return whse;
    }

    public void setWhse(Character whse) {
        this.whse = whse;
    }

     public Character getLoc() {
        return loc;
    }

    public void setLoc(Character loc) {
        this.loc = loc;
    }

     public Character getTransType() {
        return transType;
    }

    public void setTransType(Character transType) {
        this.transType = transType;
    }

      public  Integer  getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }
      public  Integer  getRefSeq() {
        return refSeq;
    }

    public void setRefSeq(Integer refSeq) {
        this.refSeq = refSeq;
    }

 public  double   getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

}
