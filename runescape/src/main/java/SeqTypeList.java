import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bp")
public final class SeqTypeList {

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "Lclient!dla;")
    public final WeightedCache aWeightedCache_22 = new WeightedCache(64);

    @OriginalMember(owner = "client!bp", name = "f", descriptor = "Lclient!dla;")
    public final WeightedCache aWeightedCache_23 = new WeightedCache(100);

    @OriginalMember(owner = "client!bp", name = "j", descriptor = "Lclient!sb;")
    public final Class330 aClass330_11;

    @OriginalMember(owner = "client!bp", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;Lclient!sb;)V")
    public SeqTypeList(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2, @OriginalArg(3) Class330 arg3, @OriginalArg(4) Class330 arg4) {
        this.aClass330_11 = arg2;
        if (this.aClass330_11 != null) {
            @Pc(26) int local26 = this.aClass330_11.method7597() - 1;
            this.aClass330_11.method7608(local26);
        }
        Static642.method8440(arg4, arg3);
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(IB)Lclient!cka;")
    public SeqType list(@OriginalArg(0) int arg0) {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_22;
        @Pc(16) SeqType local16;
        synchronized (this.aWeightedCache_22) {
            local16 = (SeqType) this.aWeightedCache_22.method2156((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) Class330 local30 = this.aClass330_11;
        @Pc(43) byte[] local43;
        synchronized (this.aClass330_11) {
            local43 = this.aClass330_11.method7595(Static668.method8702(arg0), Static291.method4226(arg0));
        }
        local16 = new SeqType();
        local16.id = arg0;
        if (local43 != null) {
            local16.method1585(new Packet(local43));
        }
        local16.method1584();
        @Pc(73) WeightedCache local73 = this.aWeightedCache_22;
        synchronized (this.aWeightedCache_22) {
            this.aWeightedCache_22.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(II)V")
    public void method1163() {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_22;
        synchronized (this.aWeightedCache_22) {
            this.aWeightedCache_22.method2147(5);
        }
        local6 = this.aWeightedCache_23;
        synchronized (this.aWeightedCache_23) {
            this.aWeightedCache_23.method2147(5);
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(I)V")
    public void method1164() {
        @Pc(2) WeightedCache local2 = this.aWeightedCache_22;
        synchronized (this.aWeightedCache_22) {
            this.aWeightedCache_22.method2151();
        }
        local2 = this.aWeightedCache_23;
        synchronized (this.aWeightedCache_23) {
            this.aWeightedCache_23.method2151();
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(B)V")
    public void method1165() {
        @Pc(7) WeightedCache local7 = this.aWeightedCache_22;
        synchronized (this.aWeightedCache_22) {
            this.aWeightedCache_22.reset();
        }
        local7 = this.aWeightedCache_23;
        synchronized (this.aWeightedCache_23) {
            this.aWeightedCache_23.reset();
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(II)Lclient!rw;")
    public AnimFrameset method1166(@OriginalArg(0) int arg0) {
        @Pc(12) WeightedCache local12 = this.aWeightedCache_23;
        synchronized (this.aWeightedCache_23) {
            @Pc(22) AnimFrameset local22 = (AnimFrameset) this.aWeightedCache_23.method2156((long) arg0);
            if (local22 == null) {
                local22 = new AnimFrameset(arg0);
                this.aWeightedCache_23.put(local22, (long) arg0);
            }
            return local22.method7565() ? local22 : null;
        }
    }
}
