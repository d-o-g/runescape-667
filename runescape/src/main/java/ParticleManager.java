import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.datastruct.key.HashTable;
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

    @OriginalMember(owner = "client!qfa", name = "n", descriptor = "Lclient!gga;")
    public static HashTable<ParticleEffector> effectorsCache = new HashTable<>(8);

    @OriginalMember(owner = "client!kp", name = "w", descriptor = "Lclient!fla;")
    public static LinkedList systemsCache;

    @OriginalMember(owner = "client!nga", name = "d", descriptor = "I")
    public static int emitterCount = 0;

    @OriginalMember(owner = "client!dia", name = "n", descriptor = "I")
    public static int runningParticleCount = 0;

    @OriginalMember(owner = "client!qm", name = "a", descriptor = "I")
    public static int particleCount = 0;

    @OriginalMember(owner = "client!pw", name = "G", descriptor = "I")
    public static int option = 2;

    @OriginalMember(owner = "client!jga", name = "l", descriptor = "I")
    public static int systemNextPtr = 0;

    @OriginalMember(owner = "client!kw", name = "y", descriptor = "I")
    public static int systemFreePtr = 0;

    @OriginalMember(owner = "client!rka", name = "Ob", descriptor = "I")
    public static int particleFreePtr = 0;

    @OriginalMember(owner = "client!sv", name = "L", descriptor = "I")
    public static int particleNextPtr = 0;

    @OriginalMember(owner = "client!cka", name = "x", descriptor = "[Lclient!hv;")
    public static ParticleSystem[] systems;

    @OriginalMember(owner = "client!qv", name = "e", descriptor = "[Lclient!pp;")
    public static MovingParticle[] particles;

    @OriginalMember(owner = "client!ula", name = "F", descriptor = "I")
    public static int effectorCount = 0;

    @OriginalMember(owner = "client!oea", name = "v", descriptor = "I")
    public static int previousParticleCount = 0;

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(JILclient!ha;)V")
    public static void tick(@OriginalArg(0) long clock, @OriginalArg(2) Toolkit toolkit) {
        previousParticleCount = particleCount;

        emitterCount = 0;
        runningParticleCount = 0;
        particleCount = 0;

        @Pc(16) long startTime = SystemTimer.safetime();

        for (@Pc(21) ParticleSystem system = (ParticleSystem) systemsCache.first(); system != null; system = (ParticleSystem) systemsCache.next()) {
            if (system.tick(toolkit, clock)) {
                runningParticleCount++;
            }
        }

        if (debug && ((clock % 100L) == 0L)) {
            System.out.println("Particle system count: " + systemsCache.size() + ", running: " + runningParticleCount);
            System.out.println("Emitters: " + emitterCount + " Particles: " + particleCount + ". Time taken: " + (SystemTimer.safetime() - startTime) + "ms");
        }
    }

    @OriginalMember(owner = "client!vr", name = "a", descriptor = "(II)V")
    public static void setOption(@OriginalArg(0) int option) {
        if (option < 0 || option > 2) {
            option = 0;
        }

        ParticleManager.option = option;
        ParticleManager.systems = new ParticleSystem[ParticleLimits.SYSTEMS[ParticleManager.option] + 1];
        ParticleManager.systemNextPtr = 0;
        ParticleManager.systemFreePtr = 0;
    }

    @OriginalMember(owner = "client!fp", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void init(@OriginalArg(0) js5 configClient) {
        particleFreePtr = 0;
        particleNextPtr = 0;
        systemsCache = new LinkedList();
        particles = new MovingParticle[1024];
        systems = new ParticleSystem[ParticleLimits.SYSTEMS[option] + 1];
        systemFreePtr = 0;
        systemNextPtr = 0;
        ParticleEmitterTypeList.setConfigClient(configClient);
        ParticleEffectorTypeList.setConfigClient(configClient);
    }

    @OriginalMember(owner = "client!df", name = "b", descriptor = "(I)V")
    public static void method2044() {
        effectorsCache = new HashTable<>(8);
        effectorCount = 0;

        for (@Pc(20) ParticleSystem system = (ParticleSystem) systemsCache.first(); system != null; system = (ParticleSystem) systemsCache.next()) {
            system.remove();
        }
    }

    private ParticleManager() {
        /* empty */
    }

    @OriginalMember(owner = "client!no", name = "c", descriptor = "(I)I")
    public static int getOption() {
        return option;
    }
}
