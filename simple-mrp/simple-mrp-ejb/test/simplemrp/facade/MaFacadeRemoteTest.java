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
     * Test of getListCountry method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListCountry() throws Exception {
        System.out.println("getListCountry");
        
        List expResult = null;
        List result = maFacade.getListCountry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListProvince method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListProvince() throws Exception {
        System.out.println("getListProvince");
        Integer p_intCountry_id = null;
        
        List expResult = null;
        List result = maFacade.getListProvince(p_intCountry_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListDistrict method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListDistrict() throws Exception {
        System.out.println("getListDistrict");
        Integer p_intProvince_id = null;
        
        List expResult = null;
        List result = maFacade.getListDistrict(p_intProvince_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListSubdist method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListSubdist() throws Exception {
        System.out.println("getListSubdist");
        Integer p_intSubdist_id = null;
        
        List expResult = null;
        List result = maFacade.getListSubdist(p_intSubdist_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubdist method, of class MaFacadeRemote.
     */
    @Test
    public void testGetSubdist() throws Exception {
        System.out.println("getSubdist");
        Integer p_intSubdist_id = null;
        
        Subdist expResult = null;
        Subdist result = maFacade.getSubdist(p_intSubdist_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListTax method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListTax() throws Exception {
        System.out.println("getListTax");
        
        List expResult = null;
        List result = maFacade.getListTax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchItem method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchItem() throws Exception {
        System.out.println("searchItem");
        String p_strItem = "";
        String p_strDesc = "";
        
        List expResult = null;
        List result = maFacade.searchItem(p_strItem, p_strDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListProduct() throws Exception {
        System.out.println("getListProduct");
        
        List expResult = null;
        List result = maFacade.getListProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListItem_source method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListItem_source() throws Exception {
        System.out.println("getListItem_source");
        
        List expResult = null;
        List result = maFacade.getListItem_source();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListItem_stat method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListItem_stat() throws Exception {
        System.out.println("getListItem_stat");
        
        List expResult = null;
        List result = maFacade.getListItem_stat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListUom method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListUom() throws Exception {
        System.out.println("getListUom");
        
        List expResult = null;
        List result = maFacade.getListUom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class MaFacadeRemote.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        String p_strItem = "";
        
        Item expResult = null;
        Item result = maFacade.getItem(p_strItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class MaFacadeRemote.
     */
    @Test
    public void testDeleteItem() throws Exception {
        System.out.println("deleteItem");
        Item p_item = null;
        
        maFacade.deleteItem(p_item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editItem method, of class MaFacadeRemote.
     */
    @Test
    public void testEditItem() throws Exception {
        System.out.println("editItem");
        Item p_item = null;
        
        maFacade.editItem(p_item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItem method, of class MaFacadeRemote.
     */
    @Test
    public void testCreateItem() throws Exception {
        System.out.println("createItem");
        Item p_item = null;
        
        String expResult = "";
        String result = maFacade.createItem(p_item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListTerm method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListTerm() throws Exception {
        System.out.println("getListTerm");
        
        List expResult = null;
        List result = maFacade.getListTerm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchUom method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchUom() throws Exception {
        System.out.println("searchUom");
        String p_strKeyword = "";
        
        List expResult = null;
        List result = maFacade.searchUom(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUom method, of class MaFacadeRemote.
     */
    @Test
    public void testGetUom() throws Exception {
        System.out.println("getUom");
        String p_strUom = "";
        
        Uom expResult = null;
        Uom result = maFacade.getUom(p_strUom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUom method, of class MaFacadeRemote.
     */
    @Test
    public void testCreateUom() throws Exception {
        System.out.println("createUom");
        Uom p_uom = null;
        
        String expResult = "";
        String result = maFacade.createUom(p_uom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editUom method, of class MaFacadeRemote.
     */
    @Test
    public void testEditUom() throws Exception {
        System.out.println("editUom");
        Uom p_uom = null;
        
        maFacade.editUom(p_uom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUom method, of class MaFacadeRemote.
     */
    @Test
    public void testDeleteUom() throws Exception {
        System.out.println("deleteUom");
        Uom p_uom = null;
        
        maFacade.deleteUom(p_uom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchProduct() throws Exception {
        System.out.println("searchProduct");
        String p_strKeyword = "";
        
        List expResult = null;
        List result = maFacade.searchProduct(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testGetProduct() throws Exception {
        System.out.println("getProduct");
        String p_strProduct = "";
        
        Product expResult = null;
        Product result = maFacade.getProduct(p_strProduct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testCreateProduct() throws Exception {
        System.out.println("createProduct");
        Product p_product = null;
        
        String expResult = "";
        String result = maFacade.createProduct(p_product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testEditProduct() throws Exception {
        System.out.println("editProduct");
        Product p_product = null;
        
        maFacade.editProduct(p_product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class MaFacadeRemote.
     */
    @Test
    public void testDeleteProduct() throws Exception {
        System.out.println("deleteProduct");
        Product p_product = null;
        
        maFacade.deleteProduct(p_product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchWhse() throws Exception {
        System.out.println("searchWhse");
        String p_strKeyword = "";
        
        List expResult = null;
        List result = maFacade.searchWhse(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testGetWhse() throws Exception {
        System.out.println("getWhse");
        String p_strWhse = "";
        
        Whse expResult = null;
        Whse result = maFacade.getWhse(p_strWhse);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testCreateWhse() throws Exception {
        System.out.println("createWhse");
        Whse p_whse = null;
        
        String expResult = "";
        String result = maFacade.createWhse(p_whse);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testEditWhse() throws Exception {
        System.out.println("editWhse");
        Whse p_whse = null;
        
        maFacade.editWhse(p_whse);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testDeleteWhse() throws Exception {
        System.out.println("deleteWhse");
        Whse p_whse = null;
        
        maFacade.deleteWhse(p_whse);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListWhse method, of class MaFacadeRemote.
     */
    @Test
    public void testGetListWhse() throws Exception {
        System.out.println("getListWhse");
        
        List expResult = null;
        List result = maFacade.getListWhse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchLoc method, of class MaFacadeRemote.
     */
    @Test
    public void testSearchLoc() throws Exception {
        System.out.println("searchLoc");
        String p_strKeyword = "";
        
        List expResult = null;
        List result = maFacade.searchLoc(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoc method, of class MaFacadeRemote.
     */
    @Test
    public void testGetLoc() throws Exception {
        System.out.println("getLoc");
        LocPK p_locPK = null;
        
        Loc expResult = null;
        Loc result = maFacade.getLoc(p_locPK);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createLoc method, of class MaFacadeRemote.
     */
    @Test
    public void testCreateLoc() throws Exception {
        System.out.println("createLoc");
        Loc p_loc = null;
        
        maFacade.createLoc(p_loc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editLoc method, of class MaFacadeRemote.
     */
    @Test
    public void testEditLoc() throws Exception {
        System.out.println("editLoc");
        Loc p_loc = null;
        
        maFacade.editLoc(p_loc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteLoc method, of class MaFacadeRemote.
     */
    @Test
    public void testDeleteLoc() throws Exception {
        System.out.println("deleteLoc");
        Loc p_loc = null;
        
        maFacade.deleteLoc(p_loc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsr method, of class MaFacadeRemote.
     */
    @Test
    public void testGetUsr() throws Exception {
        System.out.println("getUsr");
        String usrId = "";
        
        Usr expResult = null;
        Usr result = maFacade.getUsr(usrId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


}