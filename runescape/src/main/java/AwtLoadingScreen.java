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

    @OriginalMember(owner = "client!uh", name = "c", descriptor = "Ljava/awt/Font;")
    public Font aFont2;

    @OriginalMember(owner = "client!uh", name = "m", descriptor = "I")
    public int anInt9632;

    @OriginalMember(owner = "client!uh", name = "C", descriptor = "I")
    public int anInt9634;

    @OriginalMember(owner = "client!uh", name = "O", descriptor = "Z")
    public boolean aBoolean739;

    @OriginalMember(owner = "client!uh", name = "M", descriptor = "I")
    public int anInt9638;

    @OriginalMember(owner = "client!uh", name = "D", descriptor = "Z")
    public boolean aBoolean740;

    @OriginalMember(owner = "client!uh", name = "e", descriptor = "Ljava/awt/Color;")
    public Color aColor1;

    @OriginalMember(owner = "client!uh", name = "h", descriptor = "Ljava/awt/Image;")
    public Image anImage4;

    @OriginalMember(owner = "client!uh", name = "I", descriptor = "Ljava/awt/Image;")
    public Image anImage5;

    @OriginalMember(owner = "client!uh", name = "F", descriptor = "Ljava/awt/Image;")
    public Image anImage6;

    @OriginalMember(owner = "client!uh", name = "p", descriptor = "Ljava/awt/Image;")
    public Image anImage7;

    @OriginalMember(owner = "client!uh", name = "d", descriptor = "I")
    public int anInt9640;

    @OriginalMember(owner = "client!uh", name = "E", descriptor = "Ljava/awt/Image;")
    public Image anImage8;

    @OriginalMember(owner = "client!uh", name = "v", descriptor = "Ljava/awt/Image;")
    public Image anImage9;

    @OriginalMember(owner = "client!uh", name = "G", descriptor = "I")
    public int anInt9643;

    @OriginalMember(owner = "client!uh", name = "r", descriptor = "I")
    public int anInt9644;

    @OriginalMember(owner = "client!uh", name = "q", descriptor = "Ljava/awt/Image;")
    public Image anImage10;

    @OriginalMember(owner = "client!uh", name = "x", descriptor = "I")
    public int anInt9645;

    @OriginalMember(owner = "client!uh", name = "H", descriptor = "I")
    public int anInt9646;

    @OriginalMember(owner = "client!uh", name = "u", descriptor = "Z")
    public boolean aBoolean741;

    @OriginalMember(owner = "client!uh", name = "f", descriptor = "Ljava/awt/Image;")
    public Image anImage11;

    @OriginalMember(owner = "client!uh", name = "i", descriptor = "I")
    public int anInt9648;

    @OriginalMember(owner = "client!uh", name = "K", descriptor = "Ljava/awt/FontMetrics;")
    public FontMetrics aFontMetrics1;

    @OriginalMember(owner = "client!uh", name = "w", descriptor = "Ljava/awt/Image;")
    public Image anImage12;

    @OriginalMember(owner = "client!uh", name = "g", descriptor = "Ljava/awt/Image;")
    public Image anImage13;

    @OriginalMember(owner = "client!uh", name = "b", descriptor = "(I)V")
    @Override
    public void method8464() {
    }

    @OriginalMember(owner = "client!uh", name = "c", descriptor = "(I)I")
    @Override
    public int getFadeDuration() {
        return 0;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(BI)I")
    public int method8466(@OriginalArg(1) int arg0) {
        return this.aBoolean740 ? (GameShell.canvasHei - arg0) / 2 : 0;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(II)I")
    public int method8469(@OriginalArg(1) int arg0) {
        return this.aBoolean739 ? (GameShell.canvasWid - arg0) / 2 : 0;
    }

    @OriginalMember(owner = "client!uh", name = "f", descriptor = "(I)V")
    public void method8470() throws IllegalAccessException, NoSuchFieldException {
        @Pc(6) Class local6 = GameShell.loaderApplet.getClass();
        this.anImage4 = (Image) this.method8476(local6, "bar");
        this.anImage6 = (Image) this.method8476(local6, "background");
        this.anImage11 = (Image) this.method8476(local6, "left");
        this.anImage5 = (Image) this.method8476(local6, "right");
        this.anImage8 = (Image) this.method8476(local6, "top");
        this.anImage7 = (Image) this.method8476(local6, "bottom");
        this.anImage9 = (Image) this.method8476(local6, "bodyLeft");
        this.anImage12 = (Image) this.method8476(local6, "bodyRight");
        this.anImage10 = (Image) this.method8476(local6, "bodyFill");
        this.aFont2 = (Font) this.method8476(local6, "bf");
        this.aFontMetrics1 = (FontMetrics) this.method8476(local6, "bfm");
        this.aColor1 = (Color) this.method8476(local6, "colourtext");
        @Pc(134) Object local134 = this.method8476(local6, "lb");
        @Pc(137) Class local137 = local134.getClass();
        this.aBoolean739 = this.method8477(local134, local137, "xMiddle");
        this.aBoolean740 = this.method8477(local134, local137, "yMiddle");
        this.anInt9645 = this.method8472(local137, local134, "xOffset");
        this.anInt9646 = this.method8472(local137, local134, "yOffset");
        this.anInt9638 = this.method8472(local137, local134, "width");
        this.anInt9648 = this.method8472(local137, local134, "height");
        this.anInt9634 = this.method8472(local137, local134, "boxXOffset");
        this.anInt9643 = this.method8472(local137, local134, "boxYOffset");
        this.anInt9640 = this.method8472(local137, local134, "boxWidth");
        this.anInt9632 = this.method8472(local137, local134, "textYOffset");
        this.anInt9644 = this.method8472(local137, local134, "offsetPerTenCycles");
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(I)V")
    @Override
    public void method8461() {
        Static137.method2354();
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Z)V")
    public void method8471() {
        Static305.method4439(Loading.renderer.getPercentage(), Client.OUTLINE_COLOURS[Client.colourId], Static399.aColorArray2[Client.colourId], Client.FILL_COLOURS[Client.colourId], Loading.renderer.getText());
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/Class;Ljava/lang/Object;ZLjava/lang/String;)I")
    public int method8472(@OriginalArg(0) Class arg0, @OriginalArg(1) Object arg1, @OriginalArg(3) String arg2) throws IllegalAccessException, NoSuchFieldException {
        @Pc(7) Field local7 = arg0.getDeclaredField(arg2);
        return local7.getInt(arg1);
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(ZJ)Z")
    @Override
    public boolean method8463(@OriginalArg(1) long arg0) {
        return true;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/Class;Ljava/lang/String;B)Ljava/lang/Object;")
    public Object method8476(@OriginalArg(0) Class arg0, @OriginalArg(1) String arg1) throws IllegalAccessException, NoSuchFieldException {
        @Pc(7) Field local7 = arg0.getDeclaredField(arg1);
        @Pc(17) Object local17 = local7.get(GameShell.loaderApplet);
        local7.set(GameShell.loaderApplet, null);
        return local17;
    }

    @OriginalMember(owner = "client!uh", name = "d", descriptor = "(I)I")
    @Override
    public int percentage() {
        return 100;
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(ZB)V")
    @Override
    public void render(@OriginalArg(0) boolean arg0) {
        if (!this.aBoolean741) {
            if (GameShell.loaderApplet == null) {
                this.aBoolean741 = true;
            } else if (this.aFont2 == null) {
                try {
                    this.method8470();
                } catch (@Pc(18) Exception local18) {
                    this.aBoolean741 = true;
                }
            }
        }
        if (this.aBoolean741) {
            this.method8471();
            return;
        }
        @Pc(43) Graphics local43 = GameShell.canvas.getGraphics();
        if (local43 == null) {
            GameShell.canvas.repaint();
            return;
        }
        try {
            @Pc(63) int local63 = Loading.renderer.getPercentage();
            @Pc(67) String local67 = Loading.renderer.getText();
            if (Static103.anImage1 == null) {
                Static103.anImage1 = GameShell.canvas.createImage(GameShell.canvasWid, GameShell.canvasHei);
            }
            @Pc(79) Graphics local79 = Static103.anImage1.getGraphics();
            local79.clearRect(0, 0, GameShell.canvasWid, GameShell.canvasHei);
            @Pc(90) int local90 = this.anImage9.getWidth(null);
            @Pc(95) int local95 = this.anImage12.getWidth(null);
            @Pc(100) int local100 = this.anImage10.getWidth(null);
            @Pc(105) int local105 = this.anImage9.getHeight(null);
            @Pc(110) int local110 = this.anImage12.getHeight(null);
            @Pc(115) int local115 = this.anImage10.getHeight(null);
            local79.drawImage(this.anImage9, this.method8469(local90) + this.anInt9634 - this.anInt9640 / 2, this.method8466(local105) - -this.anInt9643, null);
            @Pc(152) int local152 = local90 + this.anInt9634 - this.anInt9640 / 2;
            @Pc(160) int local160 = this.anInt9640 / 2 + this.anInt9634;
            for (@Pc(162) int local162 = local152; local162 <= local160; local162 += local100) {
                local79.drawImage(this.anImage10, this.method8469(local90) + this.anInt9634 + local162, this.method8466(local115) - -this.anInt9643, null);
            }
            local79.drawImage(this.anImage12, this.method8469(local95) + this.anInt9634 + this.anInt9640 / 2, this.method8466(local110) + this.anInt9643, null);
            @Pc(231) int local231 = this.anImage11.getWidth(null);
            @Pc(236) int local236 = this.anImage11.getHeight(null);
            @Pc(241) int local241 = this.anImage5.getWidth(null);
            @Pc(246) int local246 = this.anImage5.getHeight(null);
            @Pc(251) int local251 = this.anImage7.getHeight(null);
            @Pc(256) int local256 = this.anImage8.getWidth(null);
            @Pc(261) int local261 = this.anImage8.getHeight(null);
            @Pc(266) int local266 = this.anImage7.getWidth(null);
            @Pc(271) int local271 = this.anImage4.getWidth(null);
            @Pc(276) int local276 = this.anImage6.getWidth(null);
            @Pc(286) int local286 = this.method8469(this.anInt9638) + this.anInt9645;
            @Pc(296) int local296 = this.method8466(this.anInt9648) + this.anInt9646;
            local79.drawImage(this.anImage11, local286, local296 + (this.anInt9648 - local236) / 2, null);
            local79.drawImage(this.anImage5, local286 + this.anInt9638 - local241, local296 + (this.anInt9648 + -local246) / 2, null);
            if (this.anImage13 == null) {
                this.anImage13 = GameShell.canvas.createImage(this.anInt9638 - local231 - local241, this.anInt9648);
            }
            @Pc(358) Graphics local358 = this.anImage13.getGraphics();
            for (@Pc(360) int local360 = 0; local360 < this.anInt9638 - local241 - local231; local360 += local256) {
                local358.drawImage(this.anImage8, local360, 0, null);
            }
            for (@Pc(392) int local392 = 0; local392 < this.anInt9638 - local241 - local231; local392 += local266) {
                local358.drawImage(this.anImage7, local392, this.anInt9648 - local251, null);
            }
            @Pc(439) int local439 = local63 * (this.anInt9638 - local241 - local231) / 100;
            @Pc(480) int local480;
            if (local439 > 0) {
                @Pc(458) Image local458 = GameShell.canvas.createImage(local439, this.anInt9648 - local251 - local261);
                @Pc(462) int local462 = local458.getWidth(null);
                @Pc(465) Graphics local465 = local458.getGraphics();
                @Pc(475) int local475 = this.anInt9644 * Static556.method7302() / 10 % local271;
                for (local480 = local475 - local271; local480 < local462; local480 += local271) {
                    local465.drawImage(this.anImage4, local480, 0, null);
                }
                local358.drawImage(local458, 0, local261, null);
            }
            @Pc(516) int local516 = local439;
            local439 = this.anInt9638 - local241 - local231 - local439;
            if (local439 > 0) {
                @Pc(542) Image local542 = GameShell.canvas.createImage(local439, this.anInt9648 - local251 - local261);
                @Pc(546) int local546 = local542.getWidth(null);
                @Pc(549) Graphics local549 = local542.getGraphics();
                for (local480 = 0; local480 < local546; local480 += local276) {
                    local549.drawImage(this.anImage6, local480, 0, null);
                }
                local358.drawImage(local542, local516, local261, null);
            }
            local79.drawImage(this.anImage13, local286 + local231, local296, null);
            local79.setFont(this.aFont2);
            local79.setColor(this.aColor1);
            local79.drawString(local67, (this.anInt9638 - this.aFontMetrics1.stringWidth(local67)) / 2 + local286, this.anInt9632 + 4 + local296 + this.anInt9648 / 2);
            local43.drawImage(Static103.anImage1, 0, 0, null);
        } catch (@Pc(634) Exception local634) {
            this.aBoolean741 = true;
        }
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(Ljava/lang/Object;Ljava/lang/Class;ZLjava/lang/String;)Z")
    public boolean method8477(@OriginalArg(0) Object arg0, @OriginalArg(1) Class arg1, @OriginalArg(3) String arg2) throws IllegalAccessException, NoSuchFieldException {
        @Pc(15) Field local15 = arg1.getDeclaredField(arg2);
        return local15.getBoolean(arg0);
    }
}
