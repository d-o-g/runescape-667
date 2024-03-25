import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static167 {

    @OriginalMember(owner = "client!fd", name = "n", descriptor = "[I")
    public static final int[] hitmarkOffsets = new int[4];

    @OriginalMember(owner = "client!fd", name = "b", descriptor = "(Z)Lclient!ah;")
    public static Class13 method2632() {
        try {
            return (Class13) Class.forName("Class13_Sub2").getDeclaredConstructor().newInstance();
        } catch (@Pc(17) Throwable local17) {
            return new Class13_Sub1();
        }
    }
}
