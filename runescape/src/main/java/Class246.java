import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ml")
public final class Class246 {

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache_134 = new ReferenceCache(128);

    @OriginalMember(owner = "client!ml", name = "o", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache_135 = new ReferenceCache(64);

    @OriginalMember(owner = "client!ml", name = "n", descriptor = "Lclient!sb;")
    public final js5 aJs5_83;

    @OriginalMember(owner = "client!ml", name = "g", descriptor = "Lclient!sb;")
    public final js5 aJs5_82;

    @OriginalMember(owner = "client!ml", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class246(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3) {
        this.aJs5_83 = arg3;
        this.aJs5_82 = arg2;
        this.aJs5_82.method7608(36);
    }

    @OriginalMember(owner = "client!ml", name = "b", descriptor = "(II)V")
    public void method5581() {
        @Pc(12) ReferenceCache local12 = this.aReferenceCache_134;
        synchronized (this.aReferenceCache_134) {
            this.aReferenceCache_134.clean(5);
        }
        local12 = this.aReferenceCache_135;
        synchronized (this.aReferenceCache_135) {
            this.aReferenceCache_135.clean(5);
        }
    }

    @OriginalMember(owner = "client!ml", name = "b", descriptor = "(III)V")
    public void method5583(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        this.aReferenceCache_134 = new ReferenceCache(arg0);
        this.aReferenceCache_135 = new ReferenceCache(arg1);
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(BI)Lclient!el;")
    public Class105 method5584(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_134;
        @Pc(16) Class105 local16;
        synchronized (this.aReferenceCache_134) {
            local16 = (Class105) this.aReferenceCache_134.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_82;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_82) {
            local39 = this.aJs5_82.getfile(arg0, 36);
        }
        local16 = new Class105();
        local16.aClass246_2 = this;
        local16.anInt2590 = arg0;
        if (local39 != null) {
            local16.method2423(new Packet(local39));
        }
        local16.method2430();
        @Pc(72) ReferenceCache local72 = this.aReferenceCache_134;
        synchronized (this.aReferenceCache_134) {
            this.aReferenceCache_134.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(I)V")
    public void method5585() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_134;
        synchronized (this.aReferenceCache_134) {
            this.aReferenceCache_134.removeSoftReferences();
        }
        local6 = this.aReferenceCache_135;
        synchronized (this.aReferenceCache_135) {
            this.aReferenceCache_135.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ml", name = "b", descriptor = "(I)V")
    public void method5586() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_134;
        synchronized (this.aReferenceCache_134) {
            this.aReferenceCache_134.reset();
        }
        local6 = this.aReferenceCache_135;
        synchronized (this.aReferenceCache_135) {
            this.aReferenceCache_135.reset();
        }
    }
}
