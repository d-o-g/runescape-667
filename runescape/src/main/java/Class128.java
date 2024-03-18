import com.jagex.collect.ref.ReferenceCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fh")
public final class Class128 {

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "I")
    public int anInt2921;

    @OriginalMember(owner = "client!fh", name = "i", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_61 = new ReferenceCache(64);

    @OriginalMember(owner = "client!fh", name = "k", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_62 = new ReferenceCache(60);

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
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_61;
        @Pc(24) Class227 local24;
        synchronized (this.aReferenceCache_61) {
            local24 = (Class227) this.aReferenceCache_61.get((long) arg0);
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
        @Pc(81) ReferenceCache local81 = this.aReferenceCache_61;
        synchronized (this.aReferenceCache_61) {
            this.aReferenceCache_61.put(local24, (long) arg0);
            return local24;
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(BI)V")
    public void setFeatureMask(@OriginalArg(1) int arg0) {
        this.anInt2921 = arg0;
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.reset();
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(Z)V")
    public void method2697() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_61;
        synchronized (this.aReferenceCache_61) {
            this.aReferenceCache_61.clearSoft();
        }
        local6 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.clearSoft();
        }
    }

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "(II)V")
    public void method2698() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_61;
        synchronized (this.aReferenceCache_61) {
            this.aReferenceCache_61.clean(5);
        }
        @Pc(30) ReferenceCache local30 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.clean(5);
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(I)V")
    public void method2699() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_61;
        synchronized (this.aReferenceCache_61) {
            this.aReferenceCache_61.reset();
        }
        local6 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.reset();
        }
    }
}
