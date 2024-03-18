import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kr")
public final class IDKTypeList {

    @OriginalMember(owner = "client!kr", name = "n", descriptor = "Lclient!dla;")
    public final WeightedCache aWeightedCache_115 = new WeightedCache(64);

    @OriginalMember(owner = "client!kr", name = "b", descriptor = "Lclient!sb;")
    public final Class330 aClass330_72;

    @OriginalMember(owner = "client!kr", name = "k", descriptor = "Lclient!sb;")
    public final Class330 aClass330_71;

    @OriginalMember(owner = "client!kr", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public IDKTypeList(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2, @OriginalArg(3) Class330 arg3) {
        this.aClass330_72 = arg3;
        this.aClass330_71 = arg2;
        this.aClass330_71.method7608(3);
    }

    @OriginalMember(owner = "client!kr", name = "d", descriptor = "(I)V")
    public void method5041() {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_115;
        synchronized (this.aWeightedCache_115) {
            this.aWeightedCache_115.method2151();
        }
    }

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(IB)Lclient!pka;")
    public Class294 list(@OriginalArg(0) int arg0) {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_115;
        @Pc(24) Class294 local24;
        synchronized (this.aWeightedCache_115) {
            local24 = (Class294) this.aWeightedCache_115.method2156((long) arg0);
        }
        if (local24 != null) {
            return local24;
        }
        @Pc(38) Class330 local38 = this.aClass330_71;
        @Pc(47) byte[] local47;
        synchronized (this.aClass330_71) {
            local47 = this.aClass330_71.method7595(arg0, 3);
        }
        local24 = new Class294();
        local24.aIDKTypeList_4 = this;
        if (local47 != null) {
            local24.method6613(new Packet(local47));
        }
        @Pc(74) WeightedCache local74 = this.aWeightedCache_115;
        synchronized (this.aWeightedCache_115) {
            this.aWeightedCache_115.put(local24, (long) arg0);
            return local24;
        }
    }

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(I)V")
    public void method5044() {
        @Pc(2) WeightedCache local2 = this.aWeightedCache_115;
        synchronized (this.aWeightedCache_115) {
            this.aWeightedCache_115.reset();
        }
    }

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(II)V")
    public void method5045() {
        @Pc(7) WeightedCache local7 = this.aWeightedCache_115;
        synchronized (this.aWeightedCache_115) {
            this.aWeightedCache_115.method2147(5);
        }
    }
}
