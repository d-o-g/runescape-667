import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Exception_Sub1;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Random;

public final class Static694 {

    @OriginalMember(owner = "client!vv", name = "z", descriptor = "I")
    public static int anInt10405;

    @OriginalMember(owner = "client!vv", name = "w", descriptor = "I")
    public static int anInt10411;

    @OriginalMember(owner = "client!vv", name = "D", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___122 = new ClientProt(71, 4);

    @OriginalMember(owner = "client!vv", name = "F", descriptor = "Lclient!fma;")
    public static final Class131 aClass131_6 = new Class131();

    @OriginalMember(owner = "client!vv", name = "a", descriptor = "(IZ)[B")
    public static byte[] method9027(@OriginalArg(0) int arg0) {
        @Pc(17) DoublyLinkedNode_Sub2_Sub7 local17 = (DoublyLinkedNode_Sub2_Sub7) Static541.A_DOUBLY_LINKED_LIST___4.get(arg0);
        if (local17 == null) {
            @Pc(22) byte[] local22 = new byte[512];
            @Pc(28) Random local28 = new Random(arg0);
            for (@Pc(30) int local30 = 0; local30 < 255; local30++) {
                local22[local30] = (byte) local30;
            }
            for (@Pc(42) int local42 = 0; local42 < 255; local42++) {
                @Pc(48) int local48 = 255 - local42;
                @Pc(53) int local53 = Static623.method8326(-5208, local48, local28);
                @Pc(57) byte local57 = local22[local53];
                local22[local53] = local22[local48];
                local22[local48] = local22[511 - local42] = local57;
            }
            local17 = new DoublyLinkedNode_Sub2_Sub7(local22);
            Static541.A_DOUBLY_LINKED_LIST___4.put(local17, arg0);
        }
        return local17.aByteArray21;
    }

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

            @Pc(92) int local92 = Static180.aHorizontalAlignment_3.align(client.loadingScreenWidth, width) + Static665.anInt9944;
            @Pc(101) int local101 = Static129.aVerticalAlignment_1.align(client.loadingScreenHeight, height) + Static101.anInt2097;
            if (InterfaceManager.aBoolean210) {
                local92 += Static130.method2283();
                local101 += Static422.method5771();
            }

            toolkit.createSprite(Static74.aIndexedImage_1, false).method8189(Static414.aIndexedImage_2.width + local92, Static414.aIndexedImage_2.height + local101, width - Static414.aIndexedImage_2.width * 2, height + -(Static414.aIndexedImage_2.height * 2), 1, 0, 0);
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(local92, local101);
            Static414.aIndexedImage_2.flipVertically();
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(width + local92 - imageWidth, local101);
            Static414.aIndexedImage_2.flipHorizontally();
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(width + local92 - imageWidth, -imageWidth + local101 + height);
            Static414.aIndexedImage_2.flipVertically();
            toolkit.createSprite(Static414.aIndexedImage_2, true).render(local92, height + local101 - imageWidth);
            Static414.aIndexedImage_2.flipHorizontally();
            toolkit.createSprite(Static535.aIndexedImage_3, true).method8198(local92, Static414.aIndexedImage_2.height + local101, imageWidth, height - Static414.aIndexedImage_2.height * 2);
            Static535.aIndexedImage_3.method9386();
            toolkit.createSprite(Static535.aIndexedImage_3, true).method8198(Static414.aIndexedImage_2.width + local92, local101, width - Static414.aIndexedImage_2.width * 2, imageWidth);
            Static535.aIndexedImage_3.method9386();
            toolkit.createSprite(Static535.aIndexedImage_3, true).method8198(width + local92 - imageWidth, Static414.aIndexedImage_2.height + local101, imageWidth, height - Static414.aIndexedImage_2.height * 2);
            Static535.aIndexedImage_3.method9386();
            toolkit.createSprite(Static535.aIndexedImage_3, true).method8198(local92 + Static414.aIndexedImage_2.width, height + (local101 - imageWidth), width - Static414.aIndexedImage_2.width * 2, imageWidth);
            Static535.aIndexedImage_3.method9386();
            font.renderLines(0, null, Static675.anInt10154 | 0xFF000000, text, null, null, imageWidthPlusBorder + local101, -1, 0, 1, local92 + imageWidthPlusBorder, 1, 0, width - imageWidthPlusBorder * 2, -(imageWidthPlusBorder * 2) + height);
            InterfaceManager.redrawWithin(width, local92, height, local101);
        } else {
            @Pc(40) int paraWidth = p12Metrics.paraWidth(null, text, 250);
            @Pc(49) int paraHeight = p12Metrics.paraHeight(text, null, 250) * 13;
            toolkit.aa(6, 6, paraWidth + 4 + 4, paraHeight + 4 + 4, 0xFF000000, 0);
            toolkit.method7976(6, 6, paraWidth + 8, 4 + 4 + paraHeight, -1, 0);
            p12.renderLines(0, null, 0xFFFFFFFF, text, null, null, 10, -1, 0, 1, 10, 1, 0, paraWidth, paraHeight);
            InterfaceManager.redrawWithin(paraWidth + 8, 6, paraHeight + 4 + 4, 6);
        }

        if (!arg2) {
            return;
        }

        try {
            if (InterfaceManager.aBoolean210) {
                Static430.method5818();
            } else {
                toolkit.method7984();
            }
        } catch (@Pc(458) Exception_Sub1 local458) {
        }
    }

    @OriginalMember(owner = "client!vv", name = "c", descriptor = "(B)I")
    public static int method9030() {
        @Pc(9) int local9 = Static473.aLoadState_22.step();
        if (local9 < Static655.aLoadStateArray1.length - 1) {
            Static473.aLoadState_22 = Static655.aLoadStateArray1[local9 + 1];
        }
        return 100;
    }

    @OriginalMember(owner = "client!vv", name = "e", descriptor = "(I)V")
    public static void method9031() {
        for (@Pc(10) int local10 = 0; local10 < Static617.anInt9434; local10++) {
            @Pc(23) int local23 = Static719.method9118(Static482.anInt7265 + local10, 16939, Static617.anInt9434) * Static211.anInt5574;
            for (@Pc(25) int local25 = 0; local25 < Static211.anInt5574; local25++) {
                @Pc(36) int local36 = Static719.method9118(Static632.anInt9503 + local25, 16939, Static211.anInt5574) + local23;
                if (Static173.anIntArray252[local36] == Static420.anInt6436) {
                    Static651.anInterface9Array1[local36].method9040(0, 0, Static437.horizontalAspectRatio, Static714.verticalAspectRatio, Static437.horizontalAspectRatio * local25, Static714.verticalAspectRatio * local10);
                }
            }
        }
        anInt10405++;
    }
}
