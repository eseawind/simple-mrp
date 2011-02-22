/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import simplemrp.entity.Forecast;
import simplemrp.entity.Itemmatl;
import simplemrp.entity.ItemmatlPK;
import simplemrp.entity.Itemopr;
import simplemrp.entity.ItemoprPK;
import simplemrp.entity.Job;
import simplemrp.entity.Mps;
import simplemrp.entity.Item;
import simplemrp.entity.Job_stat;
import simplemrp.entity.Workcenter;
import simplemrp.test.ContextFactory;
import simplemrp.util.BindingName;

/**
 *
 * @author wisaruthkea
 */
public class PpFacadeRemoteTest {

    private static PpFacadeRemote ppFacade;
      private static String jobId;
      private static Job j=null;
    public PpFacadeRemoteTest() throws NamingException {
        ppFacade = (PpFacadeRemote) ContextFactory.getContext().lookup(BindingName.PpFacadeRemote);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of createJob method, of class PpFacadeRemote.
     */
    @Test
    public void testCreateJob() {
        System.out.println("createJob");
         j = new Job("autogenid");
            j.setCdate(new Date());
            j.setCuser("Developer");
            j.setItem(new Item("CHAIR-WOOD-001"));
            j.setJobdate(new Date());
            j.setJoboprCollection(null);
            j.setJobstat(new Job_stat('F'));
            j.setNote("");
            j.setQty(2);
            j.setQtycomplete(2);
            j.setReleaser("dummy_user");
            j.setUdate(new Date());
            j.setUuser("dummy_user");
        jobId =ppFacade.createJob(j);
        System.out.println("createJob ID="+jobId);
        assertNotNull(jobId);

    }

    /**
     * Test of listJobStat method, of class PpFacadeRemote.
     */
    @Test
    public void testListJobStat() {
        System.out.println("listJobStat");
        
        List expResult = null;
        List result = ppFacade.listJobStat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJob method, of class PpFacadeRemote.
     */
    @Test
    public void testGetJob() {
        System.out.println("getJob");
        String inputJobId = "";
        
        Job expResult = null;
        Job result = ppFacade.getJob(inputJobId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchJob method, of class PpFacadeRemote.
     */
    @Test
    public void testSearchJob() {
        System.out.println("searchJob");
        String searchJobKey = "";
        Date p_dtJobDate = null;
        
        List expResult = null;
        List result = ppFacade.searchJob(searchJobKey, p_dtJobDate);

       
        if(result==null){
         assertEquals(expResult, result);
        } else {
            System.out.println("SearchJob Result="+result);
            assertNotNull(result);
        }
    }

   

   
    /**
     * Test of editJob method, of class PpFacadeRemote.
     */
    @Test
    public void testEditJob() throws Exception {
        System.out.println("editJob");
         j.setJobId(jobId);
       j.setJobstat(new Job_stat('R'));
        ppFacade.editJob(j);
    }

    /**
     * Test of findByJobDate method, of class PpFacadeRemote.
     */
    @Test
    public void testFindByJobDate() {
        System.out.println("findByJobDate");
        Date p_jobDate = null;
        
        List expResult = null;
        List result = ppFacade.findByJobDate(p_jobDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 /**
     * Test of removeJob method, of class PpFacadeRemote.
     */
    @Test
    public void testRemoveJob() {
        System.out.println("removeJob");

         ppFacade.removeJob(jobId);
        Job result = ppFacade.getJob(jobId);
         assertEquals(null, result);



    }
    /**
     * Test of getForecast method, of class PpFacadeRemote.
     */
    @Test
    public void testGetForecast() {
        System.out.println("getForecast");
        String forecast_id = "";
        
        Forecast expResult = null;
        Forecast result = ppFacade.getForecast(forecast_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listForecast method, of class PpFacadeRemote.
     */
    @Test
    public void testListForecast() {
        System.out.println("listForecast");
        
        List expResult = null;
        List result = ppFacade.listForecast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchForecast method, of class PpFacadeRemote.
     */
    @Test
    public void testSearchForecast() {
        System.out.println("searchForecast");
        Date forecaseDate = null;
        
        List expResult = null;
        List result = ppFacade.searchForecast(forecaseDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createForecase method, of class PpFacadeRemote.
     */
    @Test
    public void testCreateForecase() {
        System.out.println("createForecase");
        Forecast forecase = null;
        
        String expResult = "";
        String result = ppFacade.createForecase(forecase);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeForecase method, of class PpFacadeRemote.
     */
    @Test
    public void testRemoveForecase() {
        System.out.println("removeForecase");
        String forecase_id = "";
        
        ppFacade.removeForecase(forecase_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMps method, of class PpFacadeRemote.
     */
    @Test
    public void testGetMps() {
        System.out.println("getMps");
        String mpsId = "";
        
        Mps expResult = null;
        Mps result = ppFacade.getMps(mpsId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listMps method, of class PpFacadeRemote.
     */
    @Test
    public void testListMps() {
        System.out.println("listMps");
        
        List expResult = null;
        List result = ppFacade.listMps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMps method, of class PpFacadeRemote.
     */
    @Test
    public void testSearchMps() {
        System.out.println("searchMps");
        Date dueDate = null;
        
        List expResult = null;
        List result = ppFacade.searchMps(dueDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMps method, of class PpFacadeRemote.
     */
    @Test
    public void testCreateMps() {
        System.out.println("createMps");
        Mps mps = null;
        
        String expResult = "";
        String result = ppFacade.createMps(mps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editMps method, of class PpFacadeRemote.
     */
    @Test
    public void testEditMps() {
        System.out.println("editMps");
        Mps mps = null;
        
        ppFacade.editMps(mps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMps method, of class PpFacadeRemote.
     */
    @Test
    public void testRemoveMps() {
        System.out.println("removeMps");
        String mpsId = "";
        
        ppFacade.removeMps(mpsId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listMpsStat method, of class PpFacadeRemote.
     */
    @Test
    public void testListMpsStat() {
        System.out.println("listMpsStat");
        
        List expResult = null;
        List result = ppFacade.listMpsStat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listMpsType method, of class PpFacadeRemote.
     */
    @Test
    public void testListMpsType() {
        System.out.println("listMpsType");
        
        List expResult = null;
        List result = ppFacade.listMpsType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemoprByItem method, of class PpFacadeRemote.
     */
    @Test
    public void testGetItemoprByItem() throws Exception {
        System.out.println("getItemoprByItem");
        String p_strItem = "";
        
        List expResult = null;
        List result = ppFacade.getItemoprByItem(p_strItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemopr method, of class PpFacadeRemote.
     */
    @Test
    public void testGetItemopr() throws Exception {
        System.out.println("getItemopr");
        ItemoprPK p_pkItemopr = null;
        
        Itemopr expResult = null;
        Itemopr result = ppFacade.getItemopr(p_pkItemopr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItemopr method, of class PpFacadeRemote.
     */
    @Test
    public void testCreateItemopr() throws Exception {
        System.out.println("createItemopr");
        Itemopr p_itemopr = null;
        
        Integer expResult = null;
        Integer result = ppFacade.createItemopr(p_itemopr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editItemopr method, of class PpFacadeRemote.
     */
    @Test
    public void testEditItemopr() throws Exception {
        System.out.println("editItemopr");
        Itemopr p_itemopr = null;
        
        ppFacade.editItemopr(p_itemopr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItemopr method, of class PpFacadeRemote.
     */
    @Test
    public void testDeleteItemopr() throws Exception {
        System.out.println("deleteItemopr");
        Itemopr p_itemopr = null;
        
        ppFacade.deleteItemopr(p_itemopr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBomDeatil method, of class PpFacadeRemote.
     */
    @Test
    public void testGetBomDeatil() throws Exception {
        System.out.println("getBomDeatil");
        String p_strItem = "";
        
        List expResult = null;
        List result = ppFacade.getBomDeatil(p_strItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testSearchWorkcenter() throws Exception {
        System.out.println("searchWorkcenter");
        String p_strKeyword = "";
        
        List expResult = null;
        List result = ppFacade.searchWorkcenter(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testGetWorkcenter() throws Exception {
        System.out.println("getWorkcenter");
        String p_strWorkcenter = "";
        
        Workcenter expResult = null;
        Workcenter result = ppFacade.getWorkcenter(p_strWorkcenter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testCreateWorkcenter() throws Exception {
        System.out.println("createWorkcenter");
        Workcenter p_workcenter = null;
        
        String expResult = "";
        String result = ppFacade.createWorkcenter(p_workcenter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testEditWorkcenter() throws Exception {
        System.out.println("editWorkcenter");
        Workcenter p_workcenter = null;
        
        ppFacade.editWorkcenter(p_workcenter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testDeleteWorkcenter() throws Exception {
        System.out.println("deleteWorkcenter");
        Workcenter p_workcenter = null;
        
        ppFacade.deleteWorkcenter(p_workcenter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testGetListWorkcenter() throws Exception {
        System.out.println("getListWorkcenter");
        
        List expResult = null;
        List result = ppFacade.getListWorkcenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemmatlByItemopr method, of class PpFacadeRemote.
     */
    @Test
    public void testGetItemmatlByItemopr() throws Exception {
        System.out.println("getItemmatlByItemopr");
        String p_strItem = "";
        Integer p_intOpr = null;
        
        List expResult = null;
        List result = ppFacade.getItemmatlByItemopr(p_strItem, p_intOpr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemmatl method, of class PpFacadeRemote.
     */
    @Test
    public void testGetItemmatl() throws Exception {
        System.out.println("getItemmatl");
        ItemmatlPK p_pkItemmatl = null;
        
        Itemmatl expResult = null;
        Itemmatl result = ppFacade.getItemmatl(p_pkItemmatl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItemmatl method, of class PpFacadeRemote.
     */
    @Test
    public void testCreateItemmatl() throws Exception {
        System.out.println("createItemmatl");
        Itemmatl p_itemmatl = null;
        
        Integer expResult = null;
        Integer result = ppFacade.createItemmatl(p_itemmatl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editItemmatl method, of class PpFacadeRemote.
     */
    @Test
    public void testEditItemmatl() throws Exception {
        System.out.println("editItemmatl");
        Itemmatl p_itemmatl = null;
        
        ppFacade.editItemmatl(p_itemmatl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItemmatl method, of class PpFacadeRemote.
     */
    @Test
    public void testDeleteItemmatl() throws Exception {
        System.out.println("deleteItemmatl");
        Itemmatl p_itemmatl = null;
        
        ppFacade.deleteItemmatl(p_itemmatl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobMatlByJobId method, of class PpFacadeRemote.
     */
    @Test
    public void testGetJobMatlByJobId() {
        System.out.println("getJobMatlByJobId");
        String jobId = "";
        
        List expResult = null;
        List result = ppFacade.getJobMatlByJobId(jobId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

}