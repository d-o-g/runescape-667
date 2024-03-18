import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qp")
public final class BASTypeList {

    @OriginalMember(owner = "client!qp", name = "h", descriptor = "Lclient!dla;")
    public final Class82 aClass82_172 = new Class82(64);

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
        @Pc(2) Class82 local2 = this.aClass82_172;
        synchronized (this.aClass82_172) {
            this.aClass82_172.method2157();
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(IZ)V")
    public void method7115() {
        @Pc(14) Class82 local14 = this.aClass82_172;
        synchronized (this.aClass82_172) {
            this.aClass82_172.method2147(5);
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(I)V")
    public void method7117() {
        @Pc(2) Class82 local2 = this.aClass82_172;
        synchronized (this.aClass82_172) {
            this.aClass82_172.method2151();
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(BI)Lclient!pda;")
    public BASType list(@OriginalArg(1) int arg0) {
        @Pc(6) Class82 local6 = this.aClass82_172;
        @Pc(16) BASType local16;
        synchronized (this.aClass82_172) {
            local16 = (BASType) this.aClass82_172.method2156((long) arg0);
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
        @Pc(66) Class82 local66 = this.aClass82_172;
        synchronized (this.aClass82_172) {
            this.aClass82_172.method2150(local16, (long) arg0);
            return local16;
        }
    }
}
