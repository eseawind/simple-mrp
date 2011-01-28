/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.util;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.persistence.Query;

/**
 *
 * @author Golf
 */
public class ParamBinder {
    private Map mapString;
    private Map mapNumber;
    private Map mapDate;

    public ParamBinder() {
        mapString = new TreeMap<String, String>();
        mapNumber = new TreeMap<String, Number>();
        mapDate = new TreeMap<String, Date>();
    }

    public void put(String p_name, String p_value) {
        mapString.put(p_name, p_value);
    }
    
    public void put(String p_name, Number p_value) {
        mapNumber.put(p_name, p_value);
    }

    public void put(String p_name, Date p_value) {
        mapDate.put(p_name, p_value);
    }

    public Query bind(Query q) {
        if(mapDate.size() > 0) {
            Set setKey = mapDate.keySet();
            Iterator itr = setKey.iterator();

            while(itr.hasNext()) {
                String strKey = (String)itr.next();
                q.setParameter(strKey, mapDate.get(strKey));
            }
        }

        if(mapNumber.size() > 0) {
            Set setKey = mapNumber.keySet();
            Iterator itr = setKey.iterator();

            while(itr.hasNext()) {
                String strKey = (String)itr.next();
                q.setParameter(strKey, mapNumber.get(strKey));
            }
        }

        if(mapString.size() > 0) {
            Set setKey = mapString.keySet();
            Iterator itr = setKey.iterator();

            while(itr.hasNext()) {
                String strKey = (String)itr.next();
                q.setParameter(strKey, mapString.get(strKey));
            }
        }

        return q;
    }
}
