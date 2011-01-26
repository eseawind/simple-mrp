package simplemrp.mbean.co;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlForm;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.sit.common.utils.StringUtil;
import simplemrp.entity.Co_stat;
import simplemrp.entity.Coitem;
import simplemrp.entity.CoitemPK;
import simplemrp.entity.Item;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.util.CoConstant;
import simplemrp.util.EJBLookup;
import simplemrp.util.FacesUtils;

/**
 *
 * @author Golf
 */
public class CoitemBean extends CoitemAttr {

    private HtmlForm init;

    /** Creates a new instance of CoitemBean */
    public CoitemBean() {
    }

    public void loadDetail(ActionEvent e) {
        try {
            String strMode = getP_mode();
            String strCoId = getP_coId();

            if(strMode.equals(MODE_EDIT)) {
                Integer intCoSeq = getP_coSeq();

                checkCoitem(strCoId, intCoSeq);
            } else {
                setMode(MODE_NEW);
                setCoId(strCoId);
                setStat(CoConstant.CO_STAT_ORDER);
                loadCoStat();
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void addCoitem(String p_strCoId) {
        setMode(MODE_NEW);
    }

    private void checkCoitem(String p_strCoId, Integer p_intCoSeq) {
        try {
            setMode(MODE_EDIT);
            CoFacadeRemote coFacade = EJBLookup.getCoFacade();
            CoitemPK coitemPK = new CoitemPK(p_strCoId, p_intCoSeq);
            Coitem coitem = coFacade.getCoitem(coitemPK);

            if(coitem != null) {
                setCoId(coitem.getCoitemPK().getCoId());
                setCoSeq(coitem.getCoitemPK().getCoSeq());
                setItem(coitem.getItem().getItem());
                setItemDesc(coitem.getItem().getDescription());
                setPrice(coitem.getPrice());
                setQty(coitem.getQty());
                setQtyShip(coitem.getQtyship());
                setStat(coitem.getCostat().getStat());

                setUdate(coitem.getUdate());
                setUuser(coitem.getUuser());

                setCdate(coitem.getCdate());
                setCuser(coitem.getCuser());

                loadCoStat();
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    private void loadCoStat() throws Exception {
        CoFacadeRemote coFacade = EJBLookup.getCoFacade();
        List<Co_stat> lsAllCoitemStat = coFacade.getListCo_stat();

        List lsCoStat = new ArrayList<SelectItem>();
        for(int i = 0; i < lsAllCoitemStat.size(); i++) {
            Co_stat coStat = lsAllCoitemStat.get(i);
            SelectItem selectItem = new SelectItem(coStat.getStat(), coStat.getDescription());

            lsCoStat.add(selectItem);
        }

        setLsCoitemStat(lsCoStat);
    }

    public void doSave(ActionEvent e) {
        try {
            Coitem coitem = new Coitem();

            Co_stat co_stat = new Co_stat();
            co_stat.setStat(getStat());
            coitem.setCostat(co_stat);

            Item item = new Item();
            item.setItem(getItem());
            coitem.setItem(item);

            coitem.setPrice(getPrice());
            coitem.setQty(getQty());

            coitem.setUuser(getSessionUserId());

            CoFacadeRemote coFacade = EJBLookup.getCoFacade();

            if(getMode().equals(MODE_NEW)) {
                CoitemPK coitemPK = new CoitemPK();
                coitemPK.setCoId(getCoId());
                coitem.setCoitemPK(coitemPK);

                Integer intCoSeq = coFacade.createCoitem(coitem);

                checkCoitem(getCoId(), intCoSeq);

                message("Save Complete");
            } else if(getMode().equals(MODE_EDIT)) {
                CoitemPK coitemPK = new CoitemPK(getCoId(), getCoSeq());
                coitem.setCoitemPK(coitemPK);

                coFacade.editCoitem(coitem);

                checkCoitem(getCoId(), getCoSeq());

                message("Save Complete");
            } else {
                message("Unoknow Operation Mode");
            }

        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }

    public void doCheckItem(ActionEvent e) {
        try {
            String strItem = getItem();
            MaFacadeRemote maFacade = EJBLookup.getMaFacade();
            Item item = maFacade.getItem(strItem);

            if(item != null) {
                setItem(item.getItem());
                setItemDesc(item.getDescription());
            } else {
                setItem(null);
                setItemDesc(null);
                message("Find Not Found");
            }
        } catch(Exception ex) {
            message(ex.getMessage());
        }
    }
}
