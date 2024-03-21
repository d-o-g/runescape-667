import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import com.jagex.graphics.Ground;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static706 {

    @OriginalMember(owner = "client!wfa", name = "W", descriptor = "F")
    public static float aFloat217;

    @OriginalMember(owner = "client!wfa", name = "U", descriptor = "[Lclient!s;")
    public static Ground[] aGroundArray3;

    @OriginalMember(owner = "client!wfa", name = "T", descriptor = "I")
    public static int anInt10633;

    @OriginalMember(owner = "client!wfa", name = "Q", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_255 = new Class225(105, -1);

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(IILclient!gp;III)V")
    public static void method9220(@OriginalArg(0) int arg0, @OriginalArg(2) LocTypeCustomisation arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        if (arg4 < 1 || arg2 < 1 || arg4 > Static720.mapWidth - 2 || Static501.mapHeight - 2 < arg2) {
            return;
        }
        if (Static334.activeTiles == null) {
            return;
        }
        @Pc(52) Location local52 = Static2.aMapRegion.getLoc(arg4, arg2, arg3, arg0);
        if (local52 == null) {
            return;
        }
        if (local52 instanceof DynamicLocation) {
            ((DynamicLocation) local52).method6160(arg1);
            return;
        }
        if (!(local52 instanceof DynamicGroundDecor)) {
            if (local52 instanceof DynamicWall) {
                ((DynamicWall) local52).method1963(arg1);
            } else if (local52 instanceof DynamicWallDecor) {
                ((DynamicWallDecor) local52).method6862(arg1);
                return;
            }
            return;
        }
        ((DynamicGroundDecor) local52).method3581(arg1);
        return;
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(BLclient!bn;I)V")
    public static void method9221(@OriginalArg(1) Node_Sub8 arg0, @OriginalArg(2) int arg1) {
        Static400.instance.aClass57_Sub25_2.method7208();
        if (arg0 == null) {
            Static100.method1988();
        }
        Static719.aClass56_5.method3592();
        Static522.method7041(arg0);
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(IBII)Z")
    public static boolean method9224(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        Static107.aMatrix_3.method7124(arg2, arg1, arg0, Static35.anIntArray58);
        @Pc(13) int local13 = Static35.anIntArray58[2];
        if (local13 < 50) {
            return false;
        } else {
            Static35.anIntArray58[0] = Static35.anIntArray58[0] * Static1.anInt10797 / local13 + Static460.anInt6970;
            Static35.anIntArray58[2] = local13;
            Static35.anIntArray58[1] = Static407.anInt6286 + Static412.anInt6357 * Static35.anIntArray58[1] / local13;
            return true;
        }
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(Ljava/lang/String;Z)V")
    public static void method9225(@OriginalArg(0) String arg0) {
        if (arg0 == null) {
            return;
        }
        if (Static327.anInt5392 >= 200 && !Static126.aBoolean200 || Static327.anInt5392 >= 200) {
            Static67.method6098(LocalisedText.FRIENDLIST_FULL.localise(Static51.language));
            return;
        }
        @Pc(34) String local34 = Static390.method5492(arg0);
        if (local34 == null) {
            return;
        }
        @Pc(81) String local81;
        for (@Pc(40) int local40 = 0; local40 < Static327.anInt5392; local40++) {
            @Pc(47) String local47 = Static390.method5492(Static330.aStringArray25[local40]);
            if (local47 != null && local47.equals(local34)) {
                Static67.method6098(arg0 + LocalisedText.FRIENDLISTDUPE.localise(Static51.language));
                return;
            }
            if (Static572.aStringArray42[local40] != null) {
                local81 = Static390.method5492(Static572.aStringArray42[local40]);
                if (local81 != null && local81.equals(local34)) {
                    Static67.method6098(arg0 + LocalisedText.FRIENDLISTDUPE.localise(Static51.language));
                    return;
                }
            }
        }
        for (@Pc(115) int local115 = 0; local115 < Static436.anInt3849; local115++) {
            local81 = Static390.method5492(Static632.aStringArray44[local115]);
            if (local81 != null && local81.equals(local34)) {
                Static67.method6098(LocalisedText.REMOVEIGNORE1.localise(Static51.language) + arg0 + LocalisedText.REMOVEIGNORE2.localise(Static51.language));
                return;
            }
            if (Static10.aStringArray1[local115] != null) {
                @Pc(161) String local161 = Static390.method5492(Static10.aStringArray1[local115]);
                if (local161 != null && local161.equals(local34)) {
                    Static67.method6098(LocalisedText.REMOVEIGNORE1.localise(Static51.language) + arg0 + LocalisedText.REMOVEIGNORE2.localise(Static51.language));
                    return;
                }
            }
        }
        if (Static390.method5492(Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aString9).equals(local34)) {
            Static67.method6098(LocalisedText.FRIENDCANTADDSELF.localise(Static51.language));
            return;
        }
        @Pc(230) ServerConnection local230 = Static668.method8701();
        @Pc(236) ClientMessage local236 = Static293.method4335(Static669.aClass345_116, local230.aClass186_1);
        local236.buffer.p1(Static231.method3379(arg0));
        local236.buffer.pjstr(arg0);
        local230.send(local236);
    }
}
