import org.openrs2.deob.annotation.OriginalMember;

public final class Static470 {

    @OriginalMember(owner = "client!or", name = "J", descriptor = "S")
    public static short aShort82;

    @OriginalMember(owner = "client!or", name = "P", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___32 = new CutsceneActionType(50);

    @OriginalMember(owner = "client!or", name = "Y", descriptor = "I")
    public static int currentCursor = -1;

    @OriginalMember(owner = "client!or", name = "d", descriptor = "(B)V")
    public static void method6386() {
        if (!Camera.angleChangingX) {
            Camera.angleAxisX += (-Camera.angleAxisX - 24.0F) / 2.0F;
            Camera.angleChangingX = true;
            Camera.angleUpdated = true;
        }
    }

}
