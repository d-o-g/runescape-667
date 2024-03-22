package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Utf8 {

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(BI[BI)Ljava/lang/String;")
    public static String decode(@OriginalArg(1) int length, @OriginalArg(2) byte[] bytes, @OriginalArg(3) int off) {
        @Pc(8) char[] chars = new char[length];
        @Pc(10) int count = 0;
        @Pc(18) int pos = off;
        @Pc(22) int end = length + off;

        while (pos < end) {
            @Pc(31) int curr = bytes[pos++] & 0xFF;
            @Pc(45) int currUtf;

            if (curr < 128) {
                if (curr != 0) {
                    currUtf = curr;
                } else {
                    currUtf = '�';
                }
            } else if (curr < 192) {
                currUtf = '�';
            } else if (curr < 224) {
                if (pos < end && (bytes[pos] & 0xC0) == 128) {
                    currUtf = ((curr & 0x1F) << 6) | (bytes[pos++] & 0x3F);

                    if (currUtf < 128) {
                        currUtf = '�';
                    }
                } else {
                    currUtf = '�';
                }
            } else if (curr < 240) {
                if (end > pos + 1 && (bytes[pos] & 0xC0) == 128 && (bytes[pos + 1] & 0xC0) == 128) {
                    currUtf = ((curr & 0xF) << 12) | ((bytes[pos++] & 0x3F) << 6) | (bytes[pos++] & 0x3F);

                    if (currUtf < 2048) {
                        currUtf = '�';
                    }
                } else {
                    currUtf = '�';
                }
            } else if (curr < 248) {
                if (pos + 2 < end && (bytes[pos] & 0xC0) == 128 && (bytes[pos + 1] & 0xC0) == 128 && (bytes[pos + 2] & 0xC0) == 128) {
                    currUtf = ((bytes[pos++] & 0x3F) << 12) | ((curr & 0x7) << 18) | ((bytes[pos++] & 0x3F) << 6) | (bytes[pos++] & 0x3F);

                    if (currUtf >= 65536 && currUtf <= 1114111) {
                        currUtf = '�';
                    } else {
                        currUtf = '�';
                    }
                } else {
                    currUtf = '�';
                }
            } else {
                currUtf = '�';
            }

            chars[count++] = (char) currUtf;
        }

        return new String(chars, 0, count);
    }

    private Utf8() {
        /* empty */
    }
}
