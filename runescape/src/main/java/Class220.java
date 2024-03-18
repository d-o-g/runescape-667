import com.jagex.collect.ref.ReferenceCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ld")
public final class Class220 {

    @OriginalMember(owner = "client!ld", name = "n", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_121 = new ReferenceCache(20);

    @OriginalMember(owner = "client!ld", name = "d", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_122 = new ReferenceCache(64);

    @OriginalMember(owner = "client!ld", name = "l", descriptor = "Lclient!sb;")
    public final js5 aJs5_75;

    @OriginalMember(owner = "client!ld", name = "g", descriptor = "Lclient!sb;")
    public final js5 aJs5_76;

    @OriginalMember(owner = "client!ld", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class220(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3) {
        this.aJs5_75 = arg2;
        this.aJs5_76 = arg3;
        this.aJs5_75.method7608(46);
    }

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(I)V")
    public void method5182() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_122;
        synchronized (this.aReferenceCache_122) {
            this.aReferenceCache_122.reset();
        }
        local2 = this.aReferenceCache_121;
        synchronized (this.aReferenceCache_121) {
            this.aReferenceCache_121.reset();
        }
    }

    @OriginalMember(owner = "client!ld", name = "b", descriptor = "(I)V")
    public void method5183() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_122;
        synchronized (this.aReferenceCache_122) {
            this.aReferenceCache_122.removeSoftReferences();
        }
        local2 = this.aReferenceCache_121;
        synchronized (this.aReferenceCache_121) {
            this.aReferenceCache_121.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(II)V")
    public void method5184() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_122;
        synchronized (this.aReferenceCache_122) {
            this.aReferenceCache_122.clean(5);
        }
        local6 = this.aReferenceCache_121;
        synchronized (this.aReferenceCache_121) {
            this.aReferenceCache_121.clean(5);
        }
    }

    @OriginalMember(owner = "client!ld", name = "b", descriptor = "(II)Lclient!pb;")
    public Class285 method5186(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_122;
        @Pc(16) Class285 local16;
        synchronized (this.aReferenceCache_122) {
            local16 = (Class285) this.aReferenceCache_122.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_75;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_75) {
            local39 = this.aJs5_75.method7595(arg0, 46);
        }
        local16 = new Class285();
        local16.aClass220_1 = this;
        if (local39 != null) {
            local16.method6458(new Packet(local39));
        }
        @Pc(66) ReferenceCache local66 = this.aReferenceCache_122;
        synchronized (this.aReferenceCache_122) {
            this.aReferenceCache_122.put(local16, (long) arg0);
            return local16;
        }
    }
}
