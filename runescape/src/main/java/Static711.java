import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static711 {

    @OriginalMember(owner = "client!wia", name = "c", descriptor = "I")
    public static int anInt10684;

    @OriginalMember(owner = "client!wia", name = "a", descriptor = "(IBI)V")
    public static void mixBussSetLevel(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        AudioRenderer.mixBussSetLevel(arg1, arg0);
    }

}
