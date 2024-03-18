import com.jagex.collect.ref.ReferenceCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dh")
public final class Class79 {

    @OriginalMember(owner = "client!dh", name = "i", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_47 = new ReferenceCache(128);

    @OriginalMember(owner = "client!dh", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_18;

    @OriginalMember(owner = "client!dh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class79(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_18 = arg2;
        this.aJs5_18.method7608(1);
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(II)Lclient!nq;")
    public Class264 method2066(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_47;
        @Pc(18) Class264 local18;
        synchronized (this.aReferenceCache_47) {
            local18 = (Class264) this.aReferenceCache_47.get((long) arg0);
        }
        if (local18 != null) {
            return local18;
        }
        @Pc(32) js5 local32 = this.aJs5_18;
        @Pc(41) byte[] local41;
        synchronized (this.aJs5_18) {
            local41 = this.aJs5_18.method7595(arg0, 1);
        }
        local18 = new Class264();
        if (local41 != null) {
            local18.method5921(new Packet(local41));
        }
        @Pc(67) ReferenceCache local67 = this.aReferenceCache_47;
        synchronized (this.aReferenceCache_47) {
            this.aReferenceCache_47.put(local18, (long) arg0);
            return local18;
        }
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(I)V")
    public void method2067() {
        @Pc(17) ReferenceCache local17 = this.aReferenceCache_47;
        synchronized (this.aReferenceCache_47) {
            this.aReferenceCache_47.reset();
        }
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(Z)V")
    public void method2072() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_47;
        synchronized (this.aReferenceCache_47) {
            this.aReferenceCache_47.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!dh", name = "c", descriptor = "(II)V")
    public void method2073() {
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_47;
        synchronized (this.aReferenceCache_47) {
            this.aReferenceCache_47.clean(5);
        }
    }
}
