package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class TimeUtils {

    public static final long MILLISECONDS_PER_MINUTE = 60000L;

    public static final long MILLISECONDS_PER_DAY = 86400000L;

    public static final long MILLISECONDS_PER_THREE_YEARS = 94608000000L;

    public static final int RUNEDAYS_SINCE_UNIX_EPOCH = 11745;

    @OriginalMember(owner = "client!iba", name = "o", descriptor = "Ljava/util/Calendar;")
    public static final Calendar CALENDAR = Calendar.getInstance();

    @OriginalMember(owner = "client!iba", name = "p", descriptor = "Ljava/util/Calendar;")
    public static final Calendar GMT_CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    @OriginalMember(owner = "client!al", name = "k", descriptor = "[[Ljava/lang/String;")
    public static final String[][] MONTHS_BY_LANGUAGE = {
        {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"},
        {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"},
        {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"},
        {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"},
        {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}
    };

    @OriginalMember(owner = "client!kj", name = "d", descriptor = "I")
    public static int clock = 0;

    @OriginalMember(owner = "client!uca", name = "a", descriptor = "(JZ)V")
    public static void sleep(@OriginalArg(0) long milliseconds) {
        if (milliseconds <= 0L) {
            return;
        }

        if (milliseconds % 10L == 0L) {
            sleepUninterruptibly(milliseconds - 1L);
            sleepUninterruptibly(1L);
        } else {
            sleepUninterruptibly(milliseconds);
        }
    }

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(JB)V")
    public static void sleepUninterruptibly(@OriginalArg(0) long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (@Pc(12) InterruptedException ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!rfa", name = "a", descriptor = "(IJ)V")
    public static void setTime(@OriginalArg(1) long milliseconds) {
        CALENDAR.setTime(new Date(milliseconds));
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(IJ)V")
    public static void setGmtTime(@OriginalArg(1) long milliseconds) {
        GMT_CALENDAR.setTime(new Date(milliseconds));
    }

    @OriginalMember(owner = "client!qha", name = "a", descriptor = "(IIJ)Ljava/lang/String;")
    public static String dateFromTime(@OriginalArg(2) long time, @OriginalArg(1) int language) {
        setTime(time);
        @Pc(19) int day = CALENDAR.get(Calendar.DAY_OF_MONTH);
        @Pc(23) int month = CALENDAR.get(Calendar.MONTH);
        @Pc(27) int year = CALENDAR.get(Calendar.YEAR);
        return language == 3 ? simpleDateFromTime(time, language) : Integer.toString(day / 10) + day % 10 + "-" + MONTHS_BY_LANGUAGE[language][month] + "-" + year;
    }

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(JBI)Ljava/lang/String;")
    public static String simpleDateFromTime(@OriginalArg(0) long time, @OriginalArg(2) int language) {
        setTime(time);
        @Pc(17) int day = CALENDAR.get(Calendar.DAY_OF_MONTH);
        @Pc(23) int month = CALENDAR.get(Calendar.MONTH) + 1;
        @Pc(27) int year = CALENDAR.get(Calendar.YEAR);
        return Integer.toString(day / 10) + day % 10 + "/" + month / 10 + month % 10 + "/" + year % 100 / 10 + year % 10;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(JZII)Ljava/lang/String;")
    public static String datetimeFromTime(@OriginalArg(0) long time, @OriginalArg(2) int language) {
        setGmtTime(time);
        @Pc(16) Calendar calendar = GMT_CALENDAR;
        @Pc(20) int day = calendar.get(Calendar.DAY_OF_MONTH);
        @Pc(24) int month = calendar.get(Calendar.MONTH);
        @Pc(28) int year = calendar.get(Calendar.YEAR);
        @Pc(32) int hour = calendar.get(Calendar.HOUR_OF_DAY);
        @Pc(36) int minute = calendar.get(Calendar.MINUTE);
        return language == 3 ? simpleDatetimeFromTime(time, language) : Integer.toString(day / 10) + day % 10 + "-" + MONTHS_BY_LANGUAGE[language][month] + "-" + year + " " + hour / 10 + hour % 10 + ":" + minute / 10 + minute % 10;
    }

    @OriginalMember(owner = "client!dn", name = "a", descriptor = "(ZIJI)Ljava/lang/String;")
    public static String simpleDatetimeFromTime(@OriginalArg(2) long time, @OriginalArg(3) int language) {
        setGmtTime(time);
        @Pc(10) Calendar calendar = GMT_CALENDAR;
        @Pc(20) int day = calendar.get(Calendar.DAY_OF_MONTH);
        @Pc(26) int month = calendar.get(Calendar.MONTH) + 1;
        @Pc(38) int year = calendar.get(Calendar.YEAR);
        @Pc(42) int hour = calendar.get(Calendar.HOUR_OF_DAY);
        @Pc(46) int minute = calendar.get(Calendar.MINUTE);
        return Integer.toString(day / 10) + day % 10 + "/" + month / 10 + month % 10 + "/" + year % 100 / 10 + year % 10 + " " + hour / 10 + hour % 10 + ":" + minute / 10 + minute % 10;
    }

    @OriginalMember(owner = "client!gka", name = "a", descriptor = "(II)[I")
    public static int[] dateFromRunedays(@OriginalArg(0) int runedays) {
        @Pc(6) int[] date = new int[3];
        setTime(timeFromRunedays(runedays));
        date[0] = CALENDAR.get(Calendar.DAY_OF_MONTH);
        date[1] = CALENDAR.get(Calendar.MONTH);
        date[2] = CALENDAR.get(Calendar.YEAR);
        return date;
    }

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(ZJ)I")
    public static int yearFromTime(@OriginalArg(1) long time) {
        setTime(time);
        return CALENDAR.get(Calendar.YEAR);
    }

    @OriginalMember(owner = "client!bfa", name = "a", descriptor = "(IIIIIIB)J")
    public static long timeFromDate(@OriginalArg(4) int dayOfMonth, @OriginalArg(0) int month, @OriginalArg(2) int year) {
        GMT_CALENDAR.clear();
        GMT_CALENDAR.set(year, month, dayOfMonth, 12, 0, 0);
        return GMT_CALENDAR.getTime().getTime();
    }

    @OriginalMember(owner = "client!bea", name = "a", descriptor = "(IZ)J")
    public static long timeFromRunedays(@OriginalArg(0) int days) {
        return (long) (days + RUNEDAYS_SINCE_UNIX_EPOCH) * MILLISECONDS_PER_DAY;
    }

    @OriginalMember(owner = "client!cd", name = "a", descriptor = "(JZ)I")
    public static int runedaysFromTime(@OriginalArg(0) long time) {
        return (int) (time / MILLISECONDS_PER_DAY) - RUNEDAYS_SINCE_UNIX_EPOCH;
    }

    private TimeUtils() {
        /* empty */
    }
}
