import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.util.SystemTimer;
import com.jagex.game.runetek6.config.effectortype.ParticleEffectorTypeList;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterTypeList;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.particles.ParticleLimits;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ParticleManager {

    @OriginalMember(owner = "client!tha", name = "g", descriptor = "Z")
    public static final boolean debug = false;

    @OriginalMember(owner = "client!oea", name = "v", descriptor = "I")
    public static int anInt6869 = 0;

    @OriginalMember(owner = "client!nga", name = "d", descriptor = "I")
    public static int emitterCount = 0;

    @OriginalMember(owner = "client!dia", name = "n", descriptor = "I")
    public static int runningParticleCount = 0;

    @OriginalMember(owner = "client!qm", name = "a", descriptor = "I")
    public static int particleCount = 0;

    @OriginalMember(owner = "client!pw", name = "G", descriptor = "I")
    public static int option = 2;

    @OriginalMember(owner = "client!cka", name = "x", descriptor = "[Lclient!hv;")
    public static ParticleSystem[] systemCache;

    @OriginalMember(owner = "client!jga", name = "l", descriptor = "I")
    public static int systemNextPtr = 0;

    @OriginalMember(owner = "client!kw", name = "y", descriptor = "I")
    public static int systemFreePtr = 0;

    @OriginalMember(owner = "client!rka", name = "Ob", descriptor = "I")
    public static int particleFreePtr = 0;

    @OriginalMember(owner = "client!sv", name = "L", descriptor = "I")
    public static int particleNextPtr = 0;

    @OriginalMember(owner = "client!kp", name = "w", descriptor = "Lclient!fla;")
    public static LinkedList systems;

    @OriginalMember(owner = "client!qv", name = "e", descriptor = "[Lclient!pp;")
    public static MovingParticle[] particleCache;

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(JILclient!ha;)V")
    public static void method2421(@OriginalArg(0) long clock, @OriginalArg(2) Toolkit arg1) {
        anInt6869 = particleCount;
        emitterCount = 0;
        runningParticleCount = 0;
        particleCount = 0;

        @Pc(16) long before = SystemTimer.safetime();

        for (@Pc(21) ParticleSystem system = (ParticleSystem) systems.first(); system != null; system = (ParticleSystem) systems.next()) {
            if (system.isRunning(arg1, clock)) {
                runningParticleCount++;
            }
        }

        if (debug && ((clock % 100L) == 0L)) {
            System.out.println("Particle system count: " + systems.size() + ", running: " + runningParticleCount);
            System.out.println("Emitters: " + emitterCount + " Particles: " + particleCount + ". Time taken: " + (SystemTimer.safetime() - before) + "ms");
        }
    }

    @OriginalMember(owner = "client!vr", name = "a", descriptor = "(II)V")
    public static void setOption(@OriginalArg(0) int option) {
        if (option < 0 || option > 2) {
            option = 0;
        }

        ParticleManager.option = option;
        ParticleManager.systemCache = new ParticleSystem[ParticleLimits.anIntArray265[ParticleManager.option] + 1];
        ParticleManager.systemNextPtr = 0;
        ParticleManager.systemFreePtr = 0;
    }

    @OriginalMember(owner = "client!fp", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void init(@OriginalArg(0) js5 configClient) {
        particleFreePtr = 0;
        particleNextPtr = 0;
        systems = new LinkedList();
        particleCache = new MovingParticle[1024];
        systemCache = new ParticleSystem[ParticleLimits.anIntArray265[option] + 1];
        systemFreePtr = 0;
        systemNextPtr = 0;
        ParticleEmitterTypeList.setConfigClient(configClient);
        ParticleEffectorTypeList.setConfigClient(configClient);
    }

    private ParticleManager() {
        /* empty */
    }
}
