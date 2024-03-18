import com.jagex.collect.ref.ReferenceCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!al")
public final class Class17 {

    @OriginalMember(owner = "client!al", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_11 = new ReferenceCache(64);

    @OriginalMember(owner = "client!al", name = "g", descriptor = "Lclient!sb;")
    public final Class330 aClass330_2;

    @OriginalMember(owner = "client!al", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class17(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2) {
        this.aClass330_2 = arg2;
        if (this.aClass330_2 != null) {
            this.aClass330_2.method7608(54);
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(II)Lclient!sla;")
    public Class341 method263(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_11;
        @Pc(16) Class341 local16;
        synchronized (this.aReferenceCache_11) {
            local16 = (Class341) this.aReferenceCache_11.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) Class330 local30 = this.aClass330_2;
        @Pc(39) byte[] local39;
        synchronized (this.aClass330_2) {
            local39 = this.aClass330_2.method7595(arg0, 54);
        }
        local16 = new Class341();
        if (local39 != null) {
            local16.method7763(new Packet(local39));
        }
        @Pc(63) ReferenceCache local63 = this.aReferenceCache_11;
        synchronized (this.aReferenceCache_11) {
            this.aReferenceCache_11.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(I)V")
    public void method266() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_11;
        synchronized (this.aReferenceCache_11) {
            this.aReferenceCache_11.clearSoft();
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(IB)V")
    public void method267() {
        @Pc(11) ReferenceCache local11 = this.aReferenceCache_11;
        synchronized (this.aReferenceCache_11) {
            this.aReferenceCache_11.clean(5);
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(B)V")
    public void method269() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_11;
        synchronized (this.aReferenceCache_11) {
            this.aReferenceCache_11.reset();
        }
    }
}
