import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dh")
public final class Class79 {

    @OriginalMember(owner = "client!dh", name = "i", descriptor = "Lclient!dla;")
    public final WeightedCache aWeightedCache_47 = new WeightedCache(128);

    @OriginalMember(owner = "client!dh", name = "b", descriptor = "Lclient!sb;")
    public final Class330 aClass330_18;

    @OriginalMember(owner = "client!dh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class79(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2) {
        this.aClass330_18 = arg2;
        this.aClass330_18.method7608(1);
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(II)Lclient!nq;")
    public Class264 method2066(@OriginalArg(1) int arg0) {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_47;
        @Pc(18) Class264 local18;
        synchronized (this.aWeightedCache_47) {
            local18 = (Class264) this.aWeightedCache_47.method2156((long) arg0);
        }
        if (local18 != null) {
            return local18;
        }
        @Pc(32) Class330 local32 = this.aClass330_18;
        @Pc(41) byte[] local41;
        synchronized (this.aClass330_18) {
            local41 = this.aClass330_18.method7595(arg0, 1);
        }
        local18 = new Class264();
        if (local41 != null) {
            local18.method5921(new Packet(local41));
        }
        @Pc(67) WeightedCache local67 = this.aWeightedCache_47;
        synchronized (this.aWeightedCache_47) {
            this.aWeightedCache_47.put(local18, (long) arg0);
            return local18;
        }
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(I)V")
    public void method2067() {
        @Pc(17) WeightedCache local17 = this.aWeightedCache_47;
        synchronized (this.aWeightedCache_47) {
            this.aWeightedCache_47.reset();
        }
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(Z)V")
    public void method2072() {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_47;
        synchronized (this.aWeightedCache_47) {
            this.aWeightedCache_47.method2151();
        }
    }

    @OriginalMember(owner = "client!dh", name = "c", descriptor = "(II)V")
    public void method2073() {
        @Pc(14) WeightedCache local14 = this.aWeightedCache_47;
        synchronized (this.aWeightedCache_47) {
            this.aWeightedCache_47.method2147(5);
        }
    }
}
