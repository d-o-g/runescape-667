import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!no")
public class ImageInstance implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(Lclient!ge;B)Lclient!no;")
    public static ImageInstance decode(@OriginalArg(0) Packet packet) {
        @Pc(15) int local15 = packet.g2();
        @Pc(22) HorizontalAlignment local22 = HorizontalAlignment.values()[packet.g1()];
        @Pc(29) VerticalAlignment local29 = VerticalAlignment.values()[packet.g1()];
        @Pc(35) int local35 = packet.g2s();
        @Pc(39) int local39 = packet.g2s();
        return new ImageInstance(local15, local22, local29, local35, local39);
    }

    @OriginalMember(owner = "client!no", name = "l", descriptor = "Lclient!ek;")
    public final VerticalAlignment aVerticalAlignment_9;

    @OriginalMember(owner = "client!no", name = "h", descriptor = "I")
    public final int anInt3850;

    @OriginalMember(owner = "client!no", name = "e", descriptor = "I")
    public final int anInt3851;

    @OriginalMember(owner = "client!no", name = "k", descriptor = "Lclient!wk;")
    public final HorizontalAlignment aHorizontalAlignment_9;

    @OriginalMember(owner = "client!no", name = "f", descriptor = "I")
    public final int anInt3845;

    @OriginalMember(owner = "client!no", name = "<init>", descriptor = "(ILclient!wk;Lclient!ek;II)V")
    public ImageInstance(@OriginalArg(0) int arg0, @OriginalArg(1) HorizontalAlignment arg1, @OriginalArg(2) VerticalAlignment arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        this.aVerticalAlignment_9 = arg2;
        this.anInt3850 = arg3;
        this.anInt3851 = arg0;
        this.aHorizontalAlignment_9 = arg1;
        this.anInt3845 = arg4;
    }

    @OriginalMember(owner = "client!no", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.IMAGE;
    }
}
