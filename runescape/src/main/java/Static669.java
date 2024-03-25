import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static669 {

    @OriginalMember(owner = "client!vd", name = "k", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___116 = new ClientProt(51, -1);

    @OriginalMember(owner = "client!vd", name = "m", descriptor = "I")
    public static int anInt9996 = -1;

    @OriginalMember(owner = "client!vd", name = "a", descriptor = "(II)V")
    public static void method8711(@OriginalArg(0) int arg0) {
        Static180.anInt3001 = -1;
        WorldMap.anInt3181 = -1;
        WorldMap.anInt2809 = arg0;
        WorldMap.method5440();
    }

}
