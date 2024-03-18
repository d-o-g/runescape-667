import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nh")
public final class Class260 {

    @OriginalMember(owner = "client!nh", name = "j", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_138 = new ReferenceCache(64);

    @OriginalMember(owner = "client!nh", name = "f", descriptor = "Lclient!sb;")
    public final Class330 aClass330_86;

    @OriginalMember(owner = "client!nh", name = "d", descriptor = "I")
    public final int anInt6462;

    @OriginalMember(owner = "client!nh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class260(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2) {
        this.aClass330_86 = arg2;
        if (this.aClass330_86 == null) {
            this.anInt6462 = 0;
        } else {
            this.anInt6462 = this.aClass330_86.method7608(16);
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(Z)V")
    public void method5781() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_138;
        synchronized (this.aReferenceCache_138) {
            this.aReferenceCache_138.method2151();
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(II)Lclient!rha;")
    public Class321 method5782(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_138;
        @Pc(16) Class321 local16;
        synchronized (this.aReferenceCache_138) {
            local16 = (Class321) this.aReferenceCache_138.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) Class330 local30 = this.aClass330_86;
        @Pc(39) byte[] local39;
        synchronized (this.aClass330_86) {
            local39 = this.aClass330_86.method7595(arg0, 16);
        }
        local16 = new Class321();
        if (local39 != null) {
            local16.method7294(new Packet(local39));
        }
        @Pc(63) ReferenceCache local63 = this.aReferenceCache_138;
        synchronized (this.aReferenceCache_138) {
            this.aReferenceCache_138.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(B)V")
    public void method5784() {
        @Pc(13) ReferenceCache local13 = this.aReferenceCache_138;
        synchronized (this.aReferenceCache_138) {
            this.aReferenceCache_138.reset();
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(IB)V")
    public void method5785() {
        @Pc(11) ReferenceCache local11 = this.aReferenceCache_138;
        synchronized (this.aReferenceCache_138) {
            this.aReferenceCache_138.method2147(5);
        }
    }
}
