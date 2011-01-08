/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sit.common.utils;

/**
 *
 * @author wisaruthkea
 */
public class StringUtil {
    public static final String zeroLeading(String p_strValue, int p_intLength) throws Exception {
        String strFull = "00000000000000000000";

        if(p_intLength > strFull.length()) {
            throw new Exception("Length Limit " + p_intLength + "/" +strFull.length());
        }

        try {
            Integer intNext = new Integer(p_strValue).intValue();
            strFull = strFull + intNext;
        } catch (Exception ex) {
            //Do Nothing
        }

        strFull = strFull.substring(strFull.length() - p_intLength, strFull.length());

        return strFull;
    }
}
