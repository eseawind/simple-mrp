/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        
        List result = ppFacade.listJobStat();
        assertNotNull(result);
        
    }

    /**
     * Test of getJob method, of class PpFacadeRemote.
     */
    @Test
    public void testGetJob() {
        System.out.println("getJob");
        String inputJobId = this.jobId;
        
        
        Job result = ppFacade.getJob(inputJobId);
        System.out.println("Job result="+result);
        assertNotNull(result);
        
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
        Date p_jobDate = new Date();
        
        
        List result = ppFacade.findByJobDate(p_jobDate);
        System.out.println("Result = "+result);
        assertNotNull(result);
        
        
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
     * Test of listForecast method, of class PpFacadeRemote.
     */
    @Test
    public void testListForecast() {
        System.out.println("listForecast");
        
        
        List result = ppFacade.listForecast();
        assertNotNull(result);
        
    }

    /**
     * Test of searchForecast method, of class PpFacadeRemote.
     */
    @Test
    public void testSearchForecast() {
        System.out.println("searchForecast");
        Date forecaseDate = null;
        
        
        List result = ppFacade.searchForecast(forecaseDate);
        assertNotNull(result);
        
    }

   

    

    

    /**
     * Test of listMps method, of class PpFacadeRemote.
     */
    @Test
    public void testListMps() {
        System.out.println("listMps");
        
        
        List result = ppFacade.listMps();
        assertNotNull(result);
        
    }

    /**
     * Test of searchMps method, of class PpFacadeRemote.
     */
    @Test
    public void testSearchMps() {
        System.out.println("searchMps");
        Date dueDate = null;
        
        
        List result = ppFacade.searchMps(dueDate);
        System.out.println("mps result="+result);
        assertNotNull(result);
    }

    

    

    

    /**
     * Test of listMpsStat method, of class PpFacadeRemote.
     */
    @Test
    public void testListMpsStat() {
        System.out.println("listMpsStat");
        
        
        List result = ppFacade.listMpsStat();
        assertNotNull(result);
        
    }

    /**
     * Test of listMpsType method, of class PpFacadeRemote.
     */
    @Test
    public void testListMpsType() {
        System.out.println("listMpsType");
        
        
        List result = ppFacade.listMpsType();
        assertNotNull(result);
        
    }

   

 

 



 

 



 

  

   

  

    /**
     * Test of getListWorkcenter method, of class PpFacadeRemote.
     */
    @Test
    public void testGetListWorkcenter() throws Exception {
        System.out.println("getListWorkcenter");
        
        
        List result = ppFacade.getListWorkcenter();
        assertNotNull(result);
        }

   

  

  

   

   

   

    

}