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
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Country;
import simplemrp.entity.Customer;
import simplemrp.entity.District;
import simplemrp.entity.Itemprice;
import simplemrp.entity.ItempricePK;
import simplemrp.entity.Prefixname;
import simplemrp.entity.Province;
import simplemrp.entity.Slsman;
import simplemrp.entity.Subdist;
import simplemrp.entity.Tax;
import simplemrp.test.ContextFactory;
import simplemrp.util.BindingName;

/**
 *
 * @author wisaruthkea
 */
public class CoFacadeRemoteTest {
    private static CoFacadeRemote coFacade;
    private static Customer c=null;
    private static String custId;
    public CoFacadeRemoteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        coFacade = (CoFacadeRemote) ContextFactory.getContext().lookup(BindingName.CoFacadeRemote);
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
     * Test of searchCustomer method, of class CoFacadeRemote.
     */
    @Test
    public void testSearchCustomer() throws Exception {
        System.out.println("searchCustomer");
        String p_strKeyword = "";
        List expResult = null;
        List result = coFacade.searchCustomer(p_strKeyword);
        if(result==null){
         assertEquals(expResult, result);
        } else {
            System.out.println("searchCustomer Result="+result);
            assertNull(result);
        }
        
       
    }



    /**
     * Test of createCustomer method, of class CoFacadeRemote.
     */
    
    @Test
    public void testCreateCustomer() throws Exception {
        System.out.println("createCustomer");
        c = new Customer("autogenid");
        c.setTax(new Tax("V07"));
        c.setPrefixname(new Prefixname(1));
        c.setName("UNIT USER");
        c.setAddr1("UNITADDR");
        c.setAddr2("UNITADDR2");
        c.setRoad("UNITRODE");
        c.setSoi("UNITSOI");
        c.setSubdist(new Subdist(103401));
        c.setDistrict(new District(1034));
        c.setProvince(new Province(10));
        c.setZipcode("10250");
        c.setCountry(new Country(66));
        c.setPhone("08-58108022");
        c.setFax("02-722-8150");
        c.setEmail("email@domain.com");
        c.setCdate(new Date());
        c.setCuser("unittest_u");
        c.setUdate(new Date());
        c.setUuser("unittest_u");
        custId = coFacade.createCustomer(c);
        System.out.println("createCustomer ID="+custId);
        assertNotNull(custId);
        
    }

    /**
     * Test of editCustomer method, of class CoFacadeRemote.
     */
    @Test
    public void testEditCustomer() throws Exception {
        System.out.println("editCustomer");
        c.setCustId(custId);
        c.setEmail("myemail@domain.com");
        coFacade.editCustomer(c);
       
    }

        /**
     * Test of getCustomer method, of class CoFacadeRemote.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        String p_strCust_id = custId;
        String expResult = "myemail@domain.com";
        Customer result = coFacade.getCustomer(p_strCust_id);
        assertEquals(expResult, result.getEmail());
        
    }

    /**
     * Test of deleteCustomer method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteCustomer() throws Exception {
        System.out.println("deleteCustomer");
        Customer p_customer = new Customer(custId);
        coFacade.deleteCustomer(p_customer);
        // TODO review the generated test code and remove the default call to fail.
        Customer result = coFacade.getCustomer(custId);
        assertEquals(null, result);
    }

    /**
     * Test of getListPrefixname method, of class CoFacadeRemote.
     */
    @Test
    public void testGetListPrefixname() throws Exception {
        System.out.println("getListPrefixname");
        List expResult = null;
        List result = coFacade.getListPrefixname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testSearchSlsman() throws Exception {
        System.out.println("searchSlsman");
        String p_strKeyword = "";
        List expResult = null;
        List result = coFacade.searchSlsman(p_strKeyword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testGetSlsman() throws Exception {
        System.out.println("getSlsman");
        String p_strSlsman_id = "";
        Slsman expResult = null;
        Slsman result = coFacade.getSlsman(p_strSlsman_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testCreateSlsman() throws Exception {
        System.out.println("createSlsman");
        Slsman p_slsman = null;
        
        String expResult = "";
        String result = coFacade.createSlsman(p_slsman);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testEditSlsman() throws Exception {
        System.out.println("editSlsman");
        Slsman p_slsman = null;
        
        coFacade.editSlsman(p_slsman);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteSlsman() throws Exception {
        System.out.println("deleteSlsman");
        Slsman p_slsman = null;
        
        coFacade.deleteSlsman(p_slsman);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchCo method, of class CoFacadeRemote.
     */
    @Test
    public void testSearchCo() throws Exception {
        System.out.println("searchCo");
        String p_strCustomerId = "";
        
        List expResult = null;
        List result = coFacade.searchCo(p_strCustomerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCo method, of class CoFacadeRemote.
     */
    @Test
    public void testGetCo() throws Exception {
        System.out.println("getCo");
        String strCo_id = "";
        
        Co expResult = null;
        Co result = coFacade.getCo(strCo_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCo method, of class CoFacadeRemote.
     */
    @Test
    public void testCreateCo() throws Exception {
        System.out.println("createCo");
        Co p_co = null;
        
        String expResult = "";
        String result = coFacade.createCo(p_co);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCo method, of class CoFacadeRemote.
     */
    @Test
    public void testEditCo() throws Exception {
        System.out.println("editCo");
        Co p_co = null;
        
        coFacade.editCo(p_co);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCo method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteCo() throws Exception {
        System.out.println("deleteCo");
        Co p_co = null;
        
        coFacade.deleteCo(p_co);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoitemByCo method, of class CoFacadeRemote.
     */
    @Test
    public void testGetCoitemByCo() throws Exception {
        System.out.println("getCoitemByCo");
        String p_strCo_id = "";
        
        List expResult = null;
        List result = coFacade.getCoitemByCo(p_strCo_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoitem method, of class CoFacadeRemote.
     */
    @Test
    public void testGetCoitem() throws Exception {
        System.out.println("getCoitem");
        CoitemPK p_pkCoitem = null;
      
        Coitem expResult = null;
        Coitem result = coFacade.getCoitem(p_pkCoitem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCoitem method, of class CoFacadeRemote.
     */
    @Test
    public void testCreateCoitem() throws Exception {
        System.out.println("createCoitem");
        Coitem p_coitem = null;
       
        Integer expResult = null;
        Integer result = coFacade.createCoitem(p_coitem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCoitem method, of class CoFacadeRemote.
     */
    @Test
    public void testEditCoitem() throws Exception {
        System.out.println("editCoitem");
        Coitem p_coitem = null;
       
        coFacade.editCoitem(p_coitem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCoitem method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteCoitem() throws Exception {
        System.out.println("deleteCoitem");
        Coitem p_coitem = null;
       
        coFacade.deleteCoitem(p_coitem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListCo_stat method, of class CoFacadeRemote.
     */
    @Test
    public void testGetListCo_stat() throws Exception {
        System.out.println("getListCo_stat");
        
        List expResult = null;
        List result = coFacade.getListCo_stat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItempriceByItem method, of class CoFacadeRemote.
     */
    @Test
    public void testGetItempriceByItem() throws Exception {
        System.out.println("getItempriceByItem");
        String p_strItem = "";
       
        List expResult = null;
        List result = coFacade.getItempriceByItem(p_strItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemprice method, of class CoFacadeRemote.
     */
    @Test
    public void testGetItemprice() throws Exception {
        System.out.println("getItemprice");
        ItempricePK p_pkItemprice = null;
      
        Itemprice expResult = null;
        Itemprice result = coFacade.getItemprice(p_pkItemprice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createItemprice method, of class CoFacadeRemote.
     */
    @Test
    public void testCreateItemprice() throws Exception {
        System.out.println("createItemprice");
        Itemprice p_itemprice = null;
   
        coFacade.createItemprice(p_itemprice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editItemprice method, of class CoFacadeRemote.
     */
    @Test
    public void testEditItemprice() throws Exception {
        System.out.println("editItemprice");
        Itemprice p_itemprice = null;
    
        coFacade.editItemprice(p_itemprice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItemprice method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteItemprice() throws Exception {
        System.out.println("deleteItemprice");
        Itemprice p_itemprice = null;
        coFacade.deleteItemprice(p_itemprice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

}