package rs2.client.loading.screen.op.instance;

import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!rk")
public class FancyProgressBarInstance extends ProgressBarInstance {

    @OriginalMember(owner = "client!wla", name = "a", descriptor = "(BLclient!ge;)Lclient!rk;")
    public static FancyProgressBarInstance decode(@OriginalArg(1) Packet packet) {
        @Pc(7) ProgressBarInstance instance = ProgressBarInstance.decode(packet);
        @Pc(13) int bar = packet.g2();
        @Pc(19) int background = packet.g2();
        @Pc(25) int left = packet.g2();
        @Pc(29) int right = packet.g2();
        @Pc(33) int top = packet.g2();
        @Pc(43) int bottom = packet.g2();
        return new FancyProgressBarInstance(instance.horizontalAlignment, instance.verticalAlignment, instance.x, instance.y, instance.width, instance.height, instance.textOffsetX, instance.font, instance.textColour, bar, background, left, right, top, bottom);
    }

    @OriginalMember(owner = "client!rk", name = "y", descriptor = "I")
    public final int bottom;

    @OriginalMember(owner = "client!rk", name = "s", descriptor = "I")
    public final int bar;

    @OriginalMember(owner = "client!rk", name = "x", descriptor = "I")
    public final int left;

    @OriginalMember(owner = "client!rk", name = "u", descriptor = "I")
    public final int background;

    @OriginalMember(owner = "client!rk", name = "t", descriptor = "I")
    public final int right;

    @OriginalMember(owner = "client!rk", name = "q", descriptor = "I")
    public final int top;

    @OriginalMember(owner = "client!rk", name = "<init>", descriptor = "(Lclient!wk;Lclient!ek;IIIIIIIIIIIII)V")
    public FancyProgressBarInstance(@OriginalArg(0) HorizontalAlignment horizontalAlignment, @OriginalArg(1) VerticalAlignment verticalAlignment, @OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(4) int width, @OriginalArg(5) int height, @OriginalArg(6) int textOffsetX, @OriginalArg(7) int font, @OriginalArg(8) int textColour, @OriginalArg(9) int bar, @OriginalArg(10) int background, @OriginalArg(11) int left, @OriginalArg(12) int right, @OriginalArg(13) int top, @OriginalArg(14) int bottom) {
        super(horizontalAlignment, verticalAlignment, x, y, width, height, textOffsetX, font, textColour);
        this.bottom = bottom;
        this.bar = bar;
        this.left = left;
        this.background = background;
        this.right = right;
        this.top = top;
    }

    @OriginalMember(owner = "client!rk", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.FANCY_PROGRESS_BAR;
    }
}
