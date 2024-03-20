import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!al")
public final class Class17 {

    @OriginalMember(owner = "client!al", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_11 = new ReferenceCache(64);

    @OriginalMember(owner = "client!al", name = "g", descriptor = "Lclient!sb;")
    public final js5 aJs5_2;

    @OriginalMember(owner = "client!al", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class17(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_2 = arg2;
        if (this.aJs5_2 != null) {
            this.aJs5_2.fileLimit(54);
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(II)Lclient!sla;")
    public Class341 method263(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_11;
        @Pc(16) Class341 local16;
        synchronized (this.aReferenceCache_11) {
            local16 = (Class341) this.aReferenceCache_11.get((long) id);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_2;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_2) {
            local39 = this.aJs5_2.getfile(id, 54);
        }
        local16 = new Class341();
        if (local39 != null) {
            local16.method7763(new Packet(local39));
        }
        @Pc(63) ReferenceCache local63 = this.aReferenceCache_11;
        synchronized (this.aReferenceCache_11) {
            this.aReferenceCache_11.put(local16, (long) id);
            return local16;
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(I)V")
    public void method266() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_11;
        synchronized (this.aReferenceCache_11) {
            this.aReferenceCache_11.removeSoftReferences();
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
