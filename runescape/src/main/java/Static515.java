import com.jagex.core.io.Packet;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static515 {

    @OriginalMember(owner = "client!qda", name = "l", descriptor = "[[Ljava/lang/String;")
    public static final String[][] aStringArrayArray2 = new String[][]{{"M1", "M2", "S1", "F"}, {"M1", "M2", "M3", "S1", "S2", "F"}, {"M1", "M2", "M3", "M4", "S1", "S2", "S3", "F"}};

    @OriginalMember(owner = "client!qda", name = "t", descriptor = "Lclient!kda;")
    public static final Class204 aClass204_10 = new Class204(0, 1);

    @OriginalMember(owner = "client!qda", name = "x", descriptor = "Lclient!mia;")
    public static final ClientTriggerType A_CLIENT_TRIGGER_TYPE___12 = new ClientTriggerType("", 13);

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(IIIIILclient!ha;IIIIILclient!cba;)V")
    public static void method6799(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) Toolkit arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) MiniMenuEntryInner arg10) {
        if (arg8 < arg5 && arg5 < arg1 + arg8 && arg2 - 13 < arg0 && arg0 < arg2 + 3) {
            arg6 = arg3;
        }
        @Pc(41) String local41 = Static192.method2874(arg10);
        Fonts.b12.render(arg6, 0, arg2, local41, arg8 + 3, MiniMenu.questSprites, Static460.anIntArray554);
    }

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(Lclient!ge;B)Lclient!no;")
    public static Class160 method6803(@OriginalArg(0) Packet arg0) {
        @Pc(15) int local15 = arg0.g2();
        @Pc(22) Class403 local22 = Static33.method882()[arg0.g1()];
        @Pc(29) Class103 local29 = Static313.method4544()[arg0.g1()];
        @Pc(35) int local35 = arg0.g2s();
        @Pc(39) int local39 = arg0.g2s();
        return new Class160(local15, local22, local29, local35, local39);
    }

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(III)Z")
    public static boolean method6804(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static77.method1560(arg0, arg1) || Static519.method6832(-97, arg1, arg0);
    }
}
