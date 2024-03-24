import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static48 {

    @OriginalMember(owner = "client!bka", name = "i", descriptor = "[Lclient!eo;")
    public static Entity[] aEntityArray3;

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "(Lclient!bd;I)Lclient!bd;")
    public static Node_Sub6_Sub1 method1100(@OriginalArg(0) Node_Sub6_Sub1 arg0) {
        @Pc(15) Node_Sub6_Sub1 local15 = arg0 == null ? new Node_Sub6_Sub1() : new Node_Sub6_Sub1(arg0);
        local15.method929();
        return local15;
    }
}
