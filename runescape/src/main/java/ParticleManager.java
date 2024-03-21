import com.jagex.collect.LinkedList;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterTypeList;
import com.jagex.game.runetek6.config.effectortype.ParticleEffectorTypeList;
import com.jagex.graphics.particles.ParticleLimits;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class ParticleManager {

    @OriginalMember(owner = "client!rka", name = "Ob", descriptor = "I")
    public static int freePtr = 0;

    @OriginalMember(owner = "client!sv", name = "L", descriptor = "I")
    public static int nextPtr = 0;

    @OriginalMember(owner = "client!kp", name = "w", descriptor = "Lclient!fla;")
    public static LinkedList systems;

    @OriginalMember(owner = "client!qv", name = "e", descriptor = "[Lclient!pp;")
    public static MovingParticle[] cache;

    @OriginalMember(owner = "client!cka", name = "x", descriptor = "[Lclient!hv;")
    public static ParticleSystem[] systemCache;

    @OriginalMember(owner = "client!kw", name = "y", descriptor = "I")
    public static int systemFreePtr = 0;

    @OriginalMember(owner = "client!jga", name = "l", descriptor = "I")
    public static int systemNextPtr = 0;

    @OriginalMember(owner = "client!pw", name = "G", descriptor = "I")
    public static int setting = 2;

    @OriginalMember(owner = "client!fp", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void init(@OriginalArg(0) js5 configClient) {
        freePtr = 0;
        nextPtr = 0;
        systems = new LinkedList();
        cache = new MovingParticle[1024];
        systemCache = new ParticleSystem[ParticleLimits.anIntArray265[setting] + 1];
        systemFreePtr = 0;
        systemNextPtr = 0;
        ParticleEmitterTypeList.setConfigClient(configClient);
        ParticleEffectorTypeList.setConfigClient(configClient);
    }

    private ParticleManager() {
        /* empty */
    }
}
