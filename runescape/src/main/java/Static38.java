import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static38 {

    @OriginalMember(owner = "client!bea", name = "c", descriptor = "I")
    public static int anInt920;

    @OriginalMember(owner = "client!bea", name = "f", descriptor = "I")
    public static int playerModLevel = 0;

    @OriginalMember(owner = "client!bea", name = "a", descriptor = "(IIJI)V")
    public static void findPathToLoc(@OriginalArg(1) int arg0, @OriginalArg(2) long arg1, @OriginalArg(3) int arg2) {
        @Pc(10) int local10 = (int) arg1 >> 14 & 0x1F;
        @Pc(17) int local17 = (int) arg1 >> 20 & 0x3;
        @Pc(29) int local29 = Integer.MAX_VALUE & (int) (arg1 >>> 32);
        if (local10 != 10 && local10 != 11 && local10 != 22) {
            Static147.findPath(local17, arg2, 0, true, arg0, 0, local10, 0);
            return;
        }
        @Pc(62) LocType local62 = LocTypeList.instance.list(local29);
        @Pc(75) int local75;
        @Pc(78) int local78;
        if (local17 == 0 || local17 == 2) {
            local75 = local62.width;
            local78 = local62.length;
        } else {
            local75 = local62.length;
            local78 = local62.width;
        }
        @Pc(88) int local88 = local62.forceapproach;
        if (local17 != 0) {
            local88 = (local88 << local17 & 0xF) + (local88 >> 4 - local17);
        }
        Static147.findPath(0, arg2, local78, true, arg0, local88, 0, local75);
    }

}
