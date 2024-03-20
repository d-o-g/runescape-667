import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
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
    public final js5 aJs5_34;

    @OriginalMember(owner = "client!fh", name = "d", descriptor = "Lclient!sb;")
    public final js5 aJs5_33;

    @OriginalMember(owner = "client!fh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public Class128(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3) {
        this.aJs5_34 = arg3;
        this.aJs5_33 = arg2;
        @Pc(26) int local26 = this.aJs5_33.groupSize() - 1;
        this.aJs5_33.fileLimit(local26);
    }

    @OriginalMember(owner = "client!rl", name = "a", descriptor = "(II)I")
    public static int fileId(@OriginalArg(1) int arg0) {
        return arg0 & 0xFF;
    }

    @OriginalMember(owner = "client!lfa", name = "a", descriptor = "(II)I")
    public static int groupId(@OriginalArg(0) int arg0) {
        return arg0 >>> 8;
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
        @Pc(38) js5 local38 = this.aJs5_33;
        @Pc(51) byte[] local51;
        synchronized (this.aJs5_33) {
            local51 = this.aJs5_33.getfile(fileId(arg0), groupId(arg0));
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
            this.aReferenceCache_61.removeSoftReferences();
        }
        local6 = this.aReferenceCache_62;
        synchronized (this.aReferenceCache_62) {
            this.aReferenceCache_62.removeSoftReferences();
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
