import com.jagex.SignedResource;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static439 {

    @OriginalMember(owner = "client!ns", name = "c", descriptor = "Lclient!oba;")
    public static SignedResource aSignedResource_4;

    @OriginalMember(owner = "client!ns", name = "e", descriptor = "I")
    public static int anInt6674 = 0;

    @OriginalMember(owner = "client!ns", name = "a", descriptor = "I")
    public static int anInt6675 = 0;

    @OriginalMember(owner = "client!ns", name = "a", descriptor = "(B)V")
    public static void method5954() {
        Minimap.flagY = -1;
        Minimap.level = -1;
        Minimap.flagX = -1;
        Minimap.toggle = 0;
    }
}
