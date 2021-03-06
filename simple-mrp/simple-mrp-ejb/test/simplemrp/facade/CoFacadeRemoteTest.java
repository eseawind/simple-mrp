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
import simplemrp.entity.Co_stat;
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
import simplemrp.entity.Term;
import simplemrp.test.ContextFactory;
import simplemrp.util.BindingName;

/**
 *
 * @author wisaruthkea
 */
public class CoFacadeRemoteTest {

    private static CoFacadeRemote coFacade;
    //
    private static Customer c = null;
    private static String custId;
    //
    private static Slsman s = null;
    private static String slsId;
    //
    private static Co co = null;
    private static String coId;

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
        if (result == null) {
            assertEquals(expResult, result);
        } else {
            System.out.println("searchCustomer Result=" + result);
            assertNotNull(result);
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
        System.out.println("createCustomer ID=" + custId);
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
        List result = coFacade.getListPrefixname();
        System.out.println("getListPrefixname result=" + result);

    }

    /**
     * Test of createSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testCreateSlsman() throws Exception {
        System.out.println("createSlsman");
        s = new Slsman("autogenID");
        s.setFname("UNITFIRSTNAME");
        s.setLname("UNITLASTNAME");
        slsId = coFacade.createSlsman(s);
        assertNotNull(slsId);
    }

    /**
     * Test of searchSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testSearchSlsman() throws Exception {
        System.out.println("searchSlsman");
        String p_strKeyword = slsId;

        List result = coFacade.searchSlsman(p_strKeyword);
        System.out.println("searchSlsman result=" + result);
        assertNotNull(result);
    }

    /**
     * Test of getSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testGetSlsman() throws Exception {
        System.out.println("getSlsman");
        String p_strSlsman_id = slsId;
        String expResult = "UNITFIRSTNAME";
        Slsman result = coFacade.getSlsman(p_strSlsman_id);
        assertEquals(expResult, result.getFname());

    }

    /**
     * Test of editSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testEditSlsman() throws Exception {
        System.out.println("editSlsman");
        s.setSlsman(slsId);
        s.setLname("UNITLASTNAME_2");

        coFacade.editSlsman(s);
        Slsman result = coFacade.getSlsman(slsId);
        assertEquals("UNITLASTNAME_2", result.getLname());

    }

    /**
     * Test of deleteSlsman method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteSlsman() throws Exception {
        System.out.println("deleteSlsman");
        Slsman p_slsman = new Slsman(slsId);
        coFacade.deleteSlsman(p_slsman);
        Slsman result = coFacade.getSlsman(slsId);
        assertNull(result);
    }

    /**
     * Test of createCo method, of class CoFacadeRemote.
     */
    @Test
    public void testCreateCo() throws Exception {
        System.out.println("createCo");
        co = new Co("autogenID");
        co.setCustomer(new Customer("0000002"));
        co.setCustPo("UNIT-CUST-PO");
        co.setOrderdate(new Date());
        co.setDuedate(new Date());
        co.setTerm(new Term("CSH"));
        co.setCostat(new Co_stat('C'));
        co.setSlsman(new Slsman("S000001"));
        co.setTax(new Tax("V07"));
        co.setUuser("UNITUSER");
        co.setUdate(new Date());
        co.setCdate(new Date());
        co.setCuser("UNITUSER");


        coId = coFacade.createCo(co);
        System.out.println("createCo id=" + coId);
        assertNotNull(coId);
    }

    /**
     * Test of searchCo method, of class CoFacadeRemote.
     */
    @Test
    public void testSearchCo() throws Exception {
        System.out.println("searchCo");
        String p_strCustomerId = coId;

        List result = coFacade.searchCo(p_strCustomerId);
        assertNotNull(result);
        System.out.println("searchCo result="+result);
    }



    /**
     * Test of editCo method, of class CoFacadeRemote.
     */
    @Test
    public void testEditCo() throws Exception {
        System.out.println("editCo");
        co.setCoId(coId);
        co.setCuser("UNITUSER2");
        coFacade.editCo(co);
        
    }

        /**
     * Test of getCo method, of class CoFacadeRemote.
     */
    @Test
    public void testGetCo() throws Exception {
        System.out.println("getCo");
        String strCo_id = coId;


        Co result = coFacade.getCo(strCo_id);
        assertNotNull(result);
        assertEquals("UNITUSER", result.getCuser());
        System.out.println("getCo result="+result);
    }

    /**
     * Test of deleteCo method, of class CoFacadeRemote.
     */
    @Test
    public void testDeleteCo() throws Exception {
        System.out.println("deleteCo");
        Co p_co = new Co(coId);

        coFacade.deleteCo(p_co);
        Co result = coFacade.getCo(coId);
        assertNull(result);
    }

    

   

    

    

    

    /**
     * Test of getListCo_stat method, of class CoFacadeRemote.
     */
    @Test
    public void testGetListCo_stat() throws Exception {
        System.out.println("getListCo_stat");

        
        List result = coFacade.getListCo_stat();
        assertNotNull(result);
        System.out.println("getListCo_stat result="+result);
    }

    

    

    

    

   
}
