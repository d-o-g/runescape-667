package rs2.client.loading.screen.op.instance;

import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!fea")
public final class TextInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!oea", name = "a", descriptor = "(ILclient!ge;)Lclient!fea;")
    public static TextInstance decode(@OriginalArg(1) Packet packet) {
        @Pc(7) String text = packet.gjstr();
        @Pc(14) HorizontalAlignment horizontalAlignment = HorizontalAlignment.values()[packet.g1()];
        @Pc(23) VerticalAlignment verticalAlignment = VerticalAlignment.values()[packet.g1()];
        @Pc(27) int x = packet.g2s();
        @Pc(33) int y = packet.g2s();
        @Pc(39) int textHorizontalAlign = packet.g1();
        @Pc(49) int textVerticalAlign = packet.g1();
        @Pc(53) int verticalSpacing = packet.g1();
        @Pc(57) int width = packet.g2();
        @Pc(61) int height = packet.g2();
        @Pc(65) int font = packet.g4();
        @Pc(69) int textColour = packet.g4();
        @Pc(73) int shadowColour = packet.g4();
        return new TextInstance(text, horizontalAlignment, verticalAlignment, x, y, textHorizontalAlign, textVerticalAlign, verticalSpacing, width, height, font, textColour, shadowColour);
    }

    @OriginalMember(owner = "client!fea", name = "o", descriptor = "I")
    public final int textColour;

    @OriginalMember(owner = "client!fea", name = "f", descriptor = "I")
    public final int textHorizontalAlignment;

    @OriginalMember(owner = "client!fea", name = "g", descriptor = "Ljava/lang/String;")
    public final String text;

    @OriginalMember(owner = "client!fea", name = "p", descriptor = "I")
    public final int textVerticalAlignment;

    @OriginalMember(owner = "client!fea", name = "e", descriptor = "I")
    public final int x;

    @OriginalMember(owner = "client!fea", name = "i", descriptor = "I")
    public final int verticalSpacing;

    @OriginalMember(owner = "client!fea", name = "q", descriptor = "I")
    public final int width;

    @OriginalMember(owner = "client!fea", name = "l", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!fea", name = "c", descriptor = "Lclient!ek;")
    public final VerticalAlignment verticalAlignment;

    @OriginalMember(owner = "client!fea", name = "j", descriptor = "I")
    public final int shadowColour;

    @OriginalMember(owner = "client!fea", name = "d", descriptor = "Lclient!wk;")
    public final HorizontalAlignment horizontalAlignment;

    @OriginalMember(owner = "client!fea", name = "m", descriptor = "I")
    public final int font;

    @OriginalMember(owner = "client!fea", name = "n", descriptor = "I")
    public final int y;

    @OriginalMember(owner = "client!fea", name = "<init>", descriptor = "(Ljava/lang/String;Lclient!wk;Lclient!ek;IIIIIIIIII)V")
    public TextInstance(@OriginalArg(0) String text, @OriginalArg(1) HorizontalAlignment horizontalAlignment, @OriginalArg(2) VerticalAlignment verticalAlignment, @OriginalArg(3) int x, @OriginalArg(4) int y, @OriginalArg(5) int textHorizontalAlignment, @OriginalArg(6) int textVerticalAlignment, @OriginalArg(7) int verticalSpacing, @OriginalArg(8) int width, @OriginalArg(9) int height, @OriginalArg(10) int font, @OriginalArg(11) int textColour, @OriginalArg(12) int shadowColour) {
        this.textColour = textColour;
        this.textHorizontalAlignment = textHorizontalAlignment;
        this.text = text;
        this.textVerticalAlignment = textVerticalAlignment;
        this.x = x;
        this.verticalSpacing = verticalSpacing;
        this.width = width;
        this.height = height;
        this.verticalAlignment = verticalAlignment;
        this.shadowColour = shadowColour;
        this.horizontalAlignment = horizontalAlignment;
        this.font = font;
        this.y = y;
    }

    @OriginalMember(owner = "client!fea", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.TEXT;
    }
}
