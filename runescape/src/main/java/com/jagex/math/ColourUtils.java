package com.jagex.math;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ColourUtils {

    @OriginalMember(owner = "client!kda", name = "e", descriptor = "[I")
    public static int[] HSV_TO_RGB;

    @OriginalMember(owner = "client!er", name = "e", descriptor = "[I")
    public static int[] HSL_TO_RGB;

    @OriginalMember(owner = "client!nka", name = "a", descriptor = "I")
    private static int hsvReferences = 0;

    @OriginalMember(owner = "client!ft", name = "d", descriptor = "I")
    private static int hslReferences = 0;

    @OriginalMember(owner = "client!gca", name = "a", descriptor = "(IZZ)V")
    public static void init(@OriginalArg(1) boolean hsl, @OriginalArg(2) boolean hsv) {
        if (hsv) {
            hsvReferences++;
            initHSVToRgb();
        }

        if (hsl) {
            hslReferences++;
            initHSLToRgb();
        }
    }

    @OriginalMember(owner = "client!jj", name = "a", descriptor = "(ZBZ)V")
    public static void destroy(@OriginalArg(0) boolean hsv, @OriginalArg(2) boolean hsl) {
        if (hsl) {
            hslReferences--;

            if (hslReferences == 0) {
                HSL_TO_RGB = null;
            }
        }

        if (hsv) {
            hsvReferences--;

            if (hsvReferences == 0) {
                HSV_TO_RGB = null;
            }
        }
    }

    @OriginalMember(owner = "client!k", name = "c", descriptor = "(I)V")
    private static void initHSVToRgb() {
        if (HSV_TO_RGB != null) {
            return;
        }
        HSV_TO_RGB = new int[65536];
        @Pc(18) double local18 = Math.random() * 0.03D + 0.7D - 0.015D;
        @Pc(20) int local20 = 0;
        for (@Pc(22) int local22 = 0; local22 < 512; local22++) {
            @Pc(40) float local40 = ((float) (local22 >> 3) / 64.0F + 0.0078125F) * 360.0F;
            @Pc(49) float local49 = (float) (local22 & 0x7) / 8.0F + 0.0625F;
            for (@Pc(51) int local51 = 0; local51 < 128; local51++) {
                @Pc(57) float local57 = (float) local51 / 128.0F;
                @Pc(59) float local59 = 0.0F;
                @Pc(61) float local61 = 0.0F;
                @Pc(63) float local63 = 0.0F;
                @Pc(67) float local67 = local40 / 60.0F;
                @Pc(70) int local70 = (int) local67;
                @Pc(74) int local74 = local70 % 6;
                @Pc(79) float local79 = local67 - (float) local70;
                @Pc(86) float local86 = local57 * (1.0F - local49);
                @Pc(95) float local95 = local57 * (1.0F - local79 * local49);
                @Pc(106) float local106 = (1.0F - local49 * (1.0F - local79)) * local57;
                if (local74 == 0) {
                    local59 = local57;
                    local63 = local86;
                    local61 = local106;
                } else if (local74 == 1) {
                    local63 = local86;
                    local59 = local95;
                    local61 = local57;
                } else if (local74 == 2) {
                    local59 = local86;
                    local61 = local57;
                    local63 = local106;
                } else if (local74 == 3) {
                    local61 = local95;
                    local59 = local86;
                    local63 = local57;
                } else if (local74 == 4) {
                    local63 = local57;
                    local59 = local106;
                    local61 = local86;
                } else if (local74 == 5) {
                    local61 = local86;
                    local63 = local95;
                    local59 = local57;
                }
                local59 = (float) Math.pow(local59, local18);
                local61 = (float) Math.pow(local61, local18);
                local63 = (float) Math.pow(local63, local18);
                @Pc(201) int local201 = (int) (local59 * 256.0F);
                @Pc(206) int local206 = (int) (local61 * 256.0F);
                @Pc(211) int local211 = (int) (local63 * 256.0F);
                @Pc(224) int local224 = (local206 << 8) + (local201 << 16) + local211 - 16777216;
                HSV_TO_RGB[local20++] = local224;
            }
        }
    }

    @OriginalMember(owner = "client!oha", name = "a", descriptor = "(I)V")
    private static void initHSLToRgb() {
        if (HSL_TO_RGB != null) {
            return;
        }
        HSL_TO_RGB = new int[65536];
        @Pc(18) double local18 = Math.random() * 0.03D + 0.7D - 0.015D;
        for (@Pc(27) int local27 = 0; local27 < 65536; local27++) {
            @Pc(40) double local40 = (double) (local27 >> 10 & 0x3F) / 64.0D + 0.0078125D;
            @Pc(51) double local51 = (double) (local27 >> 7 & 0x7) / 8.0D + 0.0625D;
            @Pc(58) double local58 = (double) (local27 & 0x7F) / 128.0D;
            @Pc(60) double local60 = local58;
            @Pc(62) double local62 = local58;
            @Pc(64) double local64 = local58;
            if (local51 != 0.0D) {
                @Pc(82) double local82;
                if (local58 < 0.5D) {
                    local82 = (local51 + 1.0D) * local58;
                } else {
                    local82 = local58 + local51 - local51 * local58;
                }
                @Pc(95) double local95 = local58 * 2.0D - local82;
                @Pc(99) double local99 = local40 + 0.3333333333333333D;
                if (local99 > 1.0D) {
                    local99--;
                }
                @Pc(113) double local113 = local40 - 0.3333333333333333D;
                if (local113 < 0.0D) {
                    local113++;
                }
                if (local40 * 6.0D < 1.0D) {
                    local62 = local95 + local40 * 6.0D * (local82 - local95);
                } else if (local40 * 2.0D < 1.0D) {
                    local62 = local82;
                } else if (local40 * 3.0D < 2.0D) {
                    local62 = (local82 - local95) * (-local40 + 0.6666666666666666D) * 6.0D + local95;
                } else {
                    local62 = local95;
                }
                if (local99 * 6.0D < 1.0D) {
                    local60 = local99 * 6.0D * (local82 - local95) + local95;
                } else if (local99 * 2.0D < 1.0D) {
                    local60 = local82;
                } else if (local99 * 3.0D < 2.0D) {
                    local60 = local95 + (local82 - local95) * 6.0D * (0.6666666666666666D - local99);
                } else {
                    local60 = local95;
                }
                if (local113 * 6.0D < 1.0D) {
                    local64 = local95 + (local82 - local95) * 6.0D * local113;
                } else if (local113 * 2.0D < 1.0D) {
                    local64 = local82;
                } else if (local113 * 3.0D < 2.0D) {
                    local64 = (0.6666666666666666D - local113) * (-local95 + local82) * 6.0D + local95;
                } else {
                    local64 = local95;
                }
            }
            local60 = Math.pow(local60, local18);
            local62 = Math.pow(local62, local18);
            local64 = Math.pow(local64, local18);
            @Pc(290) int local290 = (int) (local60 * 256.0D);
            @Pc(295) int local295 = (int) (local62 * 256.0D);
            @Pc(300) int local300 = (int) (local64 * 256.0D);
            @Pc(311) int local311 = local300 + (local290 << 16) + (local295 << 8);
            HSL_TO_RGB[local27] = local311;
        }
    }

    @OriginalMember(owner = "client!df", name = "a", descriptor = "(II)S")
    public static short hslToHsv(@OriginalArg(1) int colour) {
        @Pc(9) int hue = colour >> 10 & 0x3F;
        @Pc(21) int saturation = colour >> 3 & 0x70;
        @Pc(25) int lightness = colour & 0x7F;

        @Pc(46) int newLightness = (lightness <= 64) ? ((lightness * saturation) >> 7) : ((saturation * (127 - lightness)) >> 7);
        @Pc(50) int value = newLightness + lightness;
        @Pc(58) int newSaturation;
        if (value == 0) {
            newSaturation = newLightness << 1;
        } else {
            newSaturation = (newLightness << 8) / value;
        }
        return (short) (((newSaturation >> 4) << 7) | (hue << 10) | value);
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(ZII)I")
    public static int method3066(@OriginalArg(2) int arg0) {
        if (arg0 == -2) {
            return 12345678;
        } else if (arg0 == -1) {
            return 96;
        } else {
            @Pc(52) int local52 = (arg0 & 0x7F) * 96 >> 7;
            if (local52 < 2) {
                local52 = 2;
            } else if (local52 > 126) {
                local52 = 126;
            }
            return local52 + (arg0 & 0xFF80);
        }
    }

    @OriginalMember(owner = "client!fca", name = "a", descriptor = "(II)I")
    public static int rgbToHsl(@OriginalArg(1) int rgb) {
        @Pc(12) double r = (double) (rgb >> 16 & 0xFF) / 256.0D;
        @Pc(21) double g = (double) (rgb >> 8 & 0xFF) / 256.0D;
        @Pc(28) double b = (double) (rgb & 0xFF) / 256.0D;

        @Pc(30) double local30 = r;
        if (r > g) {
            local30 = g;
        }
        if (local30 > b) {
            local30 = b;
        }

        @Pc(44) double local44 = r;
        if (g > r) {
            local44 = g;
        }
        if (b > local44) {
            local44 = b;
        }

        @Pc(58) double local58 = 0.0D;
        @Pc(60) double local60 = 0.0D;
        @Pc(66) double local66 = (local30 + local44) / 2.0D;
        if (local44 != local30) {
            if (local66 < 0.5D) {
                local60 = (local44 - local30) / (local30 + local44);
            }
            if (local44 == r) {
                local58 = (g - b) / (-local30 + local44);
            } else if (local44 == g) {
                local58 = (b - r) / (local44 - local30) + 2.0D;
            } else if (local44 == b) {
                local58 = (r - g) / (local44 - local30) + 4.0D;
            }
            if (local66 >= 0.5D) {
                local60 = (local44 - local30) / (2.0D - local44 - local30);
            }
        }
        local58 /= 6.0D;

        @Pc(156) int local156 = (int) (local58 * 256.0D);

        @Pc(168) int local168 = (int) (local60 * 256.0D);
        if (local168 < 0) {
            local168 = 0;
        } else if (local168 > 255) {
            local168 = 255;
        }

        @Pc(173) int local173 = (int) (local66 * 256.0D);
        if (local173 < 0) {
            local173 = 0;
        } else if (local173 > 255) {
            local173 = 255;
        }
        if (local173 > 243) {
            local168 >>= 0x4;
        } else if (local173 > 217) {
            local168 >>= 0x3;
        } else if (local173 > 192) {
            local168 >>= 0x2;
        } else if (local173 > 179) {
            local168 >>= 0x1;
        }

        return (local173 >> 1) + (local168 >> 5 << 7) + ((local156 >> 2 & 0x3F) << 10);
    }

    private ColourUtils() {
        /* empty */
    }
}
