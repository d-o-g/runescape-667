package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Cp1252 {

    @OriginalMember(owner = "client!lr", name = "h", descriptor = "[C")
    private static final char[] CHARS = {
        '€', 0, '‚', 'ƒ', '„', '…', '†', '‡',
        'ˆ', '‰', 'Š', '‹', 'Œ', 0, 'Ž', 0,
        0, '‘', '’', '“', '”', '•', '–', '—',
        '˜', '™', 'š', '›', 'œ', 0, 'ž', 'Ÿ'
    };

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "(Ljava/lang/String;I[BZII)I")
    public static int encode(@OriginalArg(0) String string, @OriginalArg(1) int initialLen, @OriginalArg(2) byte[] dest, @OriginalArg(4) int destOffset) {
        @Pc(8) int len = initialLen;

        for (@Pc(16) int i = 0; i < len; i++) {
            @Pc(23) char c = string.charAt(i);

            if (((c > 0) && (c < 128)) || ((c >= 160) && (c <= 255))) {
                dest[i + destOffset] = (byte) c;
            } else if (c == '€') {
                dest[i + destOffset] = -128;
            } else if (c == '‚') {
                dest[i + destOffset] = -126;
            } else if (c == 'ƒ') {
                dest[i + destOffset] = -125;
            } else if (c == '„') {
                dest[i + destOffset] = -124;
            } else if (c == '…') {
                dest[i + destOffset] = -123;
            } else if (c == '†') {
                dest[i + destOffset] = -122;
            } else if (c == '‡') {
                dest[i + destOffset] = -121;
            } else if (c == 'ˆ') {
                dest[i + destOffset] = -120;
            } else if (c == '‰') {
                dest[i + destOffset] = -119;
            } else if (c == 'Š') {
                dest[i + destOffset] = -118;
            } else if (c == '‹') {
                dest[i + destOffset] = -117;
            } else if (c == 'Œ') {
                dest[i + destOffset] = -116;
            } else if (c == 'Ž') {
                dest[i + destOffset] = -114;
            } else if (c == '‘') {
                dest[i + destOffset] = -111;
            } else if (c == '’') {
                dest[i + destOffset] = -110;
            } else if (c == '“') {
                dest[i + destOffset] = -109;
            } else if (c == '”') {
                dest[i + destOffset] = -108;
            } else if (c == '•') {
                dest[i + destOffset] = -107;
            } else if (c == '–') {
                dest[i + destOffset] = -106;
            } else if (c == '—') {
                dest[i + destOffset] = -105;
            } else if (c == '˜') {
                dest[i + destOffset] = -104;
            } else if (c == '™') {
                dest[i + destOffset] = -103;
            } else if (c == 'š') {
                dest[i + destOffset] = -102;
            } else if (c == '›') {
                dest[i + destOffset] = -101;
            } else if (c == 'œ') {
                dest[i + destOffset] = -100;
            } else if (c == 'ž') {
                dest[i + destOffset] = -98;
            } else if (c == 'Ÿ') {
                dest[i + destOffset] = -97;
            } else {
                dest[i + destOffset] = '?';
            }
        }

        return len;
    }

    @OriginalMember(owner = "client!la", name = "a", descriptor = "(I[BIB)Ljava/lang/String;")
    public static String decode(@OriginalArg(0) int off, @OriginalArg(1) byte[] bytes, @OriginalArg(2) int len) {
        @Pc(13) char[] chars = new char[len];
        @Pc(15) int index = 0;

        for (@Pc(17) int i = 0; i < len; i++) {
            @Pc(26) int c = bytes[i + off] & 0xFF;

            if (c != 0) {
                if (c >= 128 && c < 160) {
                    @Pc(44) char unicode = CHARS[c - 128];
                    if (unicode == '\u0000') {
                        unicode = '?';
                    }

                    c = unicode;
                }

                chars[index++] = (char) c;
            }
        }

        return new String(chars, 0, index);
    }

    @OriginalMember(owner = "client!bg", name = "a", descriptor = "(CB)B")
    public static byte encodeChar(@OriginalArg(0) char c) {
        @Pc(36) byte b;

        if (((c > 0) && (c < 128)) || ((c >= 160) && (c <= 255))) {
            b = (byte) c;
        } else if (c == '€') {
            b = -128;
        } else if (c == '‚') {
            b = -126;
        } else if (c == 'ƒ') {
            b = -125;
        } else if (c == '„') {
            b = -124;
        } else if (c == '…') {
            b = -123;
        } else if (c == '†') {
            b = -122;
        } else if (c == '‡') {
            b = -121;
        } else if (c == 'ˆ') {
            b = -120;
        } else if (c == '‰') {
            b = -119;
        } else if (c == 'Š') {
            b = -118;
        } else if (c == '‹') {
            b = -117;
        } else if (c == 'Œ') {
            b = -116;
        } else if (c == 'Ž') {
            b = -114;
        } else if (c == '‘') {
            b = -111;
        } else if (c == '’') {
            b = -110;
        } else if (c == '“') {
            b = -109;
        } else if (c == '”') {
            b = -108;
        } else if (c == '•') {
            b = -107;
        } else if (c == '–') {
            b = -106;
        } else if (c == '—') {
            b = -105;
        } else if (c == '˜') {
            b = -104;
        } else if (c == '™') {
            b = -103;
        } else if (c == 'š') {
            b = -102;
        } else if (c == '›') {
            b = -101;
        } else if (c == 'œ') {
            b = -100;
        } else if (c == 'ž') {
            b = -98;
        } else if (c == 'Ÿ') {
            b = -97;
        } else {
            b = '?';
        }

        return b;
    }

    @OriginalMember(owner = "client!kt", name = "a", descriptor = "(BB)C")
    public static char decodeChar(@OriginalArg(0) byte b) {
        @Pc(14) int c = b & 0xFF;

        if (c == 0) {
            throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(c, 16) + " provided");
        } else {
            if (c >= 128 && c < 160) {
                @Pc(50) char unicode = CHARS[c - 128];
                if (unicode == '\u0000') {
                    unicode = '?';
                }
                c = unicode;
            }

            return (char) c;
        }
    }

    @OriginalMember(owner = "client!qla", name = "a", descriptor = "(ZB)Z")
    public static boolean contains(@OriginalArg(1) byte b) {
        @Pc(16) int c = b & 0xFF;

        if (c == 0) {
            return false;
        } else {
            return c < 128 || c >= 160 || CHARS[c - 128] != 0;
        }
    }

    @OriginalMember(owner = "client!fr", name = "a", descriptor = "(IC)Z")
    public static boolean contains(@OriginalArg(1) char c) {
        if (((c > 0) && (c < 128)) || ((c >= 160) && (c <= 255))) {
            return true;
        }

        if (c != '\u0000') {
            @Pc(38) char[] chars = CHARS;
            for (@Pc(40) int i = 0; i < chars.length; i++) {
                @Pc(46) char cp1252Char = chars[i];
                if (cp1252Char == c) {
                    return true;
                }
            }
        }

        return false;
    }

    private Cp1252() {
        /* empty */
    }
}
