package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class WebTools {

    @OriginalMember(owner = "client!wk", name = "a", descriptor = "(BLjava/lang/String;)Ljava/lang/String;")
    public static String urlEncode(@OriginalArg(1) String string) {
        @Pc(9) StringBuffer buffer = new StringBuffer();
        @Pc(12) int length = string.length();

        for (@Pc(14) int i = 0; i < length; i++) {
            @Pc(29) char c = string.charAt(i);

            if (c == '%' && length > i + 2) {
                c = string.charAt(i + 1);

                @Pc(84) int v;
                if (c >= '0' && c <= '9') {
                    v = c - '0';
                } else if (c >= 'a' && c <= 'f') {
                    v = (c + 10) - 'a';
                } else if (c >= 'A' && c <= 'F') {
                    v = (c + 10) - 'A';
                } else {
                    buffer.append('%');
                    continue;
                }

                c = string.charAt(i + 2);
                v *= 16;

                if (c >= '0' && c <= '9') {
                    v += c - '0';
                } else if (c >= 'a' && c <= 'f') {
                    v += (c + 10) - 'a';
                } else if (c >= 'A' && c <= 'F') {
                    v += (c + 10) - 'A';
                } else {
                    buffer.append('%');
                    continue;
                }

                i += 2;

                if (v != 0 && Cp1252.contains((byte) v)) {
                    buffer.append(Cp1252.decode((byte) v));
                }
            } else if (c == '+') {
                buffer.append(' ');
            } else {
                buffer.append(c);
            }
        }

        return buffer.toString();
    }

    @OriginalMember(owner = "client!ne", name = "a", descriptor = "(BI)Ljava/lang/String;")
    public static String ipDecode(@OriginalArg(1) int ip) {
        return (ip >> 24 & 0xFF) +
            "." + (ip >> 16 & 0xFF) +
            "." + (ip >> 8 & 0xFF) +
            "." + (ip & 0xFF);
    }

    private WebTools() {
        /* empty */
    }
}
