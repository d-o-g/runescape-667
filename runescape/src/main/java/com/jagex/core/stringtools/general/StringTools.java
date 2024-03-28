package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class StringTools {

    @OriginalMember(owner = "client!oo", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean isDecimal(@OriginalArg(1) String string) {
        return isNumeric(true, string, 10);
    }

    @OriginalMember(owner = "client!wda", name = "a", descriptor = "(ZILjava/lang/String;I)Z")
    public static boolean isNumeric(@OriginalArg(0) boolean ignorePlus, @OriginalArg(2) String string, @OriginalArg(3) int radix) {
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
                i = (c + 10) - 'A';
            } else if (c >= 'a' && c <= 'z') {
                i = (c + 10) - 'a';
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
    public static String decimalWithSign(@OriginalArg(1) boolean makePositive, @OriginalArg(2) int number) {
        return makePositive && number >= 0 ? numberWithSign(number, 10, makePositive) : Integer.toString(number);
    }

    @OriginalMember(owner = "client!dd", name = "a", descriptor = "(ZIIZ)Ljava/lang/String;")
    public static String numberWithSign(@OriginalArg(1) int number, @OriginalArg(2) int radix, @OriginalArg(3) boolean makePositive) {
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
                    chars[i] = (char) ((delta - 10) + 'a');
                } else {
                    chars[i] = (char) (delta + '0');
                }
            }

            return new String(chars);
        } else {
            return Integer.toString(number, radix);
        }
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/String;I)I")
    public static int parseDecimal(@OriginalArg(0) String string) {
        return parseInt(string, 10, true);
    }

    @OriginalMember(owner = "client!ah", name = "a", descriptor = "(Ljava/lang/String;IZ)I")
    public static int parseHexadecimal(@OriginalArg(0) String string) {
        return parseInt(string, 16, true);
    }

    @OriginalMember(owner = "client!iha", name = "a", descriptor = "(ILjava/lang/String;IZ)I")
    public static int parseInt(@OriginalArg(1) String string, @OriginalArg(2) int radix, boolean allowPlus) {
        if (radix > 36) {
            throw new IllegalArgumentException("Invalid radix:" + radix);
        }

        @Pc(29) boolean negative = false;
        @Pc(31) boolean valid = false;
        @Pc(39) int value = 0;
        @Pc(42) int length = string.length();

        for (@Pc(44) int index = 0; index < length; index++) {
            @Pc(49) char c = string.charAt(index);

            if (index == 0) {
                if (c == '-') {
                    negative = true;
                    continue;
                }
                if (c == '+' && allowPlus) {
                    continue;
                }
            }

            @Pc(104) int i;
            if (c >= '0' && c <= '9') {
                i = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                i = (c + 10) - 'A';
            } else if (c >= 'a' && c <= 'z') {
                i = (c + 10) - 'a';
            } else {
                throw new NumberFormatException();
            }

            if (i >= radix) {
                throw new NumberFormatException();
            }

            if (negative) {
                i = -i;
            }

            @Pc(136) int v = i + (radix * value);
            if (value != v / radix) {
                throw new NumberFormatException();
            }
            valid = true;
            value = v;
        }

        if (valid) {
            return value;
        } else {
            throw new NumberFormatException();
        }
    }

    @OriginalMember(owner = "client!hda", name = "a", descriptor = "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;")
    public static String replace(@OriginalArg(0) String string, @OriginalArg(2) String target, @OriginalArg(3) String replacement) {
        for (@Pc(13) int i = string.indexOf(target); i != -1; i = string.indexOf(target, i + replacement.length())) {
            string = string.substring(0, i) + replacement + string.substring(target.length() + i);
        }
        return string;
    }

    @OriginalMember(owner = "client!sa", name = "a", descriptor = "(IZJIZ)Ljava/lang/String;")
    public static String formatNumber(@OriginalArg(0) int language, @OriginalArg(1) boolean delimit, @OriginalArg(2) long value, @OriginalArg(3) int decimals) {
        @Pc(5) char decimalDelimiter = ',';
        @Pc(19) char thousandDelimiter = '.';
        if (language == 0) {
            decimalDelimiter = '.';
            thousandDelimiter = ',';
        }
        if (language == 2) {
            thousandDelimiter = ' ';
        }

        @Pc(32) boolean negative = false;
        if (value < 0L) {
            value = -value;
            negative = true;
        }

        @Pc(48) StringBuffer buffer = new StringBuffer(26);
        if (decimals > 0) {
            for (@Pc(55) int i = 0; i < decimals; i++) {
                @Pc(59) int v = (int) value;
                value /= 10L;

                buffer.append((char) ((v + '0') - ((int) value * 10)));
            }

            buffer.append(decimalDelimiter);
        }

        @Pc(55) int length = 0;
        while (true) {
            @Pc(59) int v = (int) value;
            value /= 10L;

            buffer.append((char) ((v + '0') - ((int) value * 10)));

            if (value == 0L) {
                if (negative) {
                    buffer.append('-');
                }

                return buffer.reverse().toString();
            }

            if (delimit) {
                length++;

                if (length % 3 == 0) {
                    buffer.append(thousandDelimiter);
                }
            }
        }
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(ILjava/lang/String;)J")
    public static long longHash(@OriginalArg(1) String string) {
        @Pc(15) int length = string.length();
        @Pc(17) long hash = 0L;
        for (@Pc(19) int i = 0; i < length; i++) {
            hash = (long) string.charAt(i) + (hash << 5) - hash;
        }
        return hash;
    }

    @OriginalMember(owner = "client!gla", name = "a", descriptor = "(Ljava/lang/String;B)I")
    public static int intHash(@OriginalArg(0) String string) {
        @Pc(8) int length = string.length();
        @Pc(17) int hash = 0;
        for (@Pc(19) int i = 0; i < length; i++) {
            hash = string.charAt(i) + (hash << 5) - hash;
        }
        return hash;
    }

    @OriginalMember(owner = "client!qb", name = "a", descriptor = "(BIC)I")
    public static int intHash(@OriginalArg(1) int language, @OriginalArg(2) char c) {
        @Pc(7) int hash = c << 4;
        if (Character.isUpperCase(c) || Character.isTitleCase(c)) {
            @Pc(18) char lower = Character.toLowerCase(c);
            hash = (lower << 4) + 1;
        }
        return hash;
    }

    @OriginalMember(owner = "client!cw", name = "a", descriptor = "(ZLjava/lang/String;)I")
    public static int intHashCp1252(@OriginalArg(1) String string) {
        @Pc(12) int length = string.length();
        @Pc(14) int hash = 0;
        for (@Pc(16) int i = 0; i < length; i++) {
            hash = (hash << 5) + Cp1252.encode(string.charAt(i)) - hash;
        }
        return hash;
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IC)Z")
    public static boolean isNumeric(@OriginalArg(1) char c) {
        return c >= '0' && c <= '9';
    }

    @OriginalMember(owner = "client!hka", name = "a", descriptor = "(CI)Z")
    public static boolean isAlphabetical(@OriginalArg(0) char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    @OriginalMember(owner = "client!sp", name = "a", descriptor = "(ZC)Z")
    public static boolean isAlphanumeric(@OriginalArg(1) char c) {
        return c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    @OriginalMember(owner = "client!tb", name = "a", descriptor = "(BC)Z")
    public static boolean isPrintable(@OriginalArg(1) char c) {
        if (c >= ' ' && c <= '~') {
            return true;
        } else if (c >= ' ' && c <= 'ÿ') {
            return true;
        } else {
            return c == '€' || c == 'Œ' || c == '—' || c == 'œ' || c == 'Ÿ';
        }
    }

    @OriginalMember(owner = "client!fr", name = "a", descriptor = "(BLjava/lang/String;C)[Ljava/lang/String;")
    public static String[] split(@OriginalArg(1) String string, @OriginalArg(2) char c) {
        @Pc(8) int count = count(string, c);
        @Pc(13) String[] strings = new String[count + 1];
        @Pc(23) int pos = 0;
        @Pc(25) int start = 0;
        for (@Pc(27) int i = 0; i < count; i++) {
            @Pc(30) int end;
            for (end = start; c != string.charAt(end); end++) {
            }
            strings[pos++] = string.substring(start, end);
            start = end + 1;
        }
        strings[count] = string.substring(start);
        return strings;
    }

    @OriginalMember(owner = "client!dga", name = "a", descriptor = "(Ljava/lang/String;ZC)I")
    public static int count(@OriginalArg(0) String string, @OriginalArg(2) char c) {
        @Pc(5) int count = 0;
        @Pc(8) int length = string.length();
        for (@Pc(17) int i = 0; i < length; i++) {
            if (string.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    @OriginalMember(owner = "client!pn", name = "a", descriptor = "(CZ)C")
    public static char transliteral(@OriginalArg(0) char c) {
        if (c == 'Æ') {
            return 'E';
        } else if (c == 'æ') {
            return 'e';
        } else if (c == 'ß') {
            return 's';
        } else if (c == 'Œ') {
            return 'E';
        } else if (c == 'œ') {
            return 'e';
        } else {
            return '\u0000';
        }
    }

    @OriginalMember(owner = "client!eb", name = "a", descriptor = "(ZLjava/lang/String;)Ljava/lang/String;")
    public static String escapeBrackets(@OriginalArg(1) String string) {
        @Pc(6) int length = string.length();

        @Pc(8) int bracketLength = 0;
        for (@Pc(10) int i = 0; i < length; i++) {
            @Pc(15) char c = string.charAt(i);

            if (c == '<' || c == '>') {
                bracketLength += 3;
            }
        }

        @Pc(42) StringBuffer buffer = new StringBuffer(length + bracketLength);
        for (@Pc(44) int i = 0; i < length; i++) {
            @Pc(49) char c = string.charAt(i);

            if (c == '<') {
                buffer.append("<lt>");
            } else if (c == '>') {
                buffer.append("<gt>");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;BC)Ljava/lang/String;")
    public static String replace(@OriginalArg(0) String original, @OriginalArg(1) String replacement, @OriginalArg(4) char target) {
        @Pc(14) int originalLength = original.length();
        @Pc(17) int replacementLength = replacement.length();
        @Pc(19) int newLength = originalLength;

        @Pc(23) int extraChars = replacementLength - 1;
        if (extraChars != 0) {
            @Pc(27) int last = 0;

            while (true) {
                last = original.indexOf(target, last);
                if (last < 0) {
                    break;
                }

                newLength += extraChars;
                last++;
            }
        }

        @Pc(48) StringBuffer buffer = new StringBuffer(newLength);
        @Pc(50) int last = 0;
        while (true) {
            @Pc(55) int index = original.indexOf(target, last);
            if (index < 0) {
                buffer.append(original.substring(last));
                return buffer.toString();
            }
            buffer.append(original.substring(last, index));
            last = index + 1;
            buffer.append(replacement);
        }
    }

    private StringTools() {
        /* empty */
    }
}
