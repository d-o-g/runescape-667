import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static387 {

    @OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!ge;II)Ljava/lang/String;")
    public static String method5441(@OriginalArg(0) Packet arg0) {
        try {
            @Pc(7) int local7 = arg0.gsmart();
            if (local7 > 32767) {
                local7 = 32767;
            }
            @Pc(19) byte[] local19 = new byte[local7];
            arg0.pos += HuffmanCodec.instance.method4438(local19, arg0.data, local7, arg0.pos, 0);
            return Cp1252.decode(0, local19, local7);
        } catch (@Pc(53) Exception local53) {
            return "Cabbage";
        }
    }
}
