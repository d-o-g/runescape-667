import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static126 {

    @OriginalMember(owner = "client!du", name = "f", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___12 = new CutsceneActionType(52);

    @OriginalMember(owner = "client!du", name = "a", descriptor = "(BI)V")
    public static void method2226(@OriginalArg(1) int volume) {
        if (SongManager.anInt10171 == 0) {
            Static581.mixBuss.setVolume(volume);
        } else {
            SongManager.volume = volume;
        }
    }

    @OriginalMember(owner = "client!du", name = "a", descriptor = "(I)V")
    public static void method2228() {
        Static179.playerCount = 0;
        Static480.npcCount = 0;
        Static577.anInt8587 = 0;
        Static606.anInt8954 = 0;
    }

}
