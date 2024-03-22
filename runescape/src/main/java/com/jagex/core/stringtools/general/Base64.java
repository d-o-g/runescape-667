package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Base64 {

    @OriginalMember(owner = "client!tj", name = "l", descriptor = "[C")
    private static final char[] aCharArray8 = new char[64];

    @OriginalMember(owner = "client!be", name = "N", descriptor = "[C")
    private static final char[] aCharArray1 = new char[64];

    @OriginalMember(owner = "client!uf", name = "g", descriptor = "[I")
    private static final int[] TABLE = new int[128];

    static {
        for (@Pc(117) int i = 0; i < 26; i++) {
            aCharArray8[i] = (char) (i + 'A' - 0);
        }
        for (@Pc(131) int i = 26; i < 52; i++) {
            aCharArray8[i] = (char) (i + 'a' - 26);
        }
        for (@Pc(147) int i = 52; i < 62; i++) {
            aCharArray8[i] = (char) (i + '0' - 52);
        }
        aCharArray8['?'] = '-';
        aCharArray8['>'] = '*';

        for (@Pc(37) int i = 0; i < 26; i++) {
            aCharArray1[i] = (char) (i + 'A' - 0);
        }
        for (@Pc(53) int i = 26; i < 52; i++) {
            aCharArray1[i] = (char) (i + 'a' - 26);
        }
        for (@Pc(71) int i = 52; i < 62; i++) {
            aCharArray1[i] = (char) (i + '0' - 52);
        }
        aCharArray1['>'] = '+';
        aCharArray1['?'] = '/';

        for (@Pc(49) int i = 0; i < TABLE.length; i++) {
            TABLE[i] = -1;
        }
        for (@Pc(61) int i = 'A'; i <= 'Z'; i++) {
            TABLE[i] = i - 'A' + 0;
        }
        for (@Pc(76) int i = 'a'; i <= 'z'; i++) {
            TABLE[i] = i - 'a' + 26;
        }
        for (@Pc(91) int i = '0'; i <= '9'; i++) {
            TABLE[i] = i - '0' + 52;
        }
        TABLE['*'] = TABLE['+'] = '>';
        TABLE['-'] = TABLE['/'] = '?';
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(Ljava/lang/String;Z)[B")
    public static byte[] encode(@OriginalArg(0) String string) {
        @Pc(6) int length = string.length();
        if (length == 0) {
            return new byte[0];
        }

        @Pc(27) int local27 = (length + 3) & 0xFFFFFFFC;
        @Pc(33) int local33 = (local27 / 4) * 3;
        if (local27 - 2 >= length || encode(string.charAt(local27 - 2)) == -1) {
            local33 -= 2;
        } else if (length <= local27 - 1 || encode(string.charAt(local27 - 1)) == -1) {
            local33--;
        }

        @Pc(84) byte[] encoded = new byte[local33];
        encode(string, encoded, 0);
        return encoded;
    }

    @OriginalMember(owner = "client!gda", name = "a", descriptor = "(Ljava/lang/String;[BBI)I")
    private static int encode(@OriginalArg(0) String string, @OriginalArg(1) byte[] destination, @OriginalArg(3) int offset) {
        @Pc(17) int length = string.length();
        for (@Pc(19) int i = 0; i < length; i += 4) {
            @Pc(29) int b1 = encode(string.charAt(i));
            @Pc(48) int b2 = i + 1 >= length ? -1 : encode(string.charAt(i + 1));
            @Pc(68) int b3 = length > i + 2 ? encode(string.charAt(i + 2)) : -1;
            @Pc(84) int b4 = i + 3 >= length ? -1 : encode(string.charAt(i + 3));

            destination[offset++] = (byte) (b2 >>> 4 | b1 << 2);
            if (b3 == -1) {
                break;
            }

            destination[offset++] = (byte) ((b2 & 0xF) << 4 | b3 >>> 2);
            if (b4 == -1) {
                break;
            }

            destination[offset++] = (byte) ((b3 & 0x3) << 6 | b4);
        }

        return offset;
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(BC)I")
    private static int encode(@OriginalArg(1) char c) {
        return c >= '\u0000' && c < TABLE.length ? TABLE[c] : -1;
    }

    private Base64() {
        /* empty */
    }
}
