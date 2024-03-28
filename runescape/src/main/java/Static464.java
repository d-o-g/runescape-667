import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static464 {

    @OriginalMember(owner = "client!ol", name = "F", descriptor = "I")
    public static int anInt7013;

    @OriginalMember(owner = "client!ol", name = "G", descriptor = "[I")
    public static final int[] anIntArray561 = new int[]{-1, 8192, 0, -1, 12288, 10240, 14336, -1, 4096, 6144, 2048};

    @OriginalMember(owner = "client!ol", name = "a", descriptor = "(Lclient!ge;Z)Lclient!hea;")
    public static RotatingImageInstance method6301(@OriginalArg(0) Packet arg0) {
        @Pc(16) ImageInstance local16 = ImageInstance.decode(arg0);
        @Pc(20) int local20 = arg0.g3s();
        return new RotatingImageInstance(local16.anInt3851, local16.aHorizontalAlignment_9, local16.aVerticalAlignment_9, local16.anInt3850, local16.anInt3845, local20);
    }
}
