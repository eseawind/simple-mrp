/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simplemrp.entity.Item;
import simplemrp.entity.Loc;
import simplemrp.entity.LocPK;
import simplemrp.entity.Product;
import simplemrp.entity.Subdist;
import simplemrp.entity.Uom;
import simplemrp.entity.Usr;
import simplemrp.entity.Whse;
import simplemrp.test.ContextFactory;
import simplemrp.util.BindingName;

/**
 *
 * @author wisaruthkea
 */
public class MaFacadeRemoteTest {

    private static MaFacadeRemote maFacade;
    public MaFacadeRemoteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         maFacade = (MaFacadeRemote) ContextFactory.getContext().lookup(BindingName.MaFacadeRemote);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    

   

    

   

    

    /**
     * Test of getListTax method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListTax() throws Exception {
        System.out.println("getListTax");
        
        List expResult = null;
        List result = maFacade.getListTax();
        assertNotNull(result);
        }

   

    /**
     * Test of getListProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListProduct() throws Exception {
        System.out.println("getListProduct");
        
        List expResult = null;
        List result = maFacade.getListProduct();
        assertNotNull(result);
    }

    /**
     * Test of getListItem_source method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListItem_source() throws Exception {
        System.out.println("getListItem_source");
        
        List expResult = null;
        List result = maFacade.getListItem_source();
        assertNotNull(result);
    }

    /**
     * Test of getListItem_stat method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListItem_stat() throws Exception {
        System.out.println("getListItem_stat");
        
        
        List result = maFacade.getListItem_stat();
        assertNotNull(result);
    }

    /**
     * Test of getListUom method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListUom() throws Exception {
        System.out.println("getListUom");
        
        
        List result = maFacade.getListUom();
       assertNotNull(result);
    }

   

    
    

   

    /**
     * Test of getListTerm method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListTerm() throws Exception {
        System.out.println("getListTerm");
        
        
        List result = maFacade.getListTerm();
        assertNotNull(result);
    }

    /**
     * Test of searchUom method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchUom() throws Exception {
        System.out.println("searchUom");
        String p_strKeyword = "%";
        
        
        List result = maFacade.searchUom(p_strKeyword);
        assertNotNull(result);
    }

    

    
  

   

    /**
     * Test of searchProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchProduct() throws Exception {
        System.out.println("searchProduct");
        String p_strKeyword = "";
        
        
        List result = maFacade.searchProduct(p_strKeyword);
        assertNotNull(result);
        
    }

    

   

  
   

    

   

   

   

   

    /**
     * Test of getListWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListWhse() throws Exception {
        System.out.println("getListWhse");
        
        
        List result = maFacade.getListWhse();
        assertNotNull(result);
        
    }

    

   

   

   

   

   



}