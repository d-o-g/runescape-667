import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static402 {

    @OriginalMember(owner = "client!ml", name = "p", descriptor = "Lclient!ss;")
    public static final Class345 aClass345_72 = new Class345(76, 7);

    @OriginalMember(owner = "client!ml", name = "f", descriptor = "[B")
    public static final byte[] aByteArray68 = new byte[2048];

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(III)Z")
    public static boolean method5577(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x70000) != 0 | Static58.method1257(arg0, arg1) || Static598.method7828(arg1, arg0);
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(B)I")
    public static int method5578() {
        return Static129.anInt2406;
    }

    @OriginalMember(owner = "client!ml", name = "c", descriptor = "(II)Lclient!uja;")
    public static Class376 method5582(@OriginalArg(1) int arg0) {
        @Pc(10) Class376 local10 = (Class376) Static153.A_WEIGHTED_CACHE___56.get((long) arg0);
        if (local10 != null) {
            return local10;
        }
        @Pc(21) byte[] local21 = Static331.aJs5_65.getfile(arg0, 0);
        local10 = new Class376();
        if (local21 != null) {
            local10.method8511(arg0, new Packet(local21));
        }
        Static153.A_WEIGHTED_CACHE___56.put(local10, (long) arg0);
        return local10;
    }

}
