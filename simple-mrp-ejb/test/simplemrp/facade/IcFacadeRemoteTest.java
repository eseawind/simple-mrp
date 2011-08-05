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
import simplemrp.to.JobRecvItemTO;
import simplemrp.to.MatlToJobItemTO;
import simplemrp.to.PoRecvItemTO;
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
        assertNotNull(result);
       
    }

    

    

   

    

    /**
     * Test of savePoReceive method, of class IcFacadeRemote.
     */
    //@Test
    public void testSavePoReceive() throws Exception {
        System.out.println("savePoReceive");
        String poId = "";
        Date tranDate = null;
        List<PoRecvItemTO> lsPoOrderItem = null;
        
        icFacade.savePoReceive_V2(poId, tranDate, new PoRecvItemTO[0]);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveJobReceive method, of class IcFacadeRemote.
     */
    //@Test
    public void testSaveJobReceive() throws Exception {
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
    //@Test
    public void testSaveMatlToJob() throws Exception {
        System.out.println("saveMatlToJob");
        String jobId = "";
        Date transDate = null;
        List<MatlToJobItemTO> lsTo = null;
        
        icFacade.saveMatlToJob_V2(jobId, transDate, new MatlToJobItemTO[0]);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
  

}