package rs2.client.loading.screen.op.instance;

import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!is")
public class ProgressBarInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(Lclient!ge;I)Lclient!is;")
    public static ProgressBarInstance decode(@OriginalArg(0) Packet packet) {
        @Pc(10) HorizontalAlignment horizontalAlignment = HorizontalAlignment.values()[packet.g1()];
        @Pc(17) VerticalAlignment verticalAlignment = VerticalAlignment.values()[packet.g1()];
        @Pc(21) int x = packet.g2s();
        @Pc(25) int y = packet.g2s();
        @Pc(29) int width = packet.g2();
        @Pc(33) int height = packet.g2();
        @Pc(37) int textOffsetX = packet.g2s();
        @Pc(47) int font = packet.g4();
        @Pc(51) int textColour = packet.g4();
        return new ProgressBarInstance(horizontalAlignment, verticalAlignment, x, y, width, height, textOffsetX, font, textColour);
    }

    @OriginalMember(owner = "client!is", name = "i", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!is", name = "a", descriptor = "I")
    public final int font;

    @OriginalMember(owner = "client!is", name = "l", descriptor = "Lclient!wk;")
    public final HorizontalAlignment horizontalAlignment;

    @OriginalMember(owner = "client!is", name = "d", descriptor = "I")
    public final int textOffsetX;

    @OriginalMember(owner = "client!is", name = "g", descriptor = "Lclient!ek;")
    public final VerticalAlignment verticalAlignment;

    @OriginalMember(owner = "client!is", name = "h", descriptor = "I")
    public final int width;

    @OriginalMember(owner = "client!is", name = "n", descriptor = "I")
    public final int x;

    @OriginalMember(owner = "client!is", name = "j", descriptor = "I")
    public final int y;

    @OriginalMember(owner = "client!is", name = "k", descriptor = "I")
    public final int textColour;

    @OriginalMember(owner = "client!is", name = "<init>", descriptor = "(Lclient!wk;Lclient!ek;IIIIIII)V")
    public ProgressBarInstance(@OriginalArg(0) HorizontalAlignment horizontalAlignment, @OriginalArg(1) VerticalAlignment verticalAlignment, @OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(4) int width, @OriginalArg(5) int height, @OriginalArg(6) int textOffsetX, @OriginalArg(7) int font, @OriginalArg(8) int textColour) {
        this.height = height;
        this.font = font;
        this.horizontalAlignment = horizontalAlignment;
        this.textOffsetX = textOffsetX;
        this.verticalAlignment = verticalAlignment;
        this.width = width;
        this.x = x;
        this.y = y;
        this.textColour = textColour;
    }

    @OriginalMember(owner = "client!is", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return null;
    }
}
