/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sit.common.utils;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author wisaruthkea
 */
public class DateUtil {

    public static Date getDate() {
        Calendar ca = Calendar.getInstance();
        Date now = new Date(ca.getTimeInMillis());
        return new Date(now.getTime());
    }

    public static Date addDays(Date date, int days) throws Exception {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(c.DATE, days);

        return new Date(c.getTime().getTime());
    }
}
