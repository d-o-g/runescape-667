import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static578 {

    @OriginalMember(owner = "client!sda", name = "a", descriptor = "(IIILjava/lang/Class;)Lclient!qf;")
    public static PositionEntity getEntity(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class arg3) {
        @Pc(7) Class291 local7 = Static334.activeTiles[arg0][arg1][arg2];
        if (local7 == null) {
            return null;
        }
        for (@Pc(15) Class286 local15 = local7.aClass286_2; local15 != null; local15 = local15.aClass286_1) {
            @Pc(19) PositionEntity local19 = local15.aPositionEntity;
            if (arg3.isAssignableFrom(local19.getClass()) && local19.aShort131 == arg1 && local19.aShort132 == arg2) {
                return local19;
            }
        }
        return null;
    }

}
