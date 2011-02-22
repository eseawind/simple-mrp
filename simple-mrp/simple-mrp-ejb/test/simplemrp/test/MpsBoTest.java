/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.test;

import simplemrp.entity.Mps;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import org.sit.common.utils.OperationResult;
import java.util.ArrayList;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Item;
import simplemrp.entity.Customer;
import simplemrp.entity.Slsman;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Tax;
import simplemrp.entity.Term;
import org.sit.common.utils.DateUtil;
import simplemrp.entity.Co;
import simplemrp.facade.PpFacadeRemote;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.dao.InfForecastDao;
import simplemrp.dao.InfCoitemDao;
import simplemrp.bo.InfForecastBo;
import simplemrp.bo.InfCoitemBo;
import simplemrp.entity.Forecast;
import simplemrp.entity.Coitem;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import simplemrp.constant.CoConstant;
import simplemrp.util.EJBLookup;
import static org.junit.Assert.*;

/**
 *
 * @author Golf
 */
public class MpsBoTest {
    private CoFacadeRemote coFacade;
    private PpFacadeRemote ppFacade;

    private List<Coitem> m_lsBackupCoitem;
    private List<Forecast> m_lsBackupForecast;

    private Co m_coDummy;

    private String m_strLastMps_id;

    private String DUMMY_ITEM_1 = "LEG-ROUND-METAL";
    private String DUMMY_ITEM_2 = "SCREW-ST-1INCH";
    private Map<String, Double> m_mapDemand;

    public MpsBoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        coFacade = EJBLookup.getCoFacade();
        ppFacade = EJBLookup.getPpFacade();

        m_lsBackupCoitem = coFacade.getForMpsGen();

        for(int i = 0; i < m_lsBackupCoitem.size(); i++) {
            Coitem coitem = m_lsBackupCoitem.get(i);
            coitem.setMps_id("TEST999");

            coFacade.editCoitem(coitem);
        }

        m_lsBackupForecast = ppFacade.getForMpsGen();

        for(int i = 0; i < m_lsBackupForecast.size(); i++) {
            Forecast forecast = m_lsBackupForecast.get(i);
            forecast.setMps_id("TEST999");

            ppFacade.editForecast(forecast);
        }

        m_mapDemand = new TreeMap<String, Double>();
        m_mapDemand.put(DUMMY_ITEM_1, new Double(200));
        m_mapDemand.put(DUMMY_ITEM_2, new Double(1000));

        genDummyCo();

        m_strLastMps_id = ppFacade.getMPSLastId();
    }

    @After
    public void tearDown() throws Exception {
        m_lsBackupCoitem = coFacade.getForMpsGen();

        for(int i = 0; i < m_lsBackupCoitem.size(); i++) {
            Coitem coitem = m_lsBackupCoitem.get(i);
            coitem.setMps_id(null);

            coFacade.editCoitem(coitem);
        }

        m_lsBackupForecast = ppFacade.getForMpsGen();

        for(int i = 0; i < m_lsBackupForecast.size(); i++) {
            Forecast forecast = m_lsBackupForecast.get(i);
            forecast.setMps_id(null);

            ppFacade.editForecast(forecast);
        }
    }

    private void genDummyCo() throws Exception {
        try {
            m_coDummy = new Co();
            m_coDummy.setOrderdate(DateUtil.getDate());
            m_coDummy.setDuedate(DateUtil.addDays(DateUtil.getDate(), 20));
            m_coDummy.setTerm(new Term("CR30"));
            m_coDummy.setTax(new Tax("V07"));
            m_coDummy.setCostat(new Co_stat(CoConstant.CO_STAT_ORDER));
            m_coDummy.setSlsman(new Slsman("S000001"));
            m_coDummy.setCustomer(new Customer("0000002"));
            m_coDummy.setUuser("dummyuser");

            String strCo_id = coFacade.createCo(m_coDummy);
            
            m_coDummy.setCoId(strCo_id);

            List<Coitem> lsCoitem = new ArrayList<Coitem>();

            {//Item 1
                Coitem coitem = new Coitem();
                coitem.setCostat(new Co_stat(CoConstant.CO_STAT_ORDER));
                coitem.setItem(new Item(DUMMY_ITEM_1));
                coitem.setPrice(new Double(500));
                coitem.setQty(m_mapDemand.get(DUMMY_ITEM_1));
                coitem.setUuser("dummyuser");

                CoitemPK coitemPK = new CoitemPK();
                coitemPK.setCoId(m_coDummy.getCoId());
                coitem.setCoitemPK(coitemPK);

                Integer intCoSeq = coFacade.createCoitem(coitem);
                coitemPK.setCoSeq(intCoSeq);

                coitem.setCoitemPK(coitemPK);

                lsCoitem.add(coitem);
            }

            {//Item 2
                Coitem coitem = new Coitem();
                coitem.setCostat(new Co_stat(CoConstant.CO_STAT_ORDER));
                coitem.setItem(new Item(DUMMY_ITEM_2));
                coitem.setPrice(new Double(5));
                coitem.setQty(m_mapDemand.get(DUMMY_ITEM_2));
                coitem.setUuser("dummyuser");

                CoitemPK coitemPK = new CoitemPK();
                coitemPK.setCoId(m_coDummy.getCoId());
                coitem.setCoitemPK(coitemPK);

                Integer intCoSeq = coFacade.createCoitem(coitem);
                coitemPK.setCoSeq(intCoSeq);

                coitem.setCoitemPK(coitemPK);

                lsCoitem.add(coitem);
            }

            m_coDummy.setCoitemCollection(lsCoitem);
            
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Test
    public void testGenerateMPS() throws Exception {
        try {
            OperationResult result = ppFacade.generateMPS(m_strLastMps_id);
            Map<String, Mps> mapMPS = (Map<String, Mps>)result.getObj();

            Iterator itr = mapMPS.keySet().iterator();
            while(itr.hasNext()) {
                String strItem = (String)itr.next();
                Mps mps = mapMPS.get(strItem);

                if(m_mapDemand.containsKey(strItem)) {
                    
                } else {
                    fail("Item demand for ");
                }
            }
            
        } catch(Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }
}
