package com.jagex.graphics;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ve")
public final class FontMetrics {

    @OriginalMember(owner = "client!hh", name = "a", descriptor = "(IILclient!sb;)Lclient!ve;")
    public static FontMetrics loadFile(@OriginalArg(2) js5 fontMetrics, @OriginalArg(1) int file) {
        @Pc(8) byte[] data = fontMetrics.getfile(file);
        return data == null ? null : new FontMetrics(data);
    }

    @OriginalMember(owner = "client!cga", name = "a", descriptor = "(IIILclient!sb;)Lclient!ve;")
    public static FontMetrics loadGroup(@OriginalArg(3) js5 fontMetrics, @OriginalArg(2) int group) {
        @Pc(17) byte[] data = fontMetrics.getfile(0, group);
        return data == null ? null : new FontMetrics(data);
    }

    @OriginalMember(owner = "client!tm", name = "c", descriptor = "[Ljava/lang/String;")
    public static final String[] fontLines = new String[100];

    @OriginalMember(owner = "client!ve", name = "f", descriptor = "[B")
    public final byte[] glyphWidths;

    @OriginalMember(owner = "client!ve", name = "n", descriptor = "[[B")
    public byte[][] glyphSpacing;

    @OriginalMember(owner = "client!ve", name = "m", descriptor = "I")
    public final int verticalSpacing;

    @OriginalMember(owner = "client!ve", name = "o", descriptor = "I")
    public final int paddingTop;

    @OriginalMember(owner = "client!ve", name = "k", descriptor = "I")
    public final int paddingBottom;

    @OriginalMember(owner = "client!ve", name = "<init>", descriptor = "([B)V")
    public FontMetrics(@OriginalArg(0) byte[] data) {
        @Pc(6) Packet packet = new Packet(data);

        @Pc(10) int magic = packet.g1();
        if (magic != 0) {
            throw new RuntimeException("");
        }

        @Pc(30) boolean variableWidth = packet.g1() == 1;
        this.glyphWidths = new byte[256];
        packet.gdata(0, 256, this.glyphWidths);

        if (variableWidth) {
            @Pc(46) int[] a = new int[256];
            for (@Pc(48) int i = 0; i < 256; i++) {
                a[i] = packet.g1();
            }
            @Pc(62) int[] b = new int[256];
            for (@Pc(64) int i = 0; i < 256; i++) {
                b[i] = packet.g1();
            }

            @Pc(78) byte[][] c = new byte[256][];
            for (@Pc(80) int local80 = 0; local80 < 256; local80++) {
                c[local80] = new byte[a[local80]];
                @Pc(90) byte local90 = 0;
                for (@Pc(92) int local92 = 0; local92 < c[local80].length; local92++) {
                    local90 += packet.g1b();
                    c[local80][local92] = local90;
                }
            }

            @Pc(128) byte[][] d = new byte[256][];
            for (@Pc(92) int local92 = 0; local92 < 256; local92++) {
                d[local92] = new byte[a[local92]];
                @Pc(140) byte accumulator = 0;
                for (@Pc(142) int local142 = 0; local142 < d[local92].length; local142++) {
                    accumulator += packet.g1b();
                    d[local92][local142] = accumulator;
                }
            }

            this.glyphSpacing = new byte[256][256];
            for (@Pc(178) int prev = 0; prev < 256; prev++) {
                if (prev != ' ' && prev != ' ') {
                    for (@Pc(142) int curr = 0; curr < 256; curr++) {
                        if (curr != ' ' && curr != ' ') {
                            this.glyphSpacing[prev][curr] = (byte) computeSpacing(b, curr, a, prev, c, this.glyphWidths, d);
                        }
                    }
                }
            }

            this.verticalSpacing = b[' '] + a[' '];
        } else {
            this.verticalSpacing = packet.g1();
        }

        packet.g1();
        packet.g1();

        this.paddingTop = packet.g1();
        this.paddingBottom = packet.g1();
    }

    @OriginalMember(owner = "client!lfa", name = "a", descriptor = "([III[II[[B[B[[B)I")
    public static int computeSpacing(@OriginalArg(0) int[] b, @OriginalArg(2) int curr, @OriginalArg(3) int[] a, @OriginalArg(4) int prev, @OriginalArg(5) byte[][] c, @OriginalArg(6) byte[] glyphWidths, @OriginalArg(7) byte[][] d) {
        @Pc(7) int bPrev = b[prev];
        @Pc(14) int combinedPrev = bPrev + a[prev];
        @Pc(18) int bCurr = b[curr];
        @Pc(24) int combinedCurr = bCurr + a[curr];

        @Pc(26) int max = bPrev;
        if (bCurr > bPrev) {
            max = bCurr;
        }

        @Pc(37) int maxCombined = combinedPrev;
        if (combinedPrev > combinedCurr) {
            maxCombined = combinedCurr;
        }

        @Pc(48) int minSpacing = glyphWidths[prev] & 0xFF;
        if ((glyphWidths[curr] & 0xFF) < minSpacing) {
            minSpacing = glyphWidths[curr] & 0xFF;
        }

        @Pc(69) byte[] dPrev = d[prev];
        @Pc(73) byte[] cCurr = c[curr];

        @Pc(78) int local78 = max - bPrev;
        @Pc(83) int local83 = max - bCurr;

        for (@Pc(85) int i = max; i < maxCombined; i++) {
            @Pc(96) int spacing = cCurr[local83++] + dPrev[local78++];

            if (minSpacing > spacing) {
                minSpacing = spacing;
            }
        }

        return -minSpacing;
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(CII)I")
    public int glyphSpacing(@OriginalArg(0) char curr, @OriginalArg(1) int prev) {
        return this.glyphSpacing == null ? 0 : this.glyphSpacing[prev][curr];
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(IZ)I")
    public int glyphWidth(@OriginalArg(0) int i) {
        return this.glyphWidths[i] & 0xFF;
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(Ljava/lang/String;[Lclient!st;BI)I")
    public int paraHeight(@OriginalArg(0) String text, @OriginalArg(1) Sprite[] icons, @OriginalArg(3) int lineWidth) {
        return this.splitLines(fontLines, new int[]{lineWidth}, icons, text);
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "([Ljava/lang/String;[II[Lclient!st;Ljava/lang/String;)I")
    public int splitLines(@OriginalArg(0) String[] destination, @OriginalArg(1) int[] lineBounds, @OriginalArg(3) Sprite[] icons, @OriginalArg(4) String text) {
        if (text == null) {
            return 0;
        }

        @Pc(10) int lineWidth = 0;
        @Pc(12) int lineStart = 0;
        @Pc(14) int lastSpace = -1;
        @Pc(16) int widthOffset = 0;
        @Pc(18) byte spaceOffset = 0;
        @Pc(20) int openBracket = -1;
        @Pc(22) int prev = -1;
        @Pc(24) int lineCount = 0;

        @Pc(35) int len = text.length();
        for (@Pc(37) int i = 0; i < len; i++) {
            @Pc(46) int curr = Cp1252.encode(text.charAt(i)) & 0xFF;
            @Pc(48) int width = 0;

            if (curr == '<') {
                openBracket = i;
            } else {
                @Pc(69) int lineEnd;
                if (openBracket == -1) {
                    width = this.glyphWidth(curr);
                    lineEnd = i;
                    if (this.glyphSpacing != null && prev != -1) {
                        width += this.glyphSpacing[prev][curr];
                    }
                    prev = curr;
                } else {
                    if (curr != '>') {
                        continue;
                    }

                    lineEnd = openBracket;
                    @Pc(76) String escaped = text.substring(openBracket + 1, i);
                    openBracket = -1;

                    if (escaped.equals("br")) {
                        destination[lineCount] = text.substring(lineStart, i + 1);
                        lineCount++;
                        if (destination.length <= lineCount) {
                            return 0;
                        }
                        lineWidth = 0;
                        lineStart = i + 1;
                        lastSpace = -1;
                        prev = -1;
                        continue;
                    }

                    if (escaped.equals("lt")) {
                        width = this.glyphWidth('<');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['<'];
                        }
                        prev = '<';
                    } else if (escaped.equals("gt")) {
                        width = this.glyphWidth('>');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['>'];
                        }
                        prev = '>';
                    } else if (escaped.equals("nbsp")) {
                        width = this.glyphWidth(' ');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev][' '];
                        }
                        prev = ' ';
                    } else if (escaped.equals("shy")) {
                        width = this.glyphWidth('­');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['­'];
                        }
                        prev = '­';
                    } else if (escaped.equals("times")) {
                        width = this.glyphWidth('×');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['×'];
                        }
                        prev = '×';
                    } else if (escaped.equals("euro")) {
                        width = this.glyphWidth('€');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['€'];
                        }
                        prev = '€';
                    } else if (escaped.equals("copy")) {
                        width = this.glyphWidth('©');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['©'];
                        }
                        prev = '©';
                    } else if (escaped.equals("reg")) {
                        width = this.glyphWidth('®');
                        if (this.glyphSpacing != null && prev != -1) {
                            width += this.glyphSpacing[prev]['®'];
                        }
                        prev = '®';
                    } else if (escaped.startsWith("img=") && icons != null) {
                        try {
                            @Pc(242) int icon = StringTools.parseDecimal(escaped.substring(4));
                            width = icons[icon].scaleWidth();
                            prev = -1;
                        } catch (@Pc(253) Exception ignored) {
                            /* empty */
                        }
                    }

                    curr = -1;
                }

                if (width > 0) {
                    lineWidth += width;

                    if (lineBounds != null) {
                        if (curr == ' ') {
                            lastSpace = i;
                            spaceOffset = 1;
                            widthOffset = lineWidth;
                        }

                        if (lineBounds[lineBounds.length <= lineCount ? lineBounds.length - 1 : lineCount] < lineWidth) {
                            if (lastSpace < 0) {
                                destination[lineCount] = text.substring(lineStart, lineEnd);
                                lineCount++;
                                if (lineCount >= destination.length) {
                                    return 0;
                                }
                                lineStart = lineEnd;
                                lineWidth = width;
                                prev = -1;
                                lastSpace = -1;
                            } else {
                                destination[lineCount] = text.substring(lineStart, lastSpace + 1 - spaceOffset);
                                lineCount++;
                                if (destination.length <= lineCount) {
                                    return 0;
                                }
                                lineStart = lastSpace + 1;
                                lastSpace = -1;
                                lineWidth -= widthOffset;
                                prev = -1;
                            }
                        }

                        if (curr == '-') {
                            widthOffset = lineWidth;
                            spaceOffset = 0;
                            lastSpace = i;
                        }
                    }
                }
            }
        }

        if (text.length() > lineStart) {
            destination[lineCount] = text.substring(lineStart, text.length());
            lineCount++;
        }

        return lineCount;
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "([Lclient!st;ILjava/lang/String;I)I")
    public int paraWidth(@OriginalArg(0) Sprite[] icons, @OriginalArg(2) String arg1, @OriginalArg(3) int lineWidth) {
        @Pc(16) int lineCount = this.splitLines(fontLines, new int[]{lineWidth}, icons, arg1);
        @Pc(18) int maxWidth = 0;

        for (@Pc(20) int line = 0; line < lineCount; line++) {
            @Pc(29) int width = this.stringWidth(icons, fontLines[line]);

            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(I[Lclient!st;Ljava/lang/String;)I")
    public int stringWidth(@OriginalArg(1) Sprite[] icons, @OriginalArg(2) String text) {
        if (text == null) {
            return 0;
        }
        @Pc(10) int openBracket = -1;
        @Pc(19) int prev = -1;
        @Pc(21) int width = 0;
        @Pc(24) int len = text.length();
        for (@Pc(26) int i = 0; i < len; i++) {
            @Pc(31) char curr = text.charAt(i);
            if (curr == '<') {
                openBracket = i;
            } else {
                if (curr == '>' && openBracket != -1) {
                    @Pc(53) String escaped = text.substring(openBracket + 1, i);
                    openBracket = -1;

                    if (escaped.equals("lt")) {
                        curr = '<';
                    } else if (escaped.equals("gt")) {
                        curr = '>';
                    } else if (escaped.equals("nbsp")) {
                        curr = ' ';
                    } else if (escaped.equals("shy")) {
                        curr = '­';
                    } else if (escaped.equals("times")) {
                        curr = '×';
                    } else if (escaped.equals("euro")) {
                        curr = '€';
                    } else if (escaped.equals("copy")) {
                        curr = '©';
                    } else if (escaped.equals("reg")) {
                        curr = '®';
                    } else {
                        if (escaped.startsWith("img=") && icons != null) {
                            try {
                                @Pc(143) int icon = StringTools.parseDecimal(escaped.substring(4));
                                prev = -1;
                                width += icons[icon].scaleWidth();
                            } catch (@Pc(154) Exception ignored) {
                                /* empty */
                            }
                        }
                        continue;
                    }
                }

                if (openBracket == -1) {
                    width += this.glyphWidths[Cp1252.encode(curr) & 0xFF] & 0xFF;
                    if (this.glyphSpacing != null && prev != -1) {
                        width += this.glyphSpacing[prev][curr];
                    }
                    prev = curr;
                }
            }
        }

        return width;
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(Ljava/lang/String;[Lclient!st;II)Ljava/lang/String;")
    public String fitText(@OriginalArg(0) String text, @OriginalArg(1) Sprite[] icons, @OriginalArg(2) int maxWidth) {
        if (this.stringWidth(icons, text) <= maxWidth) {
            return text;
        }

        @Pc(27) int remainingWidth = maxWidth - this.stringWidth(null, "...");
        @Pc(29) int openBracket = -1;
        @Pc(31) int prev = -1;
        @Pc(33) int width = 0;
        @Pc(36) int local36 = text.length();
        @Pc(38) String prefix = "";

        for (@Pc(40) int i = 0; i < local36; i++) {
            @Pc(45) char curr = text.charAt(i);

            if (curr == '<') {
                openBracket = i;
            } else {
                if (curr == '>' && openBracket != -1) {
                    @Pc(69) String escaped = text.substring(openBracket + 1, i);
                    openBracket = -1;

                    if (escaped.equals("lt")) {
                        curr = '<';
                    } else if (escaped.equals("gt")) {
                        curr = '>';
                    } else if (escaped.equals("nbsp")) {
                        curr = ' ';
                    } else if (escaped.equals("shy")) {
                        curr = '­';
                    } else if (escaped.equals("times")) {
                        curr = '×';
                    } else if (escaped.equals("euro")) {
                        curr = '€';
                    } else if (escaped.equals("copy")) {
                        curr = '©';
                    } else if (escaped.equals("reg")) {
                        curr = '®';
                    } else {
                        if (escaped.startsWith("img=") && icons != null) {
                            try {
                                @Pc(155) int icon = StringTools.parseDecimal(escaped.substring(4));
                                width += icons[icon].scaleWidth();
                                prev = -1;

                                if (width > remainingWidth) {
                                    return prefix + "...";
                                }

                                prefix = text.substring(0, i + 1);
                            } catch (@Pc(192) Exception empty) {
                                /* ignored */
                            }
                        }
                        continue;
                    }
                }

                if (openBracket == -1) {
                    width += this.glyphWidths[Cp1252.encode(curr) & 0xFF] & 0xFF;
                    if (this.glyphSpacing != null && prev != -1) {
                        width += this.glyphSpacing[prev][curr];
                    }

                    prev = curr;

                    @Pc(242) int totalWidth = width;
                    if (this.glyphSpacing != null) {
                        totalWidth = width + this.glyphSpacing[curr][46];
                    }

                    if (remainingWidth < totalWidth) {
                        return prefix + "...";
                    }

                    prefix = text.substring(0, i + 1);
                }
            }
        }

        return text;
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(BLjava/lang/String;)I")
    public int stringWidth(@OriginalArg(1) String arg0) {
        return this.stringWidth(null, arg0);
    }

    @OriginalMember(owner = "client!ve", name = "a", descriptor = "(IILjava/lang/String;[Lclient!st;B)I")
    public int stringHeight(@OriginalArg(0) int lineWidth, @OriginalArg(1) int spacing, @OriginalArg(2) String text, @OriginalArg(3) Sprite[] icons) {
        if (spacing == 0) {
            spacing = this.verticalSpacing;
        }
        @Pc(24) int lineCount = this.splitLines(fontLines, new int[]{lineWidth}, icons, text);
        @Pc(42) int height = spacing * (lineCount - 1);
        return height + this.paddingTop + this.paddingBottom;
    }
}
