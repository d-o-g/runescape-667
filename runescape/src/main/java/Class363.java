import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!u")
public final class Class363 {

    @OriginalMember(owner = "client!u", name = "d", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache_201 = new ReferenceCache(64);

    @OriginalMember(owner = "client!u", name = "n", descriptor = "Lclient!dla;")
    public ReferenceCache aReferenceCache_202 = new ReferenceCache(64);

    @OriginalMember(owner = "client!u", name = "q", descriptor = "Lclient!sb;")
    public final js5 aJs5_116;

    @OriginalMember(owner = "client!u", name = "c", descriptor = "Lclient!sb;")
    public final js5 aJs5_115;

    @OriginalMember(owner = "client!u", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class363(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3) {
        this.aJs5_116 = arg3;
        this.aJs5_115 = arg2;
        this.aJs5_115.fileLimit(34);
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(B)V")
    public void method8360() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_201;
        synchronized (this.aReferenceCache_201) {
            this.aReferenceCache_201.removeSoftReferences();
        }
        local2 = this.aReferenceCache_202;
        synchronized (this.aReferenceCache_202) {
            this.aReferenceCache_202.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!u", name = "b", descriptor = "(I)V")
    public void method8361() {
        @Pc(10) ReferenceCache local10 = this.aReferenceCache_201;
        synchronized (this.aReferenceCache_201) {
            this.aReferenceCache_201.reset();
        }
        local10 = this.aReferenceCache_202;
        synchronized (this.aReferenceCache_202) {
            this.aReferenceCache_202.reset();
        }
    }

    @OriginalMember(owner = "client!u", name = "b", descriptor = "(II)Lclient!ia;")
    public Class173 method8362(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_201;
        @Pc(16) Class173 local16;
        synchronized (this.aReferenceCache_201) {
            local16 = (Class173) this.aReferenceCache_201.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_115;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_115) {
            local39 = this.aJs5_115.getfile(arg0, 34);
        }
        local16 = new Class173();
        local16.aClass363_2 = this;
        if (local39 != null) {
            local16.method3694(new Packet(local39));
        }
        @Pc(68) ReferenceCache local68 = this.aReferenceCache_201;
        synchronized (this.aReferenceCache_201) {
            this.aReferenceCache_201.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(III)V")
    public void method8365(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        this.aReferenceCache_201 = new ReferenceCache(arg1);
        this.aReferenceCache_202 = new ReferenceCache(arg0);
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(II)V")
    public void method8367() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_201;
        synchronized (this.aReferenceCache_201) {
            this.aReferenceCache_201.clean(5);
        }
        local6 = this.aReferenceCache_202;
        synchronized (this.aReferenceCache_202) {
            this.aReferenceCache_202.clean(5);
        }
    }
}
