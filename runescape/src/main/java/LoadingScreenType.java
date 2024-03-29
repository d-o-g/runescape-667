import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.FancyProgressBarInstance;
import rs2.client.loading.screen.op.instance.ImageInstance;
import rs2.client.loading.screen.op.instance.ClearScreenInstance;
import rs2.client.loading.screen.op.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.instance.NewsInstance;
import rs2.client.loading.screen.op.instance.SolidProgressBarInstance;
import rs2.client.loading.screen.op.instance.TextInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!de")
public final class LoadingScreenType {

    @OriginalMember(owner = "client!de", name = "d", descriptor = "[Lclient!gja;")
    public LoadingScreenOpInstance[] ops;

    @OriginalMember(owner = "client!de", name = "j", descriptor = "I")
    public int start;

    @OriginalMember(owner = "client!de", name = "i", descriptor = "I")
    public int fadeDuration;

    @OriginalMember(owner = "client!de", name = "a", descriptor = "(ILclient!ge;Lclient!kda;)Lclient!gja;")
    public LoadingScreenOpInstance decodeOp(@OriginalArg(1) Packet packet, @OriginalArg(2) LoadingScreenOpType type) {
        if (LoadingScreenOpType.CLEAR_SCREEN == type) {
            return ClearScreenInstance.decode(packet);
        } else if (LoadingScreenOpType.SOLID_PROGRESS_BAR == type) {
            return SolidProgressBarInstance.method6720(packet);
        } else if (type == LoadingScreenOpType.NEWS) {
            return NewsInstance.decode(packet);
        } else if (LoadingScreenOpType.ROTATING_IMAGE == type) {
            return Static464.method6301(packet);
        } else if (LoadingScreenOpType.IMAGE == type) {
            return ImageInstance.decode(packet);
        } else if (type == LoadingScreenOpType.IMAGE_PROGRESS_BAR) {
            return Static303.method4430(packet);
        } else if (LoadingScreenOpType.FANCY_PROGRESS_BAR == type) {
            return FancyProgressBarInstance.decode(packet);
        } else if (type == LoadingScreenOpType.TEXT) {
            return TextInstance.decode(packet);
        } else if (type == LoadingScreenOpType.BACKGROUND_IMAGE) {
            return Static112.method2106(packet);
        } else if (type == LoadingScreenOpType.ANIMATED_PROGRESS_BAR) {
            return Static353.method8430(packet);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!de", name = "a", descriptor = "(Lclient!ge;B)V")
    public void decode(@OriginalArg(0) Packet packet) {
        this.start = packet.g3();
        this.fadeDuration = packet.g2();
        this.ops = new LoadingScreenOpInstance[packet.g1()];
        @Pc(31) LoadingScreenOpType[] opTypes = LoadingScreenOpType.values();
        for (@Pc(33) int i = 0; i < this.ops.length; i++) {
            this.ops[i] = this.decodeOp(packet, opTypes[packet.g1()]);
        }
    }
}
