import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pc")
public final class ZoneProt {

    @OriginalMember(owner = "client!cg", name = "W", descriptor = "Lclient!pc;")
    public static final ZoneProt MAP_PROJANIM = new ZoneProt(6, 16);

    @OriginalMember(owner = "client!rq", name = "H", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___8 = new ZoneProt(5, 3);

    @OriginalMember(owner = "client!ci", name = "g", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___5 = new ZoneProt(13, 7);

    @OriginalMember(owner = "client!vca", name = "i", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___16 = new ZoneProt(12, 7);

    @OriginalMember(owner = "client!pc", name = "<init>", descriptor = "(II)V")
    public ZoneProt(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    }

    @OriginalMember(owner = "client!pc", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
