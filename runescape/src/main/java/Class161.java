import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hf")
public final class Class161 {

    @OriginalMember(owner = "client!hf", name = "c", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache = new ReferenceCache(64);

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "Lclient!sb;")
    public final js5 aJs5_53;

    @OriginalMember(owner = "client!hf", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class161(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_53 = arg2;
        if (this.aJs5_53 != null) {
            @Pc(20) int local20 = this.aJs5_53.method7597() - 1;
            this.aJs5_53.method7608(local20);
        }
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(II)V")
    public void method3420(@OriginalArg(1) int arg0) {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache;
        synchronized (this.aReferenceCache) {
            this.aReferenceCache.reset();
            this.aReferenceCache = new ReferenceCache(arg0);
        }
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(I)V")
    public void method3423() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache;
        synchronized (this.aReferenceCache) {
            this.aReferenceCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!hf", name = "c", descriptor = "(II)Lclient!eea;")
    public Class95 method3426(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache;
        @Pc(16) Class95 local16;
        synchronized (this.aReferenceCache) {
            local16 = (Class95) this.aReferenceCache.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(40) js5 local40 = this.aJs5_53;
        @Pc(53) byte[] local53;
        synchronized (this.aJs5_53) {
            local53 = this.aJs5_53.getfile(Static322.method9443(arg0), Static516.method6806(arg0));
        }
        local16 = new Class95();
        if (local53 != null) {
            local16.method2346(new Packet(local53));
        }
        @Pc(77) ReferenceCache local77 = this.aReferenceCache;
        synchronized (this.aReferenceCache) {
            this.aReferenceCache.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!hf", name = "b", descriptor = "(II)V")
    public void method3428() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache;
        synchronized (this.aReferenceCache) {
            this.aReferenceCache.clean(5);
        }
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(B)V")
    public void method3429() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache;
        synchronized (this.aReferenceCache) {
            this.aReferenceCache.reset();
        }
    }
}
