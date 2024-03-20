import com.jagex.graphics.particles.ParticleLimits;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static257 {

    @OriginalMember(owner = "client!hv", name = "f", descriptor = "[Z")
    public static final boolean[] aBooleanArray6 = new boolean[8];

    @OriginalMember(owner = "client!hv", name = "t", descriptor = "[Z")
    public static final boolean[] aBooleanArray7 = new boolean[32];

    @OriginalMember(owner = "client!hv", name = "b", descriptor = "(IZ)Lclient!hv;")
    public static ParticleSystem method3654(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        if (ParticleManager.systemFreePtr == ParticleManager.systemNextPtr) {
            return new ParticleSystem(arg0, arg1);
        } else {
            @Pc(6) ParticleSystem local6 = ParticleManager.systemCache[ParticleManager.systemNextPtr];
            ParticleManager.systemNextPtr = ParticleManager.systemNextPtr + 1 & ParticleLimits.anIntArray265[ParticleManager.setting];
            local6.method3657(arg0, arg1);
            return local6;
        }
    }
}
