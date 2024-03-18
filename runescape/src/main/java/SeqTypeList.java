import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bp")
public final class SeqTypeList {

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_22 = new ReferenceCache(64);

    @OriginalMember(owner = "client!bp", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_23 = new ReferenceCache(100);

    @OriginalMember(owner = "client!bp", name = "j", descriptor = "Lclient!sb;")
    public final js5 aJs5_11;

    @OriginalMember(owner = "client!bp", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;Lclient!sb;)V")
    public SeqTypeList(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3, @OriginalArg(4) js5 arg4) {
        this.aJs5_11 = arg2;
        if (this.aJs5_11 != null) {
            @Pc(26) int local26 = this.aJs5_11.method7597() - 1;
            this.aJs5_11.method7608(local26);
        }
        Static642.method8440(arg4, arg3);
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(IB)Lclient!cka;")
    public SeqType list(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_22;
        @Pc(16) SeqType local16;
        synchronized (this.aReferenceCache_22) {
            local16 = (SeqType) this.aReferenceCache_22.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_11;
        @Pc(43) byte[] local43;
        synchronized (this.aJs5_11) {
            local43 = this.aJs5_11.method7595(Static668.method8702(arg0), Static291.method4226(arg0));
        }
        local16 = new SeqType();
        local16.id = arg0;
        if (local43 != null) {
            local16.method1585(new Packet(local43));
        }
        local16.method1584();
        @Pc(73) ReferenceCache local73 = this.aReferenceCache_22;
        synchronized (this.aReferenceCache_22) {
            this.aReferenceCache_22.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(II)V")
    public void method1163() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_22;
        synchronized (this.aReferenceCache_22) {
            this.aReferenceCache_22.clean(5);
        }
        local6 = this.aReferenceCache_23;
        synchronized (this.aReferenceCache_23) {
            this.aReferenceCache_23.clean(5);
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(I)V")
    public void method1164() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_22;
        synchronized (this.aReferenceCache_22) {
            this.aReferenceCache_22.removeSoftReferences();
        }
        local2 = this.aReferenceCache_23;
        synchronized (this.aReferenceCache_23) {
            this.aReferenceCache_23.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(B)V")
    public void method1165() {
        @Pc(7) ReferenceCache local7 = this.aReferenceCache_22;
        synchronized (this.aReferenceCache_22) {
            this.aReferenceCache_22.reset();
        }
        local7 = this.aReferenceCache_23;
        synchronized (this.aReferenceCache_23) {
            this.aReferenceCache_23.reset();
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(II)Lclient!rw;")
    public AnimFrameset method1166(@OriginalArg(0) int arg0) {
        @Pc(12) ReferenceCache local12 = this.aReferenceCache_23;
        synchronized (this.aReferenceCache_23) {
            @Pc(22) AnimFrameset local22 = (AnimFrameset) this.aReferenceCache_23.get((long) arg0);
            if (local22 == null) {
                local22 = new AnimFrameset(arg0);
                this.aReferenceCache_23.put(local22, (long) arg0);
            }
            return local22.method7565() ? local22 : null;
        }
    }
}
