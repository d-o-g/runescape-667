import com.jagex.core.io.Packet;
import com.jagex.graphics.HorizontalAlignment;
import com.jagex.graphics.VerticalAlignment;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!fea")
public final class Class125 implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!fea", name = "o", descriptor = "I")
    public final int anInt2867;

    @OriginalMember(owner = "client!fea", name = "f", descriptor = "I")
    public final int anInt2860;

    @OriginalMember(owner = "client!fea", name = "g", descriptor = "Ljava/lang/String;")
    public final String aString30;

    @OriginalMember(owner = "client!fea", name = "p", descriptor = "I")
    public final int anInt2870;

    @OriginalMember(owner = "client!fea", name = "e", descriptor = "I")
    public final int anInt2868;

    @OriginalMember(owner = "client!fea", name = "i", descriptor = "I")
    public final int anInt2866;

    @OriginalMember(owner = "client!fea", name = "q", descriptor = "I")
    public final int anInt2865;

    @OriginalMember(owner = "client!fea", name = "l", descriptor = "I")
    public final int anInt2859;

    @OriginalMember(owner = "client!fea", name = "c", descriptor = "Lclient!ek;")
    public final VerticalAlignment aVerticalAlignment_3;

    @OriginalMember(owner = "client!fea", name = "j", descriptor = "I")
    public final int anInt2862;

    @OriginalMember(owner = "client!fea", name = "d", descriptor = "Lclient!wk;")
    public final HorizontalAlignment aHorizontalAlignment_2;

    @OriginalMember(owner = "client!fea", name = "m", descriptor = "I")
    public final int anInt2858;

    @OriginalMember(owner = "client!fea", name = "n", descriptor = "I")
    public final int anInt2869;

    @OriginalMember(owner = "client!fea", name = "<init>", descriptor = "(Ljava/lang/String;Lclient!wk;Lclient!ek;IIIIIIIIII)V")
    public Class125(@OriginalArg(0) String arg0, @OriginalArg(1) HorizontalAlignment arg1, @OriginalArg(2) VerticalAlignment arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12) {
        this.anInt2867 = arg11;
        this.anInt2860 = arg5;
        this.aString30 = arg0;
        this.anInt2870 = arg6;
        this.anInt2868 = arg3;
        this.anInt2866 = arg7;
        this.anInt2865 = arg8;
        this.anInt2859 = arg9;
        this.aVerticalAlignment_3 = arg2;
        this.anInt2862 = arg12;
        this.aHorizontalAlignment_2 = arg1;
        this.anInt2858 = arg10;
        this.anInt2869 = arg4;
    }

    @OriginalMember(owner = "client!oea", name = "a", descriptor = "(ILclient!ge;)Lclient!fea;")
    public static Class125 method6171(@OriginalArg(1) Packet arg0) {
        @Pc(7) String local7 = arg0.gjstr();
        @Pc(14) HorizontalAlignment local14 = HorizontalAlignment.values()[arg0.g1()];
        @Pc(23) VerticalAlignment local23 = VerticalAlignment.values()[arg0.g1()];
        @Pc(27) int local27 = arg0.g2s();
        @Pc(33) int local33 = arg0.g2s();
        @Pc(39) int local39 = arg0.g1();
        @Pc(49) int local49 = arg0.g1();
        @Pc(53) int local53 = arg0.g1();
        @Pc(57) int local57 = arg0.g2();
        @Pc(61) int local61 = arg0.g2();
        @Pc(65) int local65 = arg0.g4();
        @Pc(69) int local69 = arg0.g4();
        @Pc(73) int local73 = arg0.g4();
        return new Class125(local7, local14, local23, local27, local33, local39, local49, local53, local57, local61, local65, local69, local73);
    }

    @OriginalMember(owner = "client!fea", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.TEXT;
    }
}
