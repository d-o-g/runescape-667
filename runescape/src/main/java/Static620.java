import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static620 {

    @OriginalMember(owner = "client!tka", name = "h", descriptor = "F")
    public static float aFloat197;

    @OriginalMember(owner = "client!tka", name = "e", descriptor = "Lclient!pba;")
    public static Class286 aClass286_3;

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "(IIILclient!aa;Lclient!ha;IIILclient!hda;)V")
    public static void method8322(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) ClippingMask arg2, @OriginalArg(4) Toolkit arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) Component arg7) {
        @Pc(10) MapElementType local10 = MapElementTypeList.instance.list(arg4);
        if (local10 == null || !local10.aBoolean218 || !local10.method2425(TimedVarDomain.instance)) {
            return;
        }
        @Pc(36) int local36;
        if (local10.anIntArray228 != null) {
            @Pc(34) int[] local34 = new int[local10.anIntArray228.length];
            @Pc(62) int local62;
            @Pc(66) int local66;
            for (local36 = 0; local36 < local34.length / 2; local36++) {
                @Pc(51) int local51;
                if (Static511.anInt7645 == 4) {
                    local51 = (int) Static171.aFloat64 & 0x3FFF;
                } else {
                    local51 = (int) Static171.aFloat64 + Static29.anInt723 & 0x3FFF;
                }
                local62 = Trig1.SIN[local51];
                local66 = Trig1.COS[local51];
                if (Static511.anInt7645 != 4) {
                    local62 = local62 * 256 / (Static660.anInt9835 + 256);
                    local66 = local66 * 256 / (Static660.anInt9835 + 256);
                }
                local34[local36 * 2] = arg7.width / 2 + arg1 + (local66 * (local10.anIntArray228[local36 * 2] * 4 + arg6) + local62 * (arg0 + local10.anIntArray228[local36 * 2 + 1] * 4) >> 14);
                local34[local36 * 2 + 1] = arg5 + arg7.height / 2 - (local66 * (arg0 + local10.anIntArray228[local36 * 2 + 1] * 4) - local62 * (arg6 + local10.anIntArray228[local36 * 2] * 4) >> 14);
            }
            @Pc(187) Graphic local187 = arg7.graphic(arg3);
            if (local187 != null) {
                Static141.method2377(arg3, local34, local10.anInt2610, local187.lineOffsets, local187.lineWidths);
            }
            if (local10.anInt2603 > 0) {
                @Pc(223) int local223;
                @Pc(231) int local231;
                @Pc(241) int local241;
                @Pc(250) int local250;
                @Pc(252) int local252;
                for (local62 = 0; local62 < local34.length / 2 - 1; local62++) {
                    local66 = local34[local62 * 2];
                    local223 = local34[local62 * 2 + 1];
                    local231 = local34[local62 * 2 + 2];
                    local241 = local34[local62 * 2 + 2 + 1];
                    if (local66 > local231) {
                        local250 = local66;
                        local252 = local223;
                        local66 = local231;
                        local231 = local250;
                        local223 = local241;
                        local241 = local252;
                    } else if (local66 == local231 && local241 < local223) {
                        local250 = local223;
                        local223 = local241;
                        local241 = local250;
                    }
                    arg3.method7942(local66, local223, local231, local241, local10.anIntArray229[local10.aByteArray31[local62] & 0xFF], arg2, arg1, arg5, local10.anInt2603, local10.anInt2587, local10.anInt2607);
                }
                local66 = local34[local34.length - 2];
                local223 = local34[local34.length - 1];
                local231 = local34[0];
                local241 = local34[1];
                if (local231 < local66) {
                    local250 = local66;
                    local252 = local223;
                    local66 = local231;
                    local231 = local250;
                    local223 = local241;
                    local241 = local252;
                } else if (local66 == local231 && local223 > local241) {
                    local250 = local223;
                    local223 = local241;
                    local241 = local250;
                }
                arg3.method7942(local66, local223, local231, local241, local10.anIntArray229[local10.aByteArray31[local10.aByteArray31.length - 1] & 0xFF], arg2, arg1, arg5, local10.anInt2603, local10.anInt2587, local10.anInt2607);
            } else {
                for (local62 = 0; local62 < local34.length / 2 - 1; local62++) {
                    arg3.method7965(local34[local62 * 2], local34[local62 * 2 + 1], local34[local62 * 2 + 2], local34[(local62 + 1) * 2 + 1], local10.anIntArray229[local10.aByteArray31[local62] & 0xFF], arg2, arg1, arg5);
                }
                arg3.method7965(local34[local34.length - 2], local34[local34.length - 1], local34[0], local34[1], local10.anIntArray229[local10.aByteArray31[local10.aByteArray31.length - 1] & 0xFF], arg2, arg1, arg5);
            }
        }
        @Pc(517) Sprite local517 = null;
        if (local10.anInt2596 != -1) {
            local517 = local10.method2431(false, arg3);
            if (local517 != null) {
                Static6.method107(arg5, arg2, local517, arg0, arg6, arg7, arg1);
            }
        }
        if (local10.aString25 == null) {
            return;
        }
        local36 = 0;
        if (local517 != null) {
            local36 = local517.getHeight();
        }
        @Pc(553) Font local553 = Fonts.p11;
        @Pc(555) FontMetrics local555 = Fonts.p11Metrics;
        if (local10.anInt2615 == 1) {
            local553 = Fonts.p12;
            local555 = Fonts.p12Metrics;
        }
        if (local10.anInt2615 == 2) {
            local555 = Fonts.b12Metrics;
            local553 = Fonts.b12;
        }
        Static256.method3639(local553, local10.aString25, local555, arg1, local10.anInt2592, local36, arg7, arg2, arg0, arg5, arg6);
    }

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "([BZ)Ljava/lang/String;")
    public static String method8323(@OriginalArg(0) byte[] arg0) {
        return Cp1252.decode(0, arg0, arg0.length);
    }

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "(IIIIIII)V")
    public static void method8324(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        Static271.anInt4363 = arg0;
        Static427.anInt6480 = arg3;
        Static524.anInt8044 = arg4;
        Static428.anInt6487 = arg5;
        Static707.anInt10641 = arg2;
        Static523.anInt3888 = arg1;
    }
}
