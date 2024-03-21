import com.jagex.IndexedImage;
import com.jagex.game.Class14;
import com.jagex.game.Class381;
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
            Static163.activeToolkit = Static255.method3612(js5.SHADERS, Static56.anTextureSource_3, 0, Static434.aCanvas7, Static400.instance.aClass57_Sub13_1.method4373() * 2);
            if (arg0 != null) {
                Static163.activeToolkit.GA(0);
                @Pc(36) Class381 local36 = Static74.method1535(Static539.anInt8173, js5.FONTMETRICS);
                @Pc(45) Class14 local45 = Static163.activeToolkit.method8010(local36, IndexedImage.load(js5.SPRITES, Static539.anInt8173, 0), true);
                Static288.method4182();
                Static694.method9028(Static163.activeToolkit, arg0, true, local36, local45);
            }
        } else {
            @Pc(57) Toolkit local57 = null;
            @Pc(85) Class14 local85;
            if (arg0 != null) {
                local57 = Static255.method3612(js5.SHADERS, Static56.anTextureSource_3, 0, Static434.aCanvas7, 0);
                local57.GA(0);
                @Pc(76) Class381 local76 = Static74.method1535(Static539.anInt8173, js5.FONTMETRICS);
                local85 = local57.method8010(local76, IndexedImage.load(js5.SPRITES, Static539.anInt8173, 0), true);
                Static288.method4182();
                Static694.method9028(local57, arg0, true, local76, local85);
            }
            boolean var14 = false;
            label216:
            {
                try {
                    var14 = true;
                    Static163.activeToolkit = Static255.method3612(js5.SHADERS, Static56.anTextureSource_3, arg2, Static434.aCanvas7, Static400.instance.aClass57_Sub13_1.method4373() * 2);
                    if (arg0 != null) {
                        local57.GA(0);
                        @Pc(118) Class381 local118 = Static74.method1535(Static539.anInt8173, js5.FONTMETRICS);
                        @Pc(127) Class14 local127 = local57.method8010(local118, IndexedImage.load(js5.SPRITES, Static539.anInt8173, 0), true);
                        Static288.method4182();
                        Static694.method9028(local57, arg0, true, local118, local127);
                    }
                    if (Static163.activeToolkit.method7949()) {
                        @Pc(141) boolean local141 = true;
                        try {
                            local141 = Static292.aClass2_Sub43_2.anInt7610 > 256;
                        } catch (@Pc(152) Throwable local152) {
                        }
                        @Pc(158) Node_Sub13 local158;
                        if (local141) {
                            local158 = Static163.activeToolkit.method7961(146800640);
                        } else {
                            local158 = Static163.activeToolkit.method7961(104857600);
                        }
                        Static163.activeToolkit.method7938(local158);
                        var14 = false;
                    } else {
                        var14 = false;
                    }
                    break label216;
                } catch (@Pc(168) Throwable local168) {
                    @Pc(173) int local173 = Static400.instance.aClass57_Sub29_1.method7915();
                    if (local173 == 2) {
                        Static171.aBoolean245 = true;
                    }
                    Static400.instance.method5104(0, Static400.instance.aClass57_Sub29_1);
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
        Static400.instance.aClass57_Sub29_1.method7918(!arg1);
        Static400.instance.method5104(arg2, Static400.instance.aClass57_Sub29_1);
        Static112.method2109();
        Static163.activeToolkit.method8003();
        Static163.activeToolkit.X(32);
        Static460.aMatrix_10 = Static163.activeToolkit.createMatrix();
        Static59.aMatrix_5 = Static163.activeToolkit.createMatrix();
        Static209.method3110();
        Static163.activeToolkit.method7997(Static400.instance.aClass57_Sub9_1.method3199() == 1);
        if (Static163.activeToolkit.method7936()) {
            Static249.method3537(Static400.instance.aClass57_Sub20_1.method6108() == 1);
        }
        Static613.method8239(Static163.activeToolkit, Static501.mapHeight >> 3, Static720.mapWidth >> 3);
        Static218.method3187();
        Static284.aBoolean355 = true;
        Static679.aDisplayPropertiesArray1 = null;
        Static503.aBoolean578 = false;
        Static498.method6646();
    }

    @OriginalMember(owner = "client!so", name = "a", descriptor = "(IBIII)V")
    public static void method7810(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        @Pc(5) int local5 = Static691.anInt10368;
        if (local5 == 0) {
            return;
        }
        if (local5 == 1) {
            Static599.anInt8837 = arg1;
            Static691.anInt10368 = 2;
            Static435.anInt6597 = arg3;
            Static320.anInt5085 = arg0;
            Static582.anInt8629 = arg2;
        } else if (local5 == 2) {
            if (Static320.anInt5085 > arg0) {
                Static320.anInt5085 = arg0;
            }
            if (Static435.anInt6597 > arg3) {
                Static435.anInt6597 = arg3;
            }
            if (Static599.anInt8837 < arg1) {
                Static599.anInt8837 = arg1;
            }
            if (Static582.anInt8629 < arg2) {
                Static582.anInt8629 = arg2;
            }
        }
    }

}
