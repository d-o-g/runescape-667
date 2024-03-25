import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static189 {

    @OriginalMember(owner = "client!fr", name = "f", descriptor = "Lclient!hla;")
    public static final Class168 aClass168_2 = new Class168();

    @OriginalMember(owner = "client!fr", name = "c", descriptor = "Lclient!kda;")
    public static final Class204 aClass204_7 = new Class204(7, 2);

    @OriginalMember(owner = "client!fr", name = "a", descriptor = "(IB)Lclient!om;")
    public static Class280 method2864(@OriginalArg(0) int arg0) {
        @Pc(6) Class280[] local6 = Static400.method7112();
        for (@Pc(8) int local8 = 0; local8 < local6.length; local8++) {
            @Pc(19) Class280 local19 = local6[local8];
            if (arg0 == local19.anInt7039) {
                return local19;
            }
        }
        return null;
    }
}
