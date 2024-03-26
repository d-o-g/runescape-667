import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static212 {

    @OriginalMember(owner = "client!gka", name = "m", descriptor = "I")
    public static int anInt3467;

    @OriginalMember(owner = "client!gka", name = "v", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___16 = new CutsceneActionType(255);

    @OriginalMember(owner = "client!gka", name = "u", descriptor = "[I")
    public static final int[] anIntArray283 = new int[500];

    @OriginalMember(owner = "client!gka", name = "a", descriptor = "(II)[I")
    public static int[] method3135(@OriginalArg(0) int arg0) {
        @Pc(6) int[] local6 = new int[3];
        Static551.method7276(Static38.method1003(arg0));
        local6[0] = Static260.aCalendar2.get(5);
        local6[1] = Static260.aCalendar2.get(2);
        local6[2] = Static260.aCalendar2.get(1);
        return local6;
    }

}
