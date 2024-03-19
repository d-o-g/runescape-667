import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nv")
public final class Class267 {

    @OriginalMember(owner = "client!nv", name = "e", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_142 = new ReferenceCache(64);

    @OriginalMember(owner = "client!nv", name = "g", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_143 = new ReferenceCache(2);

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_88;

    @OriginalMember(owner = "client!nv", name = "d", descriptor = "Lclient!sb;")
    public final js5 aJs5_89;

    @OriginalMember(owner = "client!nv", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class267(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3) {
        this.aJs5_88 = arg3;
        this.aJs5_89 = arg2;
        this.aJs5_89.fileLimit(33);
    }

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "(II)V")
    public void method5970() {
        @Pc(11) ReferenceCache local11 = this.aReferenceCache_142;
        synchronized (this.aReferenceCache_142) {
            this.aReferenceCache_142.clean(5);
        }
        local11 = this.aReferenceCache_143;
        synchronized (this.aReferenceCache_143) {
            this.aReferenceCache_143.clean(5);
        }
    }

    @OriginalMember(owner = "client!nv", name = "a", descriptor = "(B)V")
    public void method5972() {
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_142;
        synchronized (this.aReferenceCache_142) {
            this.aReferenceCache_142.removeSoftReferences();
        }
        local9 = this.aReferenceCache_143;
        synchronized (this.aReferenceCache_143) {
            this.aReferenceCache_143.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!nv", name = "a", descriptor = "(II)Lclient!vla;")
    public Class389 method5973(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_142;
        @Pc(18) Class389 local18;
        synchronized (this.aReferenceCache_142) {
            local18 = (Class389) this.aReferenceCache_142.get((long) arg0);
        }
        if (local18 != null) {
            return local18;
        }
        @Pc(32) js5 local32 = this.aJs5_89;
        @Pc(41) byte[] local41;
        synchronized (this.aJs5_89) {
            local41 = this.aJs5_89.getfile(arg0, 33);
        }
        local18 = new Class389();
        local18.aClass267_2 = this;
        if (local41 != null) {
            local18.method8935(new Packet(local41));
        }
        @Pc(70) ReferenceCache local70 = this.aReferenceCache_142;
        synchronized (this.aReferenceCache_142) {
            this.aReferenceCache_142.put(local18, (long) arg0);
            return local18;
        }
    }

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "(B)V")
    public void method5974() {
        @Pc(7) ReferenceCache local7 = this.aReferenceCache_142;
        synchronized (this.aReferenceCache_142) {
            this.aReferenceCache_142.reset();
        }
        local7 = this.aReferenceCache_143;
        synchronized (this.aReferenceCache_143) {
            this.aReferenceCache_143.reset();
        }
    }
}
