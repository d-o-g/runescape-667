import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static497 {

    @OriginalMember(owner = "client!pla", name = "i", descriptor = "Lclient!av;")
    public static IterableHashTable<ObjStack> objStacks = new IterableHashTable<>(64);

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(ILclient!ha;)V")
    public static void method6623(@OriginalArg(1) Toolkit arg0) {
        for (@Pc(6) ParticleSystem local6 = (ParticleSystem) ParticleManager.systemsCache.first(); local6 != null; local6 = (ParticleSystem) ParticleManager.systemsCache.next()) {
            if (local6.aBoolean325) {
                local6.method3646(arg0);
            }
        }
    }

}
