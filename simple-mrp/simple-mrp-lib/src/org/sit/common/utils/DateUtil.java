/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sit.common.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author wisaruthkea
 */
public class DateUtil {

    public static java.sql.Date getDate() {
        Calendar ca = Calendar.getInstance();
        Date now = new Date(ca.getTimeInMillis());
        return new Date(now.getTime());
    }

    public static java.sql.Timestamp getTimestamp() {
        Calendar ca = Calendar.getInstance();
        Date now = new Date(ca.getTimeInMillis());
        return new Timestamp(now.getTime());
    }
}
