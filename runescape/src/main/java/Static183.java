import com.jagex.NativeLibraryList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static183 {

    @OriginalMember(owner = "client!fm", name = "m", descriptor = "[Lclient!lka;")
    public static Class231[] aClass231Array1;

    @OriginalMember(owner = "client!fm", name = "h", descriptor = "I")
    public static int anInt3024 = 0;

    @OriginalMember(owner = "client!fm", name = "a", descriptor = "(Ljava/lang/String;Z)Z")
    public static boolean method2796(@OriginalArg(0) String arg0) {
        return NativeLibraryList.nativeLibraries.containsKey(arg0);
    }
}
