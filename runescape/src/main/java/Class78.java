import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dg")
public final class Class78 {

    @OriginalMember(owner = "client!dg", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_45 = new ReferenceCache(16);

    @OriginalMember(owner = "client!dg", name = "h", descriptor = "Lclient!sb;")
    public final js5 aJs5_17;

    @OriginalMember(owner = "client!dg", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class78(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_17 = arg2;
        this.aJs5_17.method7608(30);
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(II)Lclient!afa;")
    public Class10 method2051(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_45;
        @Pc(16) Class10 local16;
        synchronized (this.aReferenceCache_45) {
            local16 = (Class10) this.aReferenceCache_45.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_17;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_17) {
            local39 = this.aJs5_17.getfile(arg0, 30);
        }
        local16 = new Class10();
        if (local39 != null) {
            local16.method131(new Packet(local39));
        }
        @Pc(63) ReferenceCache local63 = this.aReferenceCache_45;
        synchronized (this.aReferenceCache_45) {
            this.aReferenceCache_45.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(I)V")
    public void method2052() {
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_45;
        synchronized (this.aReferenceCache_45) {
            this.aReferenceCache_45.reset();
        }
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(B)V")
    public void method2053() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_45;
        synchronized (this.aReferenceCache_45) {
            this.aReferenceCache_45.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(IB)V")
    public void method2055() {
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_45;
        synchronized (this.aReferenceCache_45) {
            this.aReferenceCache_45.clean(5);
        }
    }
}
