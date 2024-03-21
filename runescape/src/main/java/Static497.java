import com.jagex.collect.key.HashTable;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static497 {

    @OriginalMember(owner = "client!pla", name = "E", descriptor = "Z")
    public static boolean aBoolean564;

    @OriginalMember(owner = "client!pla", name = "i", descriptor = "Lclient!av;")
    public static HashTable stacks = new HashTable(64);

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(ILclient!ha;)V")
    public static void method6623(@OriginalArg(1) Toolkit arg0) {
        for (@Pc(6) ParticleSystem local6 = (ParticleSystem) ParticleManager.systems.first(); local6 != null; local6 = (ParticleSystem) ParticleManager.systems.next()) {
            if (local6.aBoolean325) {
                local6.method3646(arg0);
            }
        }
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(ILclient!wj;)I")
    public static int method6629(@OriginalArg(1) Class8_Sub2_Sub1_Sub2_Sub2 arg0) {
        @Pc(6) NPCType local6 = arg0.aNPCType_1;
        if (local6.multinpcs != null) {
            local6 = local6.getMultiNPC(65535, Static34.aClass304_1);
            if (local6 == null) {
                return -1;
            }
        }
        @Pc(22) int local22 = local6.walkSound;
        @Pc(32) BASType local32 = arg0.method9317();
        @Pc(37) int local37 = arg0.aAnimator_10.getAnimationId();
        if (local37 == -1 || arg0.aBoolean817) {
            local22 = local6.readySound;
        } else if (local32.run == local37 || local32.runFollowTurn180 == local37 || local32.runFollowTurnCw == local37 || local37 == local32.runFollowTurnCcw) {
            local22 = local6.runSound;
        } else if (local32.crawl == local37 || local37 == local32.crawlFollowTurn180 || local32.crawlFollowTurnCw == local37 || local32.crawlFollowTurnCcw == local37) {
            local22 = local6.crawlSound;
        }
        return local22;
    }
}
