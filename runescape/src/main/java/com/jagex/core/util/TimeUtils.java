package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class TimeUtils {

    @OriginalMember(owner = "client!iba", name = "o", descriptor = "Ljava/util/Calendar;")
    public static final Calendar aCalendar2 = Calendar.getInstance();

    @OriginalMember(owner = "client!al", name = "k", descriptor = "[[Ljava/lang/String;")
    public static final String[][] aStringArrayArray1 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}};

    public static final int RUNEDATE_DAYS_SINCE_UNIX_EPOCH = 11745;

    public static final long MILLISECONDS_PER_DAY = 86400000L;

    @OriginalMember(owner = "client!iba", name = "p", descriptor = "Ljava/util/Calendar;")
    public static final Calendar aCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

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
    public static void method7276(@OriginalArg(1) long arg0) {
        aCalendar2.setTime(new Date(arg0));
    }

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(JBI)Ljava/lang/String;")
    public static String method8243(@OriginalArg(0) long arg0, @OriginalArg(2) int arg1) {
        method7276(arg0);
        @Pc(17) int date = aCalendar2.get(Calendar.DATE);
        @Pc(23) int month = aCalendar2.get(Calendar.MONTH) + 1;
        @Pc(27) int year = aCalendar2.get(Calendar.YEAR);
        return Integer.toString(date / 10) + date % 10 + "/" + month / 10 + month % 10 + "/" + year % 100 / 10 + year % 10;
    }

    @OriginalMember(owner = "client!qha", name = "a", descriptor = "(IIJ)Ljava/lang/String;")
    public static String parseDate(@OriginalArg(1) int arg0, @OriginalArg(2) long arg1) {
        method7276(arg1);
        @Pc(19) int date = aCalendar2.get(Calendar.DATE);
        @Pc(23) int month = aCalendar2.get(Calendar.MONTH);
        @Pc(27) int year = aCalendar2.get(Calendar.YEAR);
        return arg0 == 3 ? method8243(arg1, arg0) : Integer.toString(date / 10) + date % 10 + "-" + aStringArrayArray1[arg0][month] + "-" + year;
    }

    @OriginalMember(owner = "client!bea", name = "a", descriptor = "(IZ)J")
    public static long timeFromRunedate(@OriginalArg(0) int date) {
        return (long) (date + RUNEDATE_DAYS_SINCE_UNIX_EPOCH) * MILLISECONDS_PER_DAY;
    }

    private TimeUtils() {
        /* empty */
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(IJ)V")
    public static void method5196(@OriginalArg(1) long milliseconds) {
        aCalendar1.setTime(new Date(milliseconds));
    }

    @OriginalMember(owner = "client!dn", name = "a", descriptor = "(ZIJI)Ljava/lang/String;")
    public static String method2198(@OriginalArg(2) long arg0, @OriginalArg(3) int arg1) {
        method5196(arg0);
        @Pc(10) Calendar local10 = aCalendar1;
        @Pc(20) int local20 = local10.get(5);
        @Pc(26) int local26 = local10.get(2) + 1;
        @Pc(38) int local38 = local10.get(1);
        @Pc(42) int local42 = local10.get(11);
        @Pc(46) int local46 = local10.get(12);
        return Integer.toString(local20 / 10) + local20 % 10 + "/" + local26 / 10 + local26 % 10 + "/" + local38 % 100 / 10 + local38 % 10 + " " + local42 / 10 + local42 % 10 + ":" + local46 / 10 + local46 % 10;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(JZII)Ljava/lang/String;")
    public static String formatDatetime(@OriginalArg(0) long milliseconds, @OriginalArg(2) int language) {
        method5196(milliseconds);
        @Pc(16) Calendar local16 = aCalendar1;
        @Pc(20) int local20 = local16.get(5);
        @Pc(24) int local24 = local16.get(2);
        @Pc(28) int local28 = local16.get(1);
        @Pc(32) int local32 = local16.get(11);
        @Pc(36) int local36 = local16.get(12);
        return language == 3 ? method2198(milliseconds, language) : Integer.toString(local20 / 10) + local20 % 10 + "-" + aStringArrayArray1[language][local24] + "-" + local28 + " " + local32 / 10 + local32 % 10 + ":" + local36 / 10 + local36 % 10;
    }
}
