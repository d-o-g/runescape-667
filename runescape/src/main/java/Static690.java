import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.graphics.particles.ParticleLimits;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static690 {

    @OriginalMember(owner = "client!vr", name = "b", descriptor = "Lclient!ql;")
    public static NPCTypeList aNPCTypeList_2;

    @OriginalMember(owner = "client!vr", name = "e", descriptor = "J")
    public static long aLong318;

    @OriginalMember(owner = "client!vr", name = "c", descriptor = "Lclient!dfa;")
    public static final Class77 aClass77_7 = new Class77();

    @OriginalMember(owner = "client!vr", name = "a", descriptor = "(II)V")
    public static void method8996(@OriginalArg(0) int arg0) {
        if (arg0 < 0 || arg0 > 2) {
            arg0 = 0;
        }
        ParticleSystem.setting = arg0;
        ParticleSystem.systemCache = new ParticleSystem[ParticleLimits.anIntArray265[ParticleSystem.setting] + 1];
        ParticleSystem.systemNextPtr = 0;
        ParticleSystem.systemFreePtr = 0;
    }

    @OriginalMember(owner = "client!vr", name = "a", descriptor = "(Z)Ljava/lang/String;")
    public static String method8998() {
        return MiniMenu.open || Static470.aClass2_Sub2_Sub16_10 == null ? "" : Static470.aClass2_Sub2_Sub16_10.aString87;
    }
}
