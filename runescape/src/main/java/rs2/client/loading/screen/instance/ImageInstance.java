package rs2.client.loading.screen.instance;

import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!no")
public class ImageInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(Lclient!ge;B)Lclient!no;")
    public static ImageInstance decode(@OriginalArg(0) Packet packet) {
        @Pc(15) int sprite = packet.g2();
        @Pc(22) HorizontalAlignment horizontalAlignment = HorizontalAlignment.values()[packet.g1()];
        @Pc(29) VerticalAlignment verticalAlignment = VerticalAlignment.values()[packet.g1()];
        @Pc(35) int x = packet.g2s();
        @Pc(39) int y = packet.g2s();
        return new ImageInstance(sprite, horizontalAlignment, verticalAlignment, x, y);
    }

    @OriginalMember(owner = "client!no", name = "l", descriptor = "Lclient!ek;")
    public final VerticalAlignment verticalAlignment;

    @OriginalMember(owner = "client!no", name = "h", descriptor = "I")
    public final int x;

    @OriginalMember(owner = "client!no", name = "e", descriptor = "I")
    public final int spriteId;

    @OriginalMember(owner = "client!no", name = "k", descriptor = "Lclient!wk;")
    public final HorizontalAlignment horizontalAlignment;

    @OriginalMember(owner = "client!no", name = "f", descriptor = "I")
    public final int y;

    @OriginalMember(owner = "client!no", name = "<init>", descriptor = "(ILclient!wk;Lclient!ek;II)V")
    public ImageInstance(@OriginalArg(0) int spriteId, @OriginalArg(1) HorizontalAlignment horizontalAlignment, @OriginalArg(2) VerticalAlignment verticalAlignment, @OriginalArg(3) int x, @OriginalArg(4) int y) {
        this.verticalAlignment = verticalAlignment;
        this.x = x;
        this.spriteId = spriteId;
        this.horizontalAlignment = horizontalAlignment;
        this.y = y;
    }

    @OriginalMember(owner = "client!no", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.IMAGE;
    }
}
