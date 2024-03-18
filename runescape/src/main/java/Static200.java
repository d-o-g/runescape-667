import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static200 {

    @OriginalMember(owner = "client!gda", name = "e", descriptor = "I")
    public static final int anInt3302 = 52;

    @OriginalMember(owner = "client!gda", name = "b", descriptor = "I")
    public static int anInt3305 = 0;

    @OriginalMember(owner = "client!gda", name = "a", descriptor = "(Ljava/lang/String;[BBI)I")
    public static int method2980(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(3) int arg2) {
        @Pc(17) int local17 = arg0.length();
        for (@Pc(19) int local19 = 0; local19 < local17; local19 += 4) {
            @Pc(29) int local29 = Static204.method3081(arg0.charAt(local19));
            @Pc(48) int local48 = local19 + 1 >= local17 ? -1 : Static204.method3081(arg0.charAt(local19 + 1));
            @Pc(68) int local68 = local17 > local19 + 2 ? Static204.method3081(arg0.charAt(local19 + 2)) : -1;
            @Pc(84) int local84 = local19 + 3 >= local17 ? -1 : Static204.method3081(arg0.charAt(local19 + 3));
            arg1[arg2++] = (byte) (local48 >>> 4 | local29 << 2);
            if (local68 == -1) {
                break;
            }
            arg1[arg2++] = (byte) ((local48 & 0xF) << 4 | local68 >>> 2);
            if (local84 == -1) {
                break;
            }
            arg1[arg2++] = (byte) ((local68 & 0x3) << 6 | local84);
        }
        return arg2;
    }

}
