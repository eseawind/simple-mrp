/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sit.common.utils;

import java.util.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 *
 * @author Golf
 */
public class SQLUtil {
public static String convert(String p_string) {
    StringBuffer buffer = null;

    if((p_string == null) || (p_string.length() == 0)) {
      return new String("''");

    } else {
      p_string = p_string.replaceAll("'", "''");

      buffer = new StringBuffer(p_string.length() + 2);
      buffer.append("'").append(p_string).append("'");

      return buffer.toString();
    }
  }

  public static String convert(Timestamp p_timestamp) {
    StringBuffer buffer = new StringBuffer();

    if(p_timestamp == null) {
      buffer.append("''");
    } else {
      GregorianCalendar c = new GregorianCalendar();
      c.setTime(p_timestamp);

      String strAM_PM = null;
      String am = "AM";
      String pm = "PM";

      if(c.get(c.AM_PM) == c.AM) {
	strAM_PM = am;
      } else {
	strAM_PM = pm;
      }

      int hour = c.get(c.HOUR);

      if(hour == 0) {
	hour = 12;

	if(strAM_PM.equals(am)) {
	  strAM_PM = pm;
	} else {
	  strAM_PM = am;
	}
      }

      String strMonth = "00" + (c.get(c.MONTH) + 1);
      strMonth = strMonth.substring(strMonth.length() - 2, strMonth.length());

      String strDay = "00" + c.get(c.DAY_OF_MONTH);
      strDay = strDay.substring(strDay.length() - 2, strDay.length());

      buffer.append("TO_Date('");
      buffer.append(c.get(c.YEAR));
      buffer.append("-").append(strMonth);
      buffer.append("-").append(strDay);
      buffer.append(" ").append(hour);
      buffer.append(":").append(c.get(c.MINUTE));
      buffer.append(":").append(c.get(c.SECOND));
      buffer.append(" ").append(strAM_PM);
      buffer.append("', 'YYYY-MM-DD HH:MI:SS AM')");
    }

    return buffer.toString();
  }

  public static String convert(Number p_number) {
    if(p_number == null) {
      return new String("''");

    } else {
      return p_number.toString();
    }
  }
}
