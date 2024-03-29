package rs2.client.loading.screen.op.instance;

import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!gha")
public final class ImageProgressBarInstance extends ProgressBarInstance {

    @OriginalMember(owner = "client!gha", name = "q", descriptor = "I")
    public final int sprite;

    @OriginalMember(owner = "client!gha", name = "p", descriptor = "I")
    public final int colour;

    @OriginalMember(owner = "client!gha", name = "<init>", descriptor = "(Lclient!wk;Lclient!ek;IIIIIIIIII)V")
    public ImageProgressBarInstance(@OriginalArg(0) HorizontalAlignment horizontalAlignment, @OriginalArg(1) VerticalAlignment verticalAlignment, @OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(4) int width, @OriginalArg(5) int height, @OriginalArg(6) int textOffsetX, @OriginalArg(7) int font, @OriginalArg(8) int textColour, @OriginalArg(9) int arg9, @OriginalArg(10) int colour, @OriginalArg(11) int sprite) {
        super(horizontalAlignment, verticalAlignment, x, y, width, height, textOffsetX, font, textColour);
        this.sprite = sprite;
        this.colour = colour;
    }

    @OriginalMember(owner = "client!gha", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.IMAGE_PROGRESS_BAR;
    }
}
