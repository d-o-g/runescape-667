import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.msitype.MSIType;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static452 {

    @OriginalMember(owner = "client!oea", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___173 = new ServerProt(44, 10);

    @OriginalMember(owner = "client!oea", name = "a", descriptor = "(ILclient!ge;)Lclient!fea;")
    public static Class125 method6171(@OriginalArg(1) Packet arg0) {
        @Pc(7) String local7 = arg0.gjstr();
        @Pc(14) Class403 local14 = Static33.method882()[arg0.g1()];
        @Pc(23) Class103 local23 = Static313.method4544()[arg0.g1()];
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

    @OriginalMember(owner = "client!oea", name = "a", descriptor = "(Lclient!c;BILclient!ha;II)V")
    public static void method6173(@OriginalArg(0) LocType arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Toolkit arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        @Pc(9) MSIType local9 = MSITypeList.instance.list(arg0.msi);
        if (local9.image == -1) {
            return;
        }
        if (arg0.msiRotate) {
            @Pc(24) int local24 = arg1 + arg0.msiRotateOffset;
            arg1 = local24 & 0x3;
        } else {
            arg1 = 0;
        }
        @Pc(39) Sprite local39 = local9.sprite(arg1, arg2, arg0.msiFlip);
        if (local39 == null) {
            return;
        }
        @Pc(46) int local46 = arg0.width;
        @Pc(49) int local49 = arg0.length;
        if ((arg1 & 0x1) == 1) {
            local46 = arg0.length;
            local49 = arg0.width;
        }
        @Pc(72) int local72 = local39.scaleWidth();
        @Pc(75) int local75 = local39.scaleHeight();
        if (local9.enlarge) {
            local75 = local49 * 4;
            local72 = local46 * 4;
        }
        if (local9.anInt4165 == 0) {
            local39.render(arg3, arg4 + 4 - local49 * 4, local72, local75);
        } else {
            local39.render(arg3, arg4 - (local49 - 1) * 4, local72, local75, 0, local9.anInt4165 | 0xFF000000, 1);
        }
    }
}
