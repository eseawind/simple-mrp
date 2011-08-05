/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.mbean.master;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Product;
import simplemrp.entity.Uom;

import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;
/**
 *
 * @author GSD008
 */
public class ProductBean extends ProductAttr{

       private List<Product> lsProduct;
        private boolean disbSave;
        private boolean disbDel;
        private boolean disbNew;
        private boolean disbProduct;



         /** Creates a new instance of ProductBean */


        public ProductBean()throws Exception {
        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbProduct(false);
    }



   public List<Product> getLsProduct() {
       if(lsProduct == null) {
           lsProduct = new ArrayList<Product>();
       }
        return lsProduct;
    }

    public void setLsProduct(List<Product> lsProduct) {
        this.lsProduct = lsProduct;
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

    public boolean isDisbProduct() {
        return disbProduct;
    }

    public void setDisbProduct(boolean disbProduct) {
        this.disbProduct = disbProduct;
    }

 public void doSearch(ActionEvent e) throws Exception {
        String strKeyword = getKeyword().trim();
        if (strKeyword.length() == 0) {
            FacesUtils.addInfoMessage("Please Enter Product Name");
        } else {
            checkKeyword(strKeyword);
        }
    }
  private void checkKeyword(String p_strKeyword) throws Exception {
        if (p_strKeyword.length() > 0) {
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
         List<Product> ls = maFacade.searchProduct(p_strKeyword);


            setLsProduct(ls);
        }
    }
    public void doSelect(ActionEvent e) throws Exception {
        String strProduct = FacesUtils.getRequestParameter("p_product");
        checkProduct(strProduct);
    }
     public void doCheckProduct(ActionEvent e) throws Exception {
          checkProduct(StringUtil.prefixZero(getProduct(), 7));

    }
      private void checkProduct(String p_strProduct) throws Exception {

          setMode(MODE_EDIT);
        setDisbProduct(false);

        MaFacadeRemote maFacade = EJBLookup.getMaFacade();
        Product product = maFacade.getProduct(p_strProduct);




        if(product != null) {
            setProduct(product.getProduct());
            setDescription(product.getDescription());



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
        setDisbProduct(true);



    }

    public void doClear(ActionEvent e) throws Exception {
        clearEditScreen();
        setMode(MODE_EDIT);
    }

    public void clearEditScreen() {
        setProduct(null);
        setDescription(null);



        setDisbNew(false);
        setDisbSave(true);
        setDisbDel(true);
        setDisbProduct(false);

        setMode(MODE_EDIT);


    }

    public void doSave(ActionEvent e) throws Exception {
        try {
            Product product = new Product();
           product.setProduct(getProduct());
            product.setDescription(getDescription());




            MaFacadeRemote maFacade = EJBLookup.getMaFacade();

            if (getMode().equals(MODE_EDIT)) {



                maFacade.editProduct(product);
                if (getKeyword().trim().length() > 0) {
                    checkKeyword(getKeyword().trim());
                }
                checkProduct(product.getProduct());
                message("Save Complete");


            } else if (getMode().equals(MODE_NEW)) {


                String strNewProduct = maFacade.createProduct(product);
                checkProduct(strNewProduct);
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

       if (getProduct() !=null) {
            Product product = new Product();
            product.setProduct(getProduct());
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
           maFacade.deleteProduct(product);

            clearEditScreen();
            if (getKeyword().trim().length() > 0) {
                checkKeyword(getKeyword().trim());
            }

            message("Delete Complete");
        } else {
            message("Please Enter Product");
        }

    }
}
