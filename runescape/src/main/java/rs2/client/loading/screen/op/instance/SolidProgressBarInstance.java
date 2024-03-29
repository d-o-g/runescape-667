package rs2.client.loading.screen.op.instance;

import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!il")
public final class SolidProgressBarInstance extends ProgressBarInstance {

    @OriginalMember(owner = "client!pr", name = "a", descriptor = "(BLclient!ge;)Lclient!il;")
    public static SolidProgressBarInstance method6720(@OriginalArg(1) Packet packet) {
        @Pc(7) ProgressBarInstance instance = decode(packet);
        @Pc(23) int backgroundColour = packet.g4();
        @Pc(27) int borderColour = packet.g4();
        return new SolidProgressBarInstance(instance.horizontalAlignment, instance.verticalAlignment, instance.x, instance.y, instance.width, instance.height, instance.textOffsetX, instance.font, instance.textColour, backgroundColour, borderColour);
    }

    @OriginalMember(owner = "client!il", name = "q", descriptor = "I")
    public final int borderColour;

    @OriginalMember(owner = "client!il", name = "w", descriptor = "I")
    public final int backgroundColour;

    @OriginalMember(owner = "client!il", name = "<init>", descriptor = "(Lclient!wk;Lclient!ek;IIIIIIIII)V")
    public SolidProgressBarInstance(@OriginalArg(0) HorizontalAlignment horizontalAlignment, @OriginalArg(1) VerticalAlignment verticalAlignment, @OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(4) int width, @OriginalArg(5) int height, @OriginalArg(6) int textOffsetX, @OriginalArg(7) int font, @OriginalArg(8) int textColour, @OriginalArg(9) int backgroundColour, @OriginalArg(10) int borderColour) {
        super(horizontalAlignment, verticalAlignment, x, y, width, height, textOffsetX, font, textColour);
        this.borderColour = borderColour;
        this.backgroundColour = backgroundColour;
    }

    @OriginalMember(owner = "client!il", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.SOLID_PROGRESS_BAR;
    }
}
