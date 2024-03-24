import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static360 {

    @OriginalMember(owner = "client!lg", name = "f", descriptor = "I")
    public static int anInt5820;

    @OriginalMember(owner = "client!lg", name = "i", descriptor = "Lclient!hw;")
    public static final Class172 aClass172_3 = new Class172();

    @OriginalMember(owner = "client!lg", name = "d", descriptor = "(II)Z")
    public static boolean method5230(@OriginalArg(0) int arg0) {
        if (Static5.anInt92 != arg0 || Static178.aClass247_1 == null) {
            Static298.method4385();
            Static5.anInt92 = arg0;
            Static178.aClass247_1 = Static403.aClass247_2;
        }
        @Pc(53) int local53;
        if (Static403.aClass247_2 == Static178.aClass247_1) {
            @Pc(36) byte[] local36 = js5.CUTSCENES.getfile(arg0);
            if (local36 == null) {
                return false;
            }
            @Pc(46) Packet local46 = new Packet(local36);
            Static12.method5164(local46);
            local53 = local46.g1();
            for (@Pc(55) int local55 = 0; local55 < local53; local55++) {
                Static391.A_DEQUE___34.addLast(new Node_Sub35(local46));
            }
            @Pc(78) int local78 = local46.gsmart();
            Static75.aClass357Array2 = new Class357[local78];
            for (@Pc(83) int local83 = 0; local83 < local78; local83++) {
                Static75.aClass357Array2[local83] = new Class357(local46);
            }
            @Pc(108) int local108 = local46.gsmart();
            Static219.aClass236Array1 = new Class236[local108];
            for (@Pc(113) int local113 = 0; local113 < local108; local113++) {
                Static219.aClass236Array1[local113] = new Class236(local46, local113);
            }
            @Pc(139) int local139 = local46.gsmart();
            Static507.aClass394Array1 = new Class394[local139];
            for (@Pc(144) int local144 = 0; local144 < local139; local144++) {
                Static507.aClass394Array1[local144] = new Class394(local46);
            }
            @Pc(169) int local169 = local46.gsmart();
            Static183.aClass231Array1 = new Class231[local169];
            for (@Pc(174) int local174 = 0; local174 < local169; local174++) {
                Static183.aClass231Array1[local174] = new Class231(local46);
            }
            @Pc(195) int local195 = local46.gsmart();
            Static401.aCutsceneActionArray1 = new CutsceneAction[local195];
            for (@Pc(200) int local200 = 0; local200 < local195; local200++) {
                Static401.aCutsceneActionArray1[local200] = Static235.method3425(local46);
            }
            Static178.aClass247_1 = Static403.aClass247_3;
        }
        if (Static178.aClass247_1 == Static403.aClass247_3) {
            @Pc(227) boolean local227 = true;
            @Pc(229) CutsceneAction[] local229 = Static401.aCutsceneActionArray1;
            for (local53 = 0; local53 < local229.length; local53++) {
                @Pc(237) CutsceneAction local237 = local229[local53];
                if (!local237.method9158()) {
                    local227 = false;
                }
            }
            if (!local227) {
                return false;
            }
            Static178.aClass247_1 = Static403.aClass247_4;
        }
        return true;
    }

    @OriginalMember(owner = "client!lg", name = "a", descriptor = "(Lclient!ca;IZBI)V")
    public static void method5232(@OriginalArg(0) PlayerEntity arg0, @OriginalArg(1) int arg1, @OriginalArg(4) int arg2) {
        @Pc(10) int local10 = arg0.pathX[0];
        @Pc(15) int local15 = arg0.pathY[0];
        if (local10 < 0 || local10 >= Static720.mapWidth || local15 < 0 || Static501.mapHeight <= local15 || (arg1 < 0 || arg1 >= Static720.mapWidth || arg2 < 0 || Static501.mapHeight <= arg2)) {
            return;
        }
        @Pc(76) int local76 = Static521.method6870(arg2, arg0.boundSize((byte) 65), true, 0, local10, 0, Static480.anIntArray583, 0, local15, -4, Static577.A_COLLISION_MAP_ARRAY_1[arg0.level], Static70.anIntArray147, arg1, 0);
        if (local76 >= 1 && local76 <= 3) {
            for (@Pc(92) int local92 = 0; local92 < local76 - 1; local92++) {
                arg0.method1418(Static480.anIntArray583[local92], Static70.anIntArray147[local92], (byte) 2);
            }
        }
    }

}
