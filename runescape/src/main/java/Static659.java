import com.jagex.Client;
import com.jagex.core.constants.ModeWhere;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static659 {

    @OriginalMember(owner = "client!ut", name = "C", descriptor = "F")
    public static float aFloat213;

    @OriginalMember(owner = "client!ut", name = "v", descriptor = "I")
    public static int blockChat = 0;

    @OriginalMember(owner = "client!ut", name = "a", descriptor = "(III)I")
    public static int method8604(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(15) int local15 = arg0 * 57 + arg1;
        @Pc(21) int local21 = local15 ^ local15 << 13;
        @Pc(35) int local35 = Integer.MAX_VALUE & local21 * (local21 * 15731 * local21 + 789221) + 1376312589;
        return local35 >> 19 & 0xFF;
    }

    @OriginalMember(owner = "client!ut", name = "e", descriptor = "(B)Ljava/lang/String;")
    public static String method8605() {
        @Pc(15) String local15 = "www";
        if (Client.modeWhere == ModeWhere.WTRC) {
            local15 = "www-wtrc";
        } else if (Client.modeWhere == ModeWhere.WTQA) {
            local15 = "www-wtqa";
        } else if (Client.modeWhere == ModeWhere.WIP) {
            local15 = "www-wtwip";
        }
        @Pc(44) String local44 = "";
        if (Client.settings != null) {
            local44 = "/p=" + Client.settings;
        }
        return "http://" + local15 + "." + Client.modeGame.domainName + ".com/l=" + Client.language + "/a=" + Client.affid + local44 + "/";
    }

}
