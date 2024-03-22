package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Base37 {

    private static final int MAX_LENGTH = 12;

    private static final String MIN = "a";

    private static final long MIN_ENCODED = encode(MIN);

    private static final String MAX = "9".repeat(MAX_LENGTH);

    private static final long MAX_ENCODED = encode(MAX);

    private static final String MAX_PENULTIMATE = "9".repeat(MAX_LENGTH - 1);

    private static final long MAX_PENULTIMATE_ENCODED = encode(MAX_PENULTIMATE);

    @OriginalMember(owner = "client!kj", name = "c", descriptor = "[C")
    public static final char[] TABLE = {
        /* 00 */ '_',
        /* 01 */ 'a',
        /* 02 */ 'b',
        /* 03 */ 'c',
        /* 04 */ 'd',
        /* 05 */ 'e',
        /* 06 */ 'f',
        /* 07 */ 'g',
        /* 08 */ 'h',
        /* 09 */ 'i',
        /* 10 */ 'j',
        /* 11 */ 'k',
        /* 12 */ 'l',
        /* 13 */ 'm',
        /* 14 */ 'n',
        /* 15 */ 'o',
        /* 16 */ 'p',
        /* 17 */ 'q',
        /* 18 */ 'r',
        /* 19 */ 's',
        /* 20 */ 't',
        /* 21 */ 'u',
        /* 22 */ 'v',
        /* 23 */ 'w',
        /* 24 */ 'x',
        /* 25 */ 'y',
        /* 26 */ 'z',
        /* 27 */ '0',
        /* 28 */ '1',
        /* 29 */ '2',
        /* 30 */ '3',
        /* 31 */ '4',
        /* 32 */ '5',
        /* 33 */ '6',
        /* 34 */ '7',
        /* 35 */ '8',
        /* 36 */ '9',
    };

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Ljava/lang/String;I)J")
    public static long encode(@OriginalArg(0) String string) {
        @Pc(12) long encoded = 0L;
        @Pc(15) int length = string.length();

        for (@Pc(17) int i = 0; i < length; i++) {
            encoded *= 37L;

            @Pc(26) char c = string.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                encoded += c + 1 - 'A';
            } else if (c >= 'a' && c <= 'z') {
                encoded += c + 1 - 'a';
            } else if (c >= '0' && c <= '9') {
                encoded += c + 27 - '0';
            }

            if (encoded > MAX_PENULTIMATE_ENCODED) {
                break;
            }
        }

        while (encoded % 37L == 0L && encoded != 0L) {
            encoded /= 37L;
        }

        return encoded;
    }

    @OriginalMember(owner = "client!jaa", name = "a", descriptor = "(JI)Ljava/lang/String;")
    public static String decode(@OriginalArg(0) long value) {
        if (value < MIN_ENCODED || value > MAX_ENCODED) {
            return null;
        } else if (value % 37L == 0L) {
            return null;
        } else {
            @Pc(39) int length = 0;
            @Pc(41) long v = value;

            while (v != 0L) {
                v /= 37L;
                length++;
            }

            @Pc(56) StringBuffer buffer = new StringBuffer(length);
            while (value != 0L) {
                @Pc(59) long t = value;
                value /= 37L;
                buffer.append(TABLE[(int) (t - (value * 37L))]);
            }

            return buffer.reverse().toString();
        }
    }

    @OriginalMember(owner = "client!dba", name = "a", descriptor = "(BJ)Ljava/lang/String;")
    public static String decodeName(@OriginalArg(1) long value) {
        if (value < MIN_ENCODED || value > MAX_ENCODED) {
            return null;
        } else if (value % 37L == 0L) {
            return null;
        } else {
            @Pc(29) int length = 0;
            @Pc(31) long v = value;

            while (v != 0L) {
                v /= 37L;
                length++;
            }

            @Pc(56) StringBuffer buffer = new StringBuffer(length);
            while (value != 0L) {
                @Pc(59) long t = value;
                value /= 37L;
                @Pc(73) char c = TABLE[(int) (t - (value * 37L))];

                if (c == '_') {
                    @Pc(83) int last = buffer.length() - 1;
                    buffer.setCharAt(last, Character.toUpperCase(buffer.charAt(last)));
                    c = ' ';
                }

                buffer.append(c);
            }

            buffer.reverse();
            buffer.setCharAt(0, Character.toUpperCase(buffer.charAt(0)));
            return buffer.toString();
        }
    }

    private Base37() {
        /* empty */
    }
}
