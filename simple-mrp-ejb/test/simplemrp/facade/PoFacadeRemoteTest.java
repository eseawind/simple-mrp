/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import simplemrp.constant.PoConstant;
import simplemrp.entity.Item;
import static org.junit.Assert.*;
import simplemrp.entity.Po;
import simplemrp.entity.Poitem;
import simplemrp.entity.PoitemPK;
import simplemrp.entity.Pr;
import simplemrp.entity.Pr_stat;
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
    private static MaFacadeRemote maFacade;
    public PoFacadeRemoteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        poFacade = (PoFacadeRemote) ContextFactory.getContext().lookup(BindingName.PoFacadeRemote);
        maFacade= (MaFacadeRemote)ContextFactory.getContext().lookup(BindingName.MaFacadeRemote);

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
     * Test of getPoitemByPo method, of class PoFacadeRemote.
     */
    @Test
    public void testGetPoitemByPr() throws Exception {
        System.out.println("getPoitemByPr");
        String p_strPr_id = "R000001";

        
        List result = poFacade.getPoitemByPr(p_strPr_id);
        System.out.println("getPoitemByPr Result="+result);
        assertNotNull(result);
        
    }

    

     /**
     * Test of approvePr method, of class PoFacadeRemote.
     */
    @Test
    public void testApprovePr() throws Exception {
        System.out.println("approvePr");
        //create mockup object
        Pr pr = new Pr();
        pr.setPrId("AUTOID");
        pr.setPrstat(new Pr_stat(PoConstant.PR_STAT_REQUEST)); //request
        pr.setRequester("UNITTEST");
        pr.setApprover("UNITTEST");
        pr.setReqDate(new Date());
        pr.setNote("REQUEST BY UNITTEST");
        pr.setCuser("unittest");
        pr.setCdate(new Date());
        pr.setUdate(new Date());
        pr.setUuser("unittest");
        String genratedKey = poFacade.createPr(pr);
        System.out.println("create pr id="+genratedKey);
        
        //create pr item
        pr.setPrId(genratedKey);
        Item t1 = maFacade.getItem("CHAIR-WOOD-001");
        Pritem item1 = new Pritem(genratedKey,1);
        item1.setItem(t1);
        item1.setQty(2.0);
        item1.setDueDate(new Date());
        item1.setCdate(new Date());
        item1.setCuser("UNITTEST");
        int i1 = poFacade.createPritem(item1);
        System.out.println("Create pritem="+item1+" result="+i1);

        Item t2 = maFacade.getItem("DINNER-DESK-001");
        Pritem item2 = new Pritem(genratedKey,2);
        item2.setItem(t2);
        item2.setQty(5.0);
        item2.setDueDate(new Date());
        item2.setCdate(new Date());
        item2.setCuser("UNITTEST");
        int i2 = poFacade.createPritem(item2);
        System.out.println("Create pritem="+item2+" result="+i2);
        
       


        // chage pr stat to approve
        Pr pr2 = poFacade.getPr(genratedKey);
        pr2.setApprover("dummy_user");
        pr2.setPrstat(new Pr_stat(PoConstant.PR_STAT_APPROVED)); //chage stat to approve
        pr2.setUuser("dummy_user");
        pr2.setUdate(new Date());
        pr2.setNote("autogen by unit test");
        poFacade.editPr(pr2);
        ///

        ///check po
        String poid="";
        Double qtypo = 0.0;
        System.out.println("get poitem by pr = "+genratedKey);
        List<Poitem> lsPoitem = poFacade.getPoitemByPr(genratedKey);
        System.out.println("po item after approve="+lsPoitem);
        for(Poitem poitem:lsPoitem){
            poid= poitem.getPo().getPoId();
            System.out.print("poitem ="+poitem.toString());
            qtypo +=poitem.getQty();

        }
        System.out.println("poitem of po:"+poid+" qty sum="+qtypo);
        assertEquals(new Double(7.0), qtypo);
        //teardown
        // del po
        List<Poitem> delPoItem = poFacade.getPoitemByPo(poid);
        for(Poitem i:delPoItem){
            poFacade.deletePoitem(i);
        }
        poFacade.deletePo(new Po(poid));
        //del pr

        List<Pritem> delPrItem = poFacade.getPritemByPr(genratedKey);
        for(Pritem i:delPrItem){
            poFacade.deletePritem(i);
        }
        poFacade.deletePr(new Pr(genratedKey));






        
    }

    

}