import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.FancyProgressBarInstance;

public final class Static353 {

    @OriginalMember(owner = "client!lca", name = "k", descriptor = "Z")
    public static boolean noNpcs = false;

    @OriginalMember(owner = "client!lca", name = "a", descriptor = "(Lclient!ge;B)Lclient!fw;")
    public static AnimatedProgressBarInstance method8430(@OriginalArg(0) Packet arg0) {
        @Pc(7) FancyProgressBarInstance local7 = FancyProgressBarInstance.decode(arg0);
        @Pc(20) int local20 = arg0.g2s();
        return new AnimatedProgressBarInstance(local7.horizontalAlignment, local7.verticalAlignment, local7.x, local7.y, local7.width, local7.height, local7.textOffsetX, local7.font, local7.textColour, local7.bar, local7.background, local7.left, local7.right, local7.top, local7.bottom, local20);
    }
}
