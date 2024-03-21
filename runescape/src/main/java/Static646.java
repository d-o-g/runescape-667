import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static646 {

    @OriginalMember(owner = "client!uga", name = "c", descriptor = "I")
    public static int anInt9621;

    @OriginalMember(owner = "client!uga", name = "a", descriptor = "(II)V")
    public static void method8453(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(7) Class291 local7 = Static334.activeTiles[0][arg0][arg1];
        for (@Pc(9) int local9 = 0; local9 < 3; local9++) {
            @Pc(28) Class291 local28 = Static334.activeTiles[local9][arg0][arg1] = Static334.activeTiles[local9 + 1][arg0][arg1];
            if (local28 != null) {
                for (@Pc(33) Class286 local33 = local28.aClass286_2; local33 != null; local33 = local33.aClass286_1) {
                    @Pc(37) PositionEntity local37 = local33.aPositionEntity;
                    if (local37.aShort131 == arg0 && local37.aShort132 == arg1) {
                        local37.aByte144--;
                    }
                }
                if (local28.aGroundDecor_1 != null) {
                    local28.aGroundDecor_1.aByte144--;
                }
                if (local28.aClass8_Sub2_Sub3_2 != null) {
                    local28.aClass8_Sub2_Sub3_2.aByte144--;
                }
                if (local28.aWall_1 != null) {
                    local28.aWall_1.aByte144--;
                }
                if (local28.aWallDecor_1 != null) {
                    local28.aWallDecor_1.aByte144--;
                }
                if (local28.aClass8_Sub2_Sub4_2 != null) {
                    local28.aClass8_Sub2_Sub4_2.aByte144--;
                }
            }
        }
        if (Static334.activeTiles[0][arg0][arg1] == null) {
            Static334.activeTiles[0][arg0][arg1] = new Class291(0);
            Static334.activeTiles[0][arg0][arg1].aByte116 = 1;
        }
        Static334.activeTiles[0][arg0][arg1].aClass291_1 = local7;
        Static334.activeTiles[3][arg0][arg1] = null;
    }

    @OriginalMember(owner = "client!uga", name = "a", descriptor = "(BII)Z")
    public static boolean method8457(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x21) != 0;
    }

    @OriginalMember(owner = "client!uga", name = "a", descriptor = "(IB)I")
    public static int method8458(@OriginalArg(0) int arg0) {
        if (arg0 == 6406) {
            return 1;
        } else if (arg0 == 6409) {
            return 1;
        } else if (arg0 == 32841) {
            return 1;
        } else if (arg0 == 6410) {
            return 2;
        } else if (arg0 == 6407) {
            return 3;
        } else if (arg0 == 6408) {
            return 4;
        } else {
            throw new IllegalArgumentException("");
        }
    }
}
