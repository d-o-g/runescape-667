import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static635 {

    @OriginalMember(owner = "client!ub", name = "a", descriptor = "I")
    public static int varpUpdateCount = 0;

    @OriginalMember(owner = "client!ub", name = "a", descriptor = "(IZB)V")
    public static void method8380(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        if (arg1) {
            @Pc(26) ClientMessage local26 = Static293.method4335(Static321.VIDEO_STOP, ConnectionManager.GAME.cipher);
            local26.buffer.p2(arg0);
            ConnectionManager.GAME.send(local26);
        } else {
            Static472.method6429(Static458.aClass242_11, arg0, -1);
        }
    }
}
