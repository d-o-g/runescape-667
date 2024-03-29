package com.jagex.core.stringtools.general;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class NameTools {

    public static final int MIN_LENGTH = 1;

    public static final int MAX_LENGTH = 12;

    @OriginalMember(owner = "client!kja", name = "d", descriptor = "[C")
    public static final char[] SPECIAL = {
        ' ', ' ', '_', '-',
        'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã',
        'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë',
        'í', 'î', 'ï', 'Í', 'Î', 'Ï',
        'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ',
        'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü',
        'ç', 'Ç',
        'ÿ', 'Ÿ',
        'ñ', 'Ñ',
        'ß'
    };

    @OriginalMember(owner = "client!kw", name = "u", descriptor = "[C")
    public static final char[] SYMBOLS = {
        '[',
        ']',
        '#'
    };

    @OriginalMember(owner = "client!r", name = "a", descriptor = "(BC)Z")
    public static boolean isValid(@OriginalArg(1) char c) {
        if (Character.isISOControl(c)) {
            return false;
        } else if (StringTools.isAlphanumeric(c)) {
            return true;
        } else {
            @Pc(25) char[] specials = SPECIAL;
            for (@Pc(27) int i = 0; i < specials.length; i++) {
                @Pc(32) char special = specials[i];
                if (c == special) {
                    return true;
                }
            }

            @Pc(49) char[] symbols = SYMBOLS;
            for (@Pc(51) int i = 0; i < symbols.length; i++) {
                @Pc(56) char symbol = symbols[i];
                if (c == symbol) {
                    return true;
                }
            }

            return false;
        }
    }

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
    public static String format(@OriginalArg(1) String name) {
        if (name == null) {
            return null;
        }

        @Pc(10) int start = 0;
        @Pc(13) int end = name.length();
        while (start < end && isWhitespace(name.charAt(start))) {
            start++;
        }
        while (start < end && isWhitespace(name.charAt(end - 1))) {
            end--;
        }

        @Pc(55) int length = end - start;
        if (length < MIN_LENGTH || length > MAX_LENGTH) {
            return null;
        }

        @Pc(75) StringBuffer buffer = new StringBuffer(length);
        for (@Pc(77) int i = start; i < end; i++) {
            @Pc(82) char c = name.charAt(i);

            if (isValid(c)) {
                @Pc(90) char lowercaseChar = lowercase(c);
                if (lowercaseChar != 0) {
                    buffer.append(lowercaseChar);
                }
            }
        }

        if (buffer.length() == 0) {
            return null;
        } else {
            return buffer.toString();
        }
    }

    @OriginalMember(owner = "client!ek", name = "a", descriptor = "(BC)C")
    private static char lowercase(@OriginalArg(1) char c) {
        switch (c) {
            case ' ':
            case ' ':
            case '_':
            case '-':
                return '_';

            case '[':
            case ']':
            case '#':
                return c;

            case 'à':
            case 'á':
            case 'â':
            case 'ä':
            case 'ã':
            case 'À':
            case 'Á':
            case 'Â':
            case 'Ä':
            case 'Ã':
                return 'a';

            case 'è':
            case 'é':
            case 'ê':
            case 'ë':
            case 'È':
            case 'É':
            case 'Ê':
            case 'Ë':
                return 'e';

            case 'í':
            case 'î':
            case 'ï':
            case 'Í':
            case 'Î':
            case 'Ï':
                return 'i';

            case 'ò':
            case 'ó':
            case 'ô':
            case 'ö':
            case 'õ':
            case 'Ò':
            case 'Ó':
            case 'Ô':
            case 'Ö':
            case 'Õ':
                return 'o';

            case 'ù':
            case 'ú':
            case 'û':
            case 'ü':
            case 'Ù':
            case 'Ú':
            case 'Û':
            case 'Ü':
                return 'u';

            case 'ç':
            case 'Ç':
                return 'c';

            case 'ÿ':
            case 'Ÿ':
                return 'y';

            case 'ñ':
            case 'Ñ':
                return 'n';

            case 'ß':
                return 'b';

            default:
                return Character.toLowerCase(c);
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(CI)Z")
    private static boolean isWhitespace(@OriginalArg(0) char c) {
        return c == ' ' || c == ' ' || c == '_' || c == '-';
    }

    @OriginalMember(owner = "client!vka", name = "a", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
    public static String normalise(@OriginalArg(1) String name) {
        @Pc(17) String normalised = Base37.decodeName(Base37.encode(name));
        if (normalised == null) {
            normalised = "";
        }
        return normalised;
    }

    private NameTools() {
        /* empty */
    }
}
