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

    public static final String prefixZero(String p_strValue, int p_intLength) throws Exception {
        String strFull = "00000000000000000000";

        if(p_intLength > strFull.length()) {
            throw new Exception("Length Limit " + p_intLength + "/" + strFull.length());
        }

        try {
            Integer intNext = new Integer(p_strValue).intValue();
            strFull = strFull + intNext;
        } catch(Exception ex) {
            //Do Nothing
        }

        strFull = strFull.substring(strFull.length() - p_intLength, strFull.length());

        return strFull;
    }

    public static String prefixString(String p_strPrefix, int p_intLen) {
        String strReturn = "";

        if(p_strPrefix == null) {
            p_strPrefix = "";
        }

        String prex = p_strPrefix.trim().toUpperCase();
        String nan = "";
        String an = "";
        int n = 0;

        if(prex.length() < p_intLen) {
            for(int i = 0; i < prex.length(); i++) {
                char tmp = prex.charAt(i);
                Integer pp = new Integer(tmp);

                if(pp.intValue() >= 65 && pp.intValue() <= 90) {
                    nan = nan.concat(new String().valueOf(tmp));

                } else {
                    an = an.concat(new String().valueOf(prex.charAt(i)));
                    n++;
                }
            }

            String st = "0";

            for(int j = 0; j < p_intLen - 1; j++) {
                st = st + "0";
            }

            if(n == 0) {
                strReturn = nan;

            } else {
                int pad = p_intLen - n - nan.length();
                strReturn = nan + st.substring(0, pad) + an;
            }
        } else {
            strReturn = prex.toUpperCase();
        }

        return strReturn;
    }

    public static Integer toInteger(String p_strNumber) throws Exception {
        Integer intRet = null;

        try {
            if((p_strNumber == null) || (p_strNumber.length() == 0)) {
                intRet = 0;
            } else {
                Double dblValue = toDouble(p_strNumber);
                intRet = new Integer(dblValue.intValue());
            }
        } catch(Exception ex) {
            throw new Exception("toInteger(): " + ex.getMessage(), ex);
        }

        return intRet;
    }

    public static Double toDouble(String p_strNumber) throws Exception {
        Double dblRet = null;

        try {
            if((p_strNumber == null) || (p_strNumber.length() == 0)) {
                dblRet = 0.0;
            } else {
                p_strNumber = p_strNumber.replaceAll(",", "");
                dblRet = new Double(Double.parseDouble(p_strNumber));
            }
        } catch(Exception ex) {
            throw new Exception("toDouble(): " + ex.getMessage(), ex);
        }

        return dblRet;
    }

    public static double toDouble(Double dblValue) throws Exception {
        if(dblValue != null) {
            return dblValue.doubleValue();
        } else {
            return 0.0;
        }
    }
}
