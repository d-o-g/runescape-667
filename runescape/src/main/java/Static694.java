import com.jagex.Client;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Exception_Sub1;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.texture.Node_Sub1_Sub27;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static694 {

    @OriginalMember(owner = "client!vv", name = "z", descriptor = "I")
    public static int anInt10405;

    @OriginalMember(owner = "client!vv", name = "F", descriptor = "Lclient!fma;")
    public static final Class131 aClass131_6 = new Class131();

    @OriginalMember(owner = "client!vv", name = "a", descriptor = "(Lclient!ha;Ljava/lang/String;ZLclient!ve;Lclient!da;I)V")
    public static void drawLoadingText(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) String text, @OriginalArg(2) boolean arg2, @OriginalArg(3) FontMetrics p12Metrics, @OriginalArg(4) Font p12) {
        @Pc(15) boolean local15 = !Static483.aBoolean546 || Static71.method1525();
        if (!local15) {
            return;
        }

        if (Static483.aBoolean546 && local15) {
            @Pc(27) FontMetrics metrics = Static16.loadingTextMetrics;
            @Pc(33) Font font = toolkit.createFont(metrics, Static627.loadingTextImages, true);

            @Pc(40) int width = metrics.paraWidth(null, text, 250);
            @Pc(49) int height = metrics.stringHeight(250, metrics.verticalSpacing, text, null);

            @Pc(52) int imageWidth = Static535.aIndexedImage_3.width;
            @Pc(56) int imageWidthPlusBorder = imageWidth + 4;

            width += imageWidthPlusBorder * 2;
            height += imageWidthPlusBorder * 2;

            if (height < Static320.minHeight) {
                height = Static320.minHeight;
            }
            if (width < Static343.minWidth) {
                width = Static343.minWidth;
            }

            @Pc(92) int local92 = Static180.aHorizontalAlignment_3.align(Client.loadingScreenWidth, width) + Static665.anInt9944;
            @Pc(101) int local101 = Static129.aVerticalAlignment_1.align(Client.loadingScreenHeight, height) + Static101.anInt2097;
            if (InterfaceManager.aBoolean210) {
                local92 += Static130.method2283();
                local101 += Static422.method5771();
            }

            toolkit.createSprite(Static74.aIndexedImage_1, false).renderTiled(Static414.aIndexedImage_2.width + local92, Static414.aIndexedImage_2.height + local101, width - Static414.aIndexedImage_2.width * 2, height + -(Static414.aIndexedImage_2.height * 2), 1, 0, 0);
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(local92, local101);
            Static414.aIndexedImage_2.flipVertically();
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(width + local92 - imageWidth, local101);
            Static414.aIndexedImage_2.flipHorizontally();
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(width + local92 - imageWidth, -imageWidth + local101 + height);
            Static414.aIndexedImage_2.flipVertically();
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(local92, height + local101 - imageWidth);
            Static414.aIndexedImage_2.flipHorizontally();
            toolkit.createSprite(Static535.aIndexedImage_3, true).renderTiled(local92, Static414.aIndexedImage_2.height + local101, imageWidth, height - Static414.aIndexedImage_2.height * 2);
            Static535.aIndexedImage_3.rotate();
            toolkit.createSprite(Static535.aIndexedImage_3, true).renderTiled(Static414.aIndexedImage_2.width + local92, local101, width - Static414.aIndexedImage_2.width * 2, imageWidth);
            Static535.aIndexedImage_3.rotate();
            toolkit.createSprite(Static535.aIndexedImage_3, true).renderTiled(width + local92 - imageWidth, Static414.aIndexedImage_2.height + local101, imageWidth, height - Static414.aIndexedImage_2.height * 2);
            Static535.aIndexedImage_3.rotate();
            toolkit.createSprite(Static535.aIndexedImage_3, true).renderTiled(local92 + Static414.aIndexedImage_2.width, height + (local101 - imageWidth), width - Static414.aIndexedImage_2.width * 2, imageWidth);
            Static535.aIndexedImage_3.rotate();
            font.renderLines(0, null, Static675.anInt10154 | 0xFF000000, text, null, null, imageWidthPlusBorder + local101, -1, 0, 1, local92 + imageWidthPlusBorder, 1, 0, width - imageWidthPlusBorder * 2, -(imageWidthPlusBorder * 2) + height);
            InterfaceManager.redrawWithin(local92, local101, width, height);
        } else {
            @Pc(40) int paraWidth = p12Metrics.paraWidth(null, text, 250);
            @Pc(49) int paraHeight = p12Metrics.paraHeight(text, null, 250) * 13;
            toolkit.aa(6, 6, paraWidth + 4 + 4, paraHeight + 4 + 4, 0xFF000000, 0);
            toolkit.outlineRect(6, 6, paraWidth + 8, 4 + 4 + paraHeight, -1, 0);
            p12.renderLines(0, null, 0xFFFFFFFF, text, null, null, 10, -1, 0, 1, 10, 1, 0, paraWidth, paraHeight);
            InterfaceManager.redrawWithin(6, 6, paraWidth + 8, paraHeight + 4 + 4);
        }

        if (!arg2) {
            return;
        }

        try {
            if (InterfaceManager.aBoolean210) {
                Static430.method5818();
            } else {
                toolkit.flip();
            }
        } catch (@Pc(458) Exception_Sub1 local458) {
        }
    }

    @OriginalMember(owner = "client!vv", name = "c", descriptor = "(B)I")
    public static int method9030() {
        @Pc(9) int local9 = Loading.state.getStep();
        if (local9 < Loading.states.length - 1) {
            Loading.state = Loading.states[local9 + 1];
        }
        return 100;
    }

    @OriginalMember(owner = "client!vv", name = "e", descriptor = "(I)V")
    public static void method9031() {
        for (@Pc(10) int local10 = 0; local10 < Static617.anInt9434; local10++) {
            @Pc(23) int local23 = Node_Sub1_Sub27.method9118(Static482.anInt7265 + local10, Static617.anInt9434) * Static211.anInt5574;
            for (@Pc(25) int local25 = 0; local25 < Static211.anInt5574; local25++) {
                @Pc(36) int local36 = Node_Sub1_Sub27.method9118(Static632.anInt9503 + local25, Static211.anInt5574) + local23;
                if (Static173.anIntArray252[local36] == Static420.anInt6436) {
                    Static651.anInterface9Array1[local36].method9040(0, 0, Static437.horizontalAspectRatio, Static714.verticalAspectRatio, Static437.horizontalAspectRatio * local25, Static714.verticalAspectRatio * local10);
                }
            }
        }
        anInt10405++;
    }
}
