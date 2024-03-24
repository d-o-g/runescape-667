import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pc")
public final class ZoneProt {

    @OriginalMember(owner = "client!cg", name = "W", descriptor = "Lclient!pc;")
    public static final ZoneProt MAP_PROJANIM = new ZoneProt(6, 16);

    @OriginalMember(owner = "client!pc", name = "<init>", descriptor = "(II)V")
    public ZoneProt(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
    }

    @OriginalMember(owner = "client!pc", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
