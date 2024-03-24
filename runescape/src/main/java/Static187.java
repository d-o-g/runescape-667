import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static187 {

    @OriginalMember(owner = "client!fp", name = "M", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___36 = new ClientProt(68, -1);

    @OriginalMember(owner = "client!fp", name = "R", descriptor = "I")
    public static int anInt3093 = 0;

    @OriginalMember(owner = "client!fp", name = "a", descriptor = "(Z)V")
    public static void method2842() {
        Static322.anIntArrayArray265 = null;
        CutsceneManager.cutsceneId = -1;
        Static117.anInt2282 = 0;
        Static102.anInt2129 = 0;
        CutsceneManager.state = 0;
        Static518.aClass2_Sub21_18 = null;
        Static298.method4385();
        Static525.anInt8907 = 0;
        WorldMap.areaBaseX = 0;
        WorldMap.areaBaseZ = 0;
        Static62.anInt1465 = 0;
        for (@Pc(34) int local34 = 0; local34 < Static527.aClass254Array1.length; local34++) {
            Static527.aClass254Array1[local34] = null;
        }
        Static11.method146();
        for (@Pc(48) int local48 = 0; local48 < 2048; local48++) {
            PlayerList.highResolutionPlayers[local48] = null;
        }
        NPCList.localNpcCount = 0;
        NPCList.local.clear();
        NPCList.newNpcCount = 0;
        Static497.stacks.clear();
        Static693.method9012();
        Static334.anInt5456 = 0;
        TimedVarDomain.instance.reset();
        Static91.aClass164_9 = null;
        Static128.aClass164_8 = null;
        Static211.aClass2_Sub12_3 = null;
        Static45.aClass2_Sub47_1 = null;
        Static674.aClass2_Sub47_3 = null;
        Static675.aLong307 = 0L;
    }

}
