import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.graphics.Exception_Sub1;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.VerticalAlignment;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MessageBox {

    @OriginalMember(owner = "client!aga", name = "b", descriptor = "I")
    public static int anInt136;

    @OriginalMember(owner = "client!dca", name = "w", descriptor = "I")
    public static int y;

    @OriginalMember(owner = "client!kc", name = "e", descriptor = "I")
    public static int minHeight;

    @OriginalMember(owner = "client!vga", name = "f", descriptor = "I")
    public static int textColour;

    @OriginalMember(owner = "client!nba", name = "i", descriptor = "Lclient!wp;")
    public static IndexedImage aIndexedImage_2;

    @OriginalMember(owner = "client!eaa", name = "B", descriptor = "Lclient!ek;")
    public static VerticalAlignment verticalAlignment;

    @OriginalMember(owner = "client!oh", name = "p", descriptor = "I")
    public static int anInt6929;

    @OriginalMember(owner = "client!qr", name = "f", descriptor = "Lclient!wp;")
    public static IndexedImage aIndexedImage_3;

    @OriginalMember(owner = "client!wu", name = "C", descriptor = "I")
    public static int font;

    @OriginalMember(owner = "client!fka", name = "o", descriptor = "Lclient!wk;")
    public static HorizontalAlignment horizontalAlignment;

    @OriginalMember(owner = "client!vb", name = "v", descriptor = "I")
    public static int x;

    @OriginalMember(owner = "client!lha", name = "b", descriptor = "I")
    public static int anInt5828;

    @OriginalMember(owner = "client!cga", name = "d", descriptor = "Lclient!wp;")
    public static IndexedImage aIndexedImage_1;

    @OriginalMember(owner = "client!kq", name = "d", descriptor = "I")
    public static int minWidth;

    @OriginalMember(owner = "client!pe", name = "h", descriptor = "Z")
    public static boolean setup;

    @OriginalMember(owner = "client!aj", name = "y", descriptor = "Lclient!ve;")
    public static FontMetrics fontMetrics;

    @OriginalMember(owner = "client!ts", name = "f", descriptor = "[Lclient!wp;")
    public static IndexedImage[] fontSprites;

    @OriginalMember(owner = "client!ds", name = "a", descriptor = "(IIIILclient!ek;IIIIILclient!wk;I)V")
    public static void setup(@OriginalArg(10) HorizontalAlignment horizontalAlignment, @OriginalArg(4) VerticalAlignment verticalAlignment, @OriginalArg(1) int x, @OriginalArg(8) int y, @OriginalArg(3) int minWidth, @OriginalArg(5) int minHeight, @OriginalArg(7) int arg7, @OriginalArg(0) int arg0, @OriginalArg(6) int arg6, @OriginalArg(2) int textColour, @OriginalArg(11) int fontMetricsFile) {
        anInt136 = arg6;
        MessageBox.y = y;
        MessageBox.minHeight = minHeight;
        MessageBox.textColour = textColour;
        aIndexedImage_2 = null;
        MessageBox.verticalAlignment = verticalAlignment;
        anInt6929 = arg7;
        aIndexedImage_3 = null;
        MessageBox.font = fontMetricsFile;
        MessageBox.horizontalAlignment = horizontalAlignment;
        MessageBox.x = x;
        anInt5828 = arg0;
        aIndexedImage_1 = null;
        MessageBox.minWidth = minWidth;
        ready();
        setup = true;
    }

    @OriginalMember(owner = "client!cea", name = "b", descriptor = "(I)Z")
    public static boolean ready() {
        @Pc(5) boolean ready = true;

        if (aIndexedImage_2 == null) {
            if (js5.SPRITES.fileready(anInt6929)) {
                aIndexedImage_2 = IndexedImage.loadFirst(js5.SPRITES, anInt6929);
            } else {
                ready = false;
            }
        }

        if (aIndexedImage_3 == null) {
            if (js5.SPRITES.fileready(anInt5828)) {
                aIndexedImage_3 = IndexedImage.loadFirst(js5.SPRITES, anInt5828);
            } else {
                ready = false;
            }
        }

        if (aIndexedImage_1 == null) {
            if (js5.SPRITES.fileready(anInt136)) {
                aIndexedImage_1 = IndexedImage.loadFirst(js5.SPRITES, anInt136);
            } else {
                ready = false;
            }
        }

        if (fontMetrics == null) {
            if (js5.FONTMETRICS.fileready(font)) {
                fontMetrics = FontMetrics.loadFile(js5.FONTMETRICS, font);
            } else {
                ready = false;
            }
        }

        if (fontSprites == null) {
            if (js5.SPRITES.fileready(font)) {
                fontSprites = IndexedImage.load(js5.SPRITES, font);
            } else {
                ready = false;
            }
        }

        return ready;
    }

    @OriginalMember(owner = "client!vv", name = "a", descriptor = "(Lclient!ha;Ljava/lang/String;ZLclient!ve;Lclient!da;I)V")
    public static void draw(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) String text, @OriginalArg(2) boolean flip, @OriginalArg(3) FontMetrics p12Metrics, @OriginalArg(4) Font p12) {
        @Pc(15) boolean ready = !setup || ready();
        if (!ready) {
            return;
        }

        if (!setup || !ready) {
            @Pc(40) int paraWidth = p12Metrics.paraWidth(null, text, 250);
            @Pc(49) int paraHeight = p12Metrics.paraHeight(text, null, 250) * 13;
            toolkit.aa(6, 6, paraWidth + 4 + 4, paraHeight + 4 + 4, 0xFF000000, 0);
            toolkit.outlineRect(6, 6, paraWidth + 4 + 4, 4 + 4 + paraHeight, 0xFFFFFFFF, 0);
            p12.renderLines(text, 10, 10, 0, 0, paraWidth, paraHeight, 1, 1, 0, 0xFFFFFFFF, 0xFFFFFFFF, null, null, null);
            InterfaceManager.redrawWithin(6, 6, paraWidth + 4 + 4, paraHeight + 4 + 4);
        } else {
            @Pc(27) FontMetrics metrics = fontMetrics;
            @Pc(33) Font font = toolkit.createFont(metrics, MessageBox.fontSprites, true);

            @Pc(40) int width = metrics.paraWidth(null, text, 250);
            @Pc(49) int height = metrics.stringHeight(250, metrics.verticalSpacing, text, null);

            @Pc(52) int imageWidth = aIndexedImage_3.width;
            @Pc(56) int imageWidthPlusBorder = imageWidth + 4;

            width += imageWidthPlusBorder * 2;
            height += imageWidthPlusBorder * 2;

            if (height < minHeight) {
                height = minHeight;
            }
            if (width < minWidth) {
                width = minWidth;
            }

            @Pc(92) int alignedX = horizontalAlignment.align(Client.loadingScreenWidth, width) + x;
            @Pc(101) int alignedY = verticalAlignment.align(Client.loadingScreenHeight, height) + y;
            if (InterfaceManager.aBoolean210) {
                alignedX += Static130.method2283();
                alignedY += Static422.method5771();
            }

            toolkit.createSprite(aIndexedImage_1, false).renderTiled(aIndexedImage_2.width + alignedX, aIndexedImage_2.height + alignedY, width - aIndexedImage_2.width * 2, height + -(aIndexedImage_2.height * 2), 1, 0, 0);

            toolkit.createSprite(aIndexedImage_2, true).render(alignedX, alignedY);

            aIndexedImage_2.flipVertically();
            toolkit.createSprite(aIndexedImage_2, true).render(width + alignedX - imageWidth, alignedY);

            aIndexedImage_2.flipHorizontally();
            toolkit.createSprite(aIndexedImage_2, true).render(width + alignedX - imageWidth, -imageWidth + alignedY + height);

            aIndexedImage_2.flipVertically();
            toolkit.createSprite(aIndexedImage_2, true).render(alignedX, height + alignedY - imageWidth);

            aIndexedImage_2.flipHorizontally();
            toolkit.createSprite(aIndexedImage_3, true).renderTiled(alignedX, aIndexedImage_2.height + alignedY, imageWidth, height - aIndexedImage_2.height * 2);

            aIndexedImage_3.rotate();
            toolkit.createSprite(aIndexedImage_3, true).renderTiled(aIndexedImage_2.width + alignedX, alignedY, width - aIndexedImage_2.width * 2, imageWidth);

            aIndexedImage_3.rotate();
            toolkit.createSprite(aIndexedImage_3, true).renderTiled(width + alignedX - imageWidth, aIndexedImage_2.height + alignedY, imageWidth, height - aIndexedImage_2.height * 2);

            aIndexedImage_3.rotate();
            toolkit.createSprite(aIndexedImage_3, true).renderTiled(alignedX + aIndexedImage_2.width, height + (alignedY - imageWidth), width - aIndexedImage_2.width * 2, imageWidth);

            aIndexedImage_3.rotate();
            font.renderLines(text, alignedX + imageWidthPlusBorder, imageWidthPlusBorder + alignedY, 0, 0, width - imageWidthPlusBorder * 2, -(imageWidthPlusBorder * 2) + height, 1, 1, 0, textColour | 0xFF000000, -1, null, null, null);

            InterfaceManager.redrawWithin(alignedX, alignedY, width, height);
        }

        if (flip) {
            try {
                if (InterfaceManager.aBoolean210) {
                    Static430.flip();
                } else {
                    toolkit.flip();
                }
            } catch (@Pc(458) Exception_Sub1 local458) {
            }
        }

    }
}
