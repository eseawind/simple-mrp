/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.test;

import javax.naming.InitialContext;
import simplemrp.entity.Bank;
import java.util.logging.Level;
import java.util.logging.Logger;
import simplemrp.facade.CoFacadeRemote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Golf
 */
public class CoFacadeRemoteTest {
    private static CoFacadeRemote coFacade;

    public CoFacadeRemoteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        coFacade = (CoFacadeRemote) ContextFactory.getContext().lookup("CoFacadeRemote");
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

    @Test
    public void testCoFacadeRemote() {
        try {
            Bank bank = coFacade.getBank("TEST");
            if(bank != null) {
                System.out.println(bank.getBankId() + ":" + bank.getDescription());
            } else {
                System.out.println("Find not found");
            }
        } catch (Exception ex) {
            Logger.getLogger(CoFacadeRemoteTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
}