import com.jagex.graphics.Font;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static110 {

    @OriginalMember(owner = "client!dha", name = "s", descriptor = "I")
    public static int fullscreenHeight;

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void setBillboardJs5(@OriginalArg(0) js5 arg0) {
        Static331.aJs5_65 = arg0;
    }

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(Lclient!da;)V")
    public static void method2082(@OriginalArg(0) Font arg0) {
        Static242.aFont_7 = arg0;
    }
}
