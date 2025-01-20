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
            @Pc(36) byte[] data = js5.CUTSCENES.getfile(arg0);
            if (data == null) {
                return false;
            }

            @Pc(46) Packet packet = new Packet(data);
            Static12.method5164(packet);
            local53 = packet.g1();
            for (@Pc(55) int local55 = 0; local55 < local53; local55++) {
                Static391.A_DEQUE___34.addLast(new Node_Sub35(packet));
            }
            @Pc(78) int local78 = packet.gsmart();
            Camera.cutsceneSplines = new ScriptedCameraPath[local78];
            for (@Pc(83) int local83 = 0; local83 < local78; local83++) {
                Camera.cutsceneSplines[local83] = new ScriptedCameraPath(packet);
            }
            @Pc(108) int local108 = packet.gsmart();
            CutsceneManager.actors = new Actor[local108];
            for (@Pc(113) int local113 = 0; local113 < local108; local113++) {
                CutsceneManager.actors[local113] = new Actor(packet, local113);
            }
            @Pc(139) int local139 = packet.gsmart();
            Static507.aClass394Array1 = new Class394[local139];
            for (@Pc(144) int local144 = 0; local144 < local139; local144++) {
                Static507.aClass394Array1[local144] = new Class394(packet);
            }
            @Pc(169) int local169 = packet.gsmart();
            Static183.aClass231Array1 = new Class231[local169];
            for (@Pc(174) int local174 = 0; local174 < local169; local174++) {
                Static183.aClass231Array1[local174] = new Class231(packet);
            }
            @Pc(195) int local195 = packet.gsmart();
            Static401.aCutsceneActionArray1 = new CutsceneAction[local195];
            for (@Pc(200) int local200 = 0; local200 < local195; local200++) {
                Static401.aCutsceneActionArray1[local200] = CutsceneAction.decode(packet);
            }
            Static178.aClass247_1 = Static403.aClass247_3;
        }
        if (Static178.aClass247_1 == Static403.aClass247_3) {
            @Pc(227) boolean local227 = true;
            @Pc(229) CutsceneAction[] local229 = Static401.aCutsceneActionArray1;
            for (local53 = 0; local53 < local229.length; local53++) {
                @Pc(237) CutsceneAction local237 = local229[local53];
                if (!local237.ready()) {
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

}
