package rs2.client.loading.screen.op.instance;

import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!lv")
public final class NewsInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!bd", name = "a", descriptor = "(Lclient!ge;I)Lclient!lv;")
    public static NewsInstance decode(@OriginalArg(0) Packet packet) {
        @Pc(7) int item = packet.g1();
        @Pc(16) HorizontalAlignment horizontalAlignment = HorizontalAlignment.values()[packet.g1()];
        @Pc(25) VerticalAlignment verticalAlignment = VerticalAlignment.values()[packet.g1()];
        @Pc(29) int x = packet.g2s();
        @Pc(33) int y = packet.g2s();
        @Pc(39) int width = packet.g2();
        @Pc(43) int height = packet.g2();
        @Pc(49) int textColour = packet.g4();
        @Pc(53) int textShadowColour = packet.g4();
        @Pc(59) int lineColour = packet.g4();
        @Pc(69) boolean local69 = packet.g1() == 1;
        return new NewsInstance(item, horizontalAlignment, verticalAlignment, x, y, width, height, textColour, textShadowColour, lineColour, local69);
    }

    @OriginalMember(owner = "client!lv", name = "o", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!lv", name = "j", descriptor = "I")
    public final int textColour;

    @OriginalMember(owner = "client!lv", name = "g", descriptor = "Lclient!ek;")
    public final VerticalAlignment verticalAlignment;

    @OriginalMember(owner = "client!lv", name = "m", descriptor = "I")
    public final int x;

    @OriginalMember(owner = "client!lv", name = "d", descriptor = "I")
    public final int lineColour;

    @OriginalMember(owner = "client!lv", name = "k", descriptor = "I")
    public final int width;

    @OriginalMember(owner = "client!lv", name = "f", descriptor = "I")
    public final int y;

    @OriginalMember(owner = "client!lv", name = "a", descriptor = "Lclient!wk;")
    public final HorizontalAlignment horizontalAlignment;

    @OriginalMember(owner = "client!lv", name = "l", descriptor = "I")
    public final int item;

    @OriginalMember(owner = "client!lv", name = "i", descriptor = "Z")
    public final boolean aBoolean454;

    @OriginalMember(owner = "client!lv", name = "h", descriptor = "I")
    public final int textShadowColour;

    @OriginalMember(owner = "client!lv", name = "<init>", descriptor = "(ILclient!wk;Lclient!ek;IIIIIIIZ)V")
    public NewsInstance(@OriginalArg(0) int item, @OriginalArg(1) HorizontalAlignment horizontalAlignment, @OriginalArg(2) VerticalAlignment verticalAlignment, @OriginalArg(3) int x, @OriginalArg(4) int y, @OriginalArg(5) int width, @OriginalArg(6) int height, @OriginalArg(7) int textColour, @OriginalArg(8) int textShadowColour, @OriginalArg(9) int lineColour, @OriginalArg(10) boolean aBoolean454) {
        this.height = height;
        this.textColour = textColour;
        this.verticalAlignment = verticalAlignment;
        this.x = x;
        this.lineColour = lineColour;
        this.width = width;
        this.y = y;
        this.horizontalAlignment = horizontalAlignment;
        this.item = item;
        this.aBoolean454 = aBoolean454;
        this.textShadowColour = textShadowColour;
    }

    @OriginalMember(owner = "client!lv", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.NEWS;
    }
}
