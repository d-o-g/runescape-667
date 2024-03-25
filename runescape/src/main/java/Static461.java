import com.jagex.core.constants.LocLayer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static461 {

    @OriginalMember(owner = "client!oja", name = "a", descriptor = "[I")
    public static final int[] LOC_LAYERS_BY_SHAPE = {
        /* 00 */ LocLayer.WALL,
        /* 01 */ LocLayer.WALL,
        /* 02 */ LocLayer.WALL,
        /* 03 */ LocLayer.WALL,
        /* 04 */ LocLayer.WALLDECOR,
        /* 05 */ LocLayer.WALLDECOR,
        /* 06 */ LocLayer.WALLDECOR,
        /* 07 */ LocLayer.WALLDECOR,
        /* 08 */ LocLayer.WALLDECOR,
        /* 09 */ LocLayer.GROUND,
        /* 10 */ LocLayer.GROUND,
        /* 11 */ LocLayer.GROUND,
        /* 12 */ LocLayer.GROUND,
        /* 13 */ LocLayer.GROUND,
        /* 14 */ LocLayer.GROUND,
        /* 15 */ LocLayer.GROUND,
        /* 16 */ LocLayer.GROUND,
        /* 17 */ LocLayer.GROUND,
        /* 18 */ LocLayer.GROUND,
        /* 19 */ LocLayer.GROUND,
        /* 20 */ LocLayer.GROUND,
        /* 21 */ LocLayer.GROUND,
        /* 22 */ LocLayer.GROUNDDECOR
    };

    @OriginalMember(owner = "client!oja", name = "a", descriptor = "(II)I")
    public static int method6268(@OriginalArg(0) int arg0) {
        if (arg0 < 96) {
            return 0;
        } else if (arg0 < 128) {
            return 2;
        } else {
            return 3;
        }
    }
}
