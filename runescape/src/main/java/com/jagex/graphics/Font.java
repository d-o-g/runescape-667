package com.jagex.graphics;

import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.stringtools.general.StringTools;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Random;

@OriginalClass("client!da")
public abstract class Font {

    @OriginalMember(owner = "client!aga", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] textLines = new String[100];

    @OriginalMember(owner = "client!cba", name = "B", descriptor = "I")
    public static int shadowColour = 0;

    @OriginalMember(owner = "client!bea", name = "i", descriptor = "I")
    public static int spaceWidth = 0;

    @OriginalMember(owner = "client!rk", name = "r", descriptor = "I")
    public static int spaceOffset = 0;

    @OriginalMember(owner = "client!ua", name = "c", descriptor = "I")
    public static int strikeColour = -1;

    @OriginalMember(owner = "client!wba", name = "d", descriptor = "I")
    public static int underlineColour = -1;

    @OriginalMember(owner = "client!us", name = "m", descriptor = "I")
    public static int textColour = 0;

    @OriginalMember(owner = "client!un", name = "B", descriptor = "I")
    public static int oldTextColour = 0;

    @OriginalMember(owner = "client!un", name = "z", descriptor = "I")
    public static int oldShadowColour = 0;

    @OriginalMember(owner = "client!da", name = "i", descriptor = "Lclient!ha;")
    public final Toolkit toolkit;

    @OriginalMember(owner = "client!da", name = "m", descriptor = "Lclient!ve;")
    public final FontMetrics metrics;

    @OriginalMember(owner = "client!da", name = "<init>", descriptor = "(Lclient!ha;Lclient!ve;)V")
    protected Font(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) FontMetrics metrics) {
        this.toolkit = toolkit;
        this.metrics = metrics;
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "([Lclient!st;IIIILjava/lang/String;[IILjava/util/Random;I)I")
    public final int renderRandom(@OriginalArg(0) Sprite[] icons, @OriginalArg(1) int seed, @OriginalArg(2) int textColour, @OriginalArg(3) int y, @OriginalArg(5) String text, @OriginalArg(6) int[] iconHeights, @OriginalArg(7) int shadowColour, @OriginalArg(8) Random random, @OriginalArg(9) int x) {
        if (text == null) {
            return 0;
        }

        random.setSeed(seed);
        @Pc(22) int alpha = (random.nextInt() & 0x1F) + 192;
        this.setTextColours(alpha << 24 | textColour & 0xFFFFFF, alpha << 24 | 0xFFFFFF & shadowColour);

        @Pc(42) int len = text.length();
        @Pc(45) int[] offsetX = new int[len];
        @Pc(57) int deltaX = 0;
        for (@Pc(59) int i = 0; i < len; i++) {
            offsetX[i] = deltaX;
            if ((random.nextInt() & 0x3) == 0) {
                deltaX++;
            }
        }

        this.render(offsetX, text, y, icons, x, null, iconHeights);
        return deltaX;
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(CIIIZLclient!aa;II)V")
    protected abstract void renderSymbol(@OriginalArg(0) char c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int colour, @OriginalArg(4) boolean shadow, @OriginalArg(5) ClippingMask mask, @OriginalArg(6) int offsetX, @OriginalArg(7) int offsetY);

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IIIIILjava/lang/String;II)V")
    public final void renderShake(@OriginalArg(0) int elapsed, @OriginalArg(1) int x, @OriginalArg(2) int tick, @OriginalArg(3) int y, @OriginalArg(4) int textColour, @OriginalArg(5) String text, @OriginalArg(5) int shadowColour) {
        if (text == null) {
            return;
        }

        this.setTextColours(textColour, shadowColour);

        @Pc(32) double amplitude = 7.0D - ((double) elapsed / 8.0D);
        if (amplitude < 0.0D) {
            amplitude = 0.0D;
        }

        @Pc(41) int len = text.length();
        @Pc(44) int[] offsetY = new int[len];
        for (@Pc(46) int i = 0; i < len; i++) {
            offsetY[i] = (int) (Math.sin((double) tick + (double) i / 1.5D) * amplitude);
        }

        this.render(null, text, y, null, x - (this.metrics.stringWidth(text) / 2), offsetY, null);
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "([ILjava/lang/String;I[Lclient!st;I[IZ[I)V")
    public void render(@OriginalArg(0) int[] offsetX, @OriginalArg(1) String text, @OriginalArg(2) int y, @OriginalArg(3) Sprite[] icons, @OriginalArg(4) int x, @OriginalArg(5) int[] offsetY, @OriginalArg(7) int[] iconHeights) {
        @Pc(7) int adjustedY = y - this.metrics.verticalSpacing;
        @Pc(13) int openBracket = -1;
        @Pc(15) int prev = -1;
        @Pc(17) int charCount = 0;
        @Pc(20) int len = text.length();

        for (@Pc(29) int i = 0; i < len; i++) {
            @Pc(40) char curr = (char) (Cp1252.encode(text.charAt(i)) & 0xFF);

            if (curr == '<') {
                openBracket = i;
            } else {
                if (curr == '>' && openBracket != -1) {
                    @Pc(64) String escaped = text.substring(openBracket + 1, i);
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
                        if (escaped.startsWith("img=")) {
                            try {
                                @Pc(164) int deltaX;
                                if (offsetX == null) {
                                    deltaX = 0;
                                } else {
                                    deltaX = offsetX[charCount];
                                }

                                @Pc(174) int deltaY;
                                if (offsetY == null) {
                                    deltaY = 0;
                                } else {
                                    deltaY = offsetY[charCount];
                                }

                                charCount++;
                                @Pc(187) int iconId = StringTools.parseDecimal(escaped.substring(4));
                                @Pc(191) Sprite icon = icons[iconId];
                                @Pc(201) int height = iconHeights != null ? iconHeights[iconId] : icon.scaleHeight();
                                icon.render(deltaX + x, deltaY + -height + adjustedY + this.metrics.verticalSpacing, 1, 0, 1);
                                prev = -1;
                                x += icons[iconId].scaleWidth();
                            } catch (@Pc(230) Exception ignored) {
                                /* empty */
                            }
                        } else {
                            this.parseEscaped(escaped);
                        }

                        continue;
                    }
                }

                if (openBracket == -1) {
                    if (prev != -1) {
                        x += this.metrics.glyphSpacing(curr, prev);
                    }

                    @Pc(268) int deltaX;
                    if (offsetX == null) {
                        deltaX = 0;
                    } else {
                        deltaX = offsetX[charCount];
                    }

                    @Pc(164) int deltaY;
                    if (offsetY == null) {
                        deltaY = 0;
                    } else {
                        deltaY = offsetY[charCount];
                    }

                    if (curr != ' ') {
                        if ((shadowColour & 0xFF000000) != 0) {
                            this.fa(curr, x + deltaX + 1, deltaY + (adjustedY + 1), shadowColour, true);
                        }

                        this.fa(curr, x + deltaX, deltaY + adjustedY, textColour, false);
                    } else if (spaceWidth > 0) {
                        spaceOffset += spaceWidth;
                        x += spaceOffset >> 8;
                        spaceOffset &= 0xFF;
                    }

                    charCount++;

                    @Pc(174) int width = this.metrics.glyphWidth(curr);
                    if (strikeColour != -1) {
                        this.toolkit.horizontalLine((int) ((double) this.metrics.verticalSpacing * 0.7D) + adjustedY, strikeColour, x, width);
                    }
                    if (underlineColour != -1) {
                        this.toolkit.horizontalLine(this.metrics.verticalSpacing + adjustedY, underlineColour, x, width);
                    }
                    x += width;

                    prev = curr;
                }
            }
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(BILjava/lang/String;)V")
    public void setSpaceWidth(@OriginalArg(1) int width, @OriginalArg(2) String text) {
        @Pc(5) int spaces = 0;
        @Pc(7) boolean escaped = false;

        for (@Pc(17) int i = 0; i < text.length(); i++) {
            @Pc(22) char c = text.charAt(i);

            if (c == '<') {
                escaped = true;
            } else if (c == '>') {
                escaped = false;
            } else if (!escaped && c == ' ') {
                spaces++;
            }
        }

        if (spaces > 0) {
            spaceWidth = (width - this.metrics.stringWidth(text) << 8) / spaces;
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "([Lclient!st;IILjava/lang/String;IZLclient!aa;I[I)V")
    public void render(@OriginalArg(0) Sprite[] icons, @OriginalArg(1) int offsetY, @OriginalArg(2) int offsetX, @OriginalArg(3) String text, @OriginalArg(4) int x, @OriginalArg(6) ClippingMask mask, @OriginalArg(7) int y, @OriginalArg(8) int[] iconHeights) {
        @Pc(5) int adjustedY = y - this.metrics.verticalSpacing;
        @Pc(11) int openBracket = -1;
        @Pc(18) int prev = -1;
        @Pc(21) int len = text.length();

        for (@Pc(23) int i = 0; i < len; i++) {
            @Pc(33) char curr = (char) (Cp1252.encode(text.charAt(i)) & 0xFF);
            if (curr == '<') {
                openBracket = i;
            } else {
                if (curr == '>' && openBracket != -1) {
                    @Pc(54) String escaped = text.substring(openBracket + 1, i);
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
                        if (escaped.startsWith("img=")) {
                            try {
                                @Pc(136) int iconId = StringTools.parseDecimal(escaped.substring(4));
                                @Pc(140) Sprite icon = icons[iconId];
                                @Pc(150) int height = iconHeights == null ? icon.scaleHeight() : iconHeights[iconId];
                                if ((textColour & 0xFF000000) == 0xFF000000) {
                                    icon.render(x, this.metrics.verticalSpacing + adjustedY - height, 1, 0, 1);
                                } else {
                                    icon.render(x, adjustedY + this.metrics.verticalSpacing - height, 0, textColour & 0xFF000000 | 0xFFFFFF, 1);
                                }
                                prev = -1;
                                x += icons[iconId].scaleWidth();
                            } catch (@Pc(202) Exception ignored) {
                                /* empty */
                            }
                        } else {
                            this.parseEscaped(escaped);
                        }
                        continue;
                    }
                }

                if (openBracket == -1) {
                    if (prev != -1) {
                        x += this.metrics.glyphSpacing(curr, prev);
                    }

                    if (curr == ' ') {
                        if (spaceWidth > 0) {
                            spaceOffset += spaceWidth;
                            x += spaceOffset >> 8;
                            spaceOffset &= 0xFF;
                        }
                    } else if (mask == null) {
                        if ((shadowColour & 0xFF000000) != 0) {
                            this.fa(curr, x + 1, adjustedY - -1, shadowColour, true);
                        }

                        this.fa(curr, x, adjustedY, textColour, false);
                    } else {
                        if ((shadowColour & 0xFF000000) != 0) {
                            this.renderSymbol(curr, x + 1, adjustedY - -1, shadowColour, true, mask, offsetX, offsetY);
                        }

                        this.renderSymbol(curr, x, adjustedY, textColour, false, mask, offsetX, offsetY);
                    }

                    @Pc(328) int width = this.metrics.glyphWidth(curr);
                    if (strikeColour != -1) {
                        this.toolkit.horizontalLine(adjustedY + (int) ((double) this.metrics.verticalSpacing * 0.7D), strikeColour, x, width);
                    }
                    if (underlineColour != -1) {
                        this.toolkit.horizontalLine(this.metrics.verticalSpacing + adjustedY + 1, underlineColour, x, width);
                    }

                    prev = curr;
                    x += width;
                }
            }
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(III)V")
    public void setTextColours(@OriginalArg(1) int textColour, @OriginalArg(2) int shadowColour) {
        spaceWidth = 0;
        oldTextColour = textColour;
        Font.textColour = textColour;
        spaceOffset = 0;
        underlineColour = -1;
        strikeColour = -1;
        if (shadowColour == -1) {
            shadowColour = 0;
        }
        oldShadowColour = shadowColour;
        Font.shadowColour = shadowColour;
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(I[IILjava/lang/String;Lclient!aa;[Lclient!st;IIIIIIIIII)I")
    public final int renderLines(@OriginalArg(0) int offsetY, @OriginalArg(1) int[] iconHeights, @OriginalArg(2) int textColour, @OriginalArg(3) String text, @OriginalArg(4) ClippingMask mask, @OriginalArg(5) Sprite[] icons, @OriginalArg(6) int y, @OriginalArg(7) int shadowColour, @OriginalArg(9) int offsetX, @OriginalArg(10) int horizontalAlignment, @OriginalArg(11) int x, @OriginalArg(12) int verticalAlignment, @OriginalArg(13) int verticalSpacing, @OriginalArg(14) int width, @OriginalArg(15) int height) {
        return this.renderLines(verticalAlignment, textColour, shadowColour, icons, 0, offsetY, y, height, offsetX, mask, verticalSpacing, width, x, horizontalAlignment, iconHeights, text);
    }

    @OriginalMember(owner = "client!da", name = "fa", descriptor = "(CIIIZ)V")
    protected abstract void fa(@OriginalArg(0) char c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int colour, @OriginalArg(4) boolean shadow);

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IIILjava/lang/String;II[Lclient!st;[I)V")
    public final void render(@OriginalArg(0) int textColour, @OriginalArg(1) int shadowColour, @OriginalArg(2) int y, @OriginalArg(3) String text, @OriginalArg(5) int x, @OriginalArg(6) Sprite[] icons, @OriginalArg(7) int[] iconHeights) {
        if (text != null) {
            this.setTextColours(textColour, shadowColour);
            this.render(icons, 0, 0, text, x, null, y, iconHeights);
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IBILjava/lang/String;II)V")
    public final void renderCentre(@OriginalArg(0) int shadowColour, @OriginalArg(2) int x, @OriginalArg(3) String text, @OriginalArg(4) int y, @OriginalArg(5) int textColour) {
        if (text != null) {
            this.setTextColours(textColour, shadowColour);
            this.render(null, 0, 0, text, x - this.metrics.stringWidth(text) / 2, null, y, null);
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IILjava/lang/String;III)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) String text, @OriginalArg(3) int shadowColour, @OriginalArg(5) int textColour) {
        if (text != null) {
            this.setTextColours(textColour, shadowColour);
            this.render(null, 0, 0, text, x, null, y, null);
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IIII[Lclient!st;IIIIILclient!aa;IIII[ILjava/lang/String;)I")
    public final int renderLines(@OriginalArg(0) int verticalAlignment, @OriginalArg(2) int textColour, @OriginalArg(3) int shadowColour, @OriginalArg(4) Sprite[] icons, @OriginalArg(5) int maxLines, @OriginalArg(6) int offsetY, @OriginalArg(7) int y, @OriginalArg(8) int height, @OriginalArg(9) int offsetX, @OriginalArg(10) ClippingMask mask, @OriginalArg(11) int verticalSpacing, @OriginalArg(12) int width, @OriginalArg(13) int x, @OriginalArg(14) int horizontalAlignment, @OriginalArg(15) int[] iconHeights, @OriginalArg(16) String text) {
        if (text == null) {
            return 0;
        }

        this.setTextColours(textColour, shadowColour);

        if (verticalSpacing == 0) {
            verticalSpacing = this.metrics.verticalSpacing;
        }

        @Pc(81) int[] lineBounds;
        if ((height >= (verticalSpacing + this.metrics.paddingBottom + this.metrics.paddingTop)) || (height >= (verticalSpacing + verticalSpacing))) {
            lineBounds = new int[]{width};
        } else {
            lineBounds = null;
        }

        @Pc(93) int lineCount = this.metrics.splitLines(textLines, lineBounds, icons, text);
        if (maxLines == -1) {
            maxLines = height / verticalSpacing;
            if (maxLines <= 0) {
                maxLines = 1;
            }
        }

        if (maxLines > 0 && maxLines <= lineCount) {
            lineCount = maxLines;
            textLines[maxLines - 1] = this.metrics.fitText(textLines[maxLines - 1], icons, width);
        }

        if (verticalAlignment == 3 && lineCount == 1) {
            verticalAlignment = 1;
        }

        @Pc(190) int newY;
        if (verticalAlignment == 0) {
            newY = this.metrics.paddingTop + y;
        } else if (verticalAlignment == 1) {
            newY = ((height - this.metrics.paddingBottom - this.metrics.paddingTop - (verticalSpacing * (lineCount + -1))) / 2) + this.metrics.paddingTop + y;
        } else if (verticalAlignment == 2) {
            newY = height + y - verticalSpacing * (lineCount - 1) - this.metrics.paddingBottom;
        } else {
            @Pc(233) int local233 = (height - this.metrics.paddingTop - this.metrics.paddingBottom - verticalSpacing * (lineCount - 1)) / (lineCount + 1);
            if (local233 < 0) {
                local233 = 0;
            }
            verticalSpacing += local233;
            newY = y + this.metrics.paddingTop + local233;
        }

        for (@Pc(233) int line = 0; line < lineCount; line++) {
            if (horizontalAlignment == 0) {
                this.render(icons, offsetY, offsetX, textLines[line], x, mask, newY, iconHeights);
            } else if (horizontalAlignment == 1) {
                this.render(icons, offsetY, offsetX, textLines[line], x + (width - this.metrics.stringWidth(textLines[line])) / 2, mask, newY, iconHeights);
            } else if (horizontalAlignment == 2) {
                this.render(icons, offsetY, offsetX, textLines[line], x + width - this.metrics.stringWidth(textLines[line]), mask, newY, iconHeights);
            } else if (lineCount - 1 == line) {
                this.render(icons, offsetY, offsetX, textLines[line], x, mask, newY, iconHeights);
            } else {
                this.setSpaceWidth(width, textLines[line]);
                this.render(icons, offsetY, offsetX, textLines[line], x, mask, newY, iconHeights);
                spaceWidth = 0;
            }

            newY += verticalSpacing;
        }

        return lineCount;
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(ILjava/lang/String;)V")
    public void parseEscaped(@OriginalArg(1) String escaped) {
        try {
            if (escaped.startsWith("col=")) {
                textColour = textColour & 0xFF000000 | StringTools.parseHexadecimal(escaped.substring(4)) & 0xFFFFFF;
            } else if (escaped.equals("/col")) {
                textColour = textColour & 0xFF000000 | oldTextColour & 0xFFFFFF;
            }

            if (escaped.startsWith("argb=")) {
                textColour = StringTools.parseHexadecimal(escaped.substring(5));
            } else if (escaped.equals("/argb")) {
                textColour = oldTextColour;
            } else if (escaped.startsWith("str=")) {
                strikeColour = textColour & 0xFF000000 | StringTools.parseHexadecimal(escaped.substring(4));
            } else if (escaped.equals("str")) {
                strikeColour = textColour & 0xFF000000 | 0x800000;
            } else if (escaped.equals("/str")) {
                strikeColour = -1;
            } else if (escaped.startsWith("u=")) {
                underlineColour = textColour & 0xFF000000 | StringTools.parseHexadecimal(escaped.substring(2));
            } else if (escaped.equals("u")) {
                underlineColour = textColour & 0xFF000000;
            } else if (escaped.equals("/u")) {
                underlineColour = -1;
            } else if (escaped.equalsIgnoreCase("shad=-1")) {
                shadowColour = 0;
            } else if (escaped.startsWith("shad=")) {
                shadowColour = textColour & 0xFF000000 | StringTools.parseHexadecimal(escaped.substring(5));
            } else if (escaped.equals("shad")) {
                shadowColour = textColour & 0xFF000000;
            } else if (escaped.equals("/shad")) {
                shadowColour = oldShadowColour;
            } else if (escaped.equals("br")) {
                this.setTextColours(oldTextColour, oldShadowColour);
            }
        } catch (@Pc(214) Exception ignored) {
            /* empty */
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IILjava/lang/String;IIII)V")
    public final void renderWave2(@OriginalArg(0) int shadowColour, @OriginalArg(1) int tick, @OriginalArg(2) String text, @OriginalArg(3) int x, @OriginalArg(4) int textColour, @OriginalArg(5) int y) {
        if (text == null) {
            return;
        }

        this.setTextColours(textColour, shadowColour);

        @Pc(17) int len = text.length();
        @Pc(20) int[] offsetX = new int[len];
        @Pc(23) int[] offsetY = new int[len];
        for (@Pc(30) int i = 0; i < len; i++) {
            offsetX[i] = (int) (Math.sin(((double) i / 5.0D) + ((double) tick / 5.0D)) * 5.0D);
            offsetY[i] = (int) (Math.sin(((double) i / 3.0D) + ((double) tick / 5.0D)) * 5.0D);
        }

        this.render(offsetX, text, y, null, x - this.metrics.stringWidth(text) / 2, offsetY, null);
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(IIILjava/lang/String;III)V")
    public final void renderWave(@OriginalArg(1) int textColour, @OriginalArg(2) int tick, @OriginalArg(3) String text, @OriginalArg(4) int x, @OriginalArg(5) int y, @OriginalArg(6) int shadowColour) {
        if (text == null) {
            return;
        }

        this.setTextColours(textColour, shadowColour);

        @Pc(17) int len = text.length();
        @Pc(25) int[] offsetY = new int[len];
        for (@Pc(27) int i = 0; i < len; i++) {
            offsetY[i] = (int) (Math.sin(((double) i / 2.0D) + ((double) tick / 5.0D)) * 5.0D);
        }

        this.render(null, text, y, null, x - this.metrics.stringWidth(text) / 2, offsetY, null);
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "(BILjava/lang/String;III)V")
    public final void render(@OriginalArg(1) int x, @OriginalArg(2) String text, @OriginalArg(3) int textColour, @OriginalArg(4) int shadowColour, @OriginalArg(5) int y) {
        if (text != null) {
            this.setTextColours(textColour, shadowColour);
            this.render(null, 0, 0, text, x - this.metrics.stringWidth(text), null, y, null);
        }
    }

    @OriginalMember(owner = "client!da", name = "a", descriptor = "([IIII[IIILjava/util/Random;Ljava/lang/String;II[Lclient!st;III)I")
    public final int renderRandom(@OriginalArg(0) int[] textBounds, @OriginalArg(1) int horizontalAlign, @OriginalArg(2) int width, @OriginalArg(4) int[] iconHeights, @OriginalArg(5) int textColour, @OriginalArg(6) int height, @OriginalArg(7) Random random, @OriginalArg(8) String text, @OriginalArg(9) int x, @OriginalArg(10) int shadowColour, @OriginalArg(11) Sprite[] icons, @OriginalArg(12) int seed, @OriginalArg(13) int y, @OriginalArg(14) int verticalAlign) {
        if (text == null) {
            return 0;
        }

        random.setSeed(seed);
        @Pc(21) int alpha = (random.nextInt() & 0x1F) + 192;
        this.setTextColours(alpha << 24 | textColour & 0xFFFFFF, alpha << 24 | shadowColour & 0xFFFFFF);

        @Pc(41) int len = text.length();
        @Pc(44) int[] offsetX = new int[len];
        @Pc(46) int deltaX = 0;
        for (@Pc(48) int i = 0; i < len; i++) {
            offsetX[i] = deltaX;
            if ((random.nextInt() & 0x3) == 0) {
                deltaX++;
            }
        }

        @Pc(74) int newX = x;
        @Pc(80) int newY = this.metrics.paddingTop + y;
        if (verticalAlign == 1) {
            newY += (height - this.metrics.paddingTop - this.metrics.paddingBottom) / 2;
        } else if (verticalAlign == 2) {
            newY = y + height - this.metrics.paddingBottom;
        }

        @Pc(119) int textWidth = -1;
        if (horizontalAlign == 1) {
            textWidth = deltaX + this.metrics.stringWidth(text);
            newX = x + (width - textWidth) / 2;
        } else if (horizontalAlign == 2) {
            textWidth = deltaX + this.metrics.stringWidth(text);
            newX = x + width - textWidth;
        }

        this.render(offsetX, text, newY, icons, newX, null, iconHeights);

        if (textBounds != null) {
            if (textWidth == -1) {
                textWidth = deltaX + this.metrics.stringWidth(text);
            }

            textBounds[0] = newX;
            textBounds[1] = newY - this.metrics.paddingTop;
            textBounds[2] = textWidth;
            textBounds[3] = this.metrics.paddingBottom + this.metrics.paddingTop;
        }

        return deltaX;
    }
}
