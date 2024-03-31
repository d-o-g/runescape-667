import com.jagex.game.runetek6.client.GameShell;
import com.jagex.IndexedImage;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Fonts;
import com.jagex.graphics.MemoryPool;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static595 {

    @OriginalMember(owner = "client!so", name = "S", descriptor = "[I")
    public static int[] anIntArray702 = new int[1];

    @OriginalMember(owner = "client!so", name = "a", descriptor = "(ILjava/lang/String;ZI)V")
    public static void setToolkit(@OriginalArg(1) String arg0, @OriginalArg(2) boolean inactive, @OriginalArg(3) int toolkit) {
        Static164.method2606();
        if (toolkit == ToolkitType.JAVA) {
            Toolkit.active = Static255.create(ToolkitType.JAVA, js5.SHADERS, GameShell.canvas, Js5TextureSource.instance, ClientOptions.instance.antialiasingQuality.getValue() * 2);
            if (arg0 != null) {
                Toolkit.active.GA(0);
                @Pc(36) FontMetrics local36 = FontMetrics.loadGroup(js5.FONTMETRICS, Fonts.p12FullGroup);
                @Pc(45) Font local45 = Toolkit.active.createFont(local36, IndexedImage.load(js5.SPRITES, Fonts.p12FullGroup, 0), true);
                Static288.repaintMargins();
                MessageBox.draw(Toolkit.active, arg0, true, local36, local45);
            }
        } else {
            @Pc(57) Toolkit local57 = null;
            @Pc(85) Font local85;
            if (arg0 != null) {
                local57 = Static255.create(ToolkitType.JAVA, js5.SHADERS, GameShell.canvas, Js5TextureSource.instance, 0);
                local57.GA(0);
                @Pc(76) FontMetrics local76 = FontMetrics.loadGroup(js5.FONTMETRICS, Fonts.p12FullGroup);
                local85 = local57.createFont(local76, IndexedImage.load(js5.SPRITES, Fonts.p12FullGroup, 0), true);
                Static288.repaintMargins();
                MessageBox.draw(local57, arg0, true, local76, local85);
            }
            boolean var14 = false;
            label216:
            {
                try {
                    var14 = true;
                    Toolkit.active = Static255.create(toolkit, js5.SHADERS, GameShell.canvas, Js5TextureSource.instance, ClientOptions.instance.antialiasingQuality.getValue() * 2);
                    if (arg0 != null) {
                        local57.GA(0);
                        @Pc(118) FontMetrics p12Metrics = FontMetrics.loadGroup(js5.FONTMETRICS, Fonts.p12FullGroup);
                        @Pc(127) Font p12 = local57.createFont(p12Metrics, IndexedImage.load(js5.SPRITES, Fonts.p12FullGroup, 0), true);
                        Static288.repaintMargins();
                        MessageBox.draw(local57, arg0, true, p12Metrics, p12);
                    }
                    if (Toolkit.active.method7949()) {
                        @Pc(141) boolean local141 = true;
                        try {
                            local141 = SystemInfo.instance.totalMemory > 256;
                        } catch (@Pc(152) Throwable local152) {
                        }
                        @Pc(158) MemoryPool local158;
                        if (local141) {
                            local158 = Toolkit.active.createHeap(0x8C00000);
                        } else {
                            local158 = Toolkit.active.createHeap(0x6400000);
                        }
                        Toolkit.active.method7938(local158);
                        var14 = false;
                    } else {
                        var14 = false;
                    }
                    break label216;
                } catch (@Pc(168) Throwable local168) {
                    @Pc(173) int local173 = ClientOptions.instance.toolkit.getValue();
                    if (local173 == 2) {
                        Static171.graphicsError = true;
                    }
                    ClientOptions.instance.update(0, ClientOptions.instance.toolkit);
                    setToolkit(arg0, inactive, local173);
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
        ClientOptions.instance.toolkit.setActive(!inactive);
        ClientOptions.instance.update(toolkit, ClientOptions.instance.toolkit);
        Static112.method2109();
        Toolkit.active.method8003();
        Toolkit.active.X(32);
        Static460.aMatrix_10 = Toolkit.active.createMatrix();
        Static59.aMatrix_5 = Toolkit.active.createMatrix();
        Static209.method3110();
        Toolkit.active.setShrinkTextures(ClientOptions.instance.smallTextures.getValue() == 1);
        if (Toolkit.active.supportsBloom()) {
            Static249.setBloom(ClientOptions.instance.bloom.getValue() == 1);
        }
        Static613.method8239(Toolkit.active, Static501.mapLength >> 3, Static720.mapWidth >> 3);
        InterfaceManager.loginOpened();
        Static284.aBoolean355 = true;
        Fullscreen.modes = null;
        Static503.sentPreferences = false;
        OrthoMode.enter();
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
