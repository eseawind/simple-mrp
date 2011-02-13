/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simplemrp.entity.Po;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Pr;
import simplemrp.entity.Pritem;
import simplemrp.entity.PritemPK;
import simplemrp.entity.Vendor;
import simplemrp.test.ContextFactory;
import simplemrp.util.BindingName;

/**
 *
 * @author wisaruthkea
 */
public class PoFacadeRemoteTest {

    private static PoFacadeRemote poFacade;
    public PoFacadeRemoteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        poFacade = (PoFacadeRemote) ContextFactory.getContext().lookup(BindingName.PoFacadeRemote);

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
     * Test of searchVendor method, of class PoFacadeRemote.
     */
    @Test
    public void testSearchVendor() throws Exception {
        System.out.println("searchVendor");
        String p_strKeyword = "";
        
        List expResult = null;
        List result = poFacade.searchVendor(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendor method, of class PoFacadeRemote.
     */
    @Test
    public void testGetVendor() throws Exception {
        System.out.println("getVendor");
        String p_strVendor_id = "";
        
        Vendor expResult = null;
        Vendor result = poFacade.getVendor(p_strVendor_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createVendor method, of class PoFacadeRemote.
     */
    @Test
    public void testCreateVendor() throws Exception {
        System.out.println("createVendor");
        Vendor p_vendor = null;
        
        String expResult = "";
        String result = poFacade.createVendor(p_vendor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editVendor method, of class PoFacadeRemote.
     */
    @Test
    public void testEditVendor() throws Exception {
        System.out.println("editVendor");
        Vendor p_vendor = null;
        
        poFacade.editVendor(p_vendor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVendor method, of class PoFacadeRemote.
     */
    @Test
    public void testDeleteVendor() throws Exception {
        System.out.println("deleteVendor");
        Vendor p_vendor = null;
        
        poFacade.deleteVendor(p_vendor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListBank method, of class PoFacadeRemote.
     */
    @Test
    public void testGetListBank() throws Exception {
        System.out.println("getListBank");
        
        List expResult = null;
        List result = poFacade.getListBank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPo method, of class PoFacadeRemote.
     */
    @Test
    public void testSearchPo() throws Exception {
        System.out.println("searchPo");
        Date p_dtPoDate = null;
        
        List expResult = null;
        List result = poFacade.searchPo(p_dtPoDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPo method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPo() throws Exception {
        System.out.println("getPo");
        String strPo_id = "";
        
        Po expResult = null;
        Po result = poFacade.getPo(strPo_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPo method, of class PoFacadeRemote.
     */
    @Test
    public void testCreatePo() throws Exception {
        System.out.println("createPo");
        Po p_po = null;
        
        String expResult = "";
        String result = poFacade.createPo(p_po);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPo method, of class PoFacadeRemote.
     */
    @Test
    public void testEditPo() throws Exception {
        System.out.println("editPo");
        Po p_po = null;
        
        poFacade.editPo(p_po);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePo method, of class PoFacadeRemote.
     */
    @Test
    public void testDeletePo() throws Exception {
        System.out.println("deletePo");
        Po p_po = null;
        
        poFacade.deletePo(p_po);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoitemByPo method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPoitemByPo() throws Exception {
        System.out.println("getPoitemByPo");
        String p_strPo_id = "";
        
        List expResult = null;
        List result = poFacade.getPoitemByPo(p_strPo_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoitem method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPoitem() throws Exception {
        System.out.println("getPoitem");
        PoitemPK p_pkPoitem = null;
        
        Poitem expResult = null;
        Poitem result = poFacade.getPoitem(p_pkPoitem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPoitem method, of class PoFacadeRemote.
     */
    @Test
    public void testCreatePoitem() throws Exception {
        System.out.println("createPoitem");
        Poitem p_poitem = null;
        
        Integer expResult = null;
        Integer result = poFacade.createPoitem(p_poitem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPoitem method, of class PoFacadeRemote.
     */
    @Test
    public void testEditPoitem() throws Exception {
        System.out.println("editPoitem");
        Poitem p_poitem = null;
        
        poFacade.editPoitem(p_poitem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePoitem method, of class PoFacadeRemote.
     */
    @Test
    public void testDeletePoitem() throws Exception {
        System.out.println("deletePoitem");
        Poitem p_poitem = null;
        
        poFacade.deletePoitem(p_poitem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPo_stat method, of class PoFacadeRemote.
     */
    @Test
    public void testGetListPo_stat() throws Exception {
        System.out.println("getListPo_stat");
        
        List expResult = null;
        List result = poFacade.getListPo_stat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPr_stat method, of class PoFacadeRemote.
     */
    @Test
    public void testGetListPr_stat() throws Exception {
        System.out.println("getListPr_stat");
        
        List expResult = null;
        List result = poFacade.getListPr_stat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchPr method, of class PoFacadeRemote.
     */
    @Test
    public void testSearchPr() throws Exception {
        System.out.println("searchPr");
        String p_strRequester = "";
        Date p_dtReqDate = null;
        
        List expResult = null;
        List result = poFacade.searchPr(p_strRequester, p_dtReqDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPr method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPr() throws Exception {
        System.out.println("getPr");
        String strPr_id = "";
        
        Pr expResult = null;
        Pr result = poFacade.getPr(strPr_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPr method, of class PoFacadeRemote.
     */
    @Test
    public void testCreatePr() throws Exception {
        System.out.println("createPr");
        Pr p_pr = null;
        
        String expResult = "";
        String result = poFacade.createPr(p_pr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPr method, of class PoFacadeRemote.
     */
    @Test
    public void testEditPr() throws Exception {
        System.out.println("editPr");
        Pr p_pr = null;
        
        poFacade.editPr(p_pr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePr method, of class PoFacadeRemote.
     */
    @Test
    public void testDeletePr() throws Exception {
        System.out.println("deletePr");
        Pr p_pr = null;
        
        poFacade.deletePr(p_pr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPritemByPr method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPritemByPr() throws Exception {
        System.out.println("getPritemByPr");
        String p_strPr_id = "";
        
        List expResult = null;
        List result = poFacade.getPritemByPr(p_strPr_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPritem method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPritem() throws Exception {
        System.out.println("getPritem");
        PritemPK p_pkPritem = null;
        
        Pritem expResult = null;
        Pritem result = poFacade.getPritem(p_pkPritem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPritem method, of class PoFacadeRemote.
     */
    @Test
    public void testCreatePritem() throws Exception {
        System.out.println("createPritem");
        Pritem p_poitem = null;
        
        Integer expResult = null;
        Integer result = poFacade.createPritem(p_poitem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPritem method, of class PoFacadeRemote.
     */
    @Test
    public void testEditPritem() throws Exception {
        System.out.println("editPritem");
        Pritem p_poitem = null;
        
        poFacade.editPritem(p_poitem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePritem method, of class PoFacadeRemote.
     */
    @Test
    public void testDeletePritem() throws Exception {
        System.out.println("deletePritem");
        Pritem p_poitem = null;
        
        poFacade.deletePritem(p_poitem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

}