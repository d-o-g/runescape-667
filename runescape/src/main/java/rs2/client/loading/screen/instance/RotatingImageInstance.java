package rs2.client.loading.screen.instance;

import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.instance.ImageInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!hea")
public final class RotatingImageInstance extends ImageInstance {

    @OriginalMember(owner = "client!hea", name = "n", descriptor = "I")
    public final int rotation;

    @OriginalMember(owner = "client!hea", name = "<init>", descriptor = "(ILclient!wk;Lclient!ek;III)V")
    public RotatingImageInstance(@OriginalArg(0) int spriteId, @OriginalArg(1) HorizontalAlignment horizontalAlignment, @OriginalArg(2) VerticalAlignment verticalAlignment, @OriginalArg(3) int x, @OriginalArg(4) int y, @OriginalArg(5) int rotation) {
        super(spriteId, horizontalAlignment, verticalAlignment, x, y);
        this.rotation = rotation;
    }

    @OriginalMember(owner = "client!hea", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.ROTATING_IMAGE;
    }
}
