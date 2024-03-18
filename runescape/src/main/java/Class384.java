import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vga")
public final class Class384 {

    @OriginalMember(owner = "client!vga", name = "l", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_219 = new ReferenceCache(64);

    @OriginalMember(owner = "client!vga", name = "k", descriptor = "Lclient!sb;")
    public final js5 aJs5_120;

    @OriginalMember(owner = "client!vga", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class384(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_120 = arg2;
        this.aJs5_120.method7608(31);
    }

    @OriginalMember(owner = "client!vga", name = "b", descriptor = "(I)V")
    public void method8812() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_219;
        synchronized (this.aReferenceCache_219) {
            this.aReferenceCache_219.reset();
        }
    }

    @OriginalMember(owner = "client!vga", name = "a", descriptor = "(II)V")
    public void method8813() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_219;
        synchronized (this.aReferenceCache_219) {
            this.aReferenceCache_219.clean(5);
        }
    }

    @OriginalMember(owner = "client!vga", name = "a", descriptor = "(IB)Lclient!vt;")
    public Class392 method8814(@OriginalArg(0) int arg0) {
        @Pc(13) ReferenceCache local13 = this.aReferenceCache_219;
        @Pc(23) Class392 local23;
        synchronized (this.aReferenceCache_219) {
            local23 = (Class392) this.aReferenceCache_219.get((long) arg0);
        }
        if (local23 != null) {
            return local23;
        }
        @Pc(37) js5 local37 = this.aJs5_120;
        @Pc(46) byte[] local46;
        synchronized (this.aJs5_120) {
            local46 = this.aJs5_120.getfile(arg0, 31);
        }
        local23 = new Class392();
        if (local46 != null) {
            local23.method9006(new Packet(local46));
        }
        @Pc(70) ReferenceCache local70 = this.aReferenceCache_219;
        synchronized (this.aReferenceCache_219) {
            this.aReferenceCache_219.put(local23, (long) arg0);
            return local23;
        }
    }

    @OriginalMember(owner = "client!vga", name = "a", descriptor = "(B)V")
    public void method8815() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_219;
        synchronized (this.aReferenceCache_219) {
            this.aReferenceCache_219.removeSoftReferences();
        }
    }
}
