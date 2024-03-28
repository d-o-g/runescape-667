import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static502 {

    @OriginalMember(owner = "client!pr", name = "k", descriptor = "S")
    public static short aShort97 = 320;

    @OriginalMember(owner = "client!pr", name = "a", descriptor = "(BLclient!ge;)Lclient!il;")
    public static Class138_Sub3 method6720(@OriginalArg(1) Packet arg0) {
        @Pc(7) Class138 local7 = Class138.method8359(arg0);
        @Pc(23) int local23 = arg0.g4();
        @Pc(27) int local27 = arg0.g4();
        return new Class138_Sub3(local7.aHorizontalAlignment_10, local7.aVerticalAlignment_10, local7.anInt4423, local7.anInt4412, local7.anInt4418, local7.anInt4413, local7.anInt4416, local7.anInt4415, local7.anInt4421, local23, local27);
    }

}
