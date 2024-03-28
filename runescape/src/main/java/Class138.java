import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!is")
public class Class138 implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!is", name = "i", descriptor = "I")
    public final int anInt4413;

    @OriginalMember(owner = "client!is", name = "a", descriptor = "I")
    public final int anInt4415;

    @OriginalMember(owner = "client!is", name = "l", descriptor = "Lclient!wk;")
    public final HorizontalAlignment aHorizontalAlignment_10;

    @OriginalMember(owner = "client!is", name = "d", descriptor = "I")
    public final int anInt4416;

    @OriginalMember(owner = "client!is", name = "g", descriptor = "Lclient!ek;")
    public final VerticalAlignment aVerticalAlignment_10;

    @OriginalMember(owner = "client!is", name = "h", descriptor = "I")
    public final int anInt4418;

    @OriginalMember(owner = "client!is", name = "n", descriptor = "I")
    public final int anInt4423;

    @OriginalMember(owner = "client!is", name = "j", descriptor = "I")
    public final int anInt4412;

    @OriginalMember(owner = "client!is", name = "k", descriptor = "I")
    public final int anInt4421;

    @OriginalMember(owner = "client!is", name = "<init>", descriptor = "(Lclient!wk;Lclient!ek;IIIIIII)V")
    public Class138(@OriginalArg(0) HorizontalAlignment arg0, @OriginalArg(1) VerticalAlignment arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
        this.anInt4413 = arg5;
        this.anInt4415 = arg7;
        this.aHorizontalAlignment_10 = arg0;
        this.anInt4416 = arg6;
        this.aVerticalAlignment_10 = arg1;
        this.anInt4418 = arg4;
        this.anInt4423 = arg2;
        this.anInt4412 = arg3;
        this.anInt4421 = arg8;
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(Lclient!ge;I)Lclient!is;")
    public static Class138 method8359(@OriginalArg(0) Packet arg0) {
        @Pc(10) HorizontalAlignment local10 = HorizontalAlignment.values()[arg0.g1()];
        @Pc(17) VerticalAlignment local17 = VerticalAlignment.values()[arg0.g1()];
        @Pc(21) int local21 = arg0.g2s();
        @Pc(25) int local25 = arg0.g2s();
        @Pc(29) int local29 = arg0.g2();
        @Pc(33) int local33 = arg0.g2();
        @Pc(37) int local37 = arg0.g2s();
        @Pc(47) int local47 = arg0.g4();
        @Pc(51) int local51 = arg0.g4();
        return new Class138(local10, local17, local21, local25, local29, local33, local37, local47, local51);
    }

    @OriginalMember(owner = "client!is", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return null;
    }
}
