import com.jagex.core.io.ByteArrayWrapper;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static491 {

    @OriginalMember(owner = "client!pi", name = "a", descriptor = "(Lclient!qha;Z)V")
    public static void method9159(@OriginalArg(0) GlToolkit arg0) {
        @Pc(12) byte[] local12;
        if (Static599.anObject14 == null) {
            @Pc(5) Class35_Sub2_Sub2 local5 = new Class35_Sub2_Sub2();
            local12 = local5.method5816();
            Static599.anObject14 = ByteArrayWrapper.wrap(local12);
        }
        if (Static158.anObject5 == null) {
            @Pc(34) Class35_Sub1_Sub1 local34 = new Class35_Sub1_Sub1();
            local12 = local34.method979();
            Static158.anObject5 = ByteArrayWrapper.wrap(local12);
        }
        @Pc(49) Class202 local49 = arg0.aClass202_1;
        if (local49.method4582() && Static71.anObject4 == null) {
            local12 = Static448.method6106(4.0F, 4.0F, 0.5F, 16.0F, 0.6F, new Class59_Sub1(419684));
            Static71.anObject4 = ByteArrayWrapper.wrap(local12);
        }
    }
}
