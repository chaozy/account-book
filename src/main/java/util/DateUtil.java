package util;

/**
 * DateUtil stores the method used for
 */

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static long millisecondOfADay = 1000 * 60 * 60 * 24;
    /**
     * Convert date in java.util.Date to java.sql.Date
     * Since the date get from JXDate is in util.Date while MySql requires sql.Date
     * @param date
     * @return
     */
    public static java.sql.Date util2sql(Date date){
        return new java.sql.Date(date.getTime());
    }

    /**
     * GET the date of today then set hour, second and millisecond to 0, as no such data in JXDate
     * @return
     */
    public static Date today(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }


    /**
     * return the date of first day of current month
     * @return
     */
    public static Date monthBegin(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        // 1 here represents the first day of any month
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
    /**
     * return the date of last day of current month
     */
    public static Date monthEnd(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static int daysLeftInMonth(){
        long lastDay = monthEnd().getTime();
        long today = today().getTime();
        return (int)((lastDay - today) / millisecondOfADay) + 1;
    }

    public static int daysPassInMonth(){
        long firstDay = monthBegin().getTime();
        long today = today().getTime();

        return (int)((today - firstDay) / millisecondOfADay) + 1;
    }

    public static int daysInMonth(){
        long lastDay = monthEnd().getTime();
        long firstDay = monthBegin().getTime();
        return (int)((lastDay - firstDay) / millisecondOfADay) + 1;
    }

}
