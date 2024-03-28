import com.jagex.core.io.ByteArrayWrapper;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static132 {

    @OriginalMember(owner = "client!ec", name = "e", descriptor = "(I)V")
    public static void method2312() {
        @Pc(16) byte[] local16;
        if (Static177.anObject6 == null) {
            @Pc(9) Class35_Sub2_Sub1 local9 = new Class35_Sub2_Sub1();
            local16 = local9.method4596();
            Static177.anObject6 = ByteArrayWrapper.wrap(local16);
        }
        if (Static644.anObject18 == null) {
            @Pc(31) Class35_Sub1_Sub2 local31 = new Class35_Sub1_Sub2();
            local16 = local31.method5438();
            Static644.anObject18 = ByteArrayWrapper.wrap(local16);
        }
    }

}
