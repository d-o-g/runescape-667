import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.graphics.FlipException;
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
    public static int backgroundId;

    @OriginalMember(owner = "client!dca", name = "w", descriptor = "I")
    public static int y;

    @OriginalMember(owner = "client!kc", name = "e", descriptor = "I")
    public static int minHeight;

    @OriginalMember(owner = "client!vga", name = "f", descriptor = "I")
    public static int textColour;

    @OriginalMember(owner = "client!nba", name = "i", descriptor = "Lclient!wp;")
    public static IndexedImage corner;

    @OriginalMember(owner = "client!eaa", name = "B", descriptor = "Lclient!ek;")
    public static VerticalAlignment verticalAlignment;

    @OriginalMember(owner = "client!oh", name = "p", descriptor = "I")
    public static int cornerId;

    @OriginalMember(owner = "client!qr", name = "f", descriptor = "Lclient!wp;")
    public static IndexedImage border;

    @OriginalMember(owner = "client!wu", name = "C", descriptor = "I")
    public static int font;

    @OriginalMember(owner = "client!fka", name = "o", descriptor = "Lclient!wk;")
    public static HorizontalAlignment horizontalAlignment;

    @OriginalMember(owner = "client!vb", name = "v", descriptor = "I")
    public static int x;

    @OriginalMember(owner = "client!lha", name = "b", descriptor = "I")
    public static int borderId;

    @OriginalMember(owner = "client!cga", name = "d", descriptor = "Lclient!wp;")
    public static IndexedImage background;

    @OriginalMember(owner = "client!kq", name = "d", descriptor = "I")
    public static int minWidth;

    @OriginalMember(owner = "client!pe", name = "h", descriptor = "Z")
    public static boolean setup;

    @OriginalMember(owner = "client!aj", name = "y", descriptor = "Lclient!ve;")
    public static FontMetrics fontMetrics;

    @OriginalMember(owner = "client!ts", name = "f", descriptor = "[Lclient!wp;")
    public static IndexedImage[] fontSprites;

    @OriginalMember(owner = "client!ds", name = "a", descriptor = "(IIIILclient!ek;IIIIILclient!wk;I)V")
    public static void setup(@OriginalArg(10) HorizontalAlignment horizontalAlignment, @OriginalArg(4) VerticalAlignment verticalAlignment, @OriginalArg(1) int x, @OriginalArg(8) int y, @OriginalArg(3) int minWidth, @OriginalArg(5) int minHeight, @OriginalArg(7) int cornerId, @OriginalArg(0) int borderId, @OriginalArg(6) int backgroundId, @OriginalArg(2) int textColour, @OriginalArg(11) int font) {
        MessageBox.backgroundId = backgroundId;
        MessageBox.y = y;
        MessageBox.minHeight = minHeight;
        MessageBox.textColour = textColour;
        corner = null;
        MessageBox.verticalAlignment = verticalAlignment;
        MessageBox.cornerId = cornerId;
        border = null;
        MessageBox.font = font;
        MessageBox.horizontalAlignment = horizontalAlignment;
        MessageBox.x = x;
        MessageBox.borderId = borderId;
        background = null;
        MessageBox.minWidth = minWidth;
        ready();
        setup = true;
    }

    @OriginalMember(owner = "client!cea", name = "b", descriptor = "(I)Z")
    public static boolean ready() {
        @Pc(5) boolean ready = true;

        if (corner == null) {
            if (js5.SPRITES.fileready(cornerId)) {
                corner = IndexedImage.loadFirst(js5.SPRITES, cornerId);
            } else {
                ready = false;
            }
        }

        if (border == null) {
            if (js5.SPRITES.fileready(borderId)) {
                border = IndexedImage.loadFirst(js5.SPRITES, borderId);
            } else {
                ready = false;
            }
        }

        if (background == null) {
            if (js5.SPRITES.fileready(backgroundId)) {
                background = IndexedImage.loadFirst(js5.SPRITES, backgroundId);
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

            @Pc(52) int imageWidth = border.width;
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
            if (OrthoMode.toolkitActive) {
                alignedX += OrthoMode.method2283();
                alignedY += Static422.method5771();
            }

            toolkit.createSprite(background, false).renderTiled(corner.width + alignedX, corner.height + alignedY, width - corner.width * 2, height + -(corner.height * 2), 1, 0, 0);

            toolkit.createSprite(corner, true).render(alignedX, alignedY);

            corner.flipVertically();
            toolkit.createSprite(corner, true).render(width + alignedX - imageWidth, alignedY);

            corner.flipHorizontally();
            toolkit.createSprite(corner, true).render(width + alignedX - imageWidth, -imageWidth + alignedY + height);

            corner.flipVertically();
            toolkit.createSprite(corner, true).render(alignedX, height + alignedY - imageWidth);

            corner.flipHorizontally();
            toolkit.createSprite(border, true).renderTiled(alignedX, corner.height + alignedY, imageWidth, height - corner.height * 2);

            border.rotate();
            toolkit.createSprite(border, true).renderTiled(corner.width + alignedX, alignedY, width - corner.width * 2, imageWidth);

            border.rotate();
            toolkit.createSprite(border, true).renderTiled(width + alignedX - imageWidth, corner.height + alignedY, imageWidth, height - corner.height * 2);

            border.rotate();
            toolkit.createSprite(border, true).renderTiled(alignedX + corner.width, height + (alignedY - imageWidth), width - corner.width * 2, imageWidth);

            border.rotate();
            font.renderLines(text, alignedX + imageWidthPlusBorder, imageWidthPlusBorder + alignedY, 0, 0, width - imageWidthPlusBorder * 2, -(imageWidthPlusBorder * 2) + height, 1, 1, 0, textColour | 0xFF000000, -1, null, null, null);

            InterfaceManager.redrawWithin(alignedX, alignedY, width, height);
        }

        if (flip) {
            try {
                if (OrthoMode.toolkitActive) {
                    OrthoMode.flip();
                } else {
                    toolkit.flip();
                }
            } catch (@Pc(458) FlipException ignored) {
                /* empty */
            }
        }

    }
}
