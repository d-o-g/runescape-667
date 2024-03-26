import com.jagex.ChangeLocationRequest;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static553 {

    @OriginalMember(owner = "client!rga", name = "j", descriptor = "[[I")
    public static final int[][] anIntArrayArray206 = new int[][]{{0, 1, 2, 3}, {1, -1, -1, 0}, {-1, 2, -1, 0}, {-1, 0, -1, 2}, {0, 1, -1, 2}, {1, 2, -1, 0}, {-1, 4, -1, 1}, {-1, 3, 4, -1}, {-1, 0, 2, -1}, {-1, -1, 2, 0}, {0, 2, 5, 3}, {0, -1, 6, -1}, {0, 1, 2, 3}};

    @OriginalMember(owner = "client!rga", name = "a", descriptor = "(IIIIIIIZ)V")
    public static void method7289(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
        @Pc(7) ChangeLocationRequest local7 = null;
        for (@Pc(12) ChangeLocationRequest local12 = (ChangeLocationRequest) Static159.changes.first(); local12 != null; local12 = (ChangeLocationRequest) Static159.changes.next()) {
            if (arg4 == local12.anInt4010 && local12.x == arg3 && arg6 == local12.z && local12.layer == arg2) {
                local7 = local12;
                break;
            }
        }
        if (local7 == null) {
            local7 = new ChangeLocationRequest();
            local7.layer = arg2;
            local7.anInt4010 = arg4;
            local7.z = arg6;
            local7.x = arg3;
            if (arg3 >= 0 && arg6 >= 0 && Static720.mapWidth > arg3 && arg6 < Static501.mapLength) {
                Static293.method4332(local7);
            }
            Static159.changes.addLast(local7);
        }
        local7.aBoolean310 = true;
        local7.anInt4012 = arg0;
        local7.anInt4013 = arg5;
        local7.aBoolean309 = false;
        local7.anInt4014 = arg1;
    }

}
