import com.jagex.collect.LruCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gga")
public final class Class144 {

    @OriginalMember(owner = "client!gga", name = "h", descriptor = "Lclient!cm;")
    public LruCache.Node aClass2_Sub2_31;

    @OriginalMember(owner = "client!gga", name = "c", descriptor = "J")
    public long aLong115;

    @OriginalMember(owner = "client!gga", name = "d", descriptor = "[Lclient!cm;")
    public final LruCache.Node[] aClass2_Sub2Array1;

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "I")
    public final int anInt3417;

    @OriginalMember(owner = "client!gga", name = "<init>", descriptor = "(I)V")
    public Class144(@OriginalArg(0) int arg0) {
        this.aClass2_Sub2Array1 = new LruCache.Node[arg0];
        this.anInt3417 = arg0;
        for (@Pc(10) int local10 = 0; local10 < arg0; local10++) {
            @Pc(20) LruCache.Node local20 = this.aClass2_Sub2Array1[local10] = new LruCache.Node();
            local20.prev2 = local20;
            local20.next2 = local20;
        }
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(BLclient!cm;J)V")
    public void method3094(@OriginalArg(1) LruCache.Node arg0, @OriginalArg(2) long arg1) {
        if (arg0.prev2 != null) {
            arg0.unlink2();
        }
        @Pc(28) LruCache.Node local28 = this.aClass2_Sub2Array1[(int) ((long) (this.anInt3417 - 1) & arg1)];
        arg0.next2 = local28;
        arg0.prev2 = local28.prev2;
        arg0.prev2.next2 = arg0;
        arg0.next2.prev2 = arg0;
        arg0.key2 = arg1;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(JI)Lclient!cm;")
    public LruCache.Node method3095(@OriginalArg(0) long arg0) {
        this.aLong115 = arg0;
        @Pc(20) LruCache.Node local20 = this.aClass2_Sub2Array1[(int) (arg0 & (long) (this.anInt3417 - 1))];
        for (this.aClass2_Sub2_31 = local20.next2; this.aClass2_Sub2_31 != local20; this.aClass2_Sub2_31 = this.aClass2_Sub2_31.next2) {
            if (arg0 == this.aClass2_Sub2_31.key2) {
                @Pc(41) LruCache.Node local41 = this.aClass2_Sub2_31;
                this.aClass2_Sub2_31 = this.aClass2_Sub2_31.next2;
                return local41;
            }
        }
        this.aClass2_Sub2_31 = null;
        return null;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(I)Lclient!cm;")
    public LruCache.Node method3096() {
        if (this.aClass2_Sub2_31 == null) {
            return null;
        }
        @Pc(24) LruCache.Node local24 = this.aClass2_Sub2Array1[(int) (this.aLong115 & (long) (this.anInt3417 - 1))];
        while (this.aClass2_Sub2_31 != local24) {
            if (this.aLong115 == this.aClass2_Sub2_31.key2) {
                @Pc(38) LruCache.Node local38 = this.aClass2_Sub2_31;
                this.aClass2_Sub2_31 = this.aClass2_Sub2_31.next2;
                return local38;
            }
            this.aClass2_Sub2_31 = this.aClass2_Sub2_31.next2;
        }
        this.aClass2_Sub2_31 = null;
        return null;
    }
}
