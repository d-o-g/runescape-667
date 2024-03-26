package rs2.client.loading.screen.op;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!kda")
public final class LoadingScreenOpType {

    @OriginalMember(owner = "client!qda", name = "t", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType CLEAR_SCREEN = new LoadingScreenOpType(0, 1);

    @OriginalMember(owner = "client!ci", name = "d", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType SOLID_PROGRESS_BAR = new LoadingScreenOpType(1, 2);

    @OriginalMember(owner = "client!rq", name = "C", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType IMAGE_PROGRESS_BAR = new LoadingScreenOpType(2, 2);

    @OriginalMember(owner = "client!qr", name = "k", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType FANCY_PROGRESS_BAR = new LoadingScreenOpType(3, 2);

    @OriginalMember(owner = "client!fca", name = "n", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType NEWS = new LoadingScreenOpType(4, 1);

    @OriginalMember(owner = "client!ra", name = "q", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType IMAGE = new LoadingScreenOpType(5, 1);

    @OriginalMember(owner = "client!uh", name = "s", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType ROTATING_IMAGE = new LoadingScreenOpType(6, 1);

    @OriginalMember(owner = "client!fr", name = "c", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType TEXT = new LoadingScreenOpType(7, 2);

    @OriginalMember(owner = "client!vc", name = "b", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType BACKGROUND_IMAGE = new LoadingScreenOpType(8, 1);

    @OriginalMember(owner = "client!pu", name = "b", descriptor = "Lclient!kda;")
    public static final LoadingScreenOpType ANIMATED_PROGRESS_BAR = new LoadingScreenOpType(9, 2);

    @OriginalMember(owner = "client!lm", name = "c", descriptor = "(I)[Lclient!kda;")
    public static LoadingScreenOpType[] values() {
        return new LoadingScreenOpType[]{
            CLEAR_SCREEN,
            SOLID_PROGRESS_BAR,
            IMAGE_PROGRESS_BAR,
            FANCY_PROGRESS_BAR,
            NEWS,
            IMAGE,
            ROTATING_IMAGE,
            TEXT,
            BACKGROUND_IMAGE,
            ANIMATED_PROGRESS_BAR,
        };
    }

    @OriginalMember(owner = "client!kda", name = "g", descriptor = "I")
    public final int version;

    @OriginalMember(owner = "client!kda", name = "<init>", descriptor = "(II)V")
    public LoadingScreenOpType(@OriginalArg(0) int id, @OriginalArg(1) int version) {
        this.version = version;
    }

    @OriginalMember(owner = "client!kda", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
