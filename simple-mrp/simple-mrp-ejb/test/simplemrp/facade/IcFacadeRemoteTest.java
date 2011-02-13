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
import simplemrp.entity.Co;
import simplemrp.entity.Itemloc;
import simplemrp.mbean.ic.to.CoOrderItemTO;
import simplemrp.mbean.ic.to.JobRecvItemTO;
import simplemrp.mbean.ic.to.MatlToJobItemTO;
import simplemrp.mbean.ic.to.PoRecvItemTO;
import simplemrp.test.ContextFactory;
import simplemrp.util.BindingName;

/**
 *
 * @author wisaruthkea
 */
public class IcFacadeRemoteTest {
    private static IcFacadeRemote icFacade;
    public IcFacadeRemoteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         icFacade = (IcFacadeRemote) ContextFactory.getContext().lookup(BindingName.IcFacadeRemote);
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
     * Test of searchItemLocation method, of class IcFacadeRemote.
     */
    @Test
    public void testSearchItemLocation() {
        System.out.println("searchItemLocation");
        String warehouse = "";
        String location = "";
        
        List expResult = null;
        List result = icFacade.searchItemLocation(warehouse, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCo method, of class IcFacadeRemote.
     */
    @Test
    public void testSaveCo() {
        System.out.println("saveCo");
        Co co = null;
        
        icFacade.saveCo(co);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCo method, of class IcFacadeRemote.
     */
    @Test
    public void testFindCo() throws Exception {
        System.out.println("findCo");
        String coId = "";
        
        Co expResult = null;
        Co result = icFacade.findCo(coId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCoShipping method, of class IcFacadeRemote.
     */
    @Test
    public void testSaveCoShipping() {
        System.out.println("saveCoShipping");
        String coId = "";
        Date tranDate = null;
        List<CoOrderItemTO> lsCoOrderItem = null;
        
        icFacade.saveCoShipping(coId, tranDate, lsCoOrderItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findItemLocation method, of class IcFacadeRemote.
     */
    @Test
    public void testFindItemLocation() {
        System.out.println("findItemLocation");
        String whseId = "";
        String locationId = "";
        String itemId = "";
        
        Itemloc expResult = null;
        Itemloc result = icFacade.findItemLocation(whseId, locationId, itemId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePoReceive method, of class IcFacadeRemote.
     */
    @Test
    public void testSavePoReceive() {
        System.out.println("savePoReceive");
        String poId = "";
        Date tranDate = null;
        List<PoRecvItemTO> lsPoOrderItem = null;
        
        icFacade.savePoReceive(poId, tranDate, lsPoOrderItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveJobReceive method, of class IcFacadeRemote.
     */
    @Test
    public void testSaveJobReceive() {
        System.out.println("saveJobReceive");
        String jobId = "";
        Date transDate = null;
        JobRecvItemTO to = null;
        
        icFacade.saveJobReceive(jobId, transDate, to);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveMatlToJob method, of class IcFacadeRemote.
     */
    @Test
    public void testSaveMatlToJob() {
        System.out.println("saveMatlToJob");
        String jobId = "";
        Date transDate = null;
        List<MatlToJobItemTO> lsTo = null;
        
        icFacade.saveMatlToJob(jobId, transDate, lsTo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStocktrans method, of class IcFacadeRemote.
     */
    @Test
    public void testSearchStocktrans() throws Exception {
        System.out.println("searchStocktrans");
        String p_strTransItem = "";
        Date p_dtTransDateFrom = null;
        Date p_dtTransDateTo = null;
        
        List expResult = null;
        List result = icFacade.searchStocktrans(p_strTransItem, p_dtTransDateFrom, p_dtTransDateTo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  

}