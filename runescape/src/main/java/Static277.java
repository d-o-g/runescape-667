import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static277 {

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IIILclient!fk;I)V")
    public static void method4040(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) Node_Sub19 arg2, @OriginalArg(4) int arg3) {
        arg2.aClass2_Sub21_Sub2_1.p4_alt3(arg0);
        arg2.aClass2_Sub21_Sub2_1.p2_alt3(arg1);
        arg2.aClass2_Sub21_Sub2_1.p2(arg3);
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(Lclient!uv;IIZ)J")
    public static long method4042(@OriginalArg(0) Location loc, @OriginalArg(1) int z, @OriginalArg(2) int x) {
        @Pc(5) long local5 = 0x400000L;
        @Pc(18) long local18 = 0x8000000000000000L;
        @Pc(25) LocType local25 = Static354.aLocTypeList_4.list(loc.getId());
        @Pc(46) long flags = (long) (x | (z << 7) | (loc.getShape() << 14) | (loc.getRotation() << 20) | 0x40000000);
        if (local25.interactivity == LocInteractivity.NONINTERACTIVE) {
            flags |= local18;
        }
        if (local25.lb == 1) {
            flags |= local5;
        }
        return flags | (long) loc.getId() << 32;
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IC)Z")
    public static boolean method4043(@OriginalArg(1) char arg0) {
        return arg0 >= '0' && arg0 <= '9';
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IZI)Z")
    public static boolean method4044(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x800) != 0;
    }
}
