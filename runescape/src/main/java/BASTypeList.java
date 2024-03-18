import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qp")
public final class BASTypeList {

    @OriginalMember(owner = "client!qp", name = "h", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_172 = new ReferenceCache(64);

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "Lclient!sb;")
    public final Class330 aClass330_103;

    @OriginalMember(owner = "client!qp", name = "g", descriptor = "Lclient!vl;")
    public final WearposDefaults aWearposDefaults_2;

    @OriginalMember(owner = "client!qp", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!vl;)V")
    public BASTypeList(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class330 arg2, @OriginalArg(3) WearposDefaults arg3) {
        this.aClass330_103 = arg2;
        this.aClass330_103.method7608(32);
        this.aWearposDefaults_2 = arg3;
    }

    @OriginalMember(owner = "client!qp", name = "b", descriptor = "(B)V")
    public void method7114() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_172;
        synchronized (this.aReferenceCache_172) {
            this.aReferenceCache_172.reset();
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(IZ)V")
    public void method7115() {
        @Pc(14) ReferenceCache local14 = this.aReferenceCache_172;
        synchronized (this.aReferenceCache_172) {
            this.aReferenceCache_172.method2147(5);
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(I)V")
    public void method7117() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_172;
        synchronized (this.aReferenceCache_172) {
            this.aReferenceCache_172.method2151();
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(BI)Lclient!pda;")
    public BASType list(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_172;
        @Pc(16) BASType local16;
        synchronized (this.aReferenceCache_172) {
            local16 = (BASType) this.aReferenceCache_172.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) Class330 local30 = this.aClass330_103;
        @Pc(39) byte[] local39;
        synchronized (this.aClass330_103) {
            local39 = this.aClass330_103.method7595(arg0, 32);
        }
        local16 = new BASType();
        local16.aBASTypeList_1 = this;
        if (local39 != null) {
            local16.method6483(new Packet(local39));
        }
        @Pc(66) ReferenceCache local66 = this.aReferenceCache_172;
        synchronized (this.aReferenceCache_172) {
            this.aReferenceCache_172.put(local16, (long) arg0);
            return local16;
        }
    }
}
