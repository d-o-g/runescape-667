import com.jagex.core.util.SystemTimer;
import com.jagex.graphics.Toolkit;
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

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(JILclient!ha;)V")
    public static void method2421(@OriginalArg(0) long clock, @OriginalArg(2) Toolkit arg1) {
        anInt6869 = particleCount;
        emitterCount = 0;
        runningParticleCount = 0;
        particleCount = 0;

        @Pc(16) long before = SystemTimer.safetime();

        for (@Pc(21) ParticleSystem system = (ParticleSystem) ParticleSystem.systems.first(); system != null; system = (ParticleSystem) ParticleSystem.systems.next()) {
            if (system.isRunning(arg1, clock)) {
                runningParticleCount++;
            }
        }

        if (debug && ((clock % 100L) == 0L)) {
            System.out.println("Particle system count: " + ParticleSystem.systems.size() + ", running: " + runningParticleCount);
            System.out.println("Emitters: " + emitterCount + " Particles: " + particleCount + ". Time taken: " + (SystemTimer.safetime() - before) + "ms");
        }
    }

    private ParticleManager() {
        /* empty */
    }
}
