import com.jagex.game.runetek6.client.GameShell;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.PixelGrabber;

@OriginalClass("client!rt")
public final class WorldMapFont {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ÄËÏÖÜäëïöüÿßÁÀÉÈÍÌÓÒÚÙáàéèíìóòúùÂÊÎÔÛâêîôûÆæãÃõÕçÇ";

    @OriginalMember(owner = "client!rt", name = "e", descriptor = "[I")
    public static final int[] CHAR_MAP = new int[256];

    @OriginalMember(owner = "client!rt", name = "g", descriptor = "I")
    public static final int CHAR_COUNT = CHARS.length();

    static {
        for (@Pc(24) int i = 0; i < 256; i++) {
            @Pc(31) int c = CHARS.indexOf(i);
            if (c == -1) {
                c = 'J';
            }
            CHAR_MAP[i] = c;
        }
    }

    @OriginalMember(owner = "client!rt", name = "a", descriptor = "I")
    public int width;

    @OriginalMember(owner = "client!rt", name = "d", descriptor = "I")
    public int height;

    @OriginalMember(owner = "client!rt", name = "f", descriptor = "Z")
    public boolean aBoolean653 = false;

    @OriginalMember(owner = "client!rt", name = "c", descriptor = "[I")
    public final int[] clipping = new int[4];

    @OriginalMember(owner = "client!rt", name = "b", descriptor = "[Lclient!st;")
    public final Sprite[] sprites;

    @OriginalMember(owner = "client!rt", name = "h", descriptor = "[I")
    public final int[] charWidths;

    @OriginalMember(owner = "client!rt", name = "<init>", descriptor = "(Lclient!ha;IZLjava/awt/Component;)V")
    public WorldMapFont(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int size, @OriginalArg(2) boolean bold, @OriginalArg(3) Component component) {
        this.aBoolean653 = false;
        this.sprites = new Sprite[256];
        this.charWidths = new int[256];

        @Pc(32) Font font = new Font("Helvetica", bold ? Font.BOLD : Font.PLAIN, size);
        @Pc(36) FontMetrics metrics = component.getFontMetrics(font);
        for (@Pc(38) int i = 0; i < CHAR_COUNT; i++) {
            this.load(toolkit, font, metrics, CHARS.charAt(i), i, false);
        }

        if (bold && this.aBoolean653) {
            this.aBoolean653 = false;

            font = new Font("Helvetica", Font.PLAIN, size);
            metrics = component.getFontMetrics(font);

            for (@Pc(78) int i = 0; i < CHAR_COUNT; i++) {
                this.load(toolkit, font, metrics, CHARS.charAt(i), i, false);
            }

            if (!this.aBoolean653) {
                this.aBoolean653 = false;

                for (@Pc(103) int local103 = 0; local103 < CHAR_COUNT; local103++) {
                    this.load(toolkit, font, metrics, CHARS.charAt(local103), local103, true);
                }
            }
        }
    }

    @OriginalMember(owner = "client!rt", name = "b", descriptor = "()I")
    public int getHeight() {
        return this.height - 1;
    }

    @OriginalMember(owner = "client!rt", name = "a", descriptor = "(Lclient!ha;Ljava/lang/String;[IIIIZ)V")
    public void render(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) String string, @OriginalArg(2) int[] clipping, @OriginalArg(3) int x, @OriginalArg(4) int y, @OriginalArg(5) int colour, @OriginalArg(6) boolean shadow) {
        if (colour == 0) {
            shadow = false;
        }

        @Pc(7) int combinedColour = colour | 0xFF000000;
        for (@Pc(9) int i = 0; i < string.length(); i++) {
            @Pc(16) int c = CHAR_MAP[string.charAt(i)];

            if (shadow) {
                this.sprites[c].render(x + 1, y + 1, 0, 0xff000000, 1);
            }

            this.sprites[c].render(x, y, 0, combinedColour, 1);
            x += this.charWidths[c];
        }
    }

    @OriginalMember(owner = "client!rt", name = "a", descriptor = "()I")
    public int getWidth() {
        return this.width;
    }

    @OriginalMember(owner = "client!rt", name = "a", descriptor = "(Ljava/lang/String;)I")
    public int totalWidth(@OriginalArg(0) String string) {
        @Pc(1) int width = 0;
        for (@Pc(3) int i = 0; i < string.length(); i++) {
            @Pc(10) int index = CHAR_MAP[string.charAt(i)];
            width += this.charWidths[index];
        }
        return width;
    }

    @OriginalMember(owner = "client!rt", name = "a", descriptor = "(Lclient!ha;Ljava/lang/String;IIIZ)V")
    public void renderCenter(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) String string, @OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(4) int colour) {
        @Pc(5) int halfWidth = this.totalWidth(string) / 2;
        toolkit.K(this.clipping);

        if (((x - halfWidth) <= this.clipping[2]) && (((x + halfWidth) >= this.clipping[0]) && (((y - this.width) <= this.clipping[3]) && ((y + this.height) >= this.clipping[1])))) {
            this.render(toolkit, string, this.clipping, x - halfWidth, y, colour, true);
        }
    }

    @OriginalMember(owner = "client!rt", name = "a", descriptor = "(Lclient!ha;Ljava/awt/Font;Ljava/awt/FontMetrics;CIZ)V")
    public void load(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) Font font, @OriginalArg(2) FontMetrics metrics, @OriginalArg(3) char c, @OriginalArg(4) int id, @OriginalArg(5) boolean arg5) {
        @Pc(3) int width = metrics.charWidth(c);
        @Pc(5) int initialWidth = width;
        if (arg5) {
            try {
                if (c == '/') {
                    arg5 = false;
                }

                if (c == 'f' || c == 't' || c == 'w' || c == 'v' || c == 'k' || c == 'x' || c == 'y' || c == 'A' || c == 'V' || c == 'W') {
                    width++;
                }
            } catch (@Pc(63) Exception ignored) {
                /* empty */
            }
        }

        @Pc(67) int maxAscent = metrics.getMaxAscent();
        @Pc(73) int totalDescent = metrics.getMaxAscent() + metrics.getMaxDescent();
        @Pc(76) int height = metrics.getHeight();

        @Pc(81) Image image = GameShell.canvas.createImage(width, totalDescent);
        @Pc(84) Graphics graphics = image.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, width, totalDescent);
        graphics.setColor(Color.white);
        graphics.setFont(font);
        graphics.drawString(String.valueOf(c), 0, maxAscent);
        if (arg5) {
            graphics.drawString(String.valueOf(c), 1, maxAscent);
        }

        @Pc(120) int[] pixels = new int[width * totalDescent];
        @Pc(132) PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, totalDescent, pixels, 0, width);
        try {
            grabber.grabPixels();
        } catch (@Pc(137) Exception ignored) {
            /* empty */
        }
        image.flush();

        @Pc(143) int local143 = 0;
        label66:
        for (@Pc(145) int y = 0; y < totalDescent; y++) {
            for (@Pc(148) int x = 0; x < width; x++) {
                @Pc(157) int local157 = pixels[x + (y * width)];
                if ((local157 & 0xFFFFFF) != 0) {
                    local143 = y;
                    break label66;
                }
            }
        }

        for (@Pc(148) int i = 0; i < pixels.length; i++) {
            if ((pixels[i] & 0xFFFFFF) == 0) {
                pixels[i] = 0;
            }
        }

        this.width = maxAscent - local143;
        this.height = height;
        this.charWidths[id] = initialWidth;
        this.sprites[id] = toolkit.createSprite(width, width, totalDescent, pixels);
    }
}
