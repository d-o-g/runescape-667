package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!si")
public final class Arrays {

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([III)V")
    public static void clear(@OriginalArg(0) int[] src, @OriginalArg(1) int off, @OriginalArg(2) int initialLen) {
        @Pc(5) int len = initialLen - 7;

        while (off < len) {
            src[off++] = 0;
            src[off++] = 0;
            src[off++] = 0;
            src[off++] = 0;
            src[off++] = 0;
            src[off++] = 0;
            src[off++] = 0;
            src[off++] = 0;
        }

        len += 7;

        while (off < len) {
            src[off++] = 0;
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([FI[FII)V")
    public static void copy(@OriginalArg(0) float[] src, @OriginalArg(1) int srcOff, @OriginalArg(2) float[] dest, @OriginalArg(3) int destOff, @OriginalArg(4) int initialLen) {
        @Pc(15) int len;

        if (src == dest) {
            if (srcOff == destOff) {
                return;
            }

            if (destOff > srcOff && destOff < srcOff + initialLen) {
                len = initialLen - 1;

                @Pc(19) int srcEnd = srcOff + len;
                @Pc(23) int destEnd = destOff + len;

                len = srcEnd - len;
                len += 7;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                }

                len -= 7;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                }

                return;
            }
        }

        len = initialLen + srcOff;
        @Pc(115) int end = len - 7;

        while (srcOff < end) {
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
        }

        len = end + 7;

        while (srcOff < len) {
            dest[destOff++] = src[srcOff++];
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([IIII)V")
    public static void set(@OriginalArg(0) int[] src, @OriginalArg(1) int off, @OriginalArg(2) int initialLen, @OriginalArg(3) int value) {
        @Pc(5) int end = off + initialLen - 7;

        while (off < end) {
            src[off++] = value;
            src[off++] = value;
            src[off++] = value;
            src[off++] = value;
            src[off++] = value;
            src[off++] = value;
            src[off++] = value;
            src[off++] = value;
        }

        end += 7;

        while (off < end) {
            src[off++] = value;
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([Ljava/lang/Object;I[Ljava/lang/Object;II)V")
    public static void copy(@OriginalArg(0) Object[] src, @OriginalArg(1) int srcOff, @OriginalArg(2) Object[] dest, @OriginalArg(3) int destOff, @OriginalArg(4) int initialLen) {
        @Pc(15) int len;

        if (src == dest) {
            if (srcOff == destOff) {
                return;
            }

            if (destOff > srcOff && destOff < srcOff + initialLen) {
                len = initialLen - 1;

                @Pc(19) int local19 = srcOff + len;
                @Pc(23) int local23 = destOff + len;

                len = local19 - len;
                len += 7;

                while (local19 >= len) {
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                    dest[local23--] = src[local19--];
                }

                len -= 7;

                while (local19 >= len) {
                    dest[local23--] = src[local19--];
                }

                return;
            }
        }

        len = initialLen + srcOff;
        @Pc(115) int local115 = len - 7;

        while (srcOff < local115) {
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
        }

        len = local115 + 7;

        while (srcOff < len) {
            dest[destOff++] = src[srcOff++];
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([SI[SII)V")
    public static void copy(@OriginalArg(0) short[] src, @OriginalArg(1) int srcOff, @OriginalArg(2) short[] dest, @OriginalArg(3) int destOff, @OriginalArg(4) int initialLen) {
        if (src == dest) {
            return;
        }

        @Pc(114) int len = initialLen;
        @Pc(115) int end = len - 7;

        while (srcOff < end) {
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
        }

        len = end + 7;

        while (srcOff < len) {
            dest[destOff++] = src[srcOff++];
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([JI[JII)V")
    public static void copy(@OriginalArg(0) long[] src, @OriginalArg(1) int srcOff, @OriginalArg(2) long[] dest, @OriginalArg(3) int destOff, @OriginalArg(4) int initialLen) {
        @Pc(15) int len;

        if (src == dest) {
            if (srcOff == destOff) {
                return;
            }

            if (destOff > srcOff && destOff < srcOff + initialLen) {
                len = initialLen - 1;

                @Pc(19) int srcEnd = srcOff + len;
                @Pc(23) int destEnd = destOff + len;

                len = srcEnd - len;
                len += 3;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                }

                len -= 3;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                }

                return;
            }
        }

        len = initialLen + srcOff;
        @Pc(83) int end = len - 3;

        while (srcOff < end) {
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
        }

        len = end + 3;

        while (srcOff < len) {
            dest[destOff++] = src[srcOff++];
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([BI[BII)V")
    public static void copy(@OriginalArg(0) byte[] src, @OriginalArg(1) int srcOff, @OriginalArg(2) byte[] dest, @OriginalArg(3) int destOff, @OriginalArg(4) int initialLen) {
        @Pc(15) int len;
        if (src == dest) {
            if (srcOff == destOff) {
                return;
            }

            if (destOff > srcOff && destOff < srcOff + initialLen) {
                len = initialLen - 1;

                @Pc(19) int srcEnd = srcOff + len;
                @Pc(23) int destEnd = destOff + len;

                len = srcEnd - len;
                len += 7;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                }

                len -= 7;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                }

                return;
            }
        }

        len = initialLen + srcOff;
        @Pc(115) int end = len - 7;

        while (srcOff < end) {
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
        }

        len = end + 7;

        while (srcOff < len) {
            dest[destOff++] = src[srcOff++];
        }
    }

    @OriginalMember(owner = "client!si", name = "a", descriptor = "([II[III)V")
    public static void copy(@OriginalArg(0) int[] src, @OriginalArg(1) int srcOff, @OriginalArg(2) int[] dest, @OriginalArg(3) int destOff, @OriginalArg(4) int initialLen) {
        @Pc(15) int len;

        if (src == dest) {
            if (srcOff == destOff) {
                return;
            }

            if (destOff > srcOff && destOff < srcOff + initialLen) {
                len = initialLen - 1;

                @Pc(19) int srcEnd = srcOff + len;
                @Pc(23) int destEnd = destOff + len;

                len = srcEnd - len;
                len += 7;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                    dest[destEnd--] = src[srcEnd--];
                }

                len -= 7;

                while (srcEnd >= len) {
                    dest[destEnd--] = src[srcEnd--];
                }

                return;
            }
        }

        len = initialLen + srcOff;
        @Pc(115) int end = len - 7;

        while (srcOff < end) {
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
            dest[destOff++] = src[srcOff++];
        }

        len = end + 7;

        while (srcOff < len) {
            dest[destOff++] = src[srcOff++];
        }
    }

    private Arrays() {
        /* empty */
    }
}
