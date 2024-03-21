import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nh")
public final class Class260 {

    @OriginalMember(owner = "client!nh", name = "j", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_138 = new ReferenceCache(64);

    @OriginalMember(owner = "client!nh", name = "f", descriptor = "Lclient!sb;")
    public final js5 aJs5_86;

    @OriginalMember(owner = "client!nh", name = "d", descriptor = "I")
    public final int anInt6462;

    @OriginalMember(owner = "client!nh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class260(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_86 = arg2;
        if (this.aJs5_86 == null) {
            this.anInt6462 = 0;
        } else {
            this.anInt6462 = this.aJs5_86.fileLimit(16);
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(Z)V")
    public void method5781() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_138;
        synchronized (this.aReferenceCache_138) {
            this.aReferenceCache_138.removeSoftReferences();
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
        @Pc(30) js5 local30 = this.aJs5_86;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_86) {
            local39 = this.aJs5_86.getfile(arg0, 16);
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
            this.aReferenceCache_138.clean(5);
        }
    }
}
