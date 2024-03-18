import com.jagex.collect.ref.ReferenceCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sn")
public final class Class342 {

    @OriginalMember(owner = "client!sn", name = "e", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_192 = new ReferenceCache(64);

    @OriginalMember(owner = "client!sn", name = "l", descriptor = "Lclient!sb;")
    public final Class330 aClass330_111;

    @OriginalMember(owner = "client!sn", name = "d", descriptor = "I")
    public final int anInt8769;

    @OriginalMember(owner = "client!sn", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class342(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2) {
        this.aClass330_111 = arg2;
        if (this.aClass330_111 == null) {
            this.anInt8769 = 0;
        } else {
            this.anInt8769 = this.aClass330_111.method7608(47);
        }
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(Z)V")
    public void method7783() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_192;
        synchronized (this.aReferenceCache_192) {
            this.aReferenceCache_192.reset();
        }
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(IB)V")
    public void method7784() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_192;
        synchronized (this.aReferenceCache_192) {
            this.aReferenceCache_192.clean(5);
        }
    }

    @OriginalMember(owner = "client!sn", name = "b", descriptor = "(II)Lclient!fc;")
    public Class122 method7785(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_192;
        @Pc(16) Class122 local16;
        synchronized (this.aReferenceCache_192) {
            local16 = (Class122) this.aReferenceCache_192.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) Class330 local30 = this.aClass330_111;
        @Pc(39) byte[] local39;
        synchronized (this.aClass330_111) {
            local39 = this.aClass330_111.method7595(arg0, 47);
        }
        local16 = new Class122();
        if (local39 != null) {
            local16.method2610(new Packet(local39));
        }
        @Pc(63) ReferenceCache local63 = this.aReferenceCache_192;
        synchronized (this.aReferenceCache_192) {
            this.aReferenceCache_192.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(I)V")
    public void method7787() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_192;
        synchronized (this.aReferenceCache_192) {
            this.aReferenceCache_192.clearSoft();
        }
    }
}
