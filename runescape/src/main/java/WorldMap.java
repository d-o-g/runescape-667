import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class WorldMap {

    @OriginalMember(owner = "client!gia", name = "s", descriptor = "Lclient!hda;")
    public static Component component;

    @OriginalMember(owner = "client!cw", name = "C", descriptor = "Z")
    public static boolean hovered = false;

    @OriginalMember(owner = "client!lja", name = "l", descriptor = "I")
    public static int optionsX = -1;

    @OriginalMember(owner = "client!tba", name = "g", descriptor = "Lclient!hda;")
    public static Component optionsComponent = null;

    @OriginalMember(owner = "client!eu", name = "ic", descriptor = "I")
    public static int optionsY = -1;

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IIIILclient!d;Lclient!ha;I)V")
    public static void draw(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) TextureSource arg3, @OriginalArg(5) Toolkit arg4, @OriginalArg(6) int arg5) {
        if (Static273.anInt4403 < 100) {
            Static719.method9117(arg3, arg4);
        }
        arg4.KA(arg1, arg2, arg1 + arg5, arg2 + arg0);
        @Pc(38) int local38;
        @Pc(57) int local57;
        if (Static273.anInt4403 < 100) {
            local38 = arg5 / 2 + arg1;
            arg4.aa(arg1, arg2, arg5, arg0, -16777216, 0);
            local57 = arg2 + arg0 / 2 - 20 - 18;
            arg4.method7976(local38 - 152, local57, 304, 34, Static337.aColorArray1[Static338.anInt5562].getRGB(), 0);
            arg4.aa(local38 - 150, local57 + 2, Static273.anInt4403 * 3, 30, Static718.aColorArray3[Static338.anInt5562].getRGB(), 0);
            Fonts.b12.renderCentre(-1, local38, LocalisedText.LOADINGDOTDOTDOT.localise(Static51.language), local57 + 20, Static399.aColorArray2[Static338.anInt5562].getRGB());
            return;
        }
        @Pc(114) int local114 = Static164.anInt2809 - (int) ((float) arg5 / Static30.aFloat105);
        local38 = Static615.anInt9389 + (int) ((float) arg0 / Static30.aFloat105);
        local57 = Static164.anInt2809 + (int) ((float) arg5 / Static30.aFloat105);
        Static329.anInt1750 = (int) ((float) (arg5 * 2) / Static30.aFloat105);
        Static588.anInt8690 = (int) ((float) (arg0 * 2) / Static30.aFloat105);
        @Pc(155) int local155 = Static615.anInt9389 - (int) ((float) arg0 / Static30.aFloat105);
        Static510.anInt7639 = Static615.anInt9389 - (int) ((float) arg0 / Static30.aFloat105);
        Static534.anInt8111 = Static164.anInt2809 - (int) ((float) arg5 / Static30.aFloat105);
        Static30.method5062(Static30.anInt5655 + local114, local38 - -Static30.anInt5648, local57 + Static30.anInt5655, local155 - -Static30.anInt5648, arg1, arg2, arg5 + arg1, arg0 + arg2 + 1);
        Static30.method5060(arg4);
        @Pc(203) Deque local203 = Static30.method5081(arg4);
        Static368.method5272(local203, arg4);
        if (Static320.anInt5084 > 0) {
            Static212.anInt3467--;
            if (Static212.anInt3467 == 0) {
                Static320.anInt5084--;
                Static212.anInt3467 = 20;
            }
        }
        if (!Static105.displayFps) {
            return;
        }
        @Pc(250) int local250 = arg5 + arg1 - 5;
        @Pc(256) int local256 = arg2 + arg0 - 8;
        Fonts.p12.render(local250, "Fps:" + Static652.currentFps, 16776960, -1, local256);
        @Pc(273) int local273 = local256 - 15;
        @Pc(275) Runtime local275 = Runtime.getRuntime();
        @Pc(285) int local285 = (int) ((local275.totalMemory() - local275.freeMemory()) / 1024L);
        @Pc(287) int local287 = 16776960;
        if (local285 > 65536) {
            local287 = 16711680;
        }
        Fonts.p12.render(local250, "Mem:" + local285 + "k", local287, -1, local273);
        local256 = local273 - 15;
    }

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(BILclient!ha;III)V")
    public static void drawOverview(@OriginalArg(1) int arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        arg1.KA(arg3, arg4, arg3 + arg0, arg2 + arg4);
        arg1.method7971(arg0, arg2, arg4, arg3, -16777216);
        if (Static273.anInt4403 < 100) {
            return;
        }
        @Pc(44) float local44 = (float) Static30.anInt5644 / (float) Static30.anInt5650;
        @Pc(46) int local46 = arg0;
        @Pc(48) int local48 = arg2;
        if (local44 < 1.0F) {
            local48 = (int) (local44 * (float) arg0);
        } else {
            local46 = (int) ((float) arg2 / local44);
        }
        @Pc(75) int local75 = arg3 + (arg0 - local46) / 2;
        @Pc(84) int local84 = arg4 + (arg2 - local48) / 2;
        if (Static13.aSprite_4 == null || Static13.aSprite_4.getWidth() != arg0 || Static13.aSprite_4.getHeight() != arg2) {
            Static30.method5062(Static30.anInt5655, Static30.anInt5648 + Static30.anInt5644, Static30.anInt5650 + Static30.anInt5655, Static30.anInt5648, local75, local84, local75 + local46, local84 - -local48);
            Static30.method5060(arg1);
            Static13.aSprite_4 = arg1.method7964(local75, local84, local46, local48, false);
        }
        Static13.aSprite_4.render(local75, local84);
        @Pc(138) int local138 = local46 * Static329.anInt1750 / Static30.anInt5650;
        @Pc(144) int local144 = Static588.anInt8690 * local48 / Static30.anInt5644;
        @Pc(152) int local152 = Static534.anInt8111 * local46 / Static30.anInt5650 + local75;
        @Pc(166) int local166 = local48 + local84 - local144 - Static510.anInt7639 * local48 / Static30.anInt5644;
        @Pc(168) int local168 = -1996554240;
        if (client.modeGame == ModeGame.STELLAR_DAWN) {
            local168 = -1996488705;
        }
        arg1.aa(local152, local166, local138, local144, local168, 1);
        arg1.method7976(local152, local166, local138, local144, local168, 0);
        if (Static320.anInt5084 <= 0) {
            return;
        }
        @Pc(202) int local202;
        if (Static212.anInt3467 > 50) {
            local202 = (100 - Static212.anInt3467) * 5;
        } else {
            local202 = Static212.anInt3467 * 5;
        }
        for (@Pc(213) Node_Sub20 local213 = (Node_Sub20) Static30.A_DEQUE___31.first(); local213 != null; local213 = (Node_Sub20) Static30.A_DEQUE___31.next()) {
            @Pc(221) Class105 local221 = Static30.aClass246_3.method5584(local213.anInt3131);
            if (Static408.method5634(local221)) {
                @Pc(256) int local256;
                @Pc(269) int local269;
                if (Static475.anInt7168 == local213.anInt3131) {
                    local256 = local75 + local213.anInt3129 * local46 / Static30.anInt5650;
                    local269 = local84 + local48 * (Static30.anInt5644 - local213.anInt3124) / Static30.anInt5644;
                    arg1.method7971(4, 4, local269 - 2, local256 - 2, local202 << 24 | 0xFFFF00);
                } else if (Static409.anInt6318 != -1 && Static409.anInt6318 == local221.anInt2597) {
                    local256 = local75 + local46 * local213.anInt3129 / Static30.anInt5650;
                    local269 = local84 + (Static30.anInt5644 - local213.anInt3124) * local48 / Static30.anInt5644;
                    arg1.method7971(4, 4, local269 - 2, local256 + -2, local202 << 24 | 0xFFFF00);
                }
            }
        }
    }

    @OriginalMember(owner = "client!fo", name = "d", descriptor = "(I)Lclient!ip;")
    public static WorldMapArea area() {
        return Static30.aClass2_Sub2_Sub13_3;
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(IIIBI)V")
    public static void clickedOverview(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
        @Pc(16) float local16 = (float) Static30.anInt5644 / (float) Static30.anInt5650;
        @Pc(18) int local18 = arg0;
        @Pc(20) int local20 = arg3;
        if (local16 < 1.0F) {
            local20 = (int) ((float) arg0 * local16);
        } else {
            local18 = (int) ((float) arg3 / local16);
        }
        @Pc(47) int local47 = arg2 - (arg3 - local20) / 2;
        @Pc(56) int local56 = arg1 - (arg0 - local18) / 2;
        Static164.anInt2809 = local56 * Static30.anInt5650 / local18;
        Static615.anInt9389 = Static30.anInt5644 - Static30.anInt5644 * local47 / local20;
        Static558.anInt3181 = -1;
        Static180.anInt3001 = -1;
        Static387.method5440();
    }

    @OriginalMember(owner = "client!cba", name = "a", descriptor = "(IZILclient!hda;)V")
    public static void setOptions(@OriginalArg(0) int optionsX, @OriginalArg(2) int optionsY, @OriginalArg(3) Component optionsComponent) {
        WorldMap.optionsX = optionsX;
        WorldMap.optionsComponent = optionsComponent;
        WorldMap.optionsY = optionsY;
    }
}
