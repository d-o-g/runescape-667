import com.jagex.Client;
import rs2.client.loading.screen.LoadingScreen;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Field;

@OriginalClass("client!uh")
public final class AwtLoadingScreen implements LoadingScreen {

    @OriginalMember(owner = "client!dda", name = "l", descriptor = "Ljava/awt/Image;")
    public static Image canvasImage;

    @OriginalMember(owner = "client!sk", name = "l", descriptor = "Ljava/awt/Font;")
    public static Font fallbackFont;

    @OriginalMember(owner = "client!ef", name = "a", descriptor = "(I)V")
    public static void cleanupFallback() {
        fallbackFont = null;
        canvasImage = null;
    }

    @OriginalMember(owner = "client!jm", name = "a", descriptor = "(ILjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/lang/String;B)V")
    public static void renderFallback(@OriginalArg(0) int percentage, @OriginalArg(1) Color outline, @OriginalArg(2) Color textColour, @OriginalArg(3) Color fill, @OriginalArg(4) String text) {
        try {
            @Pc(6) Graphics canvasGraphics = GameShell.canvas.getGraphics();
            if (fallbackFont == null) {
                fallbackFont = new Font("Helvetica", 1, 13);
            }
            if (fill == null) {
                fill = new Color(140, 17, 17);
            }
            if (outline == null) {
                outline = new Color(140, 17, 17);
            }
            if (textColour == null) {
                textColour = new Color(255, 255, 255);
            }

            try {
                if (canvasImage == null) {
                    canvasImage = GameShell.canvas.createImage(GameShell.canvasWid, GameShell.canvasHei);
                }

                @Pc(58) Graphics imageGraphics = canvasImage.getGraphics();

                imageGraphics.setColor(Color.black);
                imageGraphics.fillRect(0, 0, GameShell.canvasWid, GameShell.canvasHei);

                @Pc(73) int x = GameShell.canvasWid / 2 - 152;
                @Pc(79) int y = GameShell.canvasHei / 2 - 18;

                imageGraphics.setColor(outline);
                imageGraphics.drawRect(x, y, 303, 33);

                imageGraphics.setColor(fill);
                imageGraphics.fillRect(x + 2, y + 2, percentage * 3, 30);

                imageGraphics.setColor(Color.black);
                imageGraphics.drawRect(x + 1, y + 1, 301, 31);
                imageGraphics.fillRect(x + (percentage * 3) + 2, y + 2, 300 - (percentage * 3), 30);

                imageGraphics.setFont(fallbackFont);
                imageGraphics.setColor(textColour);
                imageGraphics.drawString(text, (304 - text.length() * 6) / 2 + x, y + 22);

                if (GameShell.loadingTitle != null) {
                    imageGraphics.setFont(fallbackFont);
                    imageGraphics.setColor(textColour);
                    imageGraphics.drawString(GameShell.loadingTitle, GameShell.canvasWid / 2 - GameShell.loadingTitle.length() * 6 / 2, GameShell.canvasHei / 2 - 26);
                }

                canvasGraphics.drawImage(canvasImage, 0, 0, null);
            } catch (@Pc(205) Exception local205) {
                canvasGraphics.setColor(Color.black);
                canvasGraphics.fillRect(0, 0, GameShell.canvasWid, GameShell.canvasHei);

                @Pc(220) int x = GameShell.canvasWid / 2 - 152;
                @Pc(73) int y = GameShell.canvasHei / 2 - 18;

                canvasGraphics.setColor(outline);
                canvasGraphics.drawRect(x, y, 303, 33);

                canvasGraphics.setColor(fill);
                canvasGraphics.fillRect(x + 2, y + 2, percentage * 3, 30);

                canvasGraphics.setColor(Color.black);
                canvasGraphics.drawRect(x + 1, y + 1, 301, 31);
                canvasGraphics.fillRect(x + (percentage * 3) + 2, y + 2, 300 - (percentage * 3), 30);

                canvasGraphics.setFont(fallbackFont);
                canvasGraphics.setColor(textColour);
                if (GameShell.loadingTitle != null) {
                    canvasGraphics.setFont(fallbackFont);
                    canvasGraphics.setColor(textColour);
                    canvasGraphics.drawString(GameShell.loadingTitle, GameShell.canvasWid / 2 - GameShell.loadingTitle.length() * 6 / 2, GameShell.canvasHei / 2 - 26);
                }
                canvasGraphics.drawString(text, x + (304 - text.length() * 6) / 2, y + 22);
            }
        } catch (@Pc(336) Exception local336) {
            GameShell.canvas.repaint();
        }
    }

    @OriginalMember(owner = "client!uh", name = "c", descriptor = "Ljava/awt/Font;")
    public Font bodyFont;

    @OriginalMember(owner = "client!uh", name = "m", descriptor = "I")
    public int textYOffset;

    @OriginalMember(owner = "client!uh", name = "C", descriptor = "I")
    public int boxXOffset;

    @OriginalMember(owner = "client!uh", name = "O", descriptor = "Z")
    public boolean xMiddle;

    @OriginalMember(owner = "client!uh", name = "M", descriptor = "I")
    public int width;

    @OriginalMember(owner = "client!uh", name = "D", descriptor = "Z")
    public boolean yMiddle;

    @OriginalMember(owner = "client!uh", name = "e", descriptor = "Ljava/awt/Color;")
    public Color textColour;

    @OriginalMember(owner = "client!uh", name = "h", descriptor = "Ljava/awt/Image;")
    public Image bar;

    @OriginalMember(owner = "client!uh", name = "I", descriptor = "Ljava/awt/Image;")
    public Image right;

    @OriginalMember(owner = "client!uh", name = "F", descriptor = "Ljava/awt/Image;")
    public Image background;

    @OriginalMember(owner = "client!uh", name = "p", descriptor = "Ljava/awt/Image;")
    public Image bottom;

    @OriginalMember(owner = "client!uh", name = "d", descriptor = "I")
    public int boxWidth;

    @OriginalMember(owner = "client!uh", name = "E", descriptor = "Ljava/awt/Image;")
    public Image top;

    @OriginalMember(owner = "client!uh", name = "v", descriptor = "Ljava/awt/Image;")
    public Image bodyLeft;

    @OriginalMember(owner = "client!uh", name = "G", descriptor = "I")
    public int boxYOffset;

    @OriginalMember(owner = "client!uh", name = "r", descriptor = "I")
    public int offsetPerTenCycles;

    @OriginalMember(owner = "client!uh", name = "q", descriptor = "Ljava/awt/Image;")
    public Image bodyFill;

    @OriginalMember(owner = "client!uh", name = "x", descriptor = "I")
    public int xOffset;

    @OriginalMember(owner = "client!uh", name = "H", descriptor = "I")
    public int yOffset;

    @OriginalMember(owner = "client!uh", name = "u", descriptor = "Z")
    public boolean fallback;

    @OriginalMember(owner = "client!uh", name = "f", descriptor = "Ljava/awt/Image;")
    public Image left;

    @OriginalMember(owner = "client!uh", name = "i", descriptor = "I")
    public int height;

    @OriginalMember(owner = "client!uh", name = "K", descriptor = "Ljava/awt/FontMetrics;")
    public FontMetrics bodyFontMetrics;

    @OriginalMember(owner = "client!uh", name = "w", descriptor = "Ljava/awt/Image;")
    public Image bodyRight;

    @OriginalMember(owner = "client!uh", name = "g", descriptor = "Ljava/awt/Image;")
    public Image image;

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(B)I")
    public static int cycles() {
        return Loading.renderer.getTick();
    }

    @OriginalMember(owner = "client!uh", name = "b", descriptor = "(I)V")
    @Override
    public void init() {
    }

    @OriginalMember(owner = "client!uh", name = "c", descriptor = "(I)I")
    @Override
    public int getFadeDuration() {
        return 0;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(BI)I")
    public int alignHeight(@OriginalArg(1) int height) {
        return this.yMiddle ? (GameShell.canvasHei - height) / 2 : 0;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(II)I")
    public int alignWidth(@OriginalArg(1) int width) {
        return this.xMiddle ? (GameShell.canvasWid - width) / 2 : 0;
    }

    @OriginalMember(owner = "client!uh", name = "f", descriptor = "(I)V")
    public void load() throws IllegalAccessException, NoSuchFieldException {
        @Pc(6) Class appletClass = GameShell.loaderApplet.getClass();
        this.bar = (Image) this.getObject(appletClass, "bar");
        this.background = (Image) this.getObject(appletClass, "background");
        this.left = (Image) this.getObject(appletClass, "left");
        this.right = (Image) this.getObject(appletClass, "right");
        this.top = (Image) this.getObject(appletClass, "top");
        this.bottom = (Image) this.getObject(appletClass, "bottom");
        this.bodyLeft = (Image) this.getObject(appletClass, "bodyLeft");
        this.bodyRight = (Image) this.getObject(appletClass, "bodyRight");
        this.bodyFill = (Image) this.getObject(appletClass, "bodyFill");
        this.bodyFont = (Font) this.getObject(appletClass, "bf");
        this.bodyFontMetrics = (FontMetrics) this.getObject(appletClass, "bfm");
        this.textColour = (Color) this.getObject(appletClass, "colourtext");

        @Pc(134) Object object = this.getObject(appletClass, "lb");
        @Pc(137) Class lbClass = object.getClass();
        this.xMiddle = this.getBoolean(lbClass, object, "xMiddle");
        this.yMiddle = this.getBoolean(lbClass, object, "yMiddle");
        this.xOffset = this.getInt(lbClass, object, "xOffset");
        this.yOffset = this.getInt(lbClass, object, "yOffset");
        this.width = this.getInt(lbClass, object, "width");
        this.height = this.getInt(lbClass, object, "height");
        this.boxXOffset = this.getInt(lbClass, object, "boxXOffset");
        this.boxYOffset = this.getInt(lbClass, object, "boxYOffset");
        this.boxWidth = this.getInt(lbClass, object, "boxWidth");
        this.textYOffset = this.getInt(lbClass, object, "textYOffset");
        this.offsetPerTenCycles = this.getInt(lbClass, object, "offsetPerTenCycles");
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(I)V")
    @Override
    public void cleanup() {
        cleanupFallback();
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Z)V")
    public void renderFallback() {
        renderFallback(Loading.renderer.getPercentage(), Client.OUTLINE_COLOURS[Client.colourId], Client.TEXT_COLOURS[Client.colourId], Client.FILL_COLOURS[Client.colourId], Loading.renderer.getText());
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/Class;Ljava/lang/Object;ZLjava/lang/String;)I")
    public int getInt(@OriginalArg(0) Class clazz, @OriginalArg(1) Object object, @OriginalArg(3) String fieldName) throws IllegalAccessException, NoSuchFieldException {
        @Pc(7) Field field = clazz.getDeclaredField(fieldName);
        return field.getInt(object);
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(ZJ)Z")
    @Override
    public boolean method8463(@OriginalArg(1) long arg0) {
        return true;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/Class;Ljava/lang/String;B)Ljava/lang/Object;")
    public Object getObject(@OriginalArg(0) Class clazz, @OriginalArg(1) String fieldName) throws IllegalAccessException, NoSuchFieldException {
        @Pc(7) Field field = clazz.getDeclaredField(fieldName);
        @Pc(17) Object object = field.get(GameShell.loaderApplet);
        field.set(GameShell.loaderApplet, null);
        return object;
    }

    @OriginalMember(owner = "client!uh", name = "d", descriptor = "(I)I")
    @Override
    public int percentage() {
        return 100;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(ZB)V")
    @Override
    public void render(@OriginalArg(0) boolean arg0) {
        if (!this.fallback) {
            if (GameShell.loaderApplet == null) {
                this.fallback = true;
            } else if (this.bodyFont == null) {
                try {
                    this.load();
                } catch (@Pc(18) Exception local18) {
                    this.fallback = true;
                }
            }
        }

        if (this.fallback) {
            this.renderFallback();
            return;
        }

        @Pc(43) Graphics canvasGraphics = GameShell.canvas.getGraphics();
        if (canvasGraphics == null) {
            GameShell.canvas.repaint();
            return;
        }

        try {
            @Pc(63) int percentage = Loading.renderer.getPercentage();
            @Pc(67) String text = Loading.renderer.getText();
            if (canvasImage == null) {
                canvasImage = GameShell.canvas.createImage(GameShell.canvasWid, GameShell.canvasHei);
            }

            @Pc(79) Graphics canvasImageGraphics = canvasImage.getGraphics();
            canvasImageGraphics.clearRect(0, 0, GameShell.canvasWid, GameShell.canvasHei);

            @Pc(90) int bodyLeftWidth = this.bodyLeft.getWidth(null);
            @Pc(95) int bodyRightWidth = this.bodyRight.getWidth(null);
            @Pc(100) int bodyFillWidth = this.bodyFill.getWidth(null);
            @Pc(105) int bodyLeftHeight = this.bodyLeft.getHeight(null);
            @Pc(110) int bodyRightHeight = this.bodyRight.getHeight(null);
            @Pc(115) int bodyFillHeight = this.bodyFill.getHeight(null);

            canvasImageGraphics.drawImage(this.bodyLeft, this.alignWidth(bodyLeftWidth) + this.boxXOffset - this.boxWidth / 2, this.alignHeight(bodyLeftHeight) + this.boxYOffset, null);

            @Pc(152) int local152 = bodyLeftWidth + this.boxXOffset - this.boxWidth / 2;
            @Pc(160) int local160 = this.boxWidth / 2 + this.boxXOffset;
            for (@Pc(162) int local162 = local152; local162 <= local160; local162 += bodyFillWidth) {
                canvasImageGraphics.drawImage(this.bodyFill, this.alignWidth(bodyLeftWidth) + this.boxXOffset + local162, this.alignHeight(bodyFillHeight) + this.boxYOffset, null);
            }

            canvasImageGraphics.drawImage(this.bodyRight, this.alignWidth(bodyRightWidth) + this.boxXOffset + this.boxWidth / 2, this.alignHeight(bodyRightHeight) + this.boxYOffset, null);

            @Pc(231) int leftWidth = this.left.getWidth(null);
            @Pc(236) int leftHeight = this.left.getHeight(null);
            @Pc(241) int rightWidth = this.right.getWidth(null);
            @Pc(246) int rightHeight = this.right.getHeight(null);
            @Pc(251) int bottomHeight = this.bottom.getHeight(null);
            @Pc(256) int topWidth = this.top.getWidth(null);
            @Pc(261) int topHeight = this.top.getHeight(null);
            @Pc(266) int bottomWidth = this.bottom.getWidth(null);
            @Pc(271) int barWidth = this.bar.getWidth(null);
            @Pc(276) int backgroundWidth = this.background.getWidth(null);
            @Pc(286) int local286 = this.alignWidth(this.width) + this.xOffset;
            @Pc(296) int local296 = this.alignHeight(this.height) + this.yOffset;

            canvasImageGraphics.drawImage(this.left, local286, local296 + (this.height - leftHeight) / 2, null);
            canvasImageGraphics.drawImage(this.right, local286 + this.width - rightWidth, local296 + (this.height - rightHeight) / 2, null);

            if (this.image == null) {
                this.image = GameShell.canvas.createImage(this.width - leftWidth - rightWidth, this.height);
            }

            @Pc(358) Graphics local358 = this.image.getGraphics();
            for (@Pc(360) int x = 0; x < this.width - rightWidth - leftWidth; x += topWidth) {
                local358.drawImage(this.top, x, 0, null);
            }
            for (@Pc(392) int x = 0; x < this.width - rightWidth - leftWidth; x += bottomWidth) {
                local358.drawImage(this.bottom, x, this.height - bottomHeight, null);
            }

            @Pc(439) int local439 = percentage * (this.width - rightWidth - leftWidth) / 100;
            if (local439 > 0) {
                @Pc(458) Image barImage = GameShell.canvas.createImage(local439, this.height - bottomHeight - topHeight);
                @Pc(462) int barImageWidth = barImage.getWidth(null);
                @Pc(465) Graphics barGraphics = barImage.getGraphics();
                @Pc(475) int offsetX = ((this.offsetPerTenCycles * cycles()) / 10) % barWidth;
                for (@Pc(480) int x = offsetX - barWidth; x < barImageWidth; x += barWidth) {
                    barGraphics.drawImage(this.bar, x, 0, null);
                }
                local358.drawImage(barImage, 0, topHeight, null);
            }

            @Pc(516) int local516 = local439;
            local439 = this.width - rightWidth - leftWidth - local439;
            if (local439 > 0) {
                @Pc(542) Image backgroundImage = GameShell.canvas.createImage(local439, this.height - bottomHeight - topHeight);
                @Pc(546) int backgroundImageWidth = backgroundImage.getWidth(null);
                @Pc(549) Graphics backgroundImageGraphics = backgroundImage.getGraphics();
                for (@Pc(480) int x = 0; x < backgroundImageWidth; x += backgroundWidth) {
                    backgroundImageGraphics.drawImage(this.background, x, 0, null);
                }
                local358.drawImage(backgroundImage, local516, topHeight, null);
            }

            canvasImageGraphics.drawImage(this.image, local286 + leftWidth, local296, null);
            canvasImageGraphics.setFont(this.bodyFont);
            canvasImageGraphics.setColor(this.textColour);
            canvasImageGraphics.drawString(text, (this.width - this.bodyFontMetrics.stringWidth(text)) / 2 + local286, this.textYOffset + 4 + local296 + this.height / 2);
            canvasGraphics.drawImage(canvasImage, 0, 0, null);
        } catch (@Pc(634) Exception local634) {
            this.fallback = true;
        }
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/Object;Ljava/lang/Class;ZLjava/lang/String;)Z")
    public boolean getBoolean(@OriginalArg(1) Class clazz, @OriginalArg(0) Object object, @OriginalArg(3) String fieldName) throws IllegalAccessException, NoSuchFieldException {
        @Pc(15) Field field = clazz.getDeclaredField(fieldName);
        return field.getBoolean(object);
    }
}
