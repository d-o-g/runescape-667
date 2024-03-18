import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fh")
public final class Class128 {

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "I")
    public int anInt2921;

    @OriginalMember(owner = "client!fh", name = "i", descriptor = "Lclient!dla;")
    public final WeightedCache aWeightedCache_61 = new WeightedCache(64);

    @OriginalMember(owner = "client!fh", name = "k", descriptor = "Lclient!dla;")
    public final WeightedCache aWeightedCache_62 = new WeightedCache(60);

    @OriginalMember(owner = "client!fh", name = "f", descriptor = "Lclient!sb;")
    public final Class330 aClass330_34;

    @OriginalMember(owner = "client!fh", name = "d", descriptor = "Lclient!sb;")
    public final Class330 aClass330_33;

    @OriginalMember(owner = "client!fh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class128(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2, @OriginalArg(3) Class330 arg3) {
        this.aClass330_34 = arg3;
        this.aClass330_33 = arg2;
        @Pc(26) int local26 = this.aClass330_33.method7597() - 1;
        this.aClass330_33.method7608(local26);
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(II)Lclient!lia;")
    public Class227 method2694(@OriginalArg(1) int arg0) {
        @Pc(14) WeightedCache local14 = this.aWeightedCache_61;
        @Pc(24) Class227 local24;
        synchronized (this.aWeightedCache_61) {
            local24 = (Class227) this.aWeightedCache_61.method2156((long) arg0);
        }
        if (local24 != null) {
            return local24;
        }
        @Pc(38) Class330 local38 = this.aClass330_33;
        @Pc(51) byte[] local51;
        synchronized (this.aClass330_33) {
            local51 = this.aClass330_33.method7595(Static560.method7429(arg0), Static359.method5224(arg0));
        }
        local24 = new Class227();
        local24.anInt5833 = arg0;
        local24.aClass128_2 = this;
        if (local51 != null) {
            local24.method5246(new Packet(local51));
        }
        @Pc(81) WeightedCache local81 = this.aWeightedCache_61;
        synchronized (this.aWeightedCache_61) {
            this.aWeightedCache_61.put(local24, (long) arg0);
            return local24;
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(BI)V")
    public void setFeatureMask(@OriginalArg(1) int arg0) {
        this.anInt2921 = arg0;
        @Pc(9) WeightedCache local9 = this.aWeightedCache_62;
        synchronized (this.aWeightedCache_62) {
            this.aWeightedCache_62.reset();
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(Z)V")
    public void method2697() {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_61;
        synchronized (this.aWeightedCache_61) {
            this.aWeightedCache_61.method2151();
        }
        local6 = this.aWeightedCache_62;
        synchronized (this.aWeightedCache_62) {
            this.aWeightedCache_62.method2151();
        }
    }

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "(II)V")
    public void method2698() {
        @Pc(2) WeightedCache local2 = this.aWeightedCache_61;
        synchronized (this.aWeightedCache_61) {
            this.aWeightedCache_61.method2147(5);
        }
        @Pc(30) WeightedCache local30 = this.aWeightedCache_62;
        synchronized (this.aWeightedCache_62) {
            this.aWeightedCache_62.method2147(5);
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(I)V")
    public void method2699() {
        @Pc(6) WeightedCache local6 = this.aWeightedCache_61;
        synchronized (this.aWeightedCache_61) {
            this.aWeightedCache_61.reset();
        }
        local6 = this.aWeightedCache_62;
        synchronized (this.aWeightedCache_62) {
            this.aWeightedCache_62.reset();
        }
    }
}
