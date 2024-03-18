package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class StringTools {


    @OriginalMember(owner = "client!oo", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean isNumeric(@OriginalArg(1) String string) {
        return isNumeric(string, 10);
    }

    @OriginalMember(owner = "client!wda", name = "a", descriptor = "(ZILjava/lang/String;I)Z")
    public static boolean isNumeric(@OriginalArg(2) String string, int radix) {
        return isNumeric(string, radix, true);
    }

    private static boolean isNumeric(String string, int radix, boolean ignorePlus) {
        if (radix > 36) {
            throw new IllegalArgumentException("Invalid radix:" + radix);
        }

        @Pc(27) boolean negative = false;
        @Pc(29) boolean number = false;
        @Pc(31) int value = 0;
        @Pc(34) int length = string.length();

        for (@Pc(36) int index = 0; index < length; index++) {
            @Pc(41) char c = string.charAt(index);
            if (index == 0) {
                if (c == '-') {
                    negative = true;
                    continue;
                }
                if (c == '+' && ignorePlus) {
                    continue;
                }
            }

            @Pc(73) int i;
            if (c >= '0' && c <= '9') {
                i = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                i = c - '7';
            } else if (c >= 'a' && c <= 'z') {
                i = c - 'W';
            } else {
                return false;
            }

            if (i >= radix) {
                return false;
            }

            if (negative) {
                i = -i;
            }

            @Pc(124) int t = i + value * radix;
            if (value != t / radix) {
                return false;
            }

            value = t;
            number = true;
        }

        return number;
    }

    @OriginalMember(owner = "client!sm", name = "a", descriptor = "(BZI)Ljava/lang/String;")
    public static String parseIntWithSign(@OriginalArg(1) boolean makePositive, @OriginalArg(2) int number) {
        return makePositive && number >= 0 ? parseIntWithSign(number, 10, makePositive) : Integer.toString(number);
    }

    @OriginalMember(owner = "client!dd", name = "a", descriptor = "(ZIIZ)Ljava/lang/String;")
    public static String parseIntWithSign(@OriginalArg(1) int number, @OriginalArg(2) int radix, @OriginalArg(3) boolean makePositive) {
        if (radix > 36) {
            throw new IllegalArgumentException("Invalid radix:" + radix);
        }

        if (makePositive && number >= 0) {
            @Pc(51) int digits = 2;
            for (@Pc(55) int n = number / radix; n != 0; n /= radix) {
                digits++;
            }

            @Pc(66) char[] chars = new char[digits];
            chars[0] = '+';

            for (@Pc(74) int i = digits - 1; i > 0; i--) {
                @Pc(77) int n = number;
                number /= radix;
                @Pc(88) int delta = n - number * radix;
                if (delta >= 10) {
                    chars[i] = (char) (delta + 87);
                } else {
                    chars[i] = (char) (delta + 48);
                }
            }
            return new String(chars);
        } else {
            return Integer.toString(number, radix);
        }
    }

    private StringTools() {
        /* empty */
    }
}
