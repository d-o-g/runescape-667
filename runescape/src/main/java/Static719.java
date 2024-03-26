import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static719 {

    @OriginalMember(owner = "client!wq", name = "V", descriptor = "Lclient!cd;")
    public static Class56 aClass56_5;

    @OriginalMember(owner = "client!wq", name = "T", descriptor = "I")
    public static int anInt10504;

    @OriginalMember(owner = "client!wq", name = "S", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___45 = new CutsceneActionType(60);

    @OriginalMember(owner = "client!wq", name = "b", descriptor = "(III)I")
    public static int method9118(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        if (arg1 != 16939) {
            aClass56_5 = null;
        }
        @Pc(18) int local18 = arg2 - 1 & arg0 >> 31;
        return local18 + (arg0 + (arg0 >>> 31)) % arg2;
    }
}
