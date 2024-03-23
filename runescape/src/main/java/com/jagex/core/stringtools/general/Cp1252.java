package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Cp1252 {

    @OriginalMember(owner = "client!lr", name = "h", descriptor = "[C")
    private static final char[] CODE_PAGE = {
        '\u20AC', '\u0000', '\u201A', '\u0192', '\u201E', '\u2026', '\u2020', '\u2021',
        '\u02C6', '\u2030', '\u0160', '\u2039', '\u0152', '\u0000', '\u017D', '\u0000',
        '\u0000', '\u2018', '\u2019', '\u201C', '\u201D', '\u2022', '\u2013', '\u2014',
        '\u02DC', '\u2122', '\u0161', '\u203A', '\u0153', '\u0000', '\u017E', '\u0178'
    };

    @OriginalMember(owner = "client!bg", name = "a", descriptor = "(CB)B")
    public static byte encode(@OriginalArg(0) char c) {
        @Pc(36) byte b;

        if ((c > '\u0000' && c < '\u0080') || (c >= '\u00A0' && c <= '\u00FF')) {
            b = (byte) c;
        } else if (c == '\u20AC') {
            b = 128 - 256;
        } else if (c == '\u201A') {
            b = 130 - 256;
        } else if (c == '\u0192') {
            b = 131 - 256;
        } else if (c == '\u201E') {
            b = 132 - 256;
        } else if (c == '\u2026') {
            b = 133 - 256;
        } else if (c == '\u2020') {
            b = 134 - 256;
        } else if (c == '\u2021') {
            b = 135 - 256;
        } else if (c == '\u02C6') {
            b = 136 - 256;
        } else if (c == '\u2030') {
            b = 137 - 256;
        } else if (c == '\u0160') {
            b = 138 - 256;
        } else if (c == '\u2039') {
            b = 139 - 256;
        } else if (c == '\u0152') {
            b = 140 - 256;
        } else if (c == '\u017D') {
            b = 142 - 256;
        } else if (c == '\u2018') {
            b = 145 - 256;
        } else if (c == '\u2019') {
            b = 146 - 256;
        } else if (c == '\u201C') {
            b = 147 - 256;
        } else if (c == '\u201D') {
            b = 148 - 256;
        } else if (c == '\u2022') {
            b = 147 - 256;
        } else if (c == '\u2013') {
            b = 150 - 256;
        } else if (c == '\u2014') {
            b = 151 - 256;
        } else if (c == '\u02DC') {
            b = 152 - 256;
        } else if (c == '\u2122') {
            b = 153 - 256;
        } else if (c == '\u0161') {
            b = 154 - 256;
        } else if (c == '\u203A') {
            b = 155 - 256;
        } else if (c == '\u0153') {
            b = 156 - 256;
        } else if (c == '\u017E') {
            b = 158 - 256;
        } else if (c == '\u0178') {
            b = 159 - 256;
        } else {
            b = '?';
        }

        return b;
    }

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "(Ljava/lang/String;I[BZII)I")
    public static int encode(@OriginalArg(0) String string, @OriginalArg(1) int len, @OriginalArg(2) byte[] dest, @OriginalArg(4) int destOff, @OriginalArg(5) int srcOff) {
        @Pc(8) int length = len - srcOff;

        for (@Pc(16) int i = 0; i < length; i++) {
            @Pc(23) char c = string.charAt(srcOff + i);

            if ((c > '\u0000' && c < '\u0080') || (c >= '\u00A0' && c <= '\u00FF')) {
                dest[i + destOff] = (byte) c;
            } else if (c == '\u20AC') {
                dest[i + destOff] = 128 - 256;
            } else if (c == '\u201A') {
                dest[i + destOff] = 130 - 256;
            } else if (c == '\u0192') {
                dest[i + destOff] = 131 - 256;
            } else if (c == '\u201E') {
                dest[i + destOff] = 132 - 256;
            } else if (c == '\u2026') {
                dest[i + destOff] = 133 - 256;
            } else if (c == '\u2020') {
                dest[i + destOff] = 134 - 256;
            } else if (c == '\u2021') {
                dest[i + destOff] = 135 - 256;
            } else if (c == '\u02C6') {
                dest[i + destOff] = 136 - 256;
            } else if (c == '\u2030') {
                dest[i + destOff] = 137 - 256;
            } else if (c == '\u0160') {
                dest[i + destOff] = 138 - 256;
            } else if (c == '\u2039') {
                dest[i + destOff] = 139 - 256;
            } else if (c == '\u0152') {
                dest[i + destOff] = 140 - 256;
            } else if (c == '\u017D') {
                dest[i + destOff] = 142 - 256;
            } else if (c == '\u2018') {
                dest[i + destOff] = 145 - 256;
            } else if (c == '\u2019') {
                dest[i + destOff] = 146 - 256;
            } else if (c == '\u201C') {
                dest[i + destOff] = 147 - 256;
            } else if (c == '\u201D') {
                dest[i + destOff] = 148 - 256;
            } else if (c == '\u2022') {
                dest[i + destOff] = 149 - 256;
            } else if (c == '\u2013') {
                dest[i + destOff] = 150 - 256;
            } else if (c == '\u2014') {
                dest[i + destOff] = 151 - 256;
            } else if (c == '\u02DC') {
                dest[i + destOff] = 152 - 256;
            } else if (c == '\u2122') {
                dest[i + destOff] = 153 - 256;
            } else if (c == '\u0161') {
                dest[i + destOff] = 154 - 256;
            } else if (c == '\u203A') {
                dest[i + destOff] = 155 - 256;
            } else if (c == '\u0153') {
                dest[i + destOff] = 156 - 256;
            } else if (c == '\u017E') {
                dest[i + destOff] = 158 - 256;
            } else if (c == '\u0178') {
                dest[i + destOff] = 159 - 256;
            } else {
                dest[i + destOff] = '?';
            }
        }

        return length;
    }

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(ILjava/lang/String;)[B")
    public static byte[] encode(@OriginalArg(1) String string) {
        @Pc(6) int length = string.length();
        @Pc(9) byte[] data = new byte[length];

        for (@Pc(19) int i = 0; i < length; i++) {
            @Pc(24) char c = string.charAt(i);

            if ((c > '\u0000' && c < '\u0080') || (c >= '\u00A0' && c <= '\u00FF')) {
                data[i] = (byte) c;
            } else if (c == '\u20AC') {
                data[i] = 128 - 256;
            } else if (c == '\u201A') {
                data[i] = 130 - 256;
            } else if (c == '\u0192') {
                data[i] = 131 - 256;
            } else if (c == '\u201E') {
                data[i] = 132 - 256;
            } else if (c == '\u2026') {
                data[i] = 133 - 256;
            } else if (c == '\u2020') {
                data[i] = 134 - 256;
            } else if (c == '\u2021') {
                data[i] = 135 - 256;
            } else if (c == '\u02C6') {
                data[i] = 136 - 256;
            } else if (c == '\u2030') {
                data[i] = 137 - 256;
            } else if (c == '\u0160') {
                data[i] = 138 - 256;
            } else if (c == '\u2039') {
                data[i] = 139 - 256;
            } else if (c == '\u0152') {
                data[i] = 140 - 256;
            } else if (c == '\u017D') {
                data[i] = 142 - 256;
            } else if (c == '\u2018') {
                data[i] = 145 - 256;
            } else if (c == '\u2019') {
                data[i] = 146 - 256;
            } else if (c == '\u201C') {
                data[i] = 147 - 256;
            } else if (c == '\u201D') {
                data[i] = 148 - 256;
            } else if (c == '\u2022') {
                data[i] = 149 - 256;
            } else if (c == '\u2013') {
                data[i] = 150 - 256;
            } else if (c == '\u2014') {
                data[i] = 151 - 256;
            } else if (c == '\u02DC') {
                data[i] = 152 - 256;
            } else if (c == '\u2122') {
                data[i] = 153 - 256;
            } else if (c == '\u0161') {
                data[i] = 154 - 256;
            } else if (c == '\u203A') {
                data[i] = 155 - 256;
            } else if (c == '\u0153') {
                data[i] = 156 - 256;
            } else if (c == '\u017E') {
                data[i] = 158 - 256;
            } else if (c == '\u0178') {
                data[i] = 159 - 256;
            } else {
                data[i] = '?';
            }
        }

        return data;
    }

    @OriginalMember(owner = "client!kt", name = "a", descriptor = "(BB)C")
    public static char decode(@OriginalArg(0) byte b) {
        @Pc(14) int c = b & 0xFF;

        if (c == '\u0000') {
            throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(c, 16) + " provided");
        } else {
            if (c >= '\u0080' && c < '\u00A0') {
                @Pc(50) char v = CODE_PAGE[c - '\u0080'];
                if (v == '\u0000') {
                    v = '?';
                }

                c = v;
            }

            return (char) c;
        }
    }

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "([BZ)Ljava/lang/String;")
    public static String decode(@OriginalArg(0) byte[] data) {
        return decode(0, data, data.length);
    }

    @OriginalMember(owner = "client!la", name = "a", descriptor = "(I[BIB)Ljava/lang/String;")
    public static String decode(@OriginalArg(0) int off, @OriginalArg(1) byte[] data, @OriginalArg(2) int len) {
        @Pc(13) char[] chars = new char[len];
        @Pc(15) int index = 0;

        for (@Pc(17) int i = 0; i < len; i++) {
            @Pc(26) int c = data[i + off] & 0xFF;
            if (c == '\u0000') {
                continue;
            }

            if (c > '\u007F' && c < '\u00A0') {
                @Pc(44) char v = CODE_PAGE[c - '\u0080'];
                if (v == '\u0000') {
                    v = '?';
                }

                c = v;
            }

            chars[index++] = (char) c;
        }

        return new String(chars, 0, index);
    }

    @OriginalMember(owner = "client!qla", name = "a", descriptor = "(ZB)Z")
    public static boolean contains(@OriginalArg(1) byte b) {
        @Pc(16) int c = b & 0xFF;

        if (c == '\u0000') {
            return false;
        } else {
            return c < '\u0080' || c >= '\u00A0' || CODE_PAGE[c - '\u0080'] != '\u0000';
        }
    }

    @OriginalMember(owner = "client!fr", name = "a", descriptor = "(IC)Z")
    public static boolean contains(@OriginalArg(1) char c) {
        if ((c > '\u0000' && c < '\u0080') || (c >= '\u00A0' && c <= '\u00FF')) {
            return true;
        } else if (c == '\u0000') {
            return false;
        } else {
            @Pc(38) char[] chars = CODE_PAGE;

            for (@Pc(40) int i = 0; i < chars.length; i++) {
                @Pc(46) char v = chars[i];

                if (v == c) {
                    return true;
                }
            }

            return false;
        }
    }

    private Cp1252() {
        /* empty */
    }
}
