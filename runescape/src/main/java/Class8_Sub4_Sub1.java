import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ne")
public final class Class8_Sub4_Sub1 extends Class8_Sub4 {

    @OriginalMember(owner = "client!ne", name = "q", descriptor = "I")
    public final int anInt6433 = (int) (SystemTimer.safetime() / 1000L);

    @OriginalMember(owner = "client!ne", name = "s", descriptor = "Ljava/lang/String;")
    public final String aString72;

    @OriginalMember(owner = "client!ne", name = "r", descriptor = "S")
    public final short aShort74;

    @OriginalMember(owner = "client!ne", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public Class8_Sub4_Sub1(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
        this.aString72 = arg0;
        this.aShort74 = (short) arg1;
    }
}
