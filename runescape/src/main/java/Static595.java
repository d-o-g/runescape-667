import com.jagex.IndexedImage;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Node_Sub13;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static595 {

    @OriginalMember(owner = "client!so", name = "S", descriptor = "[I")
    public static int[] anIntArray702 = new int[1];

    @OriginalMember(owner = "client!so", name = "a", descriptor = "(ILjava/lang/String;ZI)V")
    public static void method7807(@OriginalArg(1) String arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2) {
        Static164.method2606();
        if (arg2 == 0) {
            Toolkit.active = Static255.method3612(js5.SHADERS, Static56.anTextureSource_3, 0, Static434.canvas, ClientOptions.instance.aClass57_Sub13_1.value() * 2);
            if (arg0 != null) {
                Toolkit.active.GA(0);
                @Pc(36) FontMetrics local36 = FontMetrics.loadGroup(Fonts.p12FullGroup, js5.FONTMETRICS);
                @Pc(45) Font local45 = Toolkit.active.createFont(local36, IndexedImage.load(js5.SPRITES, Fonts.p12FullGroup, 0), true);
                Static288.method4182();
                Static694.method9028(Toolkit.active, arg0, true, local36, local45);
            }
        } else {
            @Pc(57) Toolkit local57 = null;
            @Pc(85) Font local85;
            if (arg0 != null) {
                local57 = Static255.method3612(js5.SHADERS, Static56.anTextureSource_3, 0, Static434.canvas, 0);
                local57.GA(0);
                @Pc(76) FontMetrics local76 = FontMetrics.loadGroup(Fonts.p12FullGroup, js5.FONTMETRICS);
                local85 = local57.createFont(local76, IndexedImage.load(js5.SPRITES, Fonts.p12FullGroup, 0), true);
                Static288.method4182();
                Static694.method9028(local57, arg0, true, local76, local85);
            }
            boolean var14 = false;
            label216:
            {
                try {
                    var14 = true;
                    Toolkit.active = Static255.method3612(js5.SHADERS, Static56.anTextureSource_3, arg2, Static434.canvas, ClientOptions.instance.aClass57_Sub13_1.value() * 2);
                    if (arg0 != null) {
                        local57.GA(0);
                        @Pc(118) FontMetrics local118 = FontMetrics.loadGroup(Fonts.p12FullGroup, js5.FONTMETRICS);
                        @Pc(127) Font local127 = local57.createFont(local118, IndexedImage.load(js5.SPRITES, Fonts.p12FullGroup, 0), true);
                        Static288.method4182();
                        Static694.method9028(local57, arg0, true, local118, local127);
                    }
                    if (Toolkit.active.method7949()) {
                        @Pc(141) boolean local141 = true;
                        try {
                            local141 = SystemInfo.instance.totalMemory > 256;
                        } catch (@Pc(152) Throwable local152) {
                        }
                        @Pc(158) Node_Sub13 local158;
                        if (local141) {
                            local158 = Toolkit.active.method7961(146800640);
                        } else {
                            local158 = Toolkit.active.method7961(104857600);
                        }
                        Toolkit.active.method7938(local158);
                        var14 = false;
                    } else {
                        var14 = false;
                    }
                    break label216;
                } catch (@Pc(168) Throwable local168) {
                    @Pc(173) int local173 = ClientOptions.instance.toolkit.value();
                    if (local173 == 2) {
                        Static171.aBoolean245 = true;
                    }
                    ClientOptions.instance.method5104(0, ClientOptions.instance.toolkit);
                    method7807(arg0, arg1, local173);
                    @Pc(194) Object local194 = null;
                    var14 = false;
                } finally {
                    if (var14) {
                        local85 = null;
                        if (local57 != null) {
                            try {
                                local57.free();
                            } catch (@Pc(359) Throwable local359) {
                            }
                        }
                    }
                }
                if (local57 != null) {
                    try {
                        local57.free();
                    } catch (@Pc(339) Throwable local339) {
                    }
                }
                return;
            }
            local85 = null;
            if (local57 != null) {
                try {
                    local57.free();
                } catch (@Pc(349) Throwable local349) {
                }
            }
        }
        ClientOptions.instance.toolkit.method7918(!arg1);
        ClientOptions.instance.method5104(arg2, ClientOptions.instance.toolkit);
        Static112.method2109();
        Toolkit.active.method8003();
        Toolkit.active.X(32);
        Static460.aMatrix_10 = Toolkit.active.createMatrix();
        Static59.aMatrix_5 = Toolkit.active.createMatrix();
        Static209.method3110();
        Toolkit.active.method7997(ClientOptions.instance.aClass57_Sub9_1.method3199() == 1);
        if (Toolkit.active.method7936()) {
            Static249.method3537(ClientOptions.instance.bloom.value() == 1);
        }
        Static613.method8239(Toolkit.active, Static501.mapHeight >> 3, Static720.mapWidth >> 3);
        Static218.method3187();
        Static284.aBoolean355 = true;
        Static679.aDisplayPropertiesArray1 = null;
        Static503.aBoolean578 = false;
        Static498.method6646();
    }

    @OriginalMember(owner = "client!so", name = "a", descriptor = "(IBIII)V")
    public static void method7810(@OriginalArg(0) int bottom, @OriginalArg(2) int right, @OriginalArg(3) int top, @OriginalArg(4) int left) {
        @Pc(5) int local5 = Static691.anInt10368;
        if (local5 == 0) {
            return;
        }
        if (local5 == 1) {
            Static599.anInt8837 = right;
            Static691.anInt10368 = 2;
            Static435.anInt6597 = left;
            Static320.anInt5085 = bottom;
            Static582.anInt8629 = top;
        } else if (local5 == 2) {
            if (Static320.anInt5085 > bottom) {
                Static320.anInt5085 = bottom;
            }
            if (Static435.anInt6597 > left) {
                Static435.anInt6597 = left;
            }
            if (Static599.anInt8837 < right) {
                Static599.anInt8837 = right;
            }
            if (Static582.anInt8629 < top) {
                Static582.anInt8629 = top;
            }
        }
    }

}
