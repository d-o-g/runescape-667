package rs2.client.loading.screen.op.instance;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!jt")
public final class BackgroundImageInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!jt", name = "c", descriptor = "I")
    public final int image;

    @OriginalMember(owner = "client!jt", name = "<init>", descriptor = "(I)V")
    public BackgroundImageInstance(@OriginalArg(0) int image) {
        this.image = image;
    }

    @OriginalMember(owner = "client!jt", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.BACKGROUND_IMAGE;
    }
}
