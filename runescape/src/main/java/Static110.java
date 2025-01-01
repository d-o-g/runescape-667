import com.jagex.game.runetek6.config.billboardtype.BillboardTypeList;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static110 {

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void setBillboardJs5(@OriginalArg(0) js5 arg0) {
        BillboardTypeList.configClient = arg0;
    }

}
